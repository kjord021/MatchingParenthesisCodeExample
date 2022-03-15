
public class MatchParenthesis {

	public static void main(String[] args) {
		
		String input = "(())(())";
		char openingChar = '(';
		char closingChar = ')';
		
		//Create an object of type StackValidator
		//This gives us access to our two stacks which we can use for comparisons
		StackValidator sv = new StackValidator();
		
		//Assign the input to character array so we can loop and search for parenthesis
		char[] inputArray = input.toCharArray();
		for (char c : inputArray) {
			
			//If we find an openingChar at the current index of characterArray
			if (c == openingChar) {
				//We want to add the openingChar to actual and expect to find a closing char later in the string
				sv.addToActual(c);
				sv.addToExpected(closingChar);
			}
			//Else if we find a closingChar at the current index of characterArray
			else if (c == closingChar) {
				//Peek the expected stack and make sure that we have the correct result
				if (sv.peekExpected() == c) {
					//Remove closing char from both stacks
					sv.removeFromActual();
					sv.removeFromExpected();
				}
			}
			
		}
		
		if (determineIfValid(sv)) {
			System.out.println("The code is valid");
		}
		else {
			System.out.println("The code is not valid");
		}

	}
	
	//This functions determines if both arrays are empty which will identify whether the input string was valid or not
	public static boolean determineIfValid(StackValidator sv) {
		if (sv.actualEmpty() && sv.expectedEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

}
