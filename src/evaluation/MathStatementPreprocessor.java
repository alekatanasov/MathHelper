
package evaluation;

import expression.Bracket;
import expression.Bracket.BracketType;
import expression.Constant;
import interfaces.evaluation.DataIndependentTransformer;
import interfaces.expression.MathSymbol;
import interfaces.expression.MathSymbol.MathSymbolType;
import interfaces.expression.SymbolicStatement;
import java.util.List;

/**
 * This class transformMathStatement method performs some actions to prepare 
 * the math statement for further transformations
 * 
 * @author Atanasov
 */
public class MathStatementPreprocessor extends MathStatementTransformer implements DataIndependentTransformer{
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
        MathSymbol firstSymbol = this.getMathStatement().getSymbol(0);
        
        // check if the first symbol in the statement is the subtraction operation
        if(firstSymbol.getMathSymbolType() == MathSymbolType.OPERATION){
            if(firstSymbol.getMathSymbol().equals("-")){
                // insert 0 at the begging of the mathstatement
                this.getMathStatement().getStatement().add(0, new Constant("0"));
            }
        }
    }
    
    private void fixMinusAfterBracket(){
        List<MathSymbol> mathStatement = this.getMathStatement().getStatement();
        MathSymbol currentSymbol;
        MathSymbol previousSymbol;
        Bracket bracket;
        
        if(mathStatement.size() < 2){
            return;
        }
        
        // iterate through the math statement and perform fixes
        for(int c=1; c<mathStatement.size();c++){
            currentSymbol = mathStatement.get(c);
            previousSymbol = mathStatement.get(c-1);
            
            if(currentSymbol.getMathSymbolType() == MathSymbolType.OPERATION 
               && previousSymbol.getMathSymbolType()== MathSymbolType.BRACKET
               && currentSymbol.getMathSymbol().equals("-")){
                
                bracket = (Bracket) previousSymbol;
                
                if(bracket.getBracketType() == BracketType.OPENING){
                    //
                    this.getMathStatement().getStatement().add(c, new Constant("0"));
                }
            }
        }
    }
}
