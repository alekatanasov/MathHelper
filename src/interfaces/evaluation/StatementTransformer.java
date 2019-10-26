
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
     * Stores the provided symbolic statement inside the current instance of the StatementTransformer.
     * 
     * @param statement non null symbolic statement
     */
    public void loadMathStatement(SymbolicStatement statement);
    
    /**
     * Loads additional data needed for statement transformation.
     * 
     * @param data can be null for child classes which do not use the additional data field
     */
    public void loadAdditionalData(Object data);
}
