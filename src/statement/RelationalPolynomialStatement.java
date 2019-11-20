

package statement;

import interfaces.statement.RelationalPolynomial;

/**
 *
 * @author Alexander Atanasov
 */
public class RelationalPolynomialStatement extends PolynomialStatement implements RelationalPolynomial {
    private int leftSideSize;
    private int rightSideSize;
    private int relationPosition;
    
    RelationalPolynomialStatement(MathSymbolBase[] statement){
        super(statement);
        //
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
