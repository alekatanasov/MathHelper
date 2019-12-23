
package interfaces.evaluation;

/**
 * Can perform some transformation (dependent on additional parameters)on a symbolic statement.
 * 
 * @author Alexander Atanasov
 */
public interface ParameterDependentTransformer extends StatementContainer {
    /**
     * Performs some operation or transformation on the currently loaded statement.
     * 
     * @param transformationParameters additional information needed to perform the transformation
     * 
     * @return true if the transformation is possible and was successfully performed.
     */
    public boolean transformMathStatement(Object transformationParameters);
}
