

package evaluation;

import interfaces.evaluation.ParameterDependentTransformer;
import interfaces.statement.Monomial;
import interfaces.statement.RelationalPolynomial;
import interfaces.statement.SymbolicStatement;
import java.util.List;

/**
 *
 * @author Alexander Atanasov
 */
public class MonomialShifter extends RelationalPolynomialTransformer implements ParameterDependentTransformer {
    public enum ShiftDirection {
        END_SHIFT,
        BEGINNING_SHIFT;
    }
    
    public static class ShiftData {
        /**
         * The position of the monomial (which is to be shifted) in a list of monomials of
         * a polynomial statement.
         */
        private int monomialPosition;
        
        /**
         * specifies if a monomial will be shifted to the beginning or the end in the list of
         * all monomials.
         */
        private ShiftDirection shiftDirection;
        
        public ShiftData(int position, ShiftDirection direction){
            setMonomialPosition(position);
            setShiftDirection(direction);
        }
        
        public int getMonomialPosition(){
            return this.monomialPosition;
        }
        
        public ShiftDirection getShiftDirection(){
            return this.shiftDirection;
        }
        
        private void setMonomialPosition(int position){
            if(position < 0){
                throw new IllegalArgumentException("monomialPosition cannot be negative");
            }
            
            this.monomialPosition = position;
        }
        
        private void setShiftDirection(ShiftDirection direction){
            if(direction == null){
                throw new IllegalArgumentException("shiftDirection cannot be null");
            }
            
            this.shiftDirection = direction;
        }
    }
    
    public MonomialShifter(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public boolean transformMathStatement(Object transformationParameters){
        boolean isShifted = false;
        ShiftData shiftData;
        
        // error check
        if(transformationParameters == null){
            throw new IllegalArgumentException("transformationParameter cannot be null");
        } else if( !(transformationParameters instanceof ShiftData)){
            throw new IllegalArgumentException("invalid transformationParameter type");
        }
        
        shiftData = (ShiftData) transformationParameters;
        
        switch(shiftData.getShiftDirection()){
            case BEGINNING_SHIFT:
                performBeginningShift();
                break;
            case END_SHIFT:
                performEndShift();
                break;
            default:
                throw new IllegalArgumentException("unknown shift");
        }
        
        return isShifted;
    }
    
    private void performBeginningShift(){
        Monomial shiftMonomial;
    }
    
    private void performEndShift(){
        
    }
}
