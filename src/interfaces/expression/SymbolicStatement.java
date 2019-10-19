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
    public List<MathSymbol> getStatement();
    
    /**
     * 
     * @param position the position of the symbol in the symbolic statement
     * 
     * @return the symbol at the specified position
     */
    public MathSymbol getSymbol(int position);
    
    /**
     * 
     * @param symbolType symbolType to search for
     * 
     * @return true if at least one symbol in the current SymbolicStatement is found 
     *         to have symbolType type matching the provided symbolType.
     */
    public boolean containsSymbolType(MathSymbol.SymbolType symbolType);
}
