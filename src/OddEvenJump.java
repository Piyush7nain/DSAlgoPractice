import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {

    public int oddEvenJumpsTreemap(int[] arr) {
        int n=arr.length;
        int ans=1;
        int[][] dp=new int[n][2];
        dp[n-1][0]=1;
        dp[n-1][1]=1;
        TreeMap<Integer, Integer> map=new TreeMap<>();
        map.put(arr[n-1], n-1);
        for(int i=n-2; i>=0; i--){
            Map.Entry<Integer, Integer> j=map.ceilingEntry(arr[i]);
            // System.out.print(i+" :: "+j+" ");
            if(j!=null){
                dp[i][0]=dp[j.getValue()][1];
            }
            j=map.floorEntry(arr[i]);
            if(j!=null){
                dp[i][1]=dp[j.getValue()][0];
            }
            // System.out.print(j+" \n");

            if(dp[i][0]==1){
                ans++;
            }
            map.put(arr[i], i);
        }
        // System.out.println();
        // for(int i=0; i<n; i++){
        //     System.out.print(dp[i][0]+":"+dp[i][1]+" ");
        // }
        return ans;
    }

    public int oddEvenJumps(int[] arr) {

        int[][] cache = new int[arr.length][2];
        int[] odd = new int[arr.length];
        int[] even  = new int[arr.length];
        int goodValue = 0;

        for(int i=arr.length-1;i>=0;i--){

            if(i==arr.length-1){
                cache[i][0] = cache[i][1] = 1;
                odd[i] = i;
                even[i] = i;
                goodValue+=1;

                continue;
            }
            int oddInd = getOddIndex(arr, i);
            if(oddInd!=-1)
                cache[i][0] = (cache[oddInd][1]==1)?1:0;
            else cache[i][0] = 0;
            if(i>0){
                int evenInd = getEvenIndex(arr, i);
                if(evenInd!=-1) cache[i][1] = (cache[evenInd][0]==1)?1:0;
                else cache[i][1] = 0;
            }

            goodValue+= cache[i][0];

        }
        return goodValue;
    }


    int getOddIndex(int[] arr, int start){
        //smallest value greated than key
        int ind = -1;
        int key = arr[start];
        int value = Integer.MAX_VALUE;
        for(int i = start+1; i<arr.length;i++){
            if(arr[i]>=key)
                if(arr[i]<value){
                    value = arr[i];
                    ind = i;
                }
        }
        return ind;
    }

    int getEvenIndex(int[] arr, int start){
        int ind = -1;
        int key = arr[start];
        int value = Integer.MIN_VALUE;
        for(int i = start+1; i<arr.length;i++){
            if(arr[i]<=key)
                if(arr[i]>value){
                    value = arr[i];
                    ind = i;
                }
        }
        return ind;
    }
}
