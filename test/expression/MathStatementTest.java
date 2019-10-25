
package expression;

import interfaces.parse.SymbolicParser;
import org.junit.Test;
import parse.MathStatementParser;

/**
 *
 * @author Alexander Atanasov
 */
public class MathStatementTest {
    
    public MathStatementTest() {
    }

    
    /**
     * Test of createMathStatement method, of class MathStatement.
     */
    @Test
    public void testCreateMathStatement() {
        
    }

    /**
     * Test of toString method, of class MathStatement.
     */
    @Test
    public void testToString() {
        //
    }

    /**
     * Test of getStatement method, of class MathStatement.
     */
    @Test
    public void testGetStatement() {
    }

    /**
     * Test of getSymbol method, of class MathStatement.
     */
    @Test
    public void testGetSymbol() {
    }

    /**
     * Test of containsSymbolType method, of class MathStatement.
     */
    @Test
    public void testContainsSymbolType() {
        SymbolicParser parser = new MathStatementParser();
        
        parser.parseStatement("(5+1)*2");
    }
    
}
