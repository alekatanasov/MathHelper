
package interfaces.evaluation;

import evaluation.InvalidStatementException;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexandar Atanasov
 */
public interface EvaluationStrategy {
    /**
     * Perform some kind of evaluation on the provided statement.
     * 
     * @param statement a SymbolicStatement to be evaluated
     * @return a SymbolicStatement representing the result of the evaluation
     */
    public SymbolicStatement evaluate(SymbolicStatement statement) throws InvalidStatementException;
}
