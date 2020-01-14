

package statement;

import interfaces.statement.MathSymbol;
import interfaces.statement.Monomial;
import interfaces.statement.SymbolicStatement;
import java.util.List;

/**
 *
 * @author Alexander Atanasov
 */
public class SingleVariableMonomial  extends MathStatement implements Monomial {
    private Constant coefficient;
    private Constant highestPower;
    
    protected SingleVariableMonomial(List<MathSymbol> symbols){
        super(symbols);
        convertToCanonicalForm();
    }
    
    /**
     * 
     * @param symbols
     * @param positionBegin
     * @param positionEnd
     * @return 
     */
    public static SingleVariableMonomial createSingleVariableMonomial(List<MathSymbol> symbols){
        SymbolicStatement newMonomial;
        
        newMonomial = new SingleVariableMonomial(symbols);
        
        // make deep copy of the Monomial so it is completeley independent of the parent polynomial
        newMonomial = SymbolicStatement.copyMathStatement(newMonomial);
        
        return (SingleVariableMonomial) newMonomial;
    }
    
    @Override
    public Constant getCoefficient(){
        return this.coefficient;
    }
    
    @Override
    public Constant getHighestPower(){
        return this.highestPower;
    }
    
    @Override
    public void flipSign(){
        getCoefficient().flipSign();
    }
    
    @Override
    public final void convertToCanonicalForm(){
        //
    }
    
    @Override
    public boolean isInCanonicalForm(){
        // monomials are alwais in canonical form
        return true;
    }
    
    /**
     * 
     * @param value Constant representing the numeric coefficient of this Monomial
     */
    private void setCoefficient(Constant value){
        this.coefficient = value;
    }
    
    /**
     * 
     * @param power Constant representing the highest power of this Monomial
     */
    private void setHighestPower(Constant power){
        this.highestPower = power;
    }
    
    // private void 
}
