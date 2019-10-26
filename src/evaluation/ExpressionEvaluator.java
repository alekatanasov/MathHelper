
package evaluation;

import interfaces.evaluation.DataIndependentTransformer;
import interfaces.evaluation.Evaluator;
import interfaces.evaluation.StatementLoader;
import interfaces.expression.MathSymbol;
import interfaces.expression.SymbolicStatement;

/**
 * The evaluate method of this class can evaluate mathematical expressions.
 * 
 * @author Alexandar Atanasov
 */
public class ExpressionEvaluator implements Evaluator{
    @Override
    public SymbolicStatement evaluate(SymbolicStatement statement){
        DataIndependentTransformer operationExecutor = new HighestOperationExecutor(statement);
        DataIndependentTransformer bracketRemover = new BracketRemover(statement);
        DataIndependentTransformer operationOrderAdjuster = new OperationOrderAdjuster(statement);
        
        // take brackets into account and adjust the order of all operations
        operationOrderAdjuster.transformMathStatement();
        
        // execute operations and remove brackets untill no more operations exist
        while(statement.containsSymbolType(MathSymbol.MathSymbolType.OPERATION)){
            operationExecutor.transformMathStatement();
            bracketRemover.transformMathStatement();
        }
        
        return statement;
    }
}
