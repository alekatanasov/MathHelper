

package statement;

import interfaces.statement.SymbolicStatement;

/**
 *
 * @author Alexander Atanasov
 */
public class ExponentialStatement extends MathStatement{
    protected ExponentialStatement(SymbolicStatement statement){
        super(statement.getStatement());
    }
}
