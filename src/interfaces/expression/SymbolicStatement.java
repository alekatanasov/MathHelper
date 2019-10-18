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
     * @param position the position of the symbol in the symbolic statement
     * 
     * @return the symbol at the specified position
     */
    public Symbol getSymbol(int position);
    
    /**
     * 
     * @param symbolType
     * 
     * @return true if at least one symbolType in the current SymbolicStatement is found 
     *  with symbolType type matching the provided one.
     */
    public boolean containsSymbolType(Symbol.SymbolType symbolType);
}
