import java.util.Stack;

public class MaxRectangle {

    /**
     * We keep storing the heights into stack till we find a height which is less than previous height
     * Once we find such height, we calculate the area of the previous heights by using the
     * height of the top of the stack and width as the distance between index +1 of last tallest
     * height less than the top  height as that height would be more than or equal to the top height
     * and the current index. This gives us the area of the top height. We do this till we encounter a
     * top height less than the current height. We then add the current height to the stack.
     * */
    public int largestRectangleArea(int[] hs) {
        Stack<Integer> hStack = new Stack<>();
        hStack.push(-1);
        int max =0;
        for(int i= 0;i<hs.length;i++){

            while(hStack.peek()!=-1 && hs[hStack.peek()]>=hs[i]){

                int ch = hs[hStack.pop()];
                int w = i - (hStack.peek() +1);
                max = Math.max(max, ch*w);
            }
            hStack.push(i);
        }


        while(hStack.peek()!=-1){
            int ch = hs[hStack.pop()];
            int w = hs.length - (hStack.peek()+1);
            max = Math.max(max, ch*w);
        }

        return max;
    }
}
