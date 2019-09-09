
package parse;

import expression.Constant;
import expression.Operation;
import interfaces.expression.Symbol;
import interfaces.parse.SymbolicParser;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandar Atanasov
 */
public class MathStatementParser implements SymbolicParser {
    private Symbol[] lastParsedStatement;
    private String currentConstant;
    private String lastParsedConstant;
    
    public MathStatementParser(){
        this.currentConstant = "";
        this.lastParsedStatement = null;
    }
    
    @Override
    public boolean parseStatement(String statement){
       boolean parseSuccess = false;
       List<Symbol> mathStatement = new ArrayList<>();
       
       if(statement == null){
           return parseSuccess;
       } else if(statement.isEmpty()){
           return parseSuccess;
       }
       
       // main parsing loop
       for(int c=0; c < statement.length(); c++){
           // check for constant
           if(parseConstant(statement, c)){
               mathStatement.add(new Constant(popLastParsedConstant()));
           }
           
           // check for operation
           if(Operation.isOperation(statement.substring(c, c+1))){
               mathStatement.add(new Operation(statement.substring(c, c+1)));
           }
       }
       
       // check if anything was produced
       if(mathStatement.isEmpty()){
           return parseSuccess;
       }
       
       // store the statement
       this.lastParsedStatement = new Symbol[mathStatement.size()];
       for(int c=0; c < mathStatement.size(); c++){
           this.lastParsedStatement[c] = mathStatement.get(c);
       }
       
       // parsing successful
       parseSuccess = true;
       return parseSuccess;
       
    }
    
    @Override
    public Symbol[] popLastParsedStatement(){
        Symbol[] statement = this.lastParsedStatement;
        this.lastParsedStatement = null;
        return statement;
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
        // to be a part of a Constant
        if(this.currentConstant.isEmpty()){
            // no preceding constant. Check if the current character is the beggining of a constant
            if(Constant.isConstant(statement.substring(currentPosition, currentPosition+1))){
                 this.currentConstant += statement.substring(currentPosition, currentPosition+1);
                 
                // check if position is at the end of the String
                if(currentPosition == statement.length()-1){
                    parsedConstant = true;
                    loadLastParsedConstant();
                }
                    
                return parsedConstant;
            } 
        }else{
            // there is a preceding constant. Check if the current character is part of it.
                if(Constant.isConstant(statement.substring(currentPosition, currentPosition+1))
                   || statement.charAt(currentPosition) == '.'){
                    this.currentConstant += statement.substring(currentPosition, currentPosition+1);
                    
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
        this.lastParsedConstant = this.currentConstant;
        this.currentConstant = "";
        
    }
    
    /**
     * This method will return the last parsed constant and set the lastParsedConstant field to
     * empty String.
     * 
     * @return the last parsed constant
     */
    private String popLastParsedConstant(){
        String temp = this.lastParsedConstant;
        this.lastParsedConstant = "";
        return temp;
    }
}
