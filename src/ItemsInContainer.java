import java.util.*;

public class ItemsInContainer {
    public static void main(String[] args) {
        List<Integer> start = new ArrayList<Integer>(Arrays.asList(1,2,3,3,1));
        List<Integer> end = new ArrayList<Integer>(Arrays.asList(2,3,4,6,10));
        numberOfItems("**|**|***|**", start, end);
    }
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here
        int ind = 0;
        char[] arr = s.toCharArray();
        int strLen = s.length();
        for(ind =0;ind<strLen;ind++){
            if(arr[ind]== '|')
                break;
        }

        int total = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(ind++, total);
        while(ind<strLen){

            if(arr[ind]=='|')
                map.put(ind, total);
            else
                total++;

            ind++;
        }

        int indLen = startIndices.size();
        int eInd;
        int sInd;
        int sTotal;
        int eTotal;

        List<Integer> ans = new LinkedList<>();
        int first = map.firstKey();
        int last = map.lastKey();
        for(int i=0;i<indLen ;i++){
            if(map.size()==0){
                ans.add(0);
                continue;
            }
            sInd = startIndices.get(i)-1;
            eInd = endIndices.get(i)-1;
            if(sInd >eInd){
                ans.add(0);
                continue;
            }
            sTotal = ( sInd<=last)? map.ceilingEntry(sInd).getValue() : 0;
            eTotal = (eInd>=first )? map.floorEntry(eInd).getValue():0;
            ans.add(Math.max(eTotal -sTotal, 0));
        }
        return ans;
    }

}

