

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
     * @return The list of monomials in the currently loaded RelationalPolynomial. The returned list
     *         is not a copy and changes made to it will persist.
     */
    protected List<Monomial> getMonomials(){
       return this.relationalPolynomial.getMonomials();
    }
    
    /**
     * Reconstructs the currently loaded math symbolic statement based on the currently loaded
     * relational polynomial statement.
     */
    protected void rebaseStatementOnPolynomial(){
        RelationalPolynomial polynomial = this.getRelationalPolynomial();
        
        this.getMathStatement().setStatement(polynomial.getStatement());
    }
    
    /**
     * Creates a new relational polynomial from the currently loaded symbolic statement and stores it
     * in the relationalPolynomial field.
     */
    private void resolveRelationalPolynomial(){
        this.relationalPolynomial = RelationalPolynomialStatement.createRelationalPolynomialStatement(getMathStatement());
    }
}
