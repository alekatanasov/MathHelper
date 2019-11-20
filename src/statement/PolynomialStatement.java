

package statement;

import interfaces.statement.Monomial;
import interfaces.statement.Polynomial;
import interfaces.parse.MonomialParser;
import interfaces.statement.SymbolicStatement;
import java.util.ArrayList;
import java.util.List;
import parse.MonomialListParser;

/**
 *
 * @author Alexander Atanasov
 */
public class PolynomialStatement extends MathStatement implements Polynomial {
    private List<Monomial> monomials;
    private static MonomialParser monomialParser;
    
    static {
        monomialParser = new MonomialListParser();
    }
    
    protected PolynomialStatement(MathSymbol[] statement){
        super(statement);
        determineMonomials();
    }
    
    public static boolean createPolynomialStatement(SymbolicStatement statement){
        boolean creationSuccess = false;
        
        // to do
        
        return creationSuccess;
    }
    
    @Override
    public void rebaseOnMonomials(){
        List<Monomial> monomialStatement = getMonomials();
        List<interfaces.statement.MathSymbol> rebasedStatement = new ArrayList<>();
        
        if(monomialStatement.isEmpty()){
            return;
        }
        
        for(Monomial monomial : monomialStatement){
            rebasedStatement.addAll(monomial.getStatement());
        }
        
        setStatement(rebasedStatement);
    }
    
    @Override
    public List<Monomial> getMonomials(){
        determineMonomials();
        return this.monomials;
    }
    
    protected  MonomialParser getMonomialParser(){
        return monomialParser;
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
