import java.util.ArrayList;
import java.util.List;

public class Combinations {

    /**
     * https://leetcode.com/problems/combinations/description
     * */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0) return res;
        List<Integer> combination = new ArrayList<>();
        combine(n, 0, k, combination, res);
        return res;
    }
    void combine(int n,int curr,  int k,List<Integer> current, List<List<Integer>> res) {
        if(k==0){
            res.add(new ArrayList<>(current));
        }
        for(int i = curr+1;  i<=n; i++){
            if(current.isEmpty() && i > (n-k+1)){
                break;
            }
            current.add(i);
            combine(n, i, k-1, current, res);
            current.remove(current.size()-1);
        }

    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
