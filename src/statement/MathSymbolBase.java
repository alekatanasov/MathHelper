package statement;

import java.io.Serializable;

/**
 * Represents functionality common to all math symbols.
 * 
 * @author Alexandar Atanasov
 */
public abstract class MathSymbolBase implements interfaces.statement.MathSymbol, Serializable {
    private String symbol;
    
    public MathSymbolBase(String symbol){
        setSymbol(symbol);
    }
    
    @Override
    public final String getMathSymbol(){
        return this.symbol;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        
        hash *= getMathSymbol().hashCode();
        
        return hash;
    }

    protected final void setSymbol(String symbol){
        if(symbol == null){
            throw new IllegalArgumentException("symbol cannot be null");
        } else if(symbol.isEmpty()){
            throw new IllegalArgumentException("symbol cannot be empty String");
        }
        
        this.symbol = symbol;
    }
}
