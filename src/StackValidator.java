import java.util.Stack;

public class StackValidator {

	//Create Two Stacks One For The Actual Input and One For The Expected
	private Stack<Character> actual = new Stack<Character>();
	private Stack<Character> expected = new Stack<Character>();
	
	//Functions That Add A Character To Corresponding Stack
	public void addToActual(Character c) {
		actual.push(c);
	}
	
	public void addToExpected(Character c) {
		expected.push(c);
	}
	
	//Functions That Remove A Character From the Corresponding Stack
	public void removeFromActual() {
		actual.pop();
	}
	
	public void removeFromExpected() {
		expected.pop();
	}
	
	//Functions that Let you peek the first character from corresponding stack
	public Character peekActual() {
		if (!actualEmpty()) {
			return actual.peek();
		}
		else return Character.MIN_VALUE;
	}
	
	public Character peekExpected() {
		if (!expectedEmpty()) {
			return expected.peek();
		}
		else return Character.MIN_VALUE;
	}
	
	//Functions that let you determine if corresponding stack is empty
	public boolean actualEmpty() {
		if (actual.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean expectedEmpty() {
		if (expected.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
