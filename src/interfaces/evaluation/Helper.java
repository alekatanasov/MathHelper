
package interfaces.evaluation;

/**
 * 
 * @author Alexandar Atanasov
 */
public interface Helper {
    /**
     * Solves the provided mathematical statement.
     * 
     * @param mathStatement non null math statement to be solved.
     * 
     * @return String representing the solved statement.
     */
    public String solveMathStatement(String mathStatement);
}
