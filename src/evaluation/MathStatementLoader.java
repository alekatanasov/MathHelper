
package evaluation;

import interfaces.evaluation.StatementLoader;
import interfaces.expression.SymbolicStatement;

/**
 * An abstract implementation of the StatementLoader interface, which holds
 * functionality common to all inheriting classes.
 * 
 * @author Alexandar Atanasov
 */
public abstract class MathStatementLoader implements StatementLoader{
    private SymbolicStatement mathStatement;
    
    public MathStatementLoader(SymbolicStatement statement){
        loadMathStatement(statement); 
    }
    
    @Override
    public final void loadMathStatement(SymbolicStatement statement){
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        }
        
        this.mathStatement = statement;
    }
    
    /**
     * 
     * @return reference to the mathStatement field (no shallow or deep copy )
     */
    public final SymbolicStatement getMathStatement(){
        return this.mathStatement;
    }
}
