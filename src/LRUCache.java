import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    /**
     * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
     *
     * Implement the LRUCache class:
     *
     * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
     * int get(int key) Return the value of the key if the key exists, otherwise return -1.
     * void put(int key, int value) Update the value of the key if the key exists.
     * Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
     * The functions get and put must each run in O(1) average time complexity.
     *
     * Example 1:
     *
     * Input
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * Output
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * Explanation
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // cache is {1=1}
     * lRUCache.put(2, 2); // cache is {1=1, 2=2}
     * lRUCache.get(1);    // return 1
     * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
     * lRUCache.get(2);    // returns -1 (not found)
     * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
     * lRUCache.get(1);    // return -1 (not found)
     * lRUCache.get(3);    // return 3
     * lRUCache.get(4);    // return 4
     * */
    private final Map<Integer, DNode> cache;
    private DNode head;
    private DNode tail;
    private final int capacity;
    private int size;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DNode node = cache.get(key);
            remove(node.key);
            put(node.key, node.value);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(key);
        }
        if(size == capacity) {
            remove(tail.key);
        }
        add(key, value);
    }
    private void add(int key, int value) {
        DNode node = new DNode(key,value);
        if(size ==0){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        cache.put(key, node);
        size++;
    }

    private void remove(int key) {
        DNode node = cache.get(key);
        if(node == head) {
            head = head.next;
        }
        if(node == tail) {
            tail = tail.prev;
        }
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        cache.remove(key);
        size--;
    }

    public static class DNode {
        int key;
        int value;
        DNode next;
        DNode prev;
        public DNode(int key,int value) {
            this.key = key;
            this.value = value;
        }
        public DNode(int key,int value, DNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public DNode(int key, int value, DNode prev, DNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4

    }
}
