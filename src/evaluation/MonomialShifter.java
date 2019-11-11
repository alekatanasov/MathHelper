

package evaluation;

import interfaces.evaluation.ParameterDependentTransformer;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class MonomialShifter extends MathStatementLoader implements ParameterDependentTransformer{
    public enum ShiftDirection{
        RIGHT_SHIFT,
        LEFT_SHIFT;
    }
    
    public static class ShiftData{
        
    }
    
    public MonomialShifter(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public boolean transformMathStatement(Object transformationParameters){
        boolean isShifted = false;
        
        // to do
        
        return isShifted;
    }
}
