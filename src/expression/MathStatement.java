
package expression;

import interfaces.expression.MathSymbol;
import interfaces.expression.SymbolicStatement;
import interfaces.parse.SymbolicParser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandar Atanasov
 */
public class MathStatement implements SymbolicStatement{
    private List<MathSymbol> statement;
    
    private MathStatement(MathSymbol[] statement){
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
    
    private void initializeStatement(MathSymbol[] statement){
        this.statement = new ArrayList<>();
        
        for(int c = 0;c < statement.length;c++){
            this.statement.add(statement[c]);
        }
    }

}
