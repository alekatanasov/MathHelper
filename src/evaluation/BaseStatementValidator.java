/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluation;

import interfaces.statement.MathSymbol;
import interfaces.statement.SymbolicStatement;
import statement.Bracket;

/**
 *
 * @author Alexander Atanasov
 */
public abstract class BaseStatementValidator extends MathStatementContainer{
    public BaseStatementValidator(SymbolicStatement statement){
        super(statement);
    }
    
    /**
     * 
     * @return true if the brackets in the currently loaded math statement are valid( the
     *         number of opened brackets matches the number of closed ones )
     */
    protected boolean checkBrackets(){
        boolean validBrackets = true;
        Bracket bracket;
        int openingBrackets = 0;
        int closingBrackets = 0;
        
        // get the total number of opening and closing brackets
        for(MathSymbol symbol : this.getMathStatement().getStatement()){
            // check if the current symbol is a bracket
            if(symbol.getMathSymbolType() == MathSymbol.MathSymbolType.BRACKET){
                bracket = (Bracket) symbol;
                
                if(bracket.getBracketType() == Bracket.BracketType.OPENING){
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
