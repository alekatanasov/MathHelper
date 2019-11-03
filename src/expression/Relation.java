
package expression;

/**
 *
 * @author Alexander Atanasov
 */
public class Relation extends MathSymbol {
    public enum RelationType {
        EQUALITY("=");
    
        private String stringValue;
        
        RelationType(String value){
            this.stringValue = value;
        }
        
        /**
         * 
         * @return the String representation of this RelationType
         */
        public String getStringValue(){
            return this.stringValue;
        }
    }
    
    private RelationType relationType;
    
    public Relation(String symbol, RelationType type){
        super(symbol);
        setRelationType(type);
    }
    
    public static boolean isRelation(String supposedRelation){
        boolean isRelation = false;
        
        for( RelationType relationType : RelationType.values()) {
            if(relationType.getStringValue().equals(supposedRelation)){
                isRelation = true;
                break;
            }
        }
        
        return isRelation;
    }
    
    @Override
    public MathSymbolType getMathSymbolType(){
        return MathSymbolType.RELATION;
    }
    
    public RelationType getRelationType(){
        return this.relationType;
    }
    
    private void setRelationType(RelationType type){
        this.relationType = type;
    }
}
