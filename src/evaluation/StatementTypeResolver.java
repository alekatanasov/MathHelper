

package evaluation;

import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.statement.MathSymbol;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class StatementTypeResolver extends MathStatementLoader implements ParameterIndependentAnalyzer {
    public enum StatementType{
        EXPRESSION,
        EQUATION;
    }
    
    public StatementTypeResolver(SymbolicStatement statement){
        super(statement);
    }
    
    @Override
    public StatementType analyzeMathStatement(){
        StatementType statementType = StatementType.EXPRESSION;
        
        if(getMathStatement().containsSymbolType(MathSymbol.MathSymbolType.RELATION)){
            
        }
        
        return statementType;
    }
}
