package BraceChecker;

import java.util.Stack;

public class BraceChecker {
    String text;
    Stack<Character> stack = new Stack<>();

    public BraceChecker(String input) {
        text = input;
    }

    public void check() {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    System.out.println("Error: No opening brace for " + c + " at  " + i);
                    return;
                }
                char openingBrace = stack.pop();
                if (c == '}' && openingBrace != '{'
                        || c == ']' && openingBrace != '['
                        || c == ')' && openingBrace != '(') {
                    System.out.println("Error: opened " + openingBrace + " but closed " + c + " at  " + i);
                    return;
                }
            }
        }

        if (!stack.isEmpty()) {
            char openingBrace = stack.pop();
            System.out.println("Error: opened " + openingBrace + " but not closed");
        }
    }
}
