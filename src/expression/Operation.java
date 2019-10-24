
package expression;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Represents an instance of the common arithmetic operations.
 * 
 * @author Alexandar Atanasov
 */
public final class Operation extends MathSymbol{
    private int operationOrder;
    
    public Operation(String operation){
        super(operation);
        setOperationOrder(getDefaultOperationOrder(this));
    }
    
    /**
     * Check if a String represents operation as defined by the Operation class.
     * 
     * @param supposedOperation
     * @return true if the provided String represents an Operation.
     */
    public static boolean isOperation(String supposedOperation){
        boolean isOperation = false;
        
        if(supposedOperation.equals("+") ||
           supposedOperation.equals("-") ||
           supposedOperation.equals("*") ||
           supposedOperation.equals("/")||
           supposedOperation.equals("^")){
            // string is operation
            isOperation = true;
        }
        
        return isOperation;
    }
    
    /**
     * Returns the default order of the provided operation: 1 for addition and subtraction,
     * 2 for multiplication and division and 3 for power
     * 
     * @param operation non null valid operation
     * @return the default order of the provided operation
     */
    public static int getDefaultOperationOrder(Operation operation){
        int order = 0;
        
        if(operation == null){
            throw new IllegalArgumentException("operation cannot be null");
        }
        
        order = Operation.getDefaultOperationOrder(operation.getMathSymbol());
        
        return order;
    }
    
    /**
     * Returns the default order of the provided operation(the operation is represented by a string): 
     * 1 for addition and subtraction, 2 for multiplication and division and 3 for power.
     * 
     * @param operation non null non empty String representing valid operation
     * @return the default order of the provided operation
     */
    public static int getDefaultOperationOrder(String operation){
        int order = 0;
        
        if(operation == null){
            throw new IllegalArgumentException("operation cannot be null");
        } else if(operation.isEmpty()){
            throw new IllegalArgumentException("operation cannot empty string");
        }
        
        switch(operation){
            case"+":
            case"-":
                order =1;
                break;
            case"*":
            case"/":
                order =2;
                break;
            case"^":
                order =3;
                break;
            default:
                throw new IllegalArgumentException("unknown operation");
        }
        
        return order;
    }
    
    /**
     * 
     * @param leftOperand
     * @param rightOperand
     * @param operation
     * @return a Constant representing the result of the operation execution.
     */
    public static Constant performOperation(Constant leftOperand, Constant rightOperand, 
                                            Operation operation){
        BigDecimal operationResult;
        BigDecimal leftConstant = leftOperand.getValue();
        BigDecimal rightConstant = rightOperand.getValue();
        
        switch(operation.getMathSymbol()){
            case"+":
                operationResult = leftConstant.add(rightConstant, MathContext.UNLIMITED);
                break;
            case"-":
                operationResult = leftConstant.subtract(rightConstant, MathContext.UNLIMITED);
                break;
            case"*":
                operationResult = leftConstant.multiply(rightConstant, MathContext.UNLIMITED);
                break;
            case"/":
                operationResult = leftConstant.divide(rightConstant, MathContext.DECIMAL32);
                break;
            case"^":
                operationResult = leftConstant.pow(rightConstant.toBigIntegerExact().intValue(),
                                                  MathContext.UNLIMITED);
                break;
            default:
                throw new IllegalArgumentException("unknown operation");
        }
        
        return new Constant(operationResult.toPlainString());
    }
    
    public int getOperationOrder(){
        return this.operationOrder;
    }
    
    /**
     * Increase the operationOrder field by the number of steps specified by the steps parameter.
     * Each step is equivalent to the highest possible default operation order.
     * 
     * @param steps non zero positive integer
     */
    public void incrementOperationOrder(int steps){
        // error check
        if(steps < 0){
            throw new IllegalArgumentException("steps cannot be less than 0");
        }
        
        setOperationOrder(getOperationOrder() + steps*3);
    }
    
    /**
     * Resets the operationOrder to its default value (which is dependent on the type of the 
     * current operation)
     */
    public void resetOperationOrder(){
        setOperationOrder(getDefaultOperationOrder(this));
    }
    
    @Override
    public MathSymbolType getMathSymbolType(){
        return MathSymbolType.OPERATION;
    }
    
    private void setOperationOrder(int order){
        this.operationOrder = order;
    }
}
