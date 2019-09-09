
package interfaces.evaluation;

import interfaces.expression.SymbolicStatement;

/**
 *
 * @author Alexandar Atanasov
 */
public interface Evaluator {
    /**
     * Perform some kind of evaluation on the provided statement.
     * 
     * @param statement a SymbolicStatement to be evaluated
     * @return a SymbolicStatement representing the result of the evaluation
     */
    public SymbolicStatement evaluate(SymbolicStatement statement);
}
