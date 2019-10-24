
package expression;

import interfaces.expression.MathSymbol.MathSymbolType;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander Atanasov
 */
public class ConstantTest {
    
    public ConstantTest() {
    }

    /**
     * Test of isConstant method, of class Constant.
     */
    @Test
    public void testIsConstant() {
        String constant = "5";
        boolean expected = true;
        
        assertEquals(expected, Constant.isConstant(constant));
    }

    /**
     * Test of equals method, of class Constant.
     */
    @Test
    public void testEquals() {
        Constant expected = new Constant("3");
        Constant actual = new Constant("3");
        
        assertEquals(expected, actual);
    }

    /**
     * Test of getMathSymbolType method, of class Constant.
     */
    @Test
    public void testGetSymbolType() {
        Constant constant = new Constant("5");
        
        assertEquals(MathSymbolType.CONSTANT, constant.getMathSymbolType());
    } 

    /**
     * Test of getValue method, of class Constant.
     */
    @Test
    public void testGetValue() {
    }

    /**
     * Test of hashCode method, of class Constant.
     */
    @Test
    public void testHashCode() {
        Constant expected = new Constant("3");
        Constant actual = new Constant("3");
        
        assertEquals(expected.hashCode(), actual.hashCode());
    }
    
}
