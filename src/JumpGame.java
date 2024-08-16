public class JumpGame {
    /**
     * You are given an integer array nums. You are initially positioned at the array's first index,
     * and each element in the array represents your maximum jump length at that position.
     *
     * Return true if you can reach the last index, or false otherwise.
     *
     * Example 1:
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     *
     * Example 2:
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
     * which makes it impossible to reach the last index.*/

    /*
    * Starting from the last check for each index if from that index, if any next index within the range
    *  has the possibility to reach the final index. If yes, then mark current index as true. and then test previous index
    * */
    public  static boolean canJump(int[] nums){
        boolean[] canJump = new boolean[nums.length];
        canJump[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){
            int j =i+1;
            if(nums[i]==0){
                continue;
            }
            while(j<=i+nums[i]&&j<nums.length){
                if(canJump[j]){
                    canJump[i]=true;
                    break;
                }
                j++;
            }
        }
        return canJump[0];
    }
    public static boolean canJump2(int[] nums){
        int finalDestination = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            int jumpLenght = nums[i];
            if(i+jumpLenght>= finalDestination)
                finalDestination=i;

        }
        return finalDestination==0;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1,4};
        System.out.println(canJump2(nums));
    }
}
