
package evaluation;

import interfaces.expression.MathSymbol;
import interfaces.expression.MathSymbol.SymbolType;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * This class transformMathStatement method will remove unnecessary brackets.
 * Unnecessary brackets are opening and closing brackets enclosing a single constant.
 * For example "(0)"
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
        List <MathSymbol> mathSymbols = this.getMathStatement().getStatement();
        
        for(int c=0; c < mathSymbols.size(); c++){
            // ignore first and last positions
            if(c==0 || c == mathSymbols.size() - 1){
                continue;
            }
            
            // check for unnecessary brackets
            if(mathSymbols.get(c).getSymbolType() == SymbolType.CONSTANT &&
               mathSymbols.get(c-1).getSymbolType() == SymbolType.BRACKET &&
               mathSymbols.get(c+1).getSymbolType() == SymbolType.BRACKET){
                // remove the unnecessary brackets
                mathSymbols.remove(c+1);
                mathSymbols.remove(c-1);
                
                isTrasformationSuccess = true;
                
                // adjust loop counter because two elements were deleted from the mathSymbols list
                c-=2;
            }
        }
        
        return isTrasformationSuccess;
    }
}
