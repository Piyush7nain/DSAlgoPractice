import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculator {
    /**
     * Given a string s representing a valid expression, implement a basic calculator to evaluate it,
     * and return the result of the evaluation.
     *
     * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
     * such as eval().
     *
     * Example 1:
     * Input: s = "1 + 1"
     * Output: 2
     *
     *  Example 2:
     * Input: s = " 2-1 + 2 "
     * Output: 3
     *
     *  Example 3:
     * Input: s = "(1+(4+5+2)-3)+(6+8)"
     * Output: 23
     *
     * Constraints:
     * 1 <= s.length <= 3 * 105
     * s consists of digits, '+', '-', '(', ')', and ' '.
     * s represents a valid expression.
     * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
     * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
     * There will be no two consecutive operators in the input.
     * Every number and running calculation will fit in a signed 32-bit integer.
     * */

    public int calculate(String s) {
        Queue<Character> charQueue = new LinkedList<>();
        charQueue.offer('(');
        for (char ch : s.toCharArray()) {
            charQueue.add(ch);
        }
        charQueue.offer(')');
        charQueue.poll();
        return eval(charQueue);
    }

    //(1+(-456+52 -( -2234 + 52) -3 )+(6+8))
    private int eval(Queue<Character> charQueue) {
        if(charQueue.isEmpty()) return 0;
        int ans =0;
        int sign = 1;
        while(!charQueue.isEmpty()) {
            char ch = charQueue.poll();
            if(ch == ')') {
                return ans;
            }else if(ch == '+') {
                sign = 1;
            }else if(ch == '-') {
                sign = -1;
            }else if(Character.isDigit(ch)) {
                int num = ch - '0';
                while(!charQueue.isEmpty() && Character.isDigit(charQueue.peek())) {
                    num = num * 10 + (charQueue.poll() - '0');
                }
                ans += sign * num;
                sign=1;
            }else if(ch=='(') {
                ans += sign * eval(charQueue);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        System.out.println(calculator.calculate("(1+(-456+52 -( -2234 + 52) -3 )+(6+8))"));
    }
}
