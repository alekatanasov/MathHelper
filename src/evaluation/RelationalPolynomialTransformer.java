

package evaluation;

import interfaces.statement.Monomial;
import interfaces.statement.RelationalPolynomial;
import interfaces.statement.SymbolicStatement;
import java.util.List;
import statement.RelationalPolynomialStatement;

/**
 * 
 * @author Alexander Atanasov
 */
public abstract class RelationalPolynomialTransformer extends MathStatementContainer {
    private RelationalPolynomial relationalPolynomial;
    
    public RelationalPolynomialTransformer(SymbolicStatement statement){
        super(statement);
        resolveRelationalPolynomial();
    }
    
    /**
     * 
     * @return Reference (no shallow or deep copy) to the currently loaded RelationalPolynomial
     */
    protected RelationalPolynomial getRelationalPolynomial(){
        return this.relationalPolynomial;
    }
    
    /**
     * 
     * @return The list of monomials in the currently loaded RelationalPolynomial
     */
    protected List<Monomial> getMonomials(){
       return this.relationalPolynomial.getMonomials();
    }
    
    private void resolveRelationalPolynomial(){
        this.relationalPolynomial = RelationalPolynomialStatement.createRelationalPolynomialStatement(getMathStatement());
    }
}
