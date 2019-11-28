

package statement;

import interfaces.statement.Monomial;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class SingleVariableMonomial  extends MathStatement implements Monomial {
    private Constant coefficient;
    private Constant highestPower;
    private int begginingPosition;
    private int endingPosition;
    
    protected SingleVariableMonomial(MathSymbolBase[] symbols, int positionBegin, int positionEnd){
        super(symbols);
        setBeginningPosition(positionBegin);
        setEndingPosition(positionEnd);
    }
    
    /**
     * 
     * @param symbols
     * @param positionBegin
     * @param positionEnd
     * @return 
     */
    public static SingleVariableMonomial createSingleVariableMonomial(MathSymbolBase[] symbols, 
                                                                      int positionBegin, int positionEnd){
        SymbolicStatement newMonomial;
        
        newMonomial = new SingleVariableMonomial(symbols, positionBegin, positionEnd);
        
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
    public int getBeginningPosition(){
        return this.begginingPosition;
    }
    
    @Override
    public int getEndingPosition(){
        return this.endingPosition;
    }
    
    @Override
    public void flipSign(){
        getCoefficient().flipSign();
    }
    
    @Override
    public void convertToCanonicalForm(){
        // to do
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
    
    private void setBeginningPosition(int position){
        // error check
        if(position < 0){
            throw new IllegalArgumentException("beginning position cannot be less than zero");
        }
        
        this.begginingPosition = position;
    }
    
    private void setEndingPosition(int position){
        // error check
        if(position < 0){
            throw new IllegalArgumentException("ending position cannot be less than zero");
        }
        
        this.endingPosition = position;
    }
    
}
