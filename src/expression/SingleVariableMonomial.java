

package expression;

import interfaces.expression.Monomial;

/**
 *
 * @author Alexander Atanasov
 */
public class SingleVariableMonomial  implements Monomial {
    private Constant coefficient;
    private Constant highestPower;
    
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
    
}
