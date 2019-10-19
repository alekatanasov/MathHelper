package expression;

/**
 * Represents functionality common to all math symbols.
 * 
 * @author Alexandar Atanasov
 */
public abstract class MathSymbol implements interfaces.expression.MathSymbol{
    private String symbol;
    
    public MathSymbol(String symbol){
        setSymbol(symbol);
    }
    
    protected final void setSymbol(String symbol){
        if(symbol == null){
            throw new IllegalArgumentException("symbol cannot be null");
        } else if(symbol.isEmpty()){
            throw new IllegalArgumentException("symbol cannot be empty String");
        }
        
        this.symbol = symbol;
    }
    
    @Override
    public final String getMathSymbol(){
        return this.symbol;
    }
}
