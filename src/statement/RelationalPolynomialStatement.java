

package statement;

import interfaces.statement.MathSymbol;
import interfaces.statement.Monomial;
import interfaces.statement.RelationalPolynomial;
import interfaces.statement.SymbolicStatement;
import java.util.List;

/**
 *
 * @author Alexander Atanasov
 */
public class RelationalPolynomialStatement extends PolynomialStatement implements RelationalPolynomial {
    /**
     * The number of monomials left of the relation
     */
    private int leftSideSize;
    
    /**
     * The number of monomoials right of the relation
     */
    private int rightSideSize;
    
    /**
     * The position of this statement's relation in the list of MathSymbols
     */
    private int relationPosition;
    
    protected RelationalPolynomialStatement(MathSymbol[] statement){
        super(statement);
        determineRelationPosition();
        determineLeftSideSize();
        determineRightSideSize();
    }
    
    /**
     * 
     * @param statement non null symbolic statement representing valid relational polynomial.
     * 
     * @return relational polynomial statement representing the provided symbolic statement and 
     *         referentially independent from it (complete deep copy).
     */
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
        
        // convert the statement to array and create new RelationalPolynomialStatement instance
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
    
    /**
     * Finds the position of the relation in this statement and stores it in the relationPosition
     * field.
     */
    private void determineRelationPosition(){
        int position;
        List<Integer> foundPositions = getPositionsBySymbolType(MathSymbol.MathSymbolType.RELATION);
        
        // error check:
        // There should be only one relation and therefore only one position
        if(foundPositions.size() != 1){
            throw new IllegalArgumentException("invalid number of relations");
        }
        
        position = foundPositions.get(0);
        
        setRelationPosition(position);
    }
    
    /**
     * Determines the value of the rightSideSize field based on the monomials list and the
     * relationPosition field. This method should be called after the determineRelationPosition() 
     * method has been called.
     */
    private void determineLeftSideSize(){
        int size = 0;
        List<Monomial> monomials = getMonomials();
        
        // determine the number of monomials left of the relation
        for(int c = 0; c < monomials.size(); c++){
            if(monomials.get(c).getEndingPosition() == getRelationPosition() - 1){
                size = c + 1;
                break;
            }
        }
        
        // error check
        if(size == 0 && size == monomials.size()){
            throw new RuntimeException("determiningLeftSideSize error");
        }
        
        setLeftSideSize(size);
    }
    
    /**
     * Determines the rightSideSize field based on the leftSideSize and the number of monomials in
     * this polynomial. This method should be called after a call to the determineRelationPosition()
     * and determineLeftSideSize() methods.
     */
    private void determineRightSideSize(){
        int size;
        List<Monomial> monomials = getMonomials();
        
        size = monomials.size() - this.getLeftSideSize();
        this.setRightSideSize(size);
    }
}
