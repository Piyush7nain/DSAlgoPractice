import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    /**
     * https://leetcode.com/problems/target-sum/description/
     * */

    public int findTargetSumWays2(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put( i +"-"+target,  rec(nums,i-1,target + nums[i], map) + rec(nums, i-1,target - nums[i] , map) );
        }
        System.out.println(map);
        return map.getOrDefault((nums.length-1) + "-" +target, 0);
    }

    private int rec(int[] nums, int i, int target, Map<String, Integer> map) {
        if(i<0){
            if(target==0) return 1;
            else return 0;
        }
        if(map.containsKey(i+"-"+target)){
            System.out.println(i+"-"+target + " found");
            return map.get(i+"-"+target);
        }
        map.put(i + "-"+ target, rec(nums, i-1, target + nums[i], map) + rec(nums, i-1, target - nums[i] , map));
        return map.getOrDefault(i + "-" +target, 0);
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> temp = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int total = entry.getKey();
                int ways = entry.getValue();
                temp.put(total+nums[i],temp.getOrDefault(total + nums[i], 0)  + ways );
                temp.put(total-nums[i],temp.getOrDefault(total - nums[i], 0) + ways );
            }
            map = temp;
        }
        return map.getOrDefault(target, 0);
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays2(
                new int[]{1,1,1,1,1}, 3
        ));
    }
}
