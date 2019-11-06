

package interfaces.parse;

import interfaces.expression.MathSymbol;

/**
 *
 * @author Alexander Atanasov
 */
public interface StatementParser {
    /**
     * Returns the last successfully parsed mathematical statement and discards all references
     * to it in the parser.
     * 
     * @return the last successfully parsed mathematical statement. If no statement was parsed
     *         the method will return null.
     */
    public MathSymbol[] popLastParsedStatement();
}
