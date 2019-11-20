

package interfaces.statement;

import interfaces.parse.MonomialParser;
import java.util.List;

/**
 *
 * @author Alexander Atanasov
 */
public interface Polynomial extends SymbolicStatement {
    /**
     * 
     * @return reference (not a copy) to the monomials in this polynomial
     */
    public List<Monomial> getMonomials();
    
    public void rebaseOnMonomials();
}
