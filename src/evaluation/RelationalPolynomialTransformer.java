

package evaluation;

import interfaces.statement.RelationalPolynomial;
import interfaces.statement.SymbolicStatement;

/**
 * 
 * @author Alexander Atanasov
 */
public abstract class RelationalPolynomialTransformer extends MathStatementContainer {
    private RelationalPolynomial relationalPolynomial;
    
    public RelationalPolynomialTransformer(SymbolicStatement statement){
        super(statement);
    }
    
    protected RelationalPolynomial getRelationalPolynomial(){
        return this.relationalPolynomial;
    }
    
    private void resolveRelationalPolynomial(){
        // to do
    }
}
