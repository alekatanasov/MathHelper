
package parse;

import statement.Bracket;
import statement.Constant;
import statement.Operation;
import statement.Relation;
import statement.Variable;
import interfaces.statement.MathSymbol;
import interfaces.parse.SymbolicMathParser;
import java.util.ArrayList;
import java.util.List;

/**
 * Can parse String representations of mathematical statements. If non empty recognizable 
 * statement is provided to the parseStatement method, this parser will convert it to a
 * List of type MathSymbol which can be retrieved by the popLastParsedStatement method.
 * 
 * @author Alexandar Atanasov
 */
public class MathStatementParser implements SymbolicMathParser {
    private List<MathSymbol> lastParsedStatement;
    private String currentConstant;
    private String lastParsedConstant;
    
    public MathStatementParser(){
        setCurrentConstant("");
        setLastParsedStatement(null);
    }
    
    @Override
    public boolean parseStatement(String stringStatement){
       boolean parseSuccess = false;
       List <MathSymbol> mathStatement = new ArrayList<>();
       
       if(stringStatement == null){
           return parseSuccess;
       } else if(stringStatement.isEmpty()){
           return parseSuccess;
       }
       
       // main parsing loop
       for(int c=0; c < stringStatement.length(); c++){
           // check for constant
           if(parseConstant(stringStatement, c)){
               mathStatement.add(new Constant(popLastParsedConstant()));
           }
           
           // check for operation
           if(Operation.isOperation(stringStatement.substring(c, c+1))){
               mathStatement.add(new Operation(stringStatement.substring(c, c+1)));
           }
           
           // check for bracket
           if(Bracket.isBracket(stringStatement.substring(c, c+1))){
               mathStatement.add(new Bracket(stringStatement.substring(c, c+1)));
           }
           
           // check for relation
           if(Relation.isRelation(stringStatement.substring(c, c+1))){
               mathStatement.add(new Relation(stringStatement.substring(c, c+1)));
           }
           
           // check for variable
           if(Variable.isVariable(stringStatement.substring(c, c+1))){
               mathStatement.add(new Variable(stringStatement.substring(c, c+1)));
           }
       }
       
       // check if anything was produced
       if(mathStatement.isEmpty()){
           return parseSuccess;
       }
       
       // store the symbolicStatement
       this.lastParsedStatement = mathStatement;
       
       // parsing successful
       parseSuccess = true;
       return parseSuccess;
       
    }
    
    @Override
    public List<MathSymbol> popLastParsedStatement(){
        List <MathSymbol> symbolicStatement = getLastParsedStatement();
        setLastParsedStatement(null); 
        return symbolicStatement;
    }
    
    /**
     * Checks if a string contains a constant. If a constant is identified, it will be 
     * stored in the lastParsedConstant field and the method will return true. It is 
     * meant for this method to be called repeatedly in a parsing loop for every character of
     * the string. 
     * 
     * @param statement the String to be parsed 
     * @param currentPosition the current position of the parsing loop
     * @return true if a constant has been parsed successfully
     */
    private boolean parseConstant(String statement, int currentPosition){
        boolean parsedConstant = false;
        
        // check the currentConstant to see if it is possible for the current character
        // to be a part of a partialy parsed Constant
        if(this.getCurrentConstant().isEmpty()){
            // no preceding constant. Check if the current character is the beggining of a constant
            if(Constant.isConstant(statement.substring(currentPosition, currentPosition+1))){
                // the current character is indeed a digit, add it to the currentConstant
                appendToCurrentConstant(statement.substring(currentPosition, currentPosition+1));
                 
                // check if position is at the end of the String
                if(currentPosition == statement.length()-1){
                    parsedConstant = true;
                    loadLastParsedConstant();
                }
                    
                return parsedConstant;
            } 
        } else {
            // there is a preceding constant. Check if the current character is part of it.
                if(Constant.isConstant(statement.substring(currentPosition, currentPosition+1))
                   || statement.charAt(currentPosition) == '.'){
                    appendToCurrentConstant(statement.substring(currentPosition, currentPosition+1));
                    
                    // check if position is at the end of the String
                    if(currentPosition == statement.length()-1){
                        parsedConstant = true;
                        loadLastParsedConstant();
                    }
                    
                    return parsedConstant;
                } else {
                    // the preceding constant has ended. 
                    parsedConstant = true;
                    loadLastParsedConstant();
                }
        }
        
        return parsedConstant;
    }
    
    /**
     * When a constant is successfully parsed this method must be called. It will copy 
     * the currentConstant to lastParsedConstant and set currentConstant to empty String.
     */
    private void loadLastParsedConstant(){
        setLastParsedConstant(getCurrentConstant());
        setCurrentConstant("");
        
    }
    
    /**
     * This method will return the last parsed constant and set the lastParsedConstant field to
     * empty String.
     * 
     * @return the last parsed constant
     */
    private String popLastParsedConstant(){
        String constant = getLastParsedConstant();
        setLastParsedConstant("");
        return constant;
    }
    
    private void setCurrentConstant(String constant){
        this.currentConstant = constant;
    }
    
    private void appendToCurrentConstant(String stringToAppend){
        setCurrentConstant(getCurrentConstant() + stringToAppend);
    }
    
    private String getCurrentConstant(){
        return this.currentConstant;
    }
    
    private void setLastParsedConstant(String constant){
        this.lastParsedConstant = constant;
    }
    
    private String getLastParsedConstant(){
        return this.lastParsedConstant;
    }
    
    private void setLastParsedStatement(List<MathSymbol> statement){
        this.lastParsedStatement = statement;   
    }
    
    /**
     * 
     * @return Reference (no shallow or deep copy) to the lastParsedStatement field.
     */
    private List<MathSymbol> getLastParsedStatement(){
        return this.lastParsedStatement;
    }
}
