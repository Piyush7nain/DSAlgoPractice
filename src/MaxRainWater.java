public class MaxRainWater {
/*    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.*/
    public int maxArea(int[] height) {
        int maxCap  = 0;
        int f = 0; int e = height.length-1;
        while(f<e){
            maxCap = Math.max((e-f)* Math.min(height[f], height[e]), maxCap);
            if(height[f]<height[e])
                f++;
            else e--;
        }

        return maxCap;
    }
}
