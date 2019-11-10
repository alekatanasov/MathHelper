
package evaluation;

import evaluation.StatementTypeResolver.MathStatementType;
import statement.MathStatement;
import interfaces.evaluation.ParameterIndependentTransformer;
import interfaces.evaluation.EvaluationStrategy;
import interfaces.evaluation.Helper;
import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.statement.SymbolicStatement;
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
        EvaluationStrategy evaluationStrategy = null;
        ParameterIndependentAnalyzer typeResolver;
        MathStatementType statementType;
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
        
        // load strategy based on the type of the provided statement
        typeResolver = new StatementTypeResolver(inputStatement);
        statementType = (MathStatementType) typeResolver.analyzeMathStatement();
        switch(statementType){
            case EXPRESSION:
                evaluationStrategy = new ExpressionEvaluationStrategy();
                break;
            case EQUATION:
                evaluationStrategy = new EquationEvaluationStrategy();
                break;
            default:
                throw new RuntimeException("Unknown statement type");
        }
        
        // perform evaluation
        solvedStatement = evaluationStrategy.evaluate(inputStatement);
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
