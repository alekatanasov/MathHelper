package interfaces.statement;

import java.util.List;

/**
 * Represents a linear sequence of MathSymbols.
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
    public boolean containsSymbolType(MathSymbol.MathSymbolType symbolType);
    
    /**
     * Traverses this statement from 0 to size() and returns the first symbol encountered
     * which is of the specified type.
     * 
     * @param symbolType non null SymbolType to search for
     * 
     * @return the first symbol encountered which is of the specified SymbolType. If there is 
     *         no symbol of the specified type in this expression, the method will return null.
     */
    public MathSymbol getFirstSymbolByType(MathSymbol.MathSymbolType symbolType);
    
    public List<MathSymbol> getAllSymbolsByTybe(MathSymbol.MathSymbolType symbolType);
}
