import java.util.Arrays;

/**
 * Given K floors and n eggs, we need to find the minimum number of tries required
 * to find the threshold floor from which if the egg is dropped, it will break, but any floor below it
 * is safe to throw the egg from.
 *
 * We find this recursively and using DP. For any floor, there can be two cases,
 * 1. If the egg breaks, we need to find the check for the floor below it with one less egg remaining.
 * 2. If egg does not break, we need to check all the floor above it with same number of eggs remaining
 * Since, we need to be sure that we check all the cases, we always select the worst case scenario, i.e.
 * we choose the worst of both the cases.
 * Once we have found the worst case for all the floors, our ans will be the minimum value of all these
 * floors.
 *
 * */
public class EggDropProblem {

    static int[][] cache;
    public static void main(String[] args) {

        int floors = 200;
        int eggs = 200;
        System.out.println(solution(floors, eggs));
    }

    private static int solution(int floors, int eggs) {
        int ans = 0;
        cache = new int[floors+1][eggs+1];
        Arrays.fill(cache[0], 0);
        Arrays.fill(cache[1], 1);
        for(int i = 2; i<=floors; i++){
            Arrays.fill(cache[i], -1);
        }
        if(floors==1)
            return 1;
        if(eggs==1)
            return floors;
        for(int floor = 1; floor<=floors;floor++){
            for(int egg = 1; egg<=eggs; egg++){
                ans = eggDropRec(floor, egg);
            }
        }
        return ans;
    }

    static int eggDropRec(int floors, int eggs){

        if(floors==0) return 0;
        if(floors==1) return 1;
        if(eggs == 1) {
            return cache[floors][eggs] = floors;
        }
        if(cache[floors][eggs]!=-1) return cache[floors][eggs];
        int min = Integer.MAX_VALUE;
        for(int trieFloor =1; trieFloor <floors; trieFloor++ ){
            min = Math.min( Math.max(eggDropRec(trieFloor-1,eggs-1 ),
                    eggDropRec( floors-trieFloor, eggs) ), min );
        }

        return cache[floors][eggs] = min+1;
    }
}
