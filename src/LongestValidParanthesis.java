import java.util.Stack;

public class LongestValidParanthesis {
    int maxL = 0;
    char[] chars;
    int[] memory;
    int longestValidParentheses(String s) {
        chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
                indexStack.push(i);
            }else if (chars[i] == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    indexStack.pop();
                }else {
                    stack.push(chars[i]);
                    indexStack.push(i);
                }

            }
        }

        if(indexStack.isEmpty()){
            return chars.length;
        }
        int lastIndex = chars.length;
        while (!indexStack.isEmpty()) {
            int curIndex = indexStack.pop();
            int len = lastIndex - curIndex-1;
            maxL = Math.max(maxL, len);
            lastIndex = curIndex;
        }
        maxL = Math.max(maxL, lastIndex);
        return maxL;
    }
    public static void main(String[] args) {
        LongestValidParanthesis l = new LongestValidParanthesis();
        System.out.println(l.longestValidParentheses(")()())"));
    }
}
