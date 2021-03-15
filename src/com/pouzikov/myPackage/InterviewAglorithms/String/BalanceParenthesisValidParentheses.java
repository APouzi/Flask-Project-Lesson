package com.pouzikov.myPackage.InterviewAglorithms.String;

import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//
//Note that an empty string is also considered valid.
//
//Example 1:
//Input: "()"
//Output: true
//
//Example 2:
//Input: "()[]{}"
//Output: true
//
//Example 3:
//Input: "(]"
//Output: false
//
//Example 4:
//Input: "([)]"
//Output: false
//
//Example 5:
//Input: "{[]}"
//Output: true
public class BalanceParenthesisValidParentheses {
    public static void main(String[] args) {
        String s = "([()])";
        System.out.println(balanaceParenthesis(s));
    }
//
    public static boolean balanaceParenthesis(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(')
                    stack.push(')');
                else if (c == '{')
                    stack.push('}');
                else if (c == '[')
                    stack.push(']');
                else if (stack.isEmpty() || stack.pop() != c)
                    return false;
            }
            return stack.isEmpty();
        }
}
//For a passing test if we have the input string "({})" we first hit the character ( which means we push ) onto the stack.
//The stack is now ), then we hit the character { so we again push the closing bracket for this which is } the stack is
//now }). Now we hit the character } which skips over the else ifs and gets caught by else if
//(stack.isEmpty() || stack.pop() != c) this will now pop the stack and check if it matches our current character c which
//is } and it does! so we continue. Now the next character is ) which again skips all else ifs and gets caught again by
//else if (stack.isEmpty() || stack.pop() != c) we again check if this popped character from the stack matches our current
//character c which is ) and it does so now we have gone through all characters in our input string, and we now have an
//empty stack so we return the check stack.isEmpty() which is true, and our test passes. For a failing test we have the
//input string ({. We hit the first character ( so we push ) to the stack, then we hit { so we push } to the stack, the
//stack is now }). We have no more input string characters so the final check is stack.isEmpty() which returns false and
//our test fails. The idea here is to empty the stack before the input string has been fully processed. If the open and
//closing brackets are not in the correct order we end up with some characters still in the stack at the end of the process.
