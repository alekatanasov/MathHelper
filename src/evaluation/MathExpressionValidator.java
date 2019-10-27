
package evaluation;

import expression.Bracket;
import expression.Bracket.BracketType;
import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.expression.MathSymbol;
import interfaces.expression.MathSymbol.MathSymbolType;
import interfaces.expression.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class MathExpressionValidator extends MathStatementLoader implements ParameterIndependentAnalyzer{
    public MathExpressionValidator(SymbolicStatement statement){
        super(statement);
    }
    
    /**
     * Checks if the currently loaded mathematical statement is valid math expression.
     * 
     * @return true if the math statement is indeed valid
     */
    @Override
    public Object analyzeMathStatement(){
        Boolean isValidExpression = true;
        
        if(!checkBrackets()){
            isValidExpression = false;
        }
        
        return isValidExpression;
    }
    
    /**
     * 
     * @return true of brackets in the currently loaded math statement are valid
     */
    private boolean checkBrackets(){
        boolean validBrackets = true;
        Bracket bracket;
        int openingBrackets = 0;
        int closingBrackets = 0;
        
        // get the total number of opening and closing brackets
        for(MathSymbol symbol : this.getMathStatement().getStatement()){
            // check if the current symbol is a bracket
            if(symbol.getMathSymbolType() == MathSymbolType.BRACKET){
                bracket = (Bracket) symbol;
                
                if(bracket.getBracketType() == BracketType.OPENING){
                    openingBrackets++;
                } else {
                    closingBrackets++;
                }
            }
        }
        
        // validate brackets
        if(openingBrackets != closingBrackets){
            validBrackets = false;
        }
        
        return validBrackets;
    }
}
