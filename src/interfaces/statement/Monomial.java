

package interfaces.statement;

import statement.Constant;

/**
 *
 * @author Alexander Atanasov
 */
public interface Monomial extends SymbolicStatement {
    public Constant getCoefficient();
    
    public Constant getHighestPower();
    
    public int getBeginningPosition();
    
    public int getEndingPosition();
}
