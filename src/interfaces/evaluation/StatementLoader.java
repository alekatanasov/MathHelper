
package interfaces.evaluation;

import interfaces.expression.SymbolicStatement;

/**
 *
 * @author Alexandar Atanasov
 */
public interface StatementLoader {
    /**
     * Stores the provided symbolic statement inside the current instance of the StatementLoader.
     * 
     * @param statement non null symbolic statement
     */
    public void loadMathStatement(SymbolicStatement statement);
}
