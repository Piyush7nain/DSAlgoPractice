import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {


        Map<String, Integer> map = new HashMap<>();
        for(String word : words){

            map.putIfAbsent(word, 0);
            map.put(word, map.get(word)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
                if(a.getValue()==b.getValue())
                    return a.getKey().compareTo(b.getKey());
                return -a.getValue().compareTo(b.getValue());
            }
        });
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            queue.offer(entry);
        }

        List<String> ans = new LinkedList<>();
        for(int i = 0; i<k;i++){
            ans.add(queue.poll().getKey());

        }
        return ans;
    }
}
