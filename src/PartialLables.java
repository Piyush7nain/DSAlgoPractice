import java.util.*;

public class PartialLables {
    public static void main(String[] args) {
        PartialLables temp = new PartialLables();
        System.out.println(temp.partitionLabels("ebbc"));
    }
    /**
     * We need an array last[char] -> index of S where char occurs last.
     * Then, let anchor and j be the start and end of the current partition.
     * If we are at a label that occurs last at some index after j, we'll extend the partition j = last[c].
     * If we are at the end of the partition (i == j) then we'll append a partition size to our answer,
     * and set the start of our new partition to i+1.
     * */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        char[] carr =s.toCharArray();
        for(int i =0; i< carr.length;i++){
            last[carr[i]-'a'] = i;
        }

        int first = 0; int end = 0;
        List<Integer> ans = new LinkedList<>();
        for(int curr = 0; curr< carr.length;curr++){
            end = Math.max(end, last[carr[curr]-'a']);
            if(end == curr){
                ans.add(end - first +1);
                first = curr +1;
            }
        }
        return ans;
    }
    public List<Integer> partitionLabels2(String s) {

        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        char[] carr = s.toCharArray();
        for(int i = 0;i<carr.length;i++){
            map.putIfAbsent(carr[i], new ArrayList<>());
            map.get(carr[i]).add(i);
        }
        List<Integer[]> ranges = new ArrayList<>();
        int size;
        int i;
        Integer[] range;
        for(List<Integer> value : map.values()){
            int start = value.get(0);
            int end = value.get(value.size()-1);
            size = ranges.size();
            for(i = 0; i<size;i++){
                range = ranges.get(i);
                if( isWithin(range, start, end)){
                    break;
                }else if(isBackOverlap(range,start, end)){
                    range[0] = start;
                    break;
                }else if(isFrontOverlap(range, start, end)){
                    range[1] = end;
                    break;
                }else if (contains(range, start, end)){
                    range[0] = start;
                    range[1] = end;
                    break;
                }
            }
            if(i == size){
                ranges.add(new Integer[]{start, end});
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(Integer[] range2: ranges){
            ans.add(range2[1]-range2[0] +1);
        }

        return ans;
    }

    boolean isWithin(Integer[] range, int start, int end){

        return (range[0]<= start && range[1]>=end);
    }
    boolean isBackOverlap(Integer[] range, int start, int end){

        return (range[0]>= start && range[0] <= end && range[1]>=end);
    }
    boolean isFrontOverlap(Integer[] range, int start, int end){

        return (range[0]<= start && range[1]>=start && range[1]<=end);
    }
    boolean contains(Integer[] range, int start, int end){

        return (range[0]>= start && range[1]<=end);
    }
}
