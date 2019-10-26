
package interfaces.evaluation;

/**
 * Can perform some transformation (dependent on additional data)on a symbolic statement.
 * 
 * @author Alexander Atanasov
 */
public interface DataDependentTransformer extends StatementLoader{
    /**
     * Performs some operation or transformation on the currently loaded statement.
     * 
     * @param additionalData
     * 
     * @return true if the transformation is possible and was successfully performed.
     */
    public boolean transformMathStatement(Object additionalData);
}
