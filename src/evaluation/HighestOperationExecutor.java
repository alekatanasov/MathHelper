
package evaluation;

import expression.Constant;
import expression.Operation;
import interfaces.expression.Symbol;
import interfaces.expression.Symbol.SymbolType;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * The transformMathStatement method of this class will execute the operation with the 
 * highest order in the currently loaded statement.
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
        SymbolicStatement statement = getMathStatement();
        List<Symbol> symbols;
        int HighestOrderOperationPosition=1;
        int HighestOrderOperation = 0;
        Operation currentOperation;
        
        // check if the provided statement contains at least a single operation
        if(!statement.containsSymbol(SymbolType.OPERATION)){
            return isTransformationSuccess;
        }
        
        // locate the operation of the highest order
        symbols = statement.getStatement();
        for(int c=0;c< symbols.size();c++){
            if(symbols.get(c).getSymbolType().equals(SymbolType.OPERATION) ){
                currentOperation = (Operation) symbols.get(c);
                
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
    
    private MathStatementTransformer getSpecifiedOperationExecutor(){
        return this.specifiedOperationExecutor;
    }
    
}
