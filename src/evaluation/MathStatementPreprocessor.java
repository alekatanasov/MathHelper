
package evaluation;

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
        
        if(mathStatement.size() < 2){
            return;
        }
        
        for(int c=1; c<mathStatement.size();c++){
            
        }
    }
}
