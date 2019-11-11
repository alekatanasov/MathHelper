
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
 * Primary class of the MathHelper library. Serves as an entry point for
 * 
 * @author Alexandar Atanasov
 */
public class MathHelper implements Helper {
    public static final String PARSE_FAIL = "parsing input failed to produce a mathematical statement";
    
    private SymbolicParser parser;
    
    public MathHelper(){
        initializeParser();
    }
    
    @Override
    public String solveMathStatement(String mathStatement){
        EvaluationStrategy evaluationStrategy = null;
        ParameterIndependentAnalyzer statementTypeResolver;
        MathStatementType statementType;
        SymbolicStatement solvedStatement;
        SymbolicStatement inputStatement;
        String invalidStatementMassage = "";
        
        // parse the statement and exit if nothing was parsed
        if(!this.parser.parseStatement(mathStatement)){
            return MathHelper.PARSE_FAIL;
        }
        
        // statement has been converted and stored in the parser. load it to the inputStatement variable
        inputStatement = MathStatement.createMathStatement(parser);
        
        // perform preprocessing
        performStatementPreprocessing(inputStatement);
        
        // load strategy based on the type of the provided statement
        statementTypeResolver = new StatementTypeResolver(inputStatement);
        statementType = (MathStatementType) statementTypeResolver.analyzeMathStatement();
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
        try {
            solvedStatement = evaluationStrategy.evaluate(inputStatement);
        } catch (InvalidStatementException e){
            // user provided an invalid statement. return error massage
            invalidStatementMassage = e.getMessage();
            return invalidStatementMassage;
        }
        
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
