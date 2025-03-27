import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * Implement the MinStack class:
     *
     * MinStack() initializes the stack object.
     * void push(int val) pushes the element val onto the stack.
     * void pop() removes the element on the top of the stack.
     * int top() gets the top element of the stack.
     * int getMin() retrieves the minimum element in the stack.
     * You must implement a solution with O(1) time complexity for each function.
     *
     * Example 1:
     * Input
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * Output
     * [null,null,null,null,-3,null,0,-2]
     *
     * Explanation
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin(); // return -3
     * minStack.pop();
     * minStack.top();    // return 0
     * minStack.getMin(); // return -2
     * */

    LinkedList<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

        stack.addLast(val);
    }

    public void pop() {
        int val = stack.removeLast();
        if(val==minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.peek();
    }

}
