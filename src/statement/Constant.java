
package statement;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Represents an instance of a known constant numeric value.
 * 
 * @author Alexander Atanasov
 */
public final class Constant extends MathSymbolBase implements Serializable {
    public Constant(String constant){
        super(constant);
    }
    
    /**
     * Checks if the provided String represents a numeric constant value.
     * 
     * @param supposedConstant String to be checked
     * 
     * @return true if the provided String is not null or empty and represents valid
     *         numeric value. Otherwise the method will return false
     */
    public static boolean isConstant(String supposedConstant){
        boolean isConstant = false;
        
        if(supposedConstant == null){
            return isConstant;
        } else if(supposedConstant.isEmpty()){
            return isConstant;
        }
        
        try{
            Double.parseDouble(supposedConstant);
        } catch (NumberFormatException e) {
            return isConstant;
        }
        
        
        isConstant = true;
        return isConstant;
    }
    
    @Override
    public boolean  equals(Object object){
        boolean isEqual = false;
        Constant constant;
        
        if(object == null){
            return isEqual;
        } else if( !(object instanceof Constant)){
            return isEqual;
        }
        
        constant = (Constant)object;
        if(constant.getMathSymbol().equals(this.getMathSymbol())){
            isEqual = true;
        } else {
            isEqual = false;
        }
        
        return isEqual;
    }
    
    @Override
    public MathSymbolType getMathSymbolType(){
        return MathSymbolType.CONSTANT;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        
        hash *= super.hashCode();
        
        return hash;
    }
    
    /**
     * 
     * @return BigDecimal deep copy representing the value of the current constant
     */
    public BigDecimal getValue(){
        return new BigDecimal(this.getMathSymbol());
    }
}
