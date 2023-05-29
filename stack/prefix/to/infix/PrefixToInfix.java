package prefix.to.infix;

/*
 * Input :  Prefix :  *+AB-CD
Output : Infix : ((A+B)*(C-D))

Input :  Prefix :  *-A/BC-/AKL
Output : Infix : ((A-(B/C))*((A/K)-L)) 
 * 
 * Algorithm for Prefix to Infix:

    Read the Prefix expression in reverse order (from right to left)
    If the symbol is an operand, then push it onto the Stack
    If the symbol is an operator, then pop two operands from the Stack
    Create a string by concatenating the two operands and the operator between them.
    string = (operand1 + operator + operand2)
    And push the resultant string back to Stack
    Repeat the above steps until end of Prefix expression.

 */

public class PrefixToInfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
