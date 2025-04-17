import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumMutation {

    /**
     * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
     *
     * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene
     * where one mutation is defined as one single character changed in the gene string.
     *
     * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
     * There is also a gene bank bank that records all the valid gene mutations.
     * A gene must be in bank to make it a valid gene string.
     *
     * Given the two gene strings startGene and endGene and the gene bank bank,
     * return the minimum number of mutations needed to mutate from startGene to endGene.
     * If there is no such a mutation, return -1.
     *
     * Note that the starting point is assumed to be valid, so it might not be included in the bank.
     *
     * Example 1:
     * Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
     * Output: 1
     *
     *  Example 2:
     * Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
     * Output: 2
     *
     * Constraints:
     * 0 <= bank.length <= 10
     * startGene.length == endGene.length == bank[i].length == 8
     * startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
     * */

    public int minMutation(String start, String end, String[] bank) {
        int steps = 0;
        char[] chars = "ACGT".toCharArray();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int currLen = queue.size();
        while (!queue.isEmpty()) {
            if(currLen ==0){
                currLen = queue.size();
            }
            char[] a = queue.poll().toCharArray();
            currLen--;
            for (int i = 0; i < a.length; i++) {
                char c = a[i];
                for (char ch : chars) {
                    a[i] = ch;
                    String newString = new String(a);
                    if(bankSet.contains(newString)&& newString.equals(end)) {
                        return steps+1;
                    }
                    if(!visited.contains(newString) && bankSet.contains(newString)) {
                        queue.add(newString);
                        visited.add(newString);
                    }
                }
                a[i] = c;
            }
            if(currLen ==0){
                steps += 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumMutation m = new MinimumMutation();
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC","AAACCCCC","AACCCCCC"};
        System.out.println(m.minMutation(start, end, bank));
    }
}
