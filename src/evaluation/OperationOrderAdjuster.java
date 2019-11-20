
package evaluation;

import statement.Bracket;
import statement.Bracket.BracketType;
import statement.Operation;
import interfaces.evaluation.ParameterIndependentTransformer;
import interfaces.statement.MathSymbol;
import interfaces.statement.MathSymbol.MathSymbolType;
import interfaces.statement.SymbolicStatement;
import java.util.List;

/**
 * This class transformMathStatement will change each operation's operationOrder field
 * according to the number of pending open brackets.
 * 
 * @author Alexander Atanasov
 */
public class OperationOrderAdjuster extends MathStatementContainer implements ParameterIndependentTransformer{
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
            
            // check if the current MathSymbol is a bracket
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
