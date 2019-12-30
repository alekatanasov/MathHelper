

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
        // to do
        
        return true;
    }
}
