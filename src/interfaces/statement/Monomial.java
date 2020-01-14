

package interfaces.statement;

import statement.Constant;

/**
 *
 * @author Alexander Atanasov
 */
public interface Monomial extends SymbolicStatement, NormalizableStatement {
    public Constant getCoefficient();
    
    public Constant getHighestPower();
    
    /**
     * Flips the sign of the coefficient of this monomial.
     */
    public void flipSign();
}
