
package interfaces.parse;

import interfaces.expression.MathSymbol;

/**
 *
 * @author Alexandar Atanasov
 */
public interface SymbolicParser extends StatementParser {
    /**
     * Converts a mathematical statement from String to MathSymbol array. The converted
     * statement is saved internally in the current parser instance and can be 
     * accessed by calling the popLastParsedStatement method.
     * 
     * @param statement String representing a math statement.
     * 
     * @return true if the resulting  MathSymbol array is non empty.
     */
    public boolean parseStatement(String statement);
    
    @Override
    public MathSymbol[] popLastParsedStatement();
}
