/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces.statement;

import interfaces.parse.SymbolicMathParser;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import parse.MathStatementParser;
import statement.MathStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class SymbolicStatementTest {
    private SymbolicMathParser parser;
    
    public SymbolicStatementTest() {
    }

    @Before
    public void initialize(){
        this.parser = new MathStatementParser();
    }
    
    /**
     * Test of copyMathStatement method, of class SymbolicStatement.
     */
    @Test
    public void testCopyMathStatement() {
        boolean expectedResult = true;
        String statementLiteral = "(x+2)^3=x/5-1";
        
        parser.parseStatement(statementLiteral);
        SymbolicStatement statement = MathStatement.createMathStatement(parser);
        SymbolicStatement copyStatement = SymbolicStatement.copyMathStatement(statement);
        
        assertEquals(expectedResult, statement.equals(copyStatement));
    }

    
    
}
