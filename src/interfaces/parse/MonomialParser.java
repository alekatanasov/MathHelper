

package interfaces.parse;

import interfaces.expression.Monomial;
import interfaces.expression.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public interface MonomialParser extends StatementParser{
    public boolean parseMonomials(SymbolicStatement statement);
    
    @Override
    public Monomial[] popLastParsedStatement();
}
