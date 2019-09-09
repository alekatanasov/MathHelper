
package interfaces.evaluation;

import interfaces.expression.SymbolicStatement;

/**
 *
 * @author Alexandar Atanasov
 */
public interface StatementTransformer {
    /**
     * Performs some operation or transformation on the currently loaded statement.
     * 
     * @return true if the transformation is possible and was successfully performed.
     */
    public boolean transformMathStatement();
    
    /**
     * Stores the provided statement inside the current instance of the StatementTransformer
     * 
     * @param statement 
     */
    public void loadMathStatement(SymbolicStatement statement);
}
