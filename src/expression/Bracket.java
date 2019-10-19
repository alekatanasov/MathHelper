
package expression;

/**
 * Represents a single bracket 
 * 
 * @author Alexandar Atanasov
 */
public class Bracket extends MathSymbol{
    public enum BracketType{
        OPENING,
        CLOSING;
    }
    
    private BracketType bracketType;
    
    public Bracket(String bracket){
        super(bracket);
        setBracketType();
    }
    
    /**
     * 
     * @param supposedBracket non null String to be checked
     * 
     * @return true if the provided String is indeed a bracket
     */
    public static boolean isBracket(String supposedBracket){
        boolean isBracket = false;
        
        if(supposedBracket == null){
            throw new IllegalArgumentException("supposedBracket cannot be null");
        }
        
        if(supposedBracket.equals("(")
           || supposedBracket.equals(")")){
            isBracket = true;
        }
        
        return isBracket;
    }
    
    public BracketType getBracketType(){
        return this.bracketType;
    }
    
    /**
     * 
     */
    protected final void setBracketType(){
        if(this.getMathSymbol().equals("(")){
            this.bracketType = BracketType.OPENING;
        } else {
            this.bracketType = BracketType.CLOSING;
        }
    }
    
    @Override
    public SymbolType getSymbolType(){
        return SymbolType.BRACKET;
    }
}
