
package interfaces.parse;

import interfaces.expression.MathSymbol;

/**
 *
 * @author Alexandar Atanasov
 */
public interface SymbolicParser {
    /**
     * Converts mathematical statement from StringMathSymbolmbol array. The converted
     * statement is saved internally in the current parser instance and can be 
     * accessed by calling the popLastParsedStatement method.
     * 
     * @param statement String representing a math statement.
     * @return true if the reMathSymbolg Symbol array is non empty.
     */
    public boolean parseStatement(String statement);
    
    /**
     * Returns the last successfully parsed mathematical statement and discards all references
     * to it in the parser.
     * 
     * @return the last successfully parsed mathematical statement. If no statement was parsed
     *         the method will return null.
     */
    public MathSymbol[] popLastParsedStatement();
}
