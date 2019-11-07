

package interfaces.expression;

import expression.Constant;

/**
 *
 * @author Alexander Atanasov
 */
public interface Monomial {
    public Constant getCoefficient();
    
    public Constant getHighestPower();
    
    public int getBeginningPosition();
    
    public int getEndingPosition();
}
