

package interfaces.parse;

import interfaces.statement.Monomial;
import interfaces.statement.SymbolicStatement;
import java.util.List;

/**
 *
 * @author Alexander Atanasov
 */
public interface MonomialParser extends StatementParser{
    public boolean parseMonomials(SymbolicStatement statement);
    
    @Override
    public List<Monomial> popLastParsedStatement();
}
