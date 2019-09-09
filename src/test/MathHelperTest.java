
package test;

import evaluation.MathHelper;
import interfaces.evaluation.Helper;
import java.util.Scanner;

/**
 *
 * @author Alexandar Atanasov
 */
public class MathHelperTest {
    public static void main(String args[]){
        Helper mathHelper = new MathHelper();
        Scanner scanner = new Scanner(System.in);
        String solvedStatement;
        
        solvedStatement = mathHelper.solveMathStatement(scanner.nextLine());
        System.out.println(solvedStatement);
    }
}
