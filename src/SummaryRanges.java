import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SummaryRanges {

    public static void main(String[] args) {
        SummaryRanges temp = new SummaryRanges();
        temp.addNum(3);
        printArray(temp.getIntervals());

        temp.addNum(5);
        printArray(temp.getIntervals());

        temp.addNum(6);
        printArray(temp.getIntervals());

        temp.addNum(4);
        printArray(temp.getIntervals());

        temp.addNum(6);
        printArray(temp.getIntervals());

        temp.addNum(2);
        printArray(temp.getIntervals());

        temp.addNum(1);
        printArray(temp.getIntervals());
    }
    private static void printArray(int[][] arr){
        for (int[] a :arr) {
            System.out.println("["+ a[0]+" "+a[1]+"]");
        }
    }
    private class Pair{
        int start;
        int end;
        public Pair(int s, int e){
            this.start = s;
            this.end = e;
        }
    }

    TreeSet<Pair> set;
    public SummaryRanges() {
        Comparator myComp = new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                return a.start - b.start;
            }
        };

        set = new TreeSet<>(myComp);
    }

    public void addNum(int val) {

        Pair p = new Pair(val, val);
        if(set.contains(p))
            return;

        Pair upper = set.ceiling(p);
        Pair lower = set.floor(p);


        if(upper!=null && upper.start == p.start+1 && lower!=null && lower.end == p.start-1 ){
            set.remove(upper);
            set.remove(lower);
            Pair comb = new Pair(lower.start, upper.end);
            set.add(comb);
        }
        else if(lower!=null && lower.start<= p.start && lower.end>=p.start){
            return;
        }
        else if(lower!=null && lower.end == p.start-1){
            //set.remove(lower);
            lower.end = p.start;
            //set.add(lower);
        }else if(upper!=null && upper.start == p.start+1){
            //set.remove(upper);
            upper.start = p.start;
            //set.add(upper);
        }else{
            set.add(p);
        }
    }

    public int[][] getIntervals() {
        int[][] ans= new int[set.size()][2];
        int j =0;
        for (Pair e : set) {
            ans[j][0] = e.start;
            ans[j][1] = e.end;
            j++;
        }
        return ans;
    }
}
