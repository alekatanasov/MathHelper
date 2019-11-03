
package interfaces.evaluation;

/**
 * Can perform some type of analysis(which does not need additional instructions) on the 
 * currently loaded statement.
 * 
 * @author Alexander Atanasov
 */
public interface ParameterIndependentAnalyzer extends StatementLoader{
    /**
     * Perform some analysis on the currently loaded symbolic statement.
     * 
     * @return 
     */
    public Object analyzeMathStatement();
}
