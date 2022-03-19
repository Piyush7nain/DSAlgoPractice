import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
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

        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else
                map.put(nums[i], new ArrayList<Integer>(Arrays.asList( i ) ));
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
        return null;
    }
}
