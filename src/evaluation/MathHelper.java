
package evaluation;

import evaluation.StatementTypeResolver.MathStatementType;
import statement.MathStatement;
import interfaces.evaluation.ParameterIndependentTransformer;
import interfaces.evaluation.EvaluationStrategy;
import interfaces.evaluation.Helper;
import interfaces.evaluation.ParameterIndependentAnalyzer;
import interfaces.statement.SymbolicStatement;
import interfaces.parse.SymbolicMathParser;
import parse.MathStatementParser;

/**
 * Primary class of the MathHelper library. Serves as an entry point for all
 * math statement evaluations and transformations.
 * 
 * @author Alexandar Atanasov
 */
public class MathHelper implements Helper {
    public static final String PARSE_FAIL = "parsing input failed to produce a mathematical statement";
    
    private SymbolicMathParser parser;
    
    public MathHelper(){
        initializeParser();
    }
    
    @Override
    public String solveMathStatement(String inputStatement){
        EvaluationStrategy evaluationStrategy;
        SymbolicStatement solvedStatement;
        SymbolicStatement symbolicStatement;
        String invalidStatementMassage;
        
        // parse the statement and exit if nothing was parsed
        if(!this.getParser().parseStatement(inputStatement)){
            return MathHelper.PARSE_FAIL;
        }
        
        // statement has been converted and stored in the parser. load it to the symbolicStatement variable
        symbolicStatement = MathStatement.createMathStatement(parser);
        
        // perform preprocessing
        performStatementPreprocessing(symbolicStatement);
        
        // load strategy based on the type of the provided statement
        evaluationStrategy = resolveEvaluationStrategy(symbolicStatement);
        
        // perform evaluation
        try {
            solvedStatement = evaluationStrategy.evaluate(symbolicStatement);
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
    
    /**
     * Creates a new parser of type MathStatementParser
     */
    private void initializeParser(){
        this.parser = new MathStatementParser();
    }
    
    /**
     * 
     * @return Reference (no copy) to the parser field
     */
    private SymbolicMathParser getParser(){
        return this.parser;
    }
    
    /**
     * 
     * @param statement non null input statement for which evaluation strategy will be prepared
     * 
     * @return an appropriate evaluation strategy for the provided math statement
     */
    private EvaluationStrategy resolveEvaluationStrategy(SymbolicStatement statement){
        ParameterIndependentAnalyzer statementTypeResolver;
        MathStatementType  statementType;
        EvaluationStrategy evaluationStrategy = null;
        
        // find the math statement type
        statementTypeResolver = new StatementTypeResolver(statement);
        statementType = (MathStatementType) statementTypeResolver.analyzeMathStatement();
        
        // load appropriate strategy based on the type of the provided math statement
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
        
        return evaluationStrategy;
    }
}
