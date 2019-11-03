package interfaces.expression;

/**
 * Represents a single mathematical symbol.
 * 
 * @author Alexandar Atanasov
 */
public interface MathSymbol {
    public enum MathSymbolType{
        OPERATION,
        CONSTANT,
        BRACKET,
        RELATION;
    }
    
    /**
     * Each class which implements this interface has unique class dependent MathSymbol type.
     * 
     * @return The type of the current MathSymbol object.
     */
    public MathSymbolType getMathSymbolType();
    
    /**
     * 
     * @return The String representation of this math symbol.
     */
    public String getMathSymbol();
}
