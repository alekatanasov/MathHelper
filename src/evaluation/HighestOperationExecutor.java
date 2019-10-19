
package evaluation;

import expression.Operation;
import interfaces.expression.MathSymbol;
import interfaces.expression.MathSymbol.SymbolType;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * The transformMathStatement method of this class will execute the operation with the 
 * highest order in the currently loaded mathStatement.
 * 
 * @author Alexandar Atanasov
 */
public final class HighestOperationExecutor extends MathStatementTransformer{
    private MathStatementTransformer specifiedOperationExecutor;
    
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
        if(!mathStatement.containsSymbolType(SymbolType.OPERATION)){
            return isTransformationSuccess;
        }
        
        // locate the operation of the highest order
        mathSymbols = mathStatement.getStatement();
        for(int c=0;c< mathSymbols.size();c++){
            if(mathSymbols.get(c).getSymbolType().equals(SymbolType.OPERATION) ){
                currentOperation = (Operation) mathSymbols.get(c);
                
                if(currentOperation.getOperationOrder() > HighestOrderOperation){
                    HighestOrderOperation = currentOperation.getOperationOrder();
                    HighestOrderOperationPosition = c;
                }
            }
        }
        
        // execute the operation of the highest order
        getSpecifiedOperationExecutor().loadAdditionalData(HighestOrderOperationPosition);
        getSpecifiedOperationExecutor().transformMathStatement();
        
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
    private MathStatementTransformer getSpecifiedOperationExecutor(){
        return this.specifiedOperationExecutor;
    }
    
}
