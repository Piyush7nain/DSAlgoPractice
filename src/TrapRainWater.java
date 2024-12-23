import java.util.Stack;

public class TrapRainWater {

    /**
     * Given an arr of heights of column, calculate total rainwater that can be stored between them
     * */
    public static void main(String[] args) {

        int[]  heights = {10,5,4,7,2,0,0,7,8};
        StackImpl(heights);
        TwoPointerImpl(heights);
    }

    /**
     * For every index, capacity is equal to the difference between its height and min of max height
     * on  its left and right.
     * We start 3 indexes, current, rMax and lMax.
     * For each index, if rMax is less than or equal to current, we find the next rMax ahead of current.
     * and if lMax is less than current, the current is made the lMax.
     * After these the cap is calculated and added to result
     * */
    private static int TwoPointerImpl(int[] heights ){

        int lMax=0;  int rMax = 0;  int current;
        int finalCap =0;
        for(current =0; current< heights.length;current++){

            if(rMax<=current){
                rMax = current;
                for(int r = rMax; r<heights.length; r++){
                    if(heights[rMax]<=heights[r])
                        rMax = r;
                }
            }

            if(heights[lMax]<=heights[current] ){
                lMax = current;
                continue;
            }
            finalCap += Math.min(heights[lMax], heights[rMax]) - heights[current];
        }

        System.out.println(finalCap);
        return finalCap;
    }

    /**
     * Stack approach : We keep storing element which are shorter than the previous element.
     * If we encounter a height which is taller than last stored elem, we calculate the water stored at
     * the top of last elem by calculating min of height to the left ( next elem in stack) and
     * right(present) and subtracting the last elem height. This is done till we encounter the height
     * in the stack that is taller that the current is encountered.*/
    private static void StackImpl(int[] heights) {
        int finalCap = 0;
        Stack<Integer> hStack = new Stack<>();
        for (int i = 0; i< heights.length; i++) {

            while (!hStack.isEmpty() && heights[i] > heights[hStack.peek()]) {
                int poppedHeight = heights[hStack.peek()];
                hStack.pop();
                if(hStack.isEmpty())
                    break;

                int minHeight = Math.min(heights[i], heights[hStack.peek()]) -poppedHeight ;
                finalCap+= Math.max(0, i - hStack.peek() -1)*minHeight;
            }
            hStack.push(i);
        }

        System.out.println(finalCap);
    }


}
