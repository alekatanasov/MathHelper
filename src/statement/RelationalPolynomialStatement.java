

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
     * The relation which separates the left from the right side
     */
    private Relation relation;
    
    protected RelationalPolynomialStatement(SymbolicStatement statement, Relation relation){
        super(statement);
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
        Relation relation;
        MathSymbol[] symbolicArray;
        
        // error check
        if(statement == null){
            throw new IllegalArgumentException("statement cannot be null");
        }
        
        // create deep copy of the provided statement to make the new relational polynomial statement
        // completely independent
        statement = SymbolicStatement.copyMathStatement(statement);

        //
        relation = (Relation) statement.getFirstSymbolByType(MathSymbol.MathSymbolType.RELATION);
        
        //  create new RelationalPolynomialStatement instance
        newStatement = new RelationalPolynomialStatement(statement, relation);
        
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
    
    public Relation getRelation(){
        return this.relation;
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
    
    private void setRelation(Relation relation) {
        if(relation == null){
            throw new IllegalArgumentException("relation cannot be null");
        }
        
        this.relation = relation;
    }
}
