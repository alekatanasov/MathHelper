
package expression;

import interfaces.expression.Symbol;
import interfaces.expression.SymbolicStatement;
import interfaces.parse.SymbolicParser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandar Atanasov
 */
public class MathStatement implements SymbolicStatement{
    private List<Symbol> statement;
    
    private MathStatement(Symbol[] statement){
        initializeStatement(statement); 
    }
    
    /**
     * Static factory method for creating MathStatements.
     * 
     * @param parser parser instance from which the MathStatement will be fetched.
     * @return a MathStatement object which is not referenced in other places.
     */
    public static MathStatement createMathStatement(SymbolicParser parser){
        return new MathStatement(parser.popLastParsedStatement());
    }
    
    @Override
    public String toString(){
        String result="";
        
        for(Symbol symbol : statement){
            result+= symbol.getSymbol();
        }
        
        return result;
    }
    
    @Override
    public List<Symbol> getStatement(){
        return this.statement;
    }
    
    @Override
    public Symbol getSymbol(int position){
        return this.getStatement().get(position);
    }
    
    @Override
    public boolean containsSymbol(Symbol.SymbolType symbolType){
        boolean result = false;
        
        for(Symbol symbol : this.getStatement()){
            if(symbol.getSymbolType().equals(symbolType)){
                result = true;
                break;
            }
        }
        
        return result;
    }
    
    private void initializeStatement(Symbol[] statement){
        this.statement = new ArrayList<>();
        
        for(int c = 0;c < statement.length;c++){
            this.statement.add(statement[c]);
        }
    }

}
