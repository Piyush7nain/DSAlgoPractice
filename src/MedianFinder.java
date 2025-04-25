import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MedianFinder {

    /**
     * https://leetcode.com/problems/find-median-from-data-stream/description/
     * */

    LinkedList<Integer> numbers;
    LinkedList.Node<Integer> medOne;
    LinkedList.Node<Integer> medTwo;
    double median;
    Integer size;
    public MedianFinder() {
        numbers = new LinkedList<Integer>();
        size = 0;
        median = 0.0;
    }

    public void addNum(int num) {
        numbers.add(num);
        size++;
        if(size ==1){
            medOne = numbers.get(0);
            medTwo = medOne;
            median = (medOne.data + medTwo.data) / 2.0;
            return;
        }
        if(num < medOne.data){
            if(size%2 == 0){
                medOne = medOne.prev;
            }else{
                medTwo = medTwo.prev;
            }
        }else if(num >= medTwo.data){
            if(size%2 != 0){
                medOne = medOne.next;
            }else{
                medTwo = medTwo.next;
            }
        }else{
            medOne = medOne.next;
            medTwo = medTwo.prev;
        }
        median  = (medTwo.data + medOne.data) / 2.0;

    }

    public double findMedian() {
        if(size ==0){
            return 0;
        }
        System.out.println(numbers.toString());
        return (medOne.data + medTwo.data) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        List<Integer> numbers = Utils.readIntegerListFromFile("");
        for(Integer num : numbers){
            mf.addNum(num);
            System.out.println(mf.findMedian());
        }
    }

    static class LinkedList<T extends Comparable<T>> {
        Node<T> head;
        public LinkedList() {
            head = null;
        }
        public int add(T num) {
            Node<T> newNode = new Node<>(num);
            int i =0;
            if (head == null || head.data.compareTo(num) >0 ) {
                newNode.next = head;
                if(head != null){
                    head.prev = newNode;
                }
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null && current.next.data.compareTo(num) <= 0) {
                    current = current.next;
                    i++;
                }
                newNode.next = current.next;
                if (current.next != null) {
                    current.next.prev = newNode;
                }
                current.next = newNode;
                newNode.prev = current;
                i++;
            }
            return i;
        }
        public Node<T> get(int index){
            Node<T> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            return current;
        }
        public Node<T> find(T num){
            Node<T> temp = head;
            while(temp != null){
                if(temp.data.equals(num)){
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<T> current = head;
            while (current != null) {
                sb.append(current.data).append(" -> ");
                current = current.next;
            }
            sb.append("null");
            return sb.toString();
        }


        static class Node<T> {
            private T data;
            private Node<T> next;
            private Node<T> prev;
            Node(T data) {
                this.data = data;
            }

        }
    }
}
