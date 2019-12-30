

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
    
    private Relation relation;
    
    protected RelationalPolynomialStatement(List<Monomial> polynomial, Relation relation){
        super(polynomial);
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
        
        // create deep copy of the provided statement to make the new relational polynomial statement
        // completely independent
        statement = SymbolicStatement.copyMathStatement(statement);
        
        // parse monomials
        getMonomialParser().parseMonomials(statement);
        //determinedMonomials = getMonomialParser().popLastParsedStatement();
        
        //  create new RelationalPolynomialStatement instance
        newStatement = new RelationalPolynomialStatement(statement.getStatement());
        
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
