import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,2,4,8,16,32,64,128},82 ) );
    }
    public static int threeSumClosest(int[] nums, int target) {
        int ans =0;
        int sum =0;
        int gap=0;
        Arrays.sort(nums);
        int maxGap = 1001;
        int i =0;
        while(i< nums.length ){
            int lo = i+1; int hi = nums.length-1;
            while(lo<hi){
                sum = nums[i] + nums[lo] + nums[hi];
                gap = Math.abs(target -sum);
                if(gap<maxGap){
                    maxGap = gap;
                    ans = sum;
                }
                if(sum == target)
                    return sum;
                else if( sum <target){
                    lo++;
                }else
                    hi--;
            }
            i++;
        }
        return ans;
    }
}
