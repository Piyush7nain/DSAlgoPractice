import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

 You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

 Return the answer with the smaller index first.

 Example 1:

 Input:
 nums = [3,4,5,6], target = 7

 Output: [0,1]
 * */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0 ; i<nums.length;i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                ans[0] = map.get(rem);
                ans[1] = i;
                break;
            }else{
                map.put(nums[i], i);
            }

        }
        return ans;

    }

    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else
                map.put(nums[i], new ArrayList<>(Arrays.asList( i ) ));
        }
        for(int i = 0; i<nums.length;i++){

            int rem = target -nums[i];
            if(rem ==nums[i]){
                if(map.get(nums[i]).size()==2 )
                    return map.get(nums[i]).stream().mapToInt(j -> j).toArray();
            }
            else{
                if(map.containsKey(rem))
                    return new int[]{ i, map.get(rem).get(0) };
            }
        }
        return new int[0];
    }
}
