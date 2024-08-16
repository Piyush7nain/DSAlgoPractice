import java.util.Arrays;


public class HIndex {
    /**
     * Given an array of integers citations where citations[i] is the number of citations a researcher received for
     * their ith paper, return the researcher's h-index.
     *
     * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that
     * the given researcher has published at least h papers that have each been cited at least h times.
     *
     * Example 1:
     * Input: citations = [3,0,6,1,5]
     * Output: 3
     * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
     *
     * Example 2:
     * Input: citations = [1,3,1]
     * Output: 1*/

    /*
    * Sort the array. Start a counter from 1 and start comparing it with element from the back of the array.
    * If the citation[n-i]>=i in a sorted array, that means we have i elements with i or more citation
    *  */
    public static int hIndex(int[] citations){
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int index=0;
        for(int i = 1;i<=citations.length;i++){
            if(citations[citations.length -i]>=i)
                index =i;
        }
        return index;
    }

    public static int hIndex2(int[] citations){

        int[] freq = new int[citations.length+1];

        for(int i: citations){
            if(i>citations.length)
                freq[citations.length]++;
            else
                freq[i]++;
        }

        int total=0;
        for(int i=citations.length;i>=0;i--){
            total=total+freq[i];
            if(total>=i)
                return i;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(hIndex(nums));
    }
}
