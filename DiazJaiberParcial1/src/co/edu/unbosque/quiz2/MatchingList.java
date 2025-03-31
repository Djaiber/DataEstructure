package co.edu.unbosque.quiz2;


import java.util.Scanner;
import estructura.MyDequeList;

public class MatchingList {
	
	private static boolean isValid(String str) {
	        MyDequeList<Character> stack = new MyDequeList<>();
	        return isValidRec(str, 0, stack); 
	    }
    private static boolean isValidRec(String str, int index, MyDequeList<Character> stack) {
        // Break Recursive
        if (index == str.length()) {
            return stack.size() == 0;
        }
        
        char c = str.charAt(index);
        if (c == '(' || c == '[' || c == '{') {
            stack.insertLast(c);
            return isValidRec(str, index + 1, stack); 
        } else if (c == ')' || c == ']' || c == '}') {
            if (stack.size() == 0) {
                return false;
            }
            char last = stack.removeLast();
            if (!isMatchingPair(last, c)) {
                return false;
            }
        }

        return isValidRec(str, index + 1, stack);
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        
        System.out.println(isValid(input) ? "Yes" : "No");
    }

    
}