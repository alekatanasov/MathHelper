

package evaluation;

import expression.Constant;
import expression.Operation;
import interfaces.expression.Symbol;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * The transformMathStatement method of this class will execute the operation specified
 * by the operationPosition field in the currently loaded symbolic statement.
 * 
 * @author Alexander Atanasov
 */
public class SpecifiedOperationExecutor extends MathStatementTransformer{
    private Integer operationPosition;
    
    public SpecifiedOperationExecutor(SymbolicStatement statement){
        super(statement);
        setOperationPosition(null);
    }
    
    @Override
    public boolean transformMathStatement(){
        boolean isTrasformationSuccess = false;
        Constant operationResult;
        int position;
        List<Symbol> mathStatement = getMathStatement().getStatement();
        
        // error check
        if(this.getOperationPosition() == null){
            throw new IllegalArgumentException("operationPosition has not been set");
        }
        
        // execute the operation specified by the operationPosition field in the curently loaded
        // symbolic statement
        position = popOperationPosition();
        operationResult = Operation.performOperation((Constant) mathStatement.get(position-1), 
                                                     (Constant) mathStatement.get(position+1), 
                                                     (Operation) mathStatement.get(position));

        // store the resulting constant and remove the operation and the operands from the
        // symbolic statement
        mathStatement.set(position, operationResult);
        mathStatement.remove(position+1);
        mathStatement.remove(position-1);
        isTrasformationSuccess = true;

        return isTrasformationSuccess;
    }
    
    /**
     * 
     * @param data Integer which represents the position of the operation to be executed in 
     *             the currently loaded symbolic statement
     */
    @Override
    public void loadAdditionalData(Object data){
        setOperationPosition((Integer) data);
    }
    
    /**
     * 
     * @return 
     */
    private Integer popOperationPosition(){
        Integer position = getOperationPosition();
        this.setOperationPosition(null);
        return position;
    }
    
    private void setOperationPosition(Integer position){
        this.operationPosition = position;
    }
    
    /**
     * 
     * @return Reference (no copy) to the openPosition field
     */
    private Integer getOperationPosition(){
        return this.operationPosition;
    }
}
