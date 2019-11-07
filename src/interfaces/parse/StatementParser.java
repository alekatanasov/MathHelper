

package interfaces.parse;

/**
 *
 * @author Alexander Atanasov
 */
public interface StatementParser {
    /**
     * Returns the last successfully parsed statement and discards all references
     * to it in the parser.
     * 
     * @return the last successfully parsed statement. If no statement was parsed
     *         the method will return null.
     */
    public Object popLastParsedStatement();
}
