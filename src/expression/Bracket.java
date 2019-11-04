
package expression;

/**
 * Represents a single bracket.
 * 
 * @author Alexandar Atanasov
 */
public class Bracket extends MathSymbol{
    public enum BracketType{
        OPENING("("),
        CLOSING(")");
        
        private String stringValue;
        
        BracketType(String bracket){
            this.stringValue = bracket;
        }
        
        public String getStringValue(){
            return this.stringValue;
        }
    }
    
    private BracketType bracketType;
    
    public Bracket(String bracket){
        super(bracket);
        resolveBracketType();
    }
    
    /**
     * 
     * @param supposedBracket non null String to be checked
     * 
     * @return true if the provided String is indeed a bracket
     */
    public static boolean isBracket(String supposedBracket){
        boolean isBracket = false;
        
        // error check
        if(supposedBracket == null){
            throw new IllegalArgumentException("supposedBracket cannot be null");
        }
        
        for(BracketType currentType : BracketType.values()){
            if(currentType.getStringValue().equals(supposedBracket)){
                isBracket = true;
            }
        }
        
        return isBracket;
    }
    
    public BracketType getBracketType(){
        return this.bracketType;
    }
    
    @Override
    public boolean  equals(Object object){
        boolean isEqual = false;
        Bracket bracket;
        
        if(object == null){
            return isEqual;
        } else if( !(object instanceof Bracket)){
            return isEqual;
        }
        
        bracket = (Bracket) object;
        if(bracket.getMathSymbol().equals(this.getMathSymbol())
           && bracket.getBracketType() == this.getBracketType()){
            // the provided bracket is equal to the current one
            isEqual = true;
        }
        
        return isEqual;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        
        hash *= super.hashCode();
        hash *= this.getBracketType().hashCode();
        
        return hash;
    }
    
    @Override
    public MathSymbolType getMathSymbolType(){
        return MathSymbolType.BRACKET;
    }
    
    /**
     * Sets the bracketType field based on the current MathSymbol value of this 
     * bracket;
     */
    protected final void resolveBracketType(){
        for(BracketType currentType : BracketType.values()){
            if(currentType.getStringValue().equals(getMathSymbol())){
                setBracketType(currentType);
            }
        }
    }
    
    private void setBracketType(BracketType type){
        this.bracketType = type;
    }
}
