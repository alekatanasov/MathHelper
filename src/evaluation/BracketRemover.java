
package evaluation;

import interfaces.expression.Symbol;
import interfaces.expression.Symbol.SymbolType;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * This class transformMathStatement method will remove unnecessary brackets.
 * Unnecessary brackets are brackets from the type (0).
 * 
 * @author Alexander Atanasov
 */
public class BracketRemover extends MathStatementTransformer{
    public BracketRemover(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public boolean transformMathStatement(){
        boolean isTrasformationSuccess = false;
        List<Symbol> symbols = this.getMathStatement().getStatement();
        
        for(int c=0; c < symbols.size(); c++){
            // ignore first and last positions
            if(c==0 || c == symbols.size() - 1){
                continue;
            }
            
            // check for unnecessary brackets
            if(symbols.get(c).getSymbolType() == SymbolType.CONSTANT &&
               symbols.get(c-1).getSymbolType() == SymbolType.BRACKET &&
               symbols.get(c+1).getSymbolType() == SymbolType.BRACKET){
                // remove the unnecessary brackets
                symbols.remove(c+1);
                symbols.remove(c-1);
                
                isTrasformationSuccess = true;
                
                // adjust loop counter because two elements were deleted from the symbols list
                c-=2;
            }
        }
        
        return isTrasformationSuccess;
    }
}
