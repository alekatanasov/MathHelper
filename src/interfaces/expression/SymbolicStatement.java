package interfaces.expression;

import java.util.List;

/**
 *
 * @author Alexandar Atanasov
 */
public interface SymbolicStatement {
    /**
     * 
     * @return a list representation of this statement. The list is not deep or shallow copied and 
     *         changes made to it will persist.
     */
    public List<Symbol> getStatement();
    
    /**
     * 
     * @param symbolType
     * 
     * @return true if at least one symbolType in the current SymbolicStatement is found 
     *  with symbolType type matching the provided one.
     */
    public boolean containsSymbol(Symbol.SymbolType symbolType);
}
