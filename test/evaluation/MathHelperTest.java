

package evaluation;


import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Alexander Atanasov
 */
@RunWith(Parameterized.class)
public class MathHelperTest {
    String input;
    String expectedOutput;
    MathHelper mathHelper;
    
    @Before
    public void initialize(){
        this.mathHelper = new MathHelper();
    }
    
    public MathHelperTest(String input, String output){
        this.input = input;
        this.expectedOutput = output;
    }
    
    @Parameterized.Parameters
    public static Collection mathStatements() {
        return Arrays.asList(new Object[][] {
            { "1+3", "4" },
            { "2*4", "8" },
            { "-1+2", "1" },
            { "8/4", "2" },
            { "3^2", "9" },
            { "1+2*2", "5" },
            { "1+3^2", "10" },
            { "2*3^2", "18" },
            { "1+3*2^3", "25" },
            { "(1+2)*3", "9" }
      });
   }
   
    /**
     * Test of solveMathStatement method, of class MathHelper.
     */
    @Test
    public void testMathHelper() {
        System.out.println("Math statement is: " + this.input);
        assertEquals(this.expectedOutput,
        this.mathHelper.solveMathStatement(this.input));
    }
}
