

package evaluation;

import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.statement.MathSymbol.MathSymbolType;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class RelationalStatementValidator extends BaseStatementValidator implements ParameterIndependentAnalyzer {
    public RelationalStatementValidator(SymbolicStatement statement){
        super(statement);
    }
    
    /**
     * Checks if the currently loaded relational statement is valid - brackets are ok,
     * there is only one relation.
     * 
     * @return true if the math statement is indeed valid
     */
    @Override
    public Boolean analyzeMathStatement(){
        Boolean isValidExpression = true;
        
        if(!checkBrackets()){
            isValidExpression = false;
        } else if(!checkRelation()){
            isValidExpression = false;
        }
        
        return isValidExpression;
    }
    
    /**
     * 
     * @return true if there is only one relation in the currently loaded math statement
     */
    protected boolean checkRelation(){
        boolean validRelationalStatement = true;
        
        if(getMathStatement().getAllSymbolsByType(MathSymbolType.RELATION).size() != 1){
            // invalid number of relations
            validRelationalStatement = false;
        }
        
        return validRelationalStatement;
    }
}
