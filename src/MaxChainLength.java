import java.util.Arrays;
import java.util.Comparator;

public class MaxChainLength {

    public static void main(String[] args) {

        String ints = "778 887 794 916 336 387 493 650 363 422 28 691 60 764 541 927 173 427 212 737 369 568 430 783 531 863 68 124 136 930 23 803 59 70 168 394 12 457 43 230 374 422 785 920 199 538 316 325 371 414 92 527 957 981 863 874 171 997 282 306 85 926 328 337 506 847 314 730";
        String[] intsarr = ints.split(" ");
        int[] arr = new int[intsarr.length];
        for (int i = 0; i< intsarr.length;i++) {
            arr[i] = Integer.parseInt(intsarr[i]);
        }

        //int[] arr = new int[]{5 ,24 , 39,60 , 15,28 , 27,40 , 50,90};
        int n = intsarr.length/2;
        Pair[] pairs = new Pair[n];

        for(int i =0, j=0; i<2*n-1 && j<n; i=i+2, j++){
            pairs[j] = new Pair(arr[i], arr[i+1]);
        }
        Arrays.sort(pairs, (a, b) -> (a.back -b.back) );
        printArray(pairs);
        System.out.println(maxChainLength(pairs));

    }

    private static int maxChainLength(Pair[] pairs) {
        int n = pairs.length;
        int[] maxLengths = new int[n];
        int MAXLENGTH = 1;
        maxLengths[0] = 1;
        if(n==1)
            return 1;
        for(int current = 1; current < n; current++){
            int maxLen = 0;
            for(int prev = current -1; prev>=0; prev --){

                if(canJoin(pairs[current], pairs[prev])>0)
                    maxLen = Math.max(maxLen, maxLengths[prev]);
            }
            maxLen+=1;
            maxLengths[current] = maxLen;
            MAXLENGTH = Math.max(MAXLENGTH, maxLen);
            printArray(maxLengths);
        }

        return MAXLENGTH;

    }
    static int canJoin(Pair cur, Pair prev ){
        //System.out.println( "Prev :: " + prev + " Current::" + cur +" :: " +Integer.compare( cur.front,prev.back));
        return Integer.compare( cur.front,prev.back);
    }
    static void printArray ( int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    static void printArray ( Pair[] arr){
        StringBuilder sb = new StringBuilder();
        for (Pair i : arr) {
            sb.append(i.toString()).append(",");
        }
        System.out.println(sb);
    }

}
class Pair{
    int front;
    int back;
    public Pair(int a, int b){
        front = a;
        back = b;
    }
    @Override
    public String toString(){

        return "[" +front+" "+back+"]";
    }
}
class CompareByFirst implements Comparator<Pair>
{
    public int compare(Pair a, Pair b)
    {
        return a.front - b.front;
    }
}