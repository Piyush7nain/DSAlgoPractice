public class CopyListWithRandomPointer {
    /**
     * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150">
     *     QUESTION
     * </a>
     * */

    // Create new node between existing nodes, then delete old nodes
    // n1 -> n1' -> n2 -> n2' -> n3 -> n3'
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node dummy =head;
        Node newHead = null;
        printList(head);
        System.out.println("\n");
        while(dummy!=null){
            Node newNode = new Node(dummy.val);
            newNode.setGen("new");
            newNode.next = dummy.next;
            Node temp = dummy;
            dummy = dummy.next;
            temp.next = newNode;
            if(newHead==null){
                newHead = newNode;
            }
        }
        printList(head);
        System.out.println("\n");
        dummy = head;
        while(dummy!=null){
            Node newNode = dummy.next;
            if(dummy.random!=null){
                newNode.random = dummy.random.next;
            }
            dummy = newNode.next;
        }
        printList(head);
        System.out.println("\n");
        dummy = head;
        Node temp = head.next;
        while(temp!=null && temp.next!=null){
            System.out.print("Dummy: " +dummy + "\n");
            System.out.print("Temp: " +temp + "\n");
            dummy.next = dummy.next.next;
            temp.next = temp.next.next;
            dummy = dummy.next;
            temp = temp.next;
        }
        dummy.next = null;
        printList(newHead);
        System.out.println("\n");
        printList(head);

        return newHead;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        head.random = null;
        n1.random = head;
        n2.random = n3;
        n3.random = n1;
        copyListWithRandomPointer.copyRandomList(head);
    }

    void printList(Node head) {
        Node temp = head;
        while(temp!=null){
            System.out.print( temp + " - ");
            temp = temp.next;
        }
    }
    static class Node {
        int val;
        Node next;
        Node random;
        String gen;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        public void setGen(String gen) {
            this.gen = gen;
        }
        @Override
        public String toString() {
            if(random!=null){
                return "Node [val=" + val +  ", random = [" + random.val + " "+random.gen + " ], gen =" + gen+ "]";
            }else{
                return "Node [val=" + val +  ", random= null" +", gen =" + gen+ "]";
            }

        }
    }
}
