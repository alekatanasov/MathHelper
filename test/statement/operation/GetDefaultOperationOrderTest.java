

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
public class GetDefaultOperationOrderTest {
    private Operation operation;
    private int expectedOrder;
    
    public GetDefaultOperationOrderTest(Operation operation, int order) {
        this.operation = operation;
        this.expectedOrder = order;
    }

    @Parameterized.Parameters
    public static Collection mathStatements() {
        return Arrays.asList(new Object[][] {
            { new Operation("+"), 1 },
            { new Operation("-"), 1 },
            { new Operation("*"), 2 },
            { new Operation("/"), 2 },
            { new Operation("^"), 3 }
            
      });
    }
    
    /**
     * Test of getDefaultOperationOrder method, of class Operation.
     */
    @Test
    public void testGetDefaultOperationOrderOperation() {
        int operationOrder = Operation.getDefaultOperationOrder(this.operation);
        assertEquals(this.expectedOrder, operationOrder);
    }

   
}
