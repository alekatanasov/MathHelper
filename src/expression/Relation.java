
package expression;

/**
 *
 * @author Alexander Atanasov
 */
public class Relation extends MathSymbol {
    public enum RelationType {
        EQUALITY;
    }
    
    private RelationType relationType;
    
    public Relation(String symbol, RelationType type){
        super(symbol);
        setRelationType(type);
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
