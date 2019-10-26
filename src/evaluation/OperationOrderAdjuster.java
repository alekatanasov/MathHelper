
package evaluation;

import expression.Bracket;
import expression.Bracket.BracketType;
import expression.Operation;
import interfaces.evaluation.DataIndependentTransformer;
import interfaces.expression.MathSymbol;
import interfaces.expression.MathSymbol.MathSymbolType;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * This class transformMathStatement will change each operation's operationOrder field
 * according to the number of pending open brackets.
 * 
 * @author Alexander Atanasov
 */
public class OperationOrderAdjuster extends MathStatementTransformer implements DataIndependentTransformer{
    public OperationOrderAdjuster(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public boolean transformMathStatement(){
        boolean isTrasformationSuccess = false;
        List<MathSymbol> mathSymbols = this.getMathStatement().getStatement();
        MathSymbol currentMathSymbol;
        Bracket bracket;
        Operation operation;
        int openBrackets = 0;
        
        for(int c=0; c < mathSymbols.size();c++){
            currentMathSymbol = mathSymbols.get(c);
            
            // check if the current currentMathSymbol is bracket
            if(currentMathSymbol.getMathSymbolType() == MathSymbolType.BRACKET){
                bracket = (Bracket) currentMathSymbol;
                
                //adjust the openBrackets counter
                if(bracket.getBracketType() == BracketType.OPENING){
                    openBrackets++;
                } else {
                    openBrackets--;
                }
            }
            
            // check if the current currentMathSymbol is Operation
            if(currentMathSymbol.getMathSymbolType() == MathSymbolType.OPERATION){
                operation = (Operation) currentMathSymbol;
                
                //
                operation.incrementOperationOrder(openBrackets);
            }
        }
        
        // method always returns true
        isTrasformationSuccess = true;
        return isTrasformationSuccess;
    }
}
