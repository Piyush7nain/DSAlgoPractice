import java.util.*;

public class ThreeSum {

    /**
     * For the main function:
     *
     * Sort the input array nums.
     * Iterate through the array:
     * If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
     * If the current value is the same as the one before, skip it.
     * Otherwise, call twoSumII for the current position i.
     *
     * For twoSumII function:
     * Set the low pointer lo to i + 1, and high pointer hi to the last index.
     * While low pointer is smaller than high:
     * If sum of nums[i] + nums[lo] + nums[hi] is less than zero, increment lo.
     * If sum is greater than zero, decrement hi.
     * Otherwise, we found a triplet:
     * Add it to the result res.
     * Decrement hi and increment lo.
     * Increment lo while the next value is the same as before to avoid duplicates in the result.*/
    public List<List<Integer>> threeSumSort(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while(i<nums.length && nums[i]<=0){
            if(i==0 || nums[i]!=nums[i-1]){
                int lo = i+1;
                int hi = nums.length-1;
                while(lo<hi){
                    int rem = nums[i] + nums[lo] + nums[hi];
                    if(rem<0)
                        lo++;
                    else if(rem > 0)
                        hi--;
                    else{
                        ans.add( Arrays.asList( nums[i], nums[lo++], nums[hi--] ));
                        while(lo<hi && nums[lo]== nums[lo-1])
                            lo++;

                    }
                }

            }
            i++;
        }
        return ans;
    }

    //Instead of re-populating a hashset every time in the inner loop, we can use a hashmap and populate it once.
    // Values in the hashmap will indicate whether we have encountered that element in the current iteration.
    // When we process nums[j] in the inner loop, we set its hashmap value to i. This indicates that we can now use nums[j] as a complement for nums[i].
    public List<List<Integer>> threeSumNoSort(int[] nums) {

        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            if(dups.add(nums[i])){
                for(int j = i+1; j<nums.length; ++j){
                    int rem = 0 - nums[i] -nums[j];
                    if(map.containsKey(rem) && map.get(rem)==i){
                        List<Integer> list = Arrays.asList(rem, nums[j], nums[i]);
                        Collections.sort(list);
                        ans.add(list);
                    }
                    map.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
