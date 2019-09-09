
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
public final class OperationExecutor extends MathStatementTransformer{
    public OperationExecutor(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public boolean transformMathStatement(){
        boolean isTrasformationSuccess = false;
        SymbolicStatement statement = this.getMathStatement();
        List<Symbol> symbols;
        int HighestOrderOperationPosition=1;
        int HighestOrderOperation = 0;
        Operation currentOperation;
        
        // check if the provided statement contains at least a single operation
        if(!statement.containsSymbol(SymbolType.OPERATION)){
            return isTrasformationSuccess;
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
        
        // execute the operation with the highest order
        executeHighestOrderOperation(symbols, HighestOrderOperationPosition);
        
        isTrasformationSuccess = true;
        return isTrasformationSuccess;
    }
    
    /**
     * Executes the the operation of the highest order(the operation and it's right and left operands
     * are replaced with the result).
     * 
     * @param statement a symbolic mathematical statement
     * @param HighestOrderOperationPosition the index position of the operation with the highest order in
     *                                      the provided mathematical statement
     */
    private void executeHighestOrderOperation(List<Symbol> statement, int HighestOrderOperationPosition){
        Constant operationResult;
        
        operationResult = Operation.performOperation((Constant) statement.get(HighestOrderOperationPosition-1), 
                                                     (Constant) statement.get(HighestOrderOperationPosition+1),
                                                     (Operation) statement.get(HighestOrderOperationPosition));
        
        statement.remove(HighestOrderOperationPosition+1);
        statement.remove(HighestOrderOperationPosition);
        statement.set(HighestOrderOperationPosition-1, operationResult);
    }
}
