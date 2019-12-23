

package evaluation;

import interfaces.evaluation.EvaluationStrategy;
import interfaces.evaluation.ParameterDependentTransformer;
import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.statement.SymbolicStatement;


/**
 * The evaluate method of this class can evaluate equations.
 * 
 * @author Alexander Atanasov
 */
public class EquationEvaluationStrategy implements EvaluationStrategy {
    @Override
    public SymbolicStatement evaluate(SymbolicStatement statement) throws InvalidStatementException {
        SymbolicStatement result;
        ParameterIndependentAnalyzer relationalValidator = new RelationalStatementValidator(statement);
        
        // null check
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        }
        
        // check if the provided statement is valid relational statement
        boolean isValidEquation = (boolean) relationalValidator.analyzeMathStatement();
        if(!isValidEquation){
            // invalid expression provided by the user
            throw new InvalidStatementException("Invalid equation");
        }
        
        //
        result = evaluateSingleVariableEquation(statement);
        return result;
    }
    
    private SymbolicStatement evaluateSingleVariableEquation(SymbolicStatement statement){
        SymbolicStatement result;
        
        result = this.evaluateLinearEquation(statement);
        
        return result;
    }
    
    private SymbolicStatement evaluateLinearEquation(SymbolicStatement statement){
        SymbolicStatement result = null;
        ParameterDependentTransformer monomialShifter = new RelationalMonomialShifter(statement);
        
        // 
        
        
        return result;
    }
}
