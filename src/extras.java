import java.util.*;

//[1, 4, 3,4,8]
public class extras {

    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> set = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            int diff = target - nums[i];
            if(set.containsKey(diff)){
                result[0] = set.get(diff);
                result[1] = i;
            } else set.put(nums[i], i);
        }
        return result;
    }
}
