package expression;

import interfaces.expression.Symbol;

/**
 * Represents a single mathematical symbol.
 * 
 * @author Alexandar Atanasov
 */
public abstract class MathSymbol implements Symbol{
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
    public final String getSymbol(){
        return this.symbol;
    }
}
