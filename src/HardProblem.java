import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HardProblem {

    /**
     * https://codeforces.com/problemset/problem/706/C
     * */
    static int n;
    static int[] costs;
    static String[] strings;
    static Map<Integer, Map<String, Long>> memo = new HashMap<>(); // Correct memoization

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static long solve(int i, String prev) {
        if (i == n) {
            return 0;
        }

        if (memo.containsKey(i) && memo.get(i).containsKey(prev)) {
            return memo.get(i).get(prev);
        }

        long minCost = Long.MAX_VALUE;

        // Option 1: Keep original
        if (prev.isEmpty() || strings[i].compareTo(prev) >= 0) {
            long cost = solve(i + 1, strings[i]);
            if (cost != Long.MAX_VALUE) {
                minCost = Math.min(minCost, cost);
            }
        }

        // Option 2: Reverse
        String reversed = reverse(strings[i]);
        if (prev.isEmpty() || reversed.compareTo(prev) >= 0) {
            long cost = solve(i + 1, reversed);
            if (cost != Long.MAX_VALUE) {
                cost += costs[i]; // Corrected: Add cost only if solve() didn't return MAX_VALUE
                minCost = Math.min(minCost, cost);
            }
        }

        memo.computeIfAbsent(i, k -> new HashMap<>()).put(prev, minCost);
        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
        }
        strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }

        long ans = solve(0, ""); // Start with an empty previous string
        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }
}
