

package interfaces.statement;

/**
 *
 * @author Alexander Atanasov
 */
public interface RelationalStatement {
    /**
     * 
     * @return The number of meaningful elements before (left side) the relation symbol 
     *         in this statement.
     */
    public int getLeftSideSize();
    
    /**
     * 
     * @return The number of meaningful elements after (right side) the relation symbol
     *         in this statement
     */
    public int getRightSideSize();
}
