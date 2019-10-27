
package evaluation;

import expression.Bracket;
import expression.Bracket.BracketType;
import interfaces.evaluation.ParameterIndependentTransformer;
import interfaces.expression.MathSymbol;
import interfaces.expression.MathSymbol.MathSymbolType;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * This class transformMathStatement() method will remove unnecessary brackets.
 * Unnecessary brackets are opening and closing brackets enclosing a single constant -
 * for example "(0)".
 * 
 * @author Alexander Atanasov
 */
public class BracketRemover extends MathStatementLoader implements ParameterIndependentTransformer{
    public BracketRemover(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public boolean transformMathStatement(){
        boolean isTrasformationSuccess = false;
        Bracket leftBracket;
        Bracket rightBracket;
        List <MathSymbol> mathSymbols = this.getMathStatement().getStatement();
        
        for(int c=0; c < mathSymbols.size(); c++){
            // ignore first and last positions
            if(c==0 || c == mathSymbols.size() - 1){
                continue;
            }
            
            // check for unnecessary brackets
            if(mathSymbols.get(c).getMathSymbolType() == MathSymbolType.CONSTANT 
               && mathSymbols.get(c-1).getMathSymbolType() == MathSymbolType.BRACKET 
               && mathSymbols.get(c+1).getMathSymbolType() == MathSymbolType.BRACKET){
                
                // casting is safe since c+1 and c-2 are confirmed brackets
                leftBracket = (Bracket) mathSymbols.get(c-1);
                rightBracket = (Bracket)mathSymbols.get(c+1);
                
                if(leftBracket.getBracketType() == BracketType.OPENING 
                   && rightBracket.getBracketType() == BracketType.CLOSING){
                    
                    // remove the unnecessary brackets
                    mathSymbols.remove(c+1);
                    mathSymbols.remove(c-1);
                
                    isTrasformationSuccess = true; 
                }
                
                // adjust loop counter because two elements were deleted from the mathSymbols list
                c-=2;
            }
        }
        
        return isTrasformationSuccess;
    }
}
