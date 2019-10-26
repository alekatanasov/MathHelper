
package interfaces.evaluation;

/**
 *
 * @author Alexander Atanasov
 */
public interface StatementAnalyzer {
    /**
     * Perform some analysis on the currently loaded symbolic statement.
     * 
     * @param analysisInstructions optional argument (not all subclasses use it). 
     * 
     * @return 
     */
    public boolean analyzeMathStatement(Object analysisInstructions);
    
    public Object getAdditionalAnalisysData();
}
