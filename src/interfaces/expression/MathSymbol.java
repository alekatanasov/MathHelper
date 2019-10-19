package interfaces.expression;

/**
 * Represents a single mathematical symbol.
 * 
 * @author Alexandar Atanasov
 */
public interface MathSymbol {
    public enum SymbolType{
        OPERATION,
        CONSTANT,
        BRACKET;
    }
    
    public SymbolType getSymbolType();
    
    /**
     * 
     * @return The String representation of this math symbol.
     */
    public String getMathSymbol();
}
