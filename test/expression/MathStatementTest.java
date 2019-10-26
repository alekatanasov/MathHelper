
package expression;

import interfaces.expression.MathSymbol.MathSymbolType;
import interfaces.expression.SymbolicStatement;
import interfaces.parse.SymbolicParser;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import parse.MathStatementParser;

/**
 *
 * @author Alexander Atanasov
 */
public class MathStatementTest {
    private SymbolicParser parser;
    
    public MathStatementTest() {
    }

    @Before
    public void initialize(){
        this.parser = new MathStatementParser();
    }

    /**
     * Test of toString method, of class MathStatement.
     */
    @Test
    public void testToString() {
        String expectedResult = "(5+1)*2";
        
        this.parser.parseStatement(expectedResult);
        SymbolicStatement statement = MathStatement.createMathStatement(this.parser);
        
        assertEquals(expectedResult, statement.toString());
    }

    /**
     * Test of getStatement method, of class MathStatement.
     */
    @Test
    public void testGetStatement() {
        List <MathSymbol> expectedResult = new ArrayList<>();
        expectedResult.add(new Constant("3"));
        expectedResult.add(new Operation("+"));
        expectedResult.add(new Constant("2"));
        
        this.parser.parseStatement("3+2");
        SymbolicStatement statement = MathStatement.createMathStatement(this.parser);
        
        //assertEquals(expectedResult, statement.getStatement());
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
        boolean expectedResult = true;
        this.parser.parseStatement("(5+1)*2");
        SymbolicStatement statement = MathStatement.createMathStatement(this.parser);
        
        assertEquals(expectedResult, statement.containsSymbolType(MathSymbolType.OPERATION));
        assertEquals(expectedResult, statement.containsSymbolType(MathSymbolType.CONSTANT));
        assertEquals(expectedResult, statement.containsSymbolType(MathSymbolType.BRACKET));
    }
    
}
