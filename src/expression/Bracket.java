
package expression;

/**
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
     * @param symbol String to be checked
     * 
     * @return true if the provided String is indeed a bracket
     */
    public static boolean isBracket(String symbol){
        boolean isBracket = false;
        
        if(symbol.equals("(")
           || symbol.equals(")")){
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
        if(this.getSymbol().equals("(")){
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
