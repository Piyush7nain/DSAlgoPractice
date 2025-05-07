
import java.util.Set;
import java.util.TreeSet;

public class ContainDuplicateIII {

    /**
     * https://leetcode.com/problems/contains-duplicate-iii/description/
     * */

    public boolean containsDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];


            Long floor = set.floor(num + valueDiff);
            if (floor != null && floor >= num - valueDiff) {
                return true;
            }

            set.add(num);


            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ContainDuplicateIII c = new ContainDuplicateIII();
        System.out.println(c.containsDuplicate(new int[]{1,2,3,1}, 3,2));
    }
}
