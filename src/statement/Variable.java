

package statement;

import java.io.Serializable;

/**
 *
 * @author Alexander Atanasov
 */
public class Variable extends MathSymbolBase implements Serializable {
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
    
    /**
     * 
     * @param supposedVariable non null String to evaluate 
     * 
     * @return true if the provided String indeed represents a variable
     */
    public static boolean isVariable(String supposedVariable){
        boolean isVariable = false;
        
        if(supposedVariable == null){
            throw new IllegalArgumentException("supposedVariable cannot be null");
        }
        
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
    
    @Override
    public boolean  equals(Object object){
        boolean isEqual = false;
        Variable variable;
        
        if(object == null){
            return isEqual;
        } else if( !(object instanceof Variable)){
            return isEqual;
        }
        
        variable = (Variable) object;
        if(this.getMathSymbol().equals(variable.getMathSymbol())){
            isEqual = true;
        }
        
        return isEqual;
    }
    
    @Override
    public int hashCode() {
        int hash = 11;
        
        hash *= super.hashCode();
        
        return hash;
    }
}
