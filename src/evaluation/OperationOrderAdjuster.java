
package evaluation;

import expression.Bracket;
import expression.Bracket.BracketType;
import expression.Operation;
import interfaces.expression.Symbol;
import interfaces.expression.Symbol.SymbolType;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * This class transformMathStatement will change each operation's operationOrder field
 * according to the number of pending open brackets.
 * 
 * @author Alexander Atanasov
 */
public class OperationOrderAdjuster extends MathStatementTransformer{
    public OperationOrderAdjuster(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public boolean transformMathStatement(){
        boolean isTrasformationSuccess = false;
        List<Symbol> symbols = this.getMathStatement().getStatement();
        Symbol symbol;
        Bracket bracket;
        Operation operation;
        int openBrackets = 0;
        
        for(int c=0; c < symbols.size();c++){
            symbol = symbols.get(c);
            
            // check if the current symbol is bracket
            if(symbol.getSymbolType() == SymbolType.BRACKET){
                bracket = (Bracket) symbol;
                
                //adjust the openBrackets counter
                if(bracket.getBracketType() == BracketType.OPENING){
                    openBrackets++;
                } else {
                    openBrackets--;
                }
            }
            
            // check if the current symbol is Operation
            if(symbol.getSymbolType() == SymbolType.OPERATION){
                operation = (Operation) symbol;
                
                //
                operation.incrementOperationOrder(openBrackets);
            }
        }
        
        // method always returns true
        isTrasformationSuccess = true;
        return isTrasformationSuccess;
    }
}
