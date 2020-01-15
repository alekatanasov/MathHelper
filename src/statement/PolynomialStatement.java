

package statement;

import interfaces.statement.Monomial;
import interfaces.statement.Polynomial;
import interfaces.parse.MonomialParser;
import interfaces.statement.SymbolicStatement;
import java.util.List;
import parse.MonomialListParser;

/**
 *
 * @author Alexander Atanasov
 */
public class PolynomialStatement implements Polynomial {
    private List<Monomial> monomials;
    private static MonomialParser monomialParser;
    
    static {
        monomialParser = new MonomialListParser();
    }
    
    protected PolynomialStatement(SymbolicStatement statement) {
        List<Monomial> determinedMonomials;
        
        // create deep copy of the provided statement to make the new polynomial statement
        // completely independent
        statement = SymbolicStatement.copyMathStatement(statement);
        
        // parse monomials
        getMonomialParser().parseMonomials(statement);
        determinedMonomials = getMonomialParser().popLastParsedStatement();
        
        setMonomials(determinedMonomials);
    }
    
    /**
     * 
     * @param statement non null symbolic statement from which this polynomial statement will be
     *                  constructed
     * 
     * @return polynomial statement constructed from the provided symbolic statement. The
     *         polynomial statement is independent(deep copied) from the symbolic statement
     */
    public static PolynomialStatement createPolynomialStatement(SymbolicStatement statement){
        PolynomialStatement newStatement;
        List<Monomial> determinedMonomials;
        
        // error check
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        }
        
        // create new PolynomialStatement instance
        newStatement = new PolynomialStatement(statement);
        
        return newStatement;
    }
    
    @Override
    public final List<Monomial> getMonomials(){
        return this.monomials;
    }
    
    @Override
    public void convertToCanonicalForm(){
        // to do
    }
    
    @Override
    public boolean isInCanonicalForm(){
        // polynomials are alwais in canonical form
        return true;
    }
    
    /**
     * 
     * @return Reference (no copy) to the monomialParser field
     */
    protected static MonomialParser getMonomialParser(){
        return monomialParser;
    }
    
    /**
     * 
     * @param newMonomials the new value of the monomials field
     */
    private void setMonomials(List<Monomial> newMonomials){
        if(newMonomials == null){
            throw new IllegalArgumentException("newMonomials cannot be null");
        }
        
        this.monomials = newMonomials;
    }
    
    /**
     * 
     */
    private void initializeMonomials(SymbolicStatement statement){
        List<Monomial> determinedMonomials;
        
        getMonomialParser().parseMonomials(statement);
        determinedMonomials = getMonomialParser().popLastParsedStatement();
        
        setMonomials(determinedMonomials);
    }
}
