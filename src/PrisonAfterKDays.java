import java.util.HashMap;
import java.util.Map;

public class PrisonAfterKDays {

    public int[] prisonAfterNDays(int[] cells, int n) {

        Map<Integer, Integer> map = new HashMap<>();
        int currDay = n;
        boolean inLoop = false;
        int[] curr = cells;
        while(currDay>0){
            if(!inLoop){
                int bitmap = bitMap(curr);
                if(map.containsKey(bitmap)){
                    int dist = map.get(bitmap) - currDay;
                    currDay = (currDay%dist);
                    inLoop = true;
                }else
                    map.put(bitmap, currDay);
            }
            if(currDay>0){
                currDay--;
                curr = nextDay(curr);
            }
        }
        return curr;
    }
    int[] nextDay(int[] prev){
        int[] curr = new int[8];
        curr[0] = 0;
        for(int j =1;j<=6;j++){
            curr[j] = 1- ( (1-prev[j-1])*prev[j+1] + (1-prev[j+1])*prev[j-1] );
        }
        curr[7] = 0;
        return curr;
    }
    int bitMap(int[] cells){
        int map = 0;
        for(int cell : cells){
            map <<=1;
            map = map|cell;
        }

        return map;
    }

    public static int[] prisonAfterNDays2(int[] cells, int n) {

        int[] prev = cells;
        int[] temp = new int[8];
        int[] curr = new int[8];
        for(int i =1;i<=n;i++){
            System.out.println("---------: "+i+" :------------");
            System.out.println("Prev:");
            printArray(prev);
            System.out.println("Curr:");
            printArray(curr);
            curr[0] = 0;
            for(int j =1;j<=6;j++){
                System.out.println((1-prev[j-1])*prev[j+1]);
                System.out.println((1-prev[j+1])*prev[j-1]);
                curr[i] = 1- ( (1-prev[j-1])*prev[j+1] + (1-prev[j+1])*prev[j-1] );
            }
            curr[7] = 0;
            prev = curr;
            curr = new int[8];

        }
        return prev;
    }

    static void printArray ( int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
