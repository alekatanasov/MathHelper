
package evaluation;

import expression.MathStatement;
import interfaces.evaluation.ParameterIndependentTransformer;
import interfaces.evaluation.Evaluator;
import interfaces.evaluation.Helper;
import interfaces.expression.SymbolicStatement;
import interfaces.parse.SymbolicParser;
import parse.MathStatementParser;

/**
 *
 * @author Alexandar Atanasov
 */
public class MathHelper implements Helper{
    private SymbolicParser parser;
    
    public MathHelper(){
        initializeParser();
    }
    
    @Override
    public String solveMathStatement(String mathStatement){
        Evaluator expressionEvaluator = new ExpressionEvaluator();
        SymbolicStatement solvedStatement;
        SymbolicStatement inputStatement;
        
        // parse the statement and exit if nothing was parsed
        if(!this.parser.parseStatement(mathStatement)){
            return "empty or non mathematical statement provided";
        }
        
        // statement has been converted and stored in the parser. load it to the inputStatement variable
        inputStatement = MathStatement.createMathStatement(parser);
        
        // perform preprocessing
        performStatementPreprocessing(inputStatement);
        
        // perform evaluation
        solvedStatement = expressionEvaluator.evaluate(inputStatement);
        return solvedStatement.toString();
    }
    
    /**
     * 
     * @param inputStatement symbolic math statement to be preprocessed. cannot be null
     */
    private void performStatementPreprocessing(SymbolicStatement inputStatement){
   ParameterIndependentTransformer preprocessor = new MathStatementPreprocessor(inputStatement);
        
        preprocessor.transformMathStatement();
    }
    
    private void initializeParser(){
        this.parser = new MathStatementParser();
    }
}
