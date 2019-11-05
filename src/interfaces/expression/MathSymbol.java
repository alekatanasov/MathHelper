package interfaces.expression;

/**
 * Represents a single mathematical symbol.
 * 
 * @author Alexandar Atanasov
 */
public interface MathSymbol {
    public enum MathSymbolType{
        OPERATION("Operation"),
        CONSTANT("Constant"),
        BRACKET("Bracket"),
        RELATION("Relation"),
        VARIABLE("Variable");
        
        private Class classDescriptor;
        
        MathSymbolType(String className){
            try {
                this.classDescriptor = Class.forName(className);
            } catch (ClassNotFoundException e){
                
            }
        }
        
        public Class getClassDescriptor(){
            return this.classDescriptor;
        }
    }
    
    /**
     * Each class which implements this interface has unique class dependent MathSymbol type.
     * 
     * @return The type of the current MathSymbol object.
     */
    public MathSymbolType getMathSymbolType();
    
    /**
     * 
     * @return The String representation of this math symbol.
     */
    public String getMathSymbol();
}
