

package expression;

import interfaces.expression.Monomial;
import interfaces.expression.Polynomial;
import java.util.List;

/**
 *
 * @author Alexander Atanasov
 */
public class PolynomialStatement extends MathStatement implements Polynomial {
    private List<Monomial> monomials;
    
    PolynomialStatement(MathSymbol[] statement){
        super(statement);
    }
    
    @Override
    public List<Monomial> getMonomials(){
        return this.monomials;
    }
}
