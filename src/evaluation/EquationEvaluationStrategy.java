

package evaluation;

import interfaces.evaluation.EvaluationStrategy;
import interfaces.statement.SymbolicStatement;


/**
 * The evaluate method of this class can evaluate equations.
 * 
 * @author Alexander Atanasov
 */
public class EquationEvaluationStrategy implements EvaluationStrategy {
    @Override
    public SymbolicStatement evaluate(SymbolicStatement statement) throws InvalidStatementException {
        SymbolicStatement result = null;
        
        // error check
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        }
        
        result = evaluateSingleVariableEquation(statement);
        return result;
    }
    
    private SymbolicStatement evaluateSingleVariableEquation(SymbolicStatement statement){
        SymbolicStatement result = null;
        
        // to do
        
        return result;
    }
}
