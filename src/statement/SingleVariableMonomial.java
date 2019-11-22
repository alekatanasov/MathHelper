

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
    
    public static SingleVariableMonomial createSingleVariableMonomial(MathSymbolBase[] symbols, 
                                                                      int positionBegin, int positionEnd){
        SymbolicStatement monomial;
        
        monomial = new SingleVariableMonomial(symbols, positionBegin, positionEnd);
        
        // make deep copy of the monomial so it is completeley independent of the parent polynom
        monomial = SymbolicStatement.copyMathStatement(monomial);
        
        return (SingleVariableMonomial) monomial;
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
    
    /**
     * 
     * @param value Constant representing the numeric coefficient of this monomial
     */
    private void setCoefficient(Constant value){
        this.coefficient = value;
    }
    
    /**
     * 
     * @param power Constant representing the highest power of this monomial
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
