package other;

import org.junit.Test;

import java.util.Stack;

/**
 * @author liuqian
 * @date 2019/4/23  13:09
 * 有效的括号
 */
public class ValidParenthesesTest {

    @Test
    public void validParentheses() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{[()]}"));
    }

    private boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (isLeft(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || !isMatch(stack.pop(), ch)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }

    private boolean isLeft(char a) {
        return a == '(' || a == '[' || a == '{';
    }

    private boolean isRight(char a) {
        return a == ')' || a == ']' || a == '}';
    }
}
