
package evaluation;

import statement.Operation;
import interfaces.evaluation.ParameterDependentTransformer;
import interfaces.evaluation.ParameterIndependentTransformer;
import interfaces.statement.MathSymbol;
import interfaces.statement.MathSymbol.MathSymbolType;
import interfaces.statement.SymbolicStatement;
import java.util.List;

/**
 * The transformMathStatement method of this class will execute the operation with the 
 * highest order in the currently loaded mathStatement.
 * 
 * @author Alexandar Atanasov
 */
public final class HighestOperationExecutor extends MathStatementContainer implements ParameterIndependentTransformer{
    private ParameterDependentTransformer specifiedOperationExecutor;
    
    public HighestOperationExecutor(SymbolicStatement statement){
        super(statement);
        initializeSpecifiedOperationExecutor(statement);
    }
    
    @Override
    public boolean transformMathStatement(){
        boolean isTransformationSuccess = false;
        SymbolicStatement mathStatement = getMathStatement();
        List <MathSymbol> mathSymbols;
        int HighestOrderOperationPosition=1;
        int HighestOrderOperation = 0;
        Operation currentOperation;
        
        // check if the provided mathStatement contains at least a single operation
         if(!mathStatement.containsSymbolType(MathSymbolType.OPERATION)){
            return isTransformationSuccess;
        }
        
        // locate the operation of the highest order
        mathSymbols = mathStatement.getStatement();
        for(int c=0;c< mathSymbols.size();c++){
            if(mathSymbols.get(c).getMathSymbolType().equals(MathSymbolType.OPERATION) ){
                currentOperation = (Operation) mathSymbols.get(c);
                
                if(currentOperation.getOperationOrder() > HighestOrderOperation){
                    HighestOrderOperation = currentOperation.getOperationOrder();
                    HighestOrderOperationPosition = c;
                }
            }
        }
        
        // execute the operation of the highest order
        getSpecifiedOperationExecutor().transformMathStatement(HighestOrderOperationPosition);
        
        // execution is successful
        isTransformationSuccess = true;
        return isTransformationSuccess;
    }
    
    private void initializeSpecifiedOperationExecutor(SymbolicStatement statement){
        this.specifiedOperationExecutor = new SpecifiedOperationExecutor(statement);
    }
    
    /**
     * 
     * @return Reference (no copy) of the specifiedOperationExecutor field.
     */
    private ParameterDependentTransformer getSpecifiedOperationExecutor(){
        return this.specifiedOperationExecutor;
    }
    
}
