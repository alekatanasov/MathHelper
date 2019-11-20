
package interfaces.evaluation;

import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexandar Atanasov
 */
public interface StatementContainer {
    /**
     * Stores the provided symbolic statement inside the current instance of the StatementContainer.
     * 
     * @param statement non null symbolic statement
     */
    public void loadMathStatement(SymbolicStatement statement);
}
