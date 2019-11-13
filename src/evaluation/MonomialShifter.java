

package evaluation;

import interfaces.evaluation.ParameterDependentTransformer;
import interfaces.statement.Polynomial;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class MonomialShifter extends MathStatementLoader implements ParameterDependentTransformer {
    private Polynomial polynomialStatement;
    
    public enum ShiftDirection{
        END_SHIFT,
        BEGINNING_SHIFT;
    }
    
    public static class ShiftData {
        private int monomialPosition;
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
                break;
            case END_SHIFT:
                break;
            default:
                throw new IllegalArgumentException("unknown shift");
        }
        
        return isShifted;
    }
    
    private void performBeginningShift(){
        
    }
    
    private void performEndShift(){
        
    }
}
