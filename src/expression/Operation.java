
package expression;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Represents an instance of the common arithmetic operations.
 * 
 * @author Alexandar Atanasov
 */
public final class Operation extends MathSymbol {
    public enum OperationType {
        ADDITION("+", 1),
        SUBTRACTION("-", 1),
        MULTIPLICATION("*", 2),
        DIVISION("/", 2),
        EXPONENTIATION("^", 3);
        
        private  String stringValue;
        private  int defaultOrder;
        
        OperationType(String value, int order){
            this.stringValue = value;
            this.defaultOrder = order;
        }
        
        public String getStringValue(){
            return this.stringValue;
        }
        
        public int getDefaultOrder(){
            return this.defaultOrder;
        }
    }
    
    private int operationOrder;
    private OperationType operationType;
    
    public Operation(String operation){
        super(operation);
        setOperationOrder(getDefaultOperationOrder(operation));
        setOperationType(determineOperationType(operation));
    }
    
    /**
     * Check if a String represents operation as defined by the Operation class.
     * 
     * @param supposedOperation
     * @return true if the provided String represents an Operation.
     */
    public static boolean isOperation(String supposedOperation){
        boolean isOperation = false;
        
        for(OperationType operationType : OperationType.values()){
            if(operationType.getStringValue().equals(supposedOperation)){
                isOperation = true;
                break;
            }
        }
        
        return isOperation;
    }
    
    /**
     * Returns the default order of the provided operation: 1 for addition and subtraction,
     * 2 for multiplication and division and 3 for power
     * 
     * @param operation non null valid operation
     * 
     * @return the default order of the provided operation
     */
    public static int getDefaultOperationOrder(Operation operation){
        if(operation == null){
            throw new IllegalArgumentException("operation cannot be null");
        }
        
        return operation.getOperationType().getDefaultOrder();
    }
    
    /**
     * Returns the default order of the provided operation(the operation is represented by a string): 
     * 1 for addition and subtraction, 2 for multiplication and division and 3 for power.
     * 
     * @param operation non null non empty String representing valid operation
     * @return the default order of the provided operation
     */
    public static int getDefaultOperationOrder(String operation){
        int order = -1;
        
        if(operation == null){
            throw new IllegalArgumentException("operation cannot be null");
        } else if(operation.isEmpty()){
            throw new IllegalArgumentException("operation cannot empty string");
        }
        
        if(isOperation(operation)){
            for(OperationType type : OperationType.values()){
                if(type.getStringValue().equals(operation)){
                    order = type.getDefaultOrder();
                }
            }
        } else {
            throw new IllegalArgumentException("unknown operation");
        }
        
        if(order == -1){
           throw new IllegalArgumentException("unknown operation"); 
        }
        
        return order;
    }
    
    /**
     * 
     * @param leftOperand
     * @param rightOperand
     * @param operation
     * 
     * @return a Constant representing the result of the operation execution.
     */
    public static Constant performOperation(Constant leftOperand, Constant rightOperand, 
                                            Operation operation){
        BigDecimal operationResult;
        BigDecimal leftConstant = leftOperand.getValue();
        BigDecimal rightConstant = rightOperand.getValue();
        
        switch(operation.getOperationType()){
            case ADDITION:
                operationResult = leftConstant.add(rightConstant, MathContext.UNLIMITED);
                break;
            case SUBTRACTION:
                operationResult = leftConstant.subtract(rightConstant, MathContext.UNLIMITED);
                break;
            case MULTIPLICATION:
                operationResult = leftConstant.multiply(rightConstant, MathContext.UNLIMITED);
                break;
            case DIVISION:
                operationResult = leftConstant.divide(rightConstant, MathContext.DECIMAL32);
                break;
            case EXPONENTIATION:
                operationResult = leftConstant.pow(rightConstant.toBigIntegerExact().intValue(),
                                                  MathContext.UNLIMITED);
                break;
            default:
                throw new IllegalArgumentException("unknown operation");
        }
        
        return new Constant(operationResult.toPlainString());
    }
    
    /**
     * 
     * @param operation non null String representing an operation. If a string 
     *                  which cannot be recognized as operation is provided an exception will 
     *                  thrown.
     * 
     * @return the OperationType of the provided operation.
     */
    public static OperationType determineOperationType(String operation){
        OperationType operationType = null;
        
        for(OperationType currentType : OperationType.values()){
            if(currentType.getStringValue().equals(operation)){
                operationType = currentType;
            }
        }
        
        // error check
        if(operationType == null){
            throw new IllegalArgumentException("unknown operation");
        }
        
        return operationType;
    }
    
    @Override
    public boolean  equals(Object object){
        boolean isEqual = false;
        Operation operation;
        
        if(object == null){
            return isEqual;
        } else if( !(object instanceof Operation)){
            return isEqual;
        }
        
        operation = (Operation) object;
        if(operation.getMathSymbol().equals(this.getMathSymbol())
           && operation.getMathSymbolType() == this.getMathSymbolType()
           && operation.getOperationOrder() == this.getOperationOrder()
           && operation.getOperationType() == this.getOperationType()){
            // provided operation is indeed equal to the current operation
            isEqual = true;
        }
        
        return isEqual;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        
        hash *= super.hashCode();
        hash *= getOperationOrder();
        hash *= getMathSymbolType().hashCode();
        hash *= getOperationType().hashCode();
        
        return hash;
    }
    
    public OperationType getOperationType(){
        return this.operationType;
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
    
    /**
     * 
     * @param order integer representing this operation's operation order.
     *              No checks performed.
     */
    private void setOperationOrder(int order){
        this.operationOrder = order;
    }
    
    private void setOperationType(OperationType type){
        this.operationType = type;
    }
}
