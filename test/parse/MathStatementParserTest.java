

package parse;


import interfaces.statement.MathSymbol;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Alexander Atanasov
 */
@RunWith(Parameterized.class)
public class MathStatementParserTest {
    private MathStatementParser parser;
    private String input;
    private String expectedOutput;
    
    public MathStatementParserTest(String input, String output) {
        this.input = input;
        this.expectedOutput = output;
    }

    @Before
    public void initialize(){
        this.parser = new MathStatementParser();
    }
    
    @Parameterized.Parameters
    public static Collection mathStatements() {
        return Arrays.asList(new Object[][] {
            { "1+3", "1+3" },
            { "1-3", "1-3" },
            { "1*3", "1*3" },
            { "2^3", "2^3" },
            { "-1+3", "-1+3" },
            { "(1+2-3)", "(1+2-3)" },
            { "(-2^2/3)", "(-2^2/3)" },
            { "(-2^2/3)+(-2+1)", "(-2^2/3)+(-2+1)" },
            { "((1+2-3)^2)/3", "((1+2-3)^2)/3" },
            { "x=5", "x=5" },
            { "2*x+1-x^2=x^3*4", "2*x+1-x^2=x^3*4" },
            { "(x^2-10)/(-x*3)=(x+2)^x", "(x^2-10)/(-x*3)=(x+2)^x" }
            
      });
   }
    
    /**
     * 
     */
    @Test
    public void testMathStatementParser() {
        String parsedStatement = "";
        MathSymbol[] mathStatement;
        
        this.parser.parseStatement(this.input);
        mathStatement = this.parser.popLastParsedStatement();
        for(int c = 0; c < mathStatement.length; c++){
            parsedStatement+= mathStatement[c].getMathSymbol();
        }
        
        System.out.println("Math statement is: " + this.input);
        assertEquals(this.expectedOutput,parsedStatement);
    }
    
}
