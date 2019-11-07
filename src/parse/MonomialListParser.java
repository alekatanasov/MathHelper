

package parse;

import interfaces.expression.Monomial;
import interfaces.expression.SymbolicStatement;
import interfaces.parse.MonomialParser;
import java.util.List;

/**
 *
 * @author Alexanander Atanasov
 */
public class MonomialListParser implements MonomialParser {
    private List<Monomial> lastParsedStatement;
    
    public MonomialListParser(){
        //
    }
    
    @Override
    public boolean parseMonomials(SymbolicStatement statement){
        boolean parseResult = false;
        
        // to do
        
        return parseResult;
    }
    
    @Override
    public List<Monomial> popLastParsedStatement(){
        List<Monomial> statement = getLastParsedStatement();
        setLastParsedStatement(null);
        return statement;
    }
    
    private void setLastParsedStatement(List<Monomial> statement){
        this.lastParsedStatement = statement;
    }
    
    private List<Monomial> getLastParsedStatement(){
        return this.lastParsedStatement;
    }
}
