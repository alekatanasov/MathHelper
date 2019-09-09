package interfaces.expression;

/**
 *
 * @author Alexandar Atanasov
 */
public interface Symbol {
    public enum SymbolType{
        OPERATION,
        CONSTANT
    }
    
    public SymbolType getSymbolType();
    
    /**
     * 
     * @return The String representation of this symbol.
     */
    public String getSymbol();
}
