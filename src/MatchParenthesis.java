

public class MatchParenthesis {

	public static void main(String[] args) {
		
		String input = "(write (setf my-array (make-array '(10))))\n" +
				"(terpri)\n" +
				"(setf (aref my-array 0) 25)\n" +
				"(setf (aref my-array 1) 23)\n" +
				"(setf (aref my-array 2) 45)\n" +
				"(setf (aref my-array 3) 10)\n" +
				"(setf (aref my-array 4) 20)\n" +
				"(setf (aref my-array 5) 17)\n" +
				"(setf (aref my-array 6) 25)\n" +
				"(setf (aref my-array 7) 19)\n" +
				"(setf (aref my-array 8) 67)\n" +
				"(setf (aref my-array 9) 30)\n" +
				"(write my-array)";
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
				//Peek the expected stack and make sure that we have an expected parenthesis
				if (sv.peekExpected() != null) {
					//Remove closing char from both stacks
					sv.removeFromActual();
					sv.removeFromExpected();
				}
				//Otherwise add an extra closing parenthesis to the actual stack
				else {
					sv.addToActual(closingChar);
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
