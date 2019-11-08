
package statement;

import java.io.Serializable;

/**
 *
 * @author Alexander Atanasov
 */
public class Relation extends MathSymbol implements Serializable {
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
    
    public Relation(String symbol){
        super(symbol);
        resolveRelationType();
    }
    
    /**
     * 
     * @param supposedRelation non null String to evaluate
     * 
     * @return true if the provided String is indeed a Relation
     */
    public static boolean isRelation(String supposedRelation){
        boolean isRelation = false;
        
        if(supposedRelation == null){
            throw new IllegalArgumentException("supposedRelation cannot be null");
        }
        
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
    
    @Override
    public boolean  equals(Object object){
        boolean isEqual = false;
        Relation relation;
        
        if(object == null){
            return isEqual;
        } else if( !(object instanceof Relation)){
            return isEqual;
        }
        
        relation = (Relation) object;
        if(this.getMathSymbol().equals(relation.getMathSymbol())
           && this.getRelationType() == relation.getRelationType()){
            isEqual = true;
        }
        
        return isEqual;
    }
    
    @Override
    public int hashCode() {
        int hash = 11;
        
        hash *= super.hashCode();
        hash *= getRelationType().hashCode();
        
        return hash;
    }
    
    public RelationType getRelationType(){
        return this.relationType;
    }
    
    private void setRelationType(RelationType type){
        this.relationType = type;
    }
    
    /**
     * Determines the type of the current relation. This process  depends on the String 
     * representation of this relation.
     */
    private void resolveRelationType(){
        RelationType relationType = null;
        String relation = this.getMathSymbol();
        
        for(RelationType currentType : RelationType.values()){
            if(currentType.getStringValue().equals(relation)){
                relationType = currentType;
            }
        }
        
        // check for error
        if(relationType == null){
            throw new IllegalArgumentException("unknown relation");
        }
        
        setRelationType(relationType);
    }
}
