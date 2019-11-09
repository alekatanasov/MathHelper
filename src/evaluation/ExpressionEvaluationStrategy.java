
package evaluation;

import interfaces.evaluation.ParameterIndependentTransformer;
import interfaces.evaluation.EvaluationStrategy;
import interfaces.evaluation.StatementLoader;
import interfaces.statement.MathSymbol;
import interfaces.statement.SymbolicStatement;

/**
 * The evaluate method of this class can evaluate mathematical expressions.
 * 
 * @author Alexandar Atanasov
 */
public class ExpressionEvaluationStrategy implements EvaluationStrategy{
    @Override
    public SymbolicStatement evaluate(SymbolicStatement statement){
        ParameterIndependentTransformer operationExecutor = new HighestOperationExecutor(statement);
        ParameterIndependentTransformer bracketRemover = new BracketRemover(statement);
        ParameterIndependentTransformer operationOrderAdjuster = new OperationOrderAdjuster(statement);
        
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
