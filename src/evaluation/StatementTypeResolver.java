

package evaluation;

import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.statement.MathSymbol;
import interfaces.statement.SymbolicStatement;
import statement.Relation;
import statement.Relation.RelationType;

/**
 *
 * @author Alexander Atanasov
 */
public class StatementTypeResolver extends MathStatementContainer implements ParameterIndependentAnalyzer {
    public enum MathStatementType {
        EXPRESSION,
        EQUATION;
    }
    
    public StatementTypeResolver(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public MathStatementType analyzeMathStatement(){
        MathStatementType statementType = MathStatementType.EXPRESSION;
        Relation relation;
        
        // check if the math statement is relational statement
        if(getMathStatement().containsSymbolType(MathSymbol.MathSymbolType.RELATION)){
            relation = (Relation) getMathStatement().getFirstSymbolByType(MathSymbol.MathSymbolType.RELATION);
            
            if(relation.getRelationType() == RelationType.EQUALITY){
                statementType = MathStatementType.EQUATION;
            }
        }
        
        return statementType;
    }
}
