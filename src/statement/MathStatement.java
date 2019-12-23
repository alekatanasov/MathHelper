
package statement;

import interfaces.statement.MathSymbol;
import interfaces.statement.SymbolicStatement;
import interfaces.parse.SymbolicMathParser;
import interfaces.statement.MathSymbol.MathSymbolType;
import static interfaces.statement.SymbolicStatement.copyMathStatement;
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
    public static MathStatement createMathStatement(SymbolicMathParser parser){
        if(parser == null){
            throw new IllegalArgumentException("parser cannot be null");
        }
        
        return new MathStatement(parser.popLastParsedStatement());
    }
    
    @Override
    public MathSymbol getFirstSymbolByType(MathSymbol.MathSymbolType symbolType){
        MathSymbol wantedSymbol = null;
        
        for(MathSymbol symbol : this.getStatement()){
            if(symbol.getMathSymbolType() == symbolType){
                wantedSymbol = symbol;
                break;
            }
        }
        
        return wantedSymbol;
    }
    
    @Override
    public List<MathSymbol> getAllSymbolsByType(MathSymbol.MathSymbolType symbolType){
        List<MathSymbol> symbols = new ArrayList<>();
        
        for(MathSymbol symbol : this.getStatement()){
            if(symbol.getMathSymbolType() == symbolType){
                symbols.add(symbol);
            }
        }
        
        return symbols;
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
    public void setStatement(List<MathSymbol> statement){
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        }
        
        this.statement = statement;
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
        MathStatement equalStatement;
        
        if(object == null){
            return isEqual;
        } else if( !(object instanceof MathStatement)){
            return isEqual;
        }
        
        // compare the current statement to the provided one for equality
        equalStatement = (MathStatement) object;
        if(equalStatement.getStatement().equals(this.getStatement())){
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
    
    @Override
    public void concatenate(SymbolicStatement statement){
        List<MathSymbol> statementDeepCopy;
        
        // error check
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        } else if(statement.getStatement().isEmpty()){
            // empty newStatement provided, exit from method
            return;
        }
        
        statementDeepCopy = copyMathStatement(statement).getStatement();
        
        getStatement().addAll(statementDeepCopy);
    }
    
    @Override
    public List<Integer> getPositionsBySymbolType(MathSymbolType symbolType){
        List<Integer> positions = new ArrayList<>();
        
        // to do
        
        return positions;
    }
    
    @Override
    public int size(){
        return getStatement().size();
    }
    
    /**
     * 
     * @param symbols an array of MathSymbols representing a symbolic math statement
     */
    private void initializeStatement(MathSymbol[] symbols){
        List<MathSymbol> newStatement = new ArrayList<>();
        
        for(int c = 0;c < symbols.length;c++){
            newStatement.add(symbols[c]);
        }
        
        setStatement(newStatement);
    }

}
