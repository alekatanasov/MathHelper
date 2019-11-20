

package statement;

import interfaces.statement.Monomial;
import interfaces.statement.Polynomial;
import interfaces.parse.MonomialParser;
import interfaces.statement.MathSymbol;
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
    
    public static PolynomialStatement createPolynomialStatement(SymbolicStatement statement){
        PolynomialStatement newStatement;
        MathSymbol[] symbolicArray;
        
        // error check
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        }
        
        symbolicArray = new MathSymbolBase[statement.getStatement().size()];
        symbolicArray = statement.getStatement().toArray(symbolicArray);
        
        newStatement = new PolynomialStatement(symbolicArray);
        
        return newStatement;
    }
    
    @Override
    public void rebaseOnMonomials(){
        List<Monomial> monomialStatement = getMonomials();
        List<MathSymbol> rebasedStatement = new ArrayList<>();
        
        if(monomialStatement.isEmpty()){
            return;
        }
        
        for(Monomial monomial : monomialStatement){
            rebasedStatement.addAll(monomial.getStatement());
        }
        
        setStatement(rebasedStatement);
    }
    
    @Override
    public final List<Monomial> getMonomials(){
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
