

package evaluation;

import interfaces.evaluation.ParameterDependentTransformer;
import interfaces.evaluation.ParameterIndependentTransformer;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class LinearEquationSolver extends RelationalPolynomialTransformer implements ParameterIndependentTransformer{
    public LinearEquationSolver(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public boolean transformMathStatement(){
        ParameterDependentTransformer monomialShifter = new RelationalMonomialShifter(getRelationalPolynomial());
        
        for(int c = 0; c < getRelationalPolynomial().size(); c++){
            
        }
        
        return true;
    }
}
