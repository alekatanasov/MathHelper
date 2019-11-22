

package evaluation;

import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.statement.MathSymbol.MathSymbolType;
import interfaces.statement.Polynomial;
import interfaces.statement.SymbolicStatement;
import statement.PolynomialStatement;

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
        } else if(!checkMonomialCount()){
            isValidExpression = false;
        }
        
        return isValidExpression;
    }
    
    /**
     * 
     * @return true if there is only one relation in the currently loaded math statement and
     *         it's position is not the start or the end of the statement
     */
    protected boolean checkRelation(){
        boolean validRelationalStatement = true;
        int relationPosition;
        
        if(getMathStatement().getAllSymbolsByType(MathSymbolType.RELATION).size() != 1){
            // invalid number of relations
            validRelationalStatement = false;
        } 
        
        // there is only one relation. get it's position
        relationPosition = getMathStatement().getPositionsBySymbolType(MathSymbolType.RELATION).get(0);
        
        if(relationPosition == 0 || relationPosition == getMathStatement().getStatement().size() - 1){
            validRelationalStatement = false;
        }
        
        return validRelationalStatement;
    }
    
    protected boolean checkMonomialCount() {
        boolean validCount = true;
        Polynomial polynomial = PolynomialStatement.createPolynomialStatement(getMathStatement());
        
        if(polynomial.getMonomials().size() < 2){
            validCount = false;
        }
        
        return validCount;
    }
}
