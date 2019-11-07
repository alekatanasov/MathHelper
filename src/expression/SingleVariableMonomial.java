

package expression;

import interfaces.expression.Monomial;

/**
 *
 * @author Alexander Atanasov
 */
public class SingleVariableMonomial  implements Monomial {
    private Constant coefficient;
    private Constant highestPower;
    private int begginingPosition;
    private int endingPosition;
    
    public SingleVariableMonomial(Constant coefficient, Constant highestPower){
        setCoefficient(coefficient);
        setHighestPower(highestPower);
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
    
    private void setCoefficient(Constant value){
        if(value == null){
            throw new IllegalArgumentException("coefficient cannot be null");
        }
        
        this.coefficient = value;
    }
    
    private void setHighestPower(Constant power){
        if(power == null){
            throw new IllegalArgumentException("highest power cannot be null");
        }
        
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
