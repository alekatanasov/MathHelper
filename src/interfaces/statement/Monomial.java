

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
     * 
     * @return This monomial's first symbol position in a polynomial statement
     */
    public int getBeginningPosition();
    
    /**
     * 
     * @return This monomial's last symbol position in a polynomial statement
     */
    public int getEndingPosition();
    
    /**
     * Flips the sign of the coefficient of this monomial.
     */
    public void flipSign();
}
