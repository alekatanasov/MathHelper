
package statement.operation;

import statement.Constant;
import statement.Operation;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

/**
 *
 * @author Alexander Atanasov
 */
@RunWith(Parameterized.class)
public class PerformOperationTest {
    private Constant leftOperand;
    private Constant rightOperand;
    private Operation operation;
    private Constant expectedResult;
    
    public PerformOperationTest(Constant leftOperand, Constant rightOperand,
                         Operation operation, Constant result) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
        this.expectedResult = result;
    }

    @Parameterized.Parameters
    public static Collection mathStatements() {
        return Arrays.asList(new Object[][] {
            { new Constant("3"), new Constant("4"), new Operation("+"), new Constant("7")},
            { new Constant("3"), new Constant("4"), new Operation("-"), new Constant("-1")},
            { new Constant("3"), new Constant("4"), new Operation("*"), new Constant("12")},
            { new Constant("4"), new Constant("2"), new Operation("/"), new Constant("2")},
            { new Constant("2"), new Constant("3"), new Operation("^"), new Constant("8")}
      });
    }
    
    /**
     * Test of performOperation method, of class Operation.
     */
    @Test
    public void testPerformOperation() {
        Constant testResult = Operation.performOperation(leftOperand, rightOperand, operation);
        
        System.out.println("Resulting constant is : " + testResult.getMathSymbol());
        assertEquals(this.expectedResult, testResult);
    }

}
