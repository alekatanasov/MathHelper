

package expression;

/**
 *
 * @author Alexander Atanasov
 */
public class Variable extends MathSymbol {
    public Variable(String variable){
        super(variable);
    }
    
    @Override
    public MathSymbolType getMathSymbolType(){
        return MathSymbolType.VARIABLE;
    }
}
