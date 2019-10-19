
package evaluation;

import expression.Bracket;
import expression.Bracket.BracketType;
import expression.Constant;
import interfaces.expression.Symbol;
import interfaces.expression.Symbol.SymbolType;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * This class transformMathStatement method performs some actions to prepare 
 * the math statement for further transformations
 * 
 * @author Atanasov
 */
public class MathStatementPreprocessor extends MathStatementTransformer{
    public MathStatementPreprocessor(SymbolicStatement statement){
        super(statement);
    }
    
    /**
     * 
     * @return always returns true
     */
    @Override
    public boolean transformMathStatement(){
        fixLeadingMinus();
        fixMinusAfterBracket();
        return true;
    }
    
    private void fixLeadingMinus(){
        Symbol firstSymbol = this.getMathStatement().getSymbol(0);
        
        // check if the first symbol in the statement is the subtraction operation
        if(firstSymbol.getSymbolType() == SymbolType.OPERATION){
            if(firstSymbol.getSymbol().equals("-")){
                // insert 0 at the begging of the mathstatement
                this.getMathStatement().getStatement().add(0, new Constant("0"));
            }
        }
    }
    
    private void fixMinusAfterBracket(){
        List<Symbol> mathStatement = this.getMathStatement().getStatement();
        Symbol currentSymbol;
        Symbol previousSymbol;
        Bracket bracket;
        
        if(mathStatement.size() < 2){
            return;
        }
        
        // iterate through the math statement and perform fixes
        for(int c=1; c<mathStatement.size();c++){
            currentSymbol = mathStatement.get(c);
            previousSymbol = mathStatement.get(c-1);
            
            if(currentSymbol.getSymbolType() == SymbolType.OPERATION 
               && previousSymbol.getSymbolType() == SymbolType.BRACKET
               && currentSymbol.getSymbol().equals("-")){
                
                bracket = (Bracket) previousSymbol;
                
                if(bracket.getBracketType() == BracketType.OPENING){
                    //
                    this.getMathStatement().getStatement().add(c, new Constant("0"));
                }
            }
        }
    }
}
