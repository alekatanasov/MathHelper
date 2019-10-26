

package evaluation;

import expression.Constant;
import expression.Operation;
import interfaces.evaluation.DataDependentTransformer;
import interfaces.expression.MathSymbol;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * The transformMathStatement method of this class will execute the operation specified
 * by the operationPosition field in the currently loaded symbolic statement.
 * 
 * @author Alexander Atanasov
 */
public class SpecifiedOperationExecutor extends MathStatementTransformer implements DataDependentTransformer{
    
    public SpecifiedOperationExecutor(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public boolean transformMathStatement(Object additionalData){
        int operationPosition = (Integer) additionalData;
        boolean isTrasformationSuccess = false;
        Constant operationResult;
        List<MathSymbol> mathStatement = getMathStatement().getStatement();
        
        // error check
        if(operationPosition < 0){
            throw new IllegalArgumentException("operationPosition cannot be less than 0");
        }
        
        // execute the operation specified by the operationPosition field in the curently loaded
        // symbolic statement
        operationResult = Operation.performOperation((Constant) mathStatement.get(operationPosition-1), 
                                                     (Constant) mathStatement.get(operationPosition+1), 
                                                     (Operation) mathStatement.get(operationPosition));

        // store the resulting constant and remove the operation and the operands from the
        // symbolic statement
        mathStatement.set(operationPosition, operationResult);
        mathStatement.remove(operationPosition+1);
        mathStatement.remove(operationPosition-1);
        isTrasformationSuccess = true;

        return isTrasformationSuccess;
    }
}
