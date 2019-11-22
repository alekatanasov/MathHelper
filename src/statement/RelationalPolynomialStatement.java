

package statement;

import interfaces.statement.MathSymbol;
import interfaces.statement.RelationalPolynomial;
import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class RelationalPolynomialStatement extends PolynomialStatement implements RelationalPolynomial {
    private int leftSideSize;
    private int rightSideSize;
    private int relationPosition;
    
    protected RelationalPolynomialStatement(MathSymbol[] statement){
        super(statement);
        //
    }
    
    public static RelationalPolynomialStatement createRelationalPolynomialStatement(SymbolicStatement statement){
        RelationalPolynomialStatement newStatement;
        MathSymbol[] symbolicArray;
        
        // error check
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        }
        
        // create deep copy of the provided statement to make the new polynomial statement
        // completely independent
        statement = SymbolicStatement.copyMathStatement(statement);
        
        // convert the statement to array and create new PolynomialStatement instance
        symbolicArray = new MathSymbolBase[statement.getStatement().size()];
        symbolicArray = statement.getStatement().toArray(symbolicArray);
        newStatement = new RelationalPolynomialStatement(symbolicArray);
        
        return newStatement;
    }
    
    @Override
    public int getLeftSideSize(){
        return this.leftSideSize;
    }
    
    @Override
    public int getRightSideSize(){
        return this.rightSideSize;
    }
    
    @Override
    public int getRelationPosition(){
        return this.relationPosition;
    }
    
    private void setLeftSideSize(int size) {
        if(size < 0){
            throw new IllegalArgumentException("size cannot be less than 0");
        }
        
        this.leftSideSize = size;
    }
    
    private void setRightSideSize(int size){
        if(size < 0){
            throw new IllegalArgumentException("size cannot be less than 0");
        }
        
        this.rightSideSize = size;
    }
    
    private void setRelationPosition(int position){
        if(position < 0){
            throw new IllegalArgumentException("position cannot be less than 0");
        }
        
        this.relationPosition = position;
    }
}
