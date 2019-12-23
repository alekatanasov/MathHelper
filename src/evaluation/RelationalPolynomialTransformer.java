

package evaluation;

import interfaces.evaluation.StatementContainer;
import interfaces.statement.Monomial;
import interfaces.statement.RelationalPolynomial;
import interfaces.statement.SymbolicStatement;
import java.util.List;
import statement.RelationalPolynomialStatement;

/**
 * 
 * 
 * @author Alexander Atanasov
 */
public abstract class RelationalPolynomialTransformer implements StatementContainer{
    private RelationalPolynomial relationalPolynomial;
    
    public RelationalPolynomialTransformer(SymbolicStatement statement){
        loadMathStatement(statement);
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
    
    @Override
    public final void loadMathStatement(SymbolicStatement statement){
        this.relationalPolynomial = RelationalPolynomialStatement.createRelationalPolynomialStatement(statement);
    }
}
