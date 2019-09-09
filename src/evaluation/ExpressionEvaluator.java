
package evaluation;

import interfaces.evaluation.Evaluator;
import interfaces.evaluation.StatementTransformer;
import interfaces.expression.Symbol;
import interfaces.expression.SymbolicStatement;

/**
 * The evaluate method of this class can evaluate mathematical expressions.
 * 
 * @author Alexandar Atanasov
 */
public class ExpressionEvaluator implements Evaluator{
    @Override
    public SymbolicStatement evaluate(SymbolicStatement statement){
        StatementTransformer operationExecutor = new OperationExecutor(statement);
        
        while(statement.containsSymbol(Symbol.SymbolType.OPERATION)){
            operationExecutor.transformMathStatement();
        }
        
        return statement;
    }
}
