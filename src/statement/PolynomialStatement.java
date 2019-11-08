

package statement;

import interfaces.statement.Monomial;
import interfaces.statement.Polynomial;
import interfaces.parse.MonomialParser;
import java.util.List;
import parse.MonomialListParser;

/**
 *
 * @author Alexander Atanasov
 */
public class PolynomialStatement extends MathStatement implements Polynomial {
    private List<Monomial> monomials;
    private MonomialParser monomialParser;
    
    PolynomialStatement(MathSymbol[] statement){
        super(statement);
        initializeMonomialParser();
        determineMonomials();
    }
    
    @Override
    public List<Monomial> getMonomials(){
        determineMonomials();
        return this.monomials;
    }
    
    private void initializeMonomialParser(){
        this.monomialParser = new MonomialListParser();
    }
    
    private MonomialParser getMonomialParser(){
        return this.monomialParser;
    }
    
    private void setMonomials(List<Monomial> newMonomials){
        this.monomials = newMonomials;
    }
    
    private void determineMonomials(){
        List<Monomial> determinedMonomials;
        
        getMonomialParser().parseMonomials(this);
        determinedMonomials = getMonomialParser().popLastParsedStatement();
        
        setMonomials(determinedMonomials);
    }
}
