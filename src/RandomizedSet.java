import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> indexMap;
    int size;
    Map<Integer, Integer> valMap;
    public RandomizedSet() {
        indexMap = new HashMap<>();
        valMap = new HashMap<>();
        size=0;
    }

    public boolean insert(int val) {
        if(valMap.containsKey(val))
            return false;
        size++;
        indexMap.put(size, val);
        valMap.put(val, size);
        return true;
    }

    public boolean remove(int val) {
        if(!valMap.containsKey(val))
            return false;
        int index = valMap.get(val);
        int lastElement = indexMap.get(size);
        valMap.remove(val);
        indexMap.remove(size);
        size--;
        if(size!=0) {
            indexMap.put(index, lastElement);
            valMap.put(lastElement, index);
        }
        return true;
    }

    public int getRandom() {
        int random = (int) ((Math.random()*(size)) +1);
        return indexMap.get(random);
    }
    void printSet(){
        String str = "//";
       for(Integer entry: indexMap.values()){
           str+= entry+"-";
        }
       str+="//";
       System.out.println(str);
    }
    public static void main(String[] args) {
        RandomizedSet rSet = new RandomizedSet();
        rSet.remove(0);
        rSet.remove(0);
        rSet.insert(0);
        rSet.printSet();
        System.out.println(rSet.getRandom());
        System.out.println(rSet.remove(0));
        System.out.println(rSet.insert(0));
        rSet.printSet();

//        int count =1;
//        int[] counts = new int[4];
//        while(count<=999){
//            int val = rSet.getRandom();
//            counts[val]++;
//            count++;
//        }
//        System.out.println(Arrays.toString(counts));
    }
}
