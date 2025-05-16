import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompareStringByFreq {

    /**
     * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/description/
     * */

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        var ans = new int[queries.length];
        var freq = new int[words.length];
        var qFreq = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            freq[i] = getFrequency(words[i]);
            qFreq[i] = getFrequency(queries[i]);
        }
        Arrays.sort(freq);
        System.out.println(Arrays.toString(freq));
        System.out.println(Arrays.toString(qFreq));
        for (int i = 0; i < queries.length; i++) {
            var f = getFrequency(queries[i]);
            if(f> freq[freq.length-1]){
                ans[i] = freq.length;
            } else if( f < freq[0]){
                ans[i] = 0;
            }else{
                ans[i] = freq.length - binarySearch(freq, f) -1;
            }
        }
        return ans;
    }

    public int binarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int result = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = low; i <= high; i++){

            sb.append("[" + i+":" +arr[i] + "] ");
        }
        System.out.println(sb.toString());
        while(low <= high){
            mid = (low + high)/2;
            String op = (arr[mid]>key)?">":"<";
            System.out.println("low :"+low+" high: "+ high + " mid : " + mid
                    +" value :"+arr[mid] +" "+ op + " "+ key );
            if(arr[mid] > key){
                high = mid-1;
            }else if(arr[mid] < key){
                result = mid;
                low = mid+1;
            }else{
                result = mid;
                low = mid+1;
            }
        }
        return result;
    }

    private int getFrequency(String word) {
        char cMin = word.charAt(0);
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if( word.charAt(i) < cMin ) {
                cMin = word.charAt(i);
                count = 1;
            }else if( word.charAt(i) == cMin ) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CompareStringByFreq compareStringByFreq = new CompareStringByFreq();
        System.out.println(Arrays.toString(compareStringByFreq.numSmallerByFrequency(
                new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"},
                new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"}
        )));
//        System.out.println(compareStringByFreq.binarySearch(
//                new int[]{1, 1, 1, 1, 2, 2, 2, 3, 5, 10}, 5
//        ));
    }
}
