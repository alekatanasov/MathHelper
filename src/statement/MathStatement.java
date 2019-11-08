
package statement;

import interfaces.statement.MathSymbol;
import interfaces.statement.SymbolicStatement;
import interfaces.parse.SymbolicParser;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandar Atanasov
 */
public class MathStatement implements SymbolicStatement, Serializable {
    private List<MathSymbol> statement;
    
    protected MathStatement(MathSymbol[] statement){
        initializeStatement(statement); 
    }
    
    /**
     * Static factory method for creating MathStatements.
     * 
     * @param parser non null parser instance from which the MathStatement will be fetched.
     * 
     * @return a MathStatement object which is not referenced in other places.
     */
    public static MathStatement createMathStatement(SymbolicParser parser){
        if(parser == null){
            throw new IllegalArgumentException("parser cannot be null");
        }
        
        return new MathStatement(parser.popLastParsedStatement());
    }
    
    /**
     * 
     * @param statement statement to be copied. If null this method will return null.
     * 
     * @return deep copy of the provided statement
     */
    public static MathStatement copyMathStatement(MathStatement statement){
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
    
    @Override
    public String toString(){
        String result="";
        
        for(MathSymbol symbol : statement){
            result+= symbol.getMathSymbol();
        }
        
        return result;
    }
    
    @Override
    public List<MathSymbol> getStatement(){
        return this.statement;
    }
    
    @Override
    public MathSymbol getSymbol(int position){
        return this.getStatement().get(position);
    }
    
    @Override
    public boolean containsSymbolType(MathSymbol.MathSymbolType symbolType){
        boolean result = false;
        
        for(MathSymbol symbol : this.getStatement()){
            if(symbol.getMathSymbolType().equals(symbolType)){
                result = true;
                break;
            }
        }
        
        return result;
    }
    
    @Override
    public boolean  equals(Object object){
        boolean isEqual = false;
        MathStatement statement;
        
        if(object == null){
            return isEqual;
        } else if( !(object instanceof MathStatement)){
            return isEqual;
        }
        
        statement = (MathStatement) object;
        if(statement.getStatement().equals(this.getStatement())){
            isEqual = true;
        }
        
        return isEqual;
        
    }
    
    @Override
    public int hashCode() {
        int hash = 11;
        
        hash *= this.getStatement().hashCode();
        
        return hash;
    }
    
    private void initializeStatement(MathSymbol[] statement){
        this.statement = new ArrayList<>();
        
        for(int c = 0;c < statement.length;c++){
            this.statement.add(statement[c]);
        }
    }

}
