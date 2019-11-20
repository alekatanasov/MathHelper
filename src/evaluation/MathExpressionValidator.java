
package evaluation;

import statement.Bracket;
import statement.Bracket.BracketType;
import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.statement.MathSymbol;
import interfaces.statement.MathSymbol.MathSymbolType;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class MathExpressionValidator extends MathStatementContainer implements ParameterIndependentAnalyzer{
    public MathExpressionValidator(SymbolicStatement statement){
        super(statement);
    }
    
    /**
     * Checks if the currently loaded mathematical statement is valid math expression.
     * 
     * @return true if the math statement is indeed valid
     */
    @Override
    public Boolean analyzeMathStatement(){
        Boolean isValidExpression = true;
        
        if(!checkBrackets()){
            isValidExpression = false;
        }
        
        return isValidExpression;
    }
    
    /**
     * 
     * @return true if the brackets in the currently loaded math statement are valid( the
     *         number of opened brackets matches the number of closed ones )
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
