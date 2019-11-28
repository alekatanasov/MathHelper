

package interfaces.statement;

/**
 * A type of mathematical statement which possesses canonical form.
 * 
 * @author Alexander Atanasov
 */
public interface NormalizableStatement {
    public void convertToCanonicalForm();
    
    public boolean isInCanonicalForm();
}
