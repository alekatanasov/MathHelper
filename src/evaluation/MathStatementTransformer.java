
package evaluation;

import interfaces.evaluation.StatementTransformer;
import interfaces.expression.SymbolicStatement;

/**
 *
 * @author Alexandar Atanasov
 */
public abstract class MathStatementTransformer implements StatementTransformer{
    private SymbolicStatement mathStatement;
    
    public MathStatementTransformer(SymbolicStatement statement){
        loadMathStatement(statement); 
    }
    
    @Override
    public final void loadMathStatement(SymbolicStatement statement){
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        }
        
        this.mathStatement = statement;
    }
    
    public SymbolicStatement getMathStatement(){
        return this.mathStatement;
    }
}
