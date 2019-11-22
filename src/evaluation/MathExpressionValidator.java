
package evaluation;

import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class MathExpressionValidator extends BaseStatementValidator implements ParameterIndependentAnalyzer{
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
}
