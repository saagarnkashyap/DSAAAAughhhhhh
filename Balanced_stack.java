import java.util.*;
public class Balanced_stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();    // input being ((()) - which is not Balanced
		// this code is used to check if the stack is Balanced or not :)

		Stack<Character> st = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch=='(') {
				st.push(ch);
			}
			else {
				if(st.isEmpty()) {
					System.out.println("NOT");
					return;
				}
				st.pop();
			}
		}
		if(st.isEmpty()) {
			System.out.println("Balanced");
		}
		else {
			System.out.println("Not");
		}
	}
}