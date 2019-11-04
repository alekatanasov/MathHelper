

package expression;

/**
 *
 * @author Alexander Atanasov
 */
public class Variable extends MathSymbol {
    public enum VariableLiteral{
        X("x"),
        Y("y"),
        Z("z");
        
        private String stringValue;
        
        VariableLiteral(String literal){
            this.stringValue = literal;
        }
        
        public String getStringValue(){
            return this.stringValue;
        }
    }
    
    public Variable(String variable){
        super(variable);
    }
    
    public static boolean isVariable(String supposedVariable){
        boolean isVariable = false;
        
        for(VariableLiteral literal : VariableLiteral.values()){
            if(literal.getStringValue().equals(supposedVariable)){
                isVariable = true;
            }
        }
        
        return isVariable;
    }
    
    @Override
    public MathSymbolType getMathSymbolType(){
        return MathSymbolType.VARIABLE;
    }
}
