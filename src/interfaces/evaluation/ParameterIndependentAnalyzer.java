
package interfaces.evaluation;

/**
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
