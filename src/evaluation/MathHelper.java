
package evaluation;

import expression.MathStatement;
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
        
        // parse the statement and exit if nothing was parsed
        if(!this.parser.parseStatement(mathStatement)){
            return "empty or non mathematical statement provided";
        }
        
        // statement has been converted and stored in the parser. pass it to the evaluator
        solvedStatement = expressionEvaluator.evaluate(MathStatement.createMathStatement(parser));
        return solvedStatement.toString();
    }
    
    private void initializeParser(){
        this.parser = new MathStatementParser();
    }
}
