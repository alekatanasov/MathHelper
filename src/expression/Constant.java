
package expression;

import java.math.BigDecimal;

/**
 * Represents a numeric value.
 * 
 * @author Alexander Atanasov
 */
public final class Constant extends MathSymbol{
    public Constant(String constant){
        super(constant);
    }
    
    /**
     * Checks if a String represents a numeric value.
     * 
     * @param supposedConstant String to be checked
     * 
     * @return true if the provided String is not null or empty and represents valid
     *         numeric value
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
    public SymbolType getSymbolType(){
        return SymbolType.CONSTANT;
    }
    
    /**
     * 
     * @return BigDecimal deep copy representing the value of the current constant
     */
    public BigDecimal getValue(){
        return new BigDecimal(this.getSymbol());
    }
}
