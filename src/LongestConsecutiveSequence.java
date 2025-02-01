import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LongestConsecutiveSequence {

    /**
     * Given an unsorted array of integers nums, return the length of the
     * longest consecutive elements sequence.
     *
     * You must write an algorithm that runs in O(n) time.
     *
     * Example 1:
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
     * Therefore its length is 4.
     *
     *  Example 2:
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     *
     * Constraints:
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * */

    public int longestConsecutive3(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }
                if(length > longest) {
                    longest = length;
                    System.out.println("["+num + ","+(num + length-1)+"]");
                }
//                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer[]> frontMap = new HashMap<>();
        Map<Integer, Integer[]> endMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            Integer[] front = null;
            Integer[] back = null;
            if(frontMap.containsKey(num) || endMap.containsKey(num)) {
                continue;
            }
            if(frontMap.containsKey(num+1)) {
                back = frontMap.get(num+1);
            }
            if(endMap.containsKey(num-1) || endMap.containsKey(num)) {
                front = endMap.get(num-1);
            }
            Integer[] mergedQueue = merge(front, back, num);
            System.out.println("Front: "+ Arrays.toString(front)+ ", Num: "+num + ", Back: "+Arrays.toString(back) +", Merged Queue: " + Arrays.toString(mergedQueue) + ":: Size : " + (mergedQueue[1]-mergedQueue[0]+ 1));
            if((mergedQueue[1]-mergedQueue[0]+ 1) > res) {
                res = (mergedQueue[1]-mergedQueue[0]+ 1);
                System.out.println("Updated Size : " + (mergedQueue[1]-mergedQueue[0]+ 1));
            }
            frontMap.put(mergedQueue[0], mergedQueue);
            endMap.put(mergedQueue[1], mergedQueue);
        }
        return res;
    }

    Integer[] merge(Integer[] front, Integer[] back, int num) {
        Integer[] merged = new Integer[2];
        if(front == null) {
            front = new Integer[]{num, num};
        }
        if(back == null) {
            back = new Integer[]{num, num};
        }
        merged[0] = Math.min(front[0], num);
        merged[1] = Math.max(back[1], num);
        return merged;
    }
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Set<Integer>> list = new HashSet<>() {};
        int res = 1;
        for (int num : nums) {
            Set<Integer> prev = null;
            Set<Integer> next = null;
            for(Set<Integer> set : list) {
                if(set.contains(num-1)) {
                    prev = set;
                }else if(set.contains(num+1) || set.contains(num)) {
                    next = set;
                }
            }
            if(prev != null) {
                list.remove(prev);
            }
            if(next != null) {
                list.remove(next);
            }
            Set<Integer> newSet = merge(prev, next, num);
            if(newSet.size() > res) {
                res = newSet.size();
            }
            list.add(newSet);

        }

        return res;

    }

    private Set<Integer> merge(Set<Integer> prev, Set<Integer> next, int num) {
        Set<Integer> newSet = new HashSet<>();
        newSet.add(num);
        if(next!=null){
            newSet.addAll(next);
        }
        if(prev!=null){
            newSet.addAll(prev);
        }
        return newSet;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        String fileName = "src/input.txt"; // File containing the integers
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by commas or whitespace and parse integers
                String[] tokens = line.split("[,\\s]+");
                for (String token : tokens) {
                    if (!token.isEmpty()) {
                        numbers.add(Integer.parseInt(token));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // Convert the list to an array
        int[] arr = numbers.stream().mapToInt(Integer::intValue).toArray();
//        System.out.println(Arrays.toString(arr));
        System.out.println(lcs.longestConsecutive(arr));
    }
}
