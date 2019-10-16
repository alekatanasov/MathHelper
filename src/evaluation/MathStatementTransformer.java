
package evaluation;

import interfaces.evaluation.StatementTransformer;
import interfaces.expression.SymbolicStatement;

/**
 * An abstract implementation of the StatementTransformer interface, which holds
 * functionality common to all inheritors.
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
    
    /**
     * Default implementation of the method which does not do anything and exists for convenience
     * since not all inheritors use additional data.
     * 
     * @param data 
     */
    @Override
    public void loadAdditionalData(Object data){
        // nothing to do here
    }
    
    /**
     * 
     * @return reference to the mathStatement field (no shallow or deep copy )
     */
    public SymbolicStatement getMathStatement(){
        return this.mathStatement;
    }
}
