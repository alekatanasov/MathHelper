
package interfaces.evaluation;

/**
 * Can perform some transformation (which does not require parameters) on a symbolic statement.
 * 
 * @author Alexander Atanasov
 */
public interface ParameterIndependentTransformer extends StatementContainer{
    /**
     * Perform some transformation or manipulation on the currently loaded symbolic statement.
     * 
     * @return true if the transformation was successfully performed
     */
    public boolean transformMathStatement();
}
