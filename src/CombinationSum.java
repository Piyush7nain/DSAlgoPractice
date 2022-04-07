import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum t = new CombinationSum();
        t.combinationSum(new int[]{2,3,6,7},7);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<candidates.length;i++)
            backTrack(candidates, ans, i,0, new ArrayList<>(), target);

        return ans;
    }

    void backTrack(int[] arr, List<List<Integer>> ans, int curr, int cSum, List<Integer> cList, int target ){
        cSum +=arr[curr];
        if(cSum>target)
            return;
        if(cSum == target){
            cList.add(arr[curr]);
            ans.add(new ArrayList<>(cList));
            cList.remove(cList.size()-1);
            return;
        }

        for(int i = curr; i<arr.length;i++){
            if(arr[i]+cSum<=target){
                cList.add(arr[curr]);
                backTrack(arr, ans, i,cSum, cList, target);
                cList.remove(cList.size()-1);
            }else break;
        }
    }
}
