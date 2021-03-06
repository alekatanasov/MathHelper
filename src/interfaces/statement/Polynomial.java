

package interfaces.statement;

import java.util.List;

/**
 *
 * @author Alexander Atanasov
 */
public interface Polynomial extends NormalizableStatement{
    /**
     * 
     * @return reference (not a copy) to the monomials in this polynomial
     */
    public List<Monomial> getMonomials();
    
}
