import java.util.Stack;

public class ValidateStackSequences {

    /**
     * https://leetcode.com/problems/validate-stack-sequences/description/
     * */

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        for (int i = 0; i < popped.length; i++) {
            popStack.push(popped[popped.length -1 - i]);
        }
        for (int i = 0; i < pushed.length; i++) {
            pushStack.push(pushed[i]);
            while(!pushStack.empty() && !popStack.empty() &&
            pushStack.peek().equals(popStack.peek() )){
                popStack.pop();
                pushStack.pop();
            }
        }
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences vs = new ValidateStackSequences();
        System.out.println(
                vs.validateStackSequences(
                        new int[]{1,2,3,4,5},
                        new int[]{4,5,3,2,1}
                )
        );
    }
}
