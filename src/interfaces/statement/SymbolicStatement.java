package interfaces.statement;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import statement.MathStatement;

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
    
    public void setStatement(List<MathSymbol> statement);
    
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
    
    /**
     * 
     * @param symbolType non null SymbolType
     * 
     * @return a list of all symbols from the selected SymbolType. If the statement does not
     *         contain any MathSymbols from the required type, this method will return an empty list
     */
    public List<MathSymbol> getAllSymbolsByType(MathSymbol.MathSymbolType symbolType);
    
    /**
     * Concatenates the provided statement to this one. The provided statement will be deep
     * copied and then appended to the current statement.
     * 
     * @param statement non null statement to be added to the current one
     */
    public void concatenate(SymbolicStatement statement);
    
    /**
     * 
     * @param statement statement to be copied. If null this method will return null.
     * 
     * @return deep copy of the provided statement
     */
    public static SymbolicStatement copyMathStatement(SymbolicStatement statement){
        MathStatement copyStatement;
        
        // copy by serialization and deserialization
        try {
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
	    objectOutputStream.writeObject(statement);

            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
	    ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            copyStatement = (MathStatement) objectInputStream.readObject();
       } catch (IOException e) {
	   throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
	   throw new RuntimeException(e);
       }
        
        return copyStatement;
    }
}
