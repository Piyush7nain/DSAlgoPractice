import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReorderEdges {

    /**
     * https://www.naukri.com/code360/problems/reorder-edges_1376443
     * */

    public static int reorderEdges(int n, ArrayList<ArrayList<Integer>> edgeList) {
        // Write your code here
        Map<Integer, Node> nodes = new HashMap<>();
        int count =0;
        for(int i =0;i< n; i++){
            Node node = new Node(i);
            nodes.put(i, node);
        }
        for(ArrayList<Integer> l : edgeList){
            Node pNode = nodes.get(l.get(0));
            Node cNode = nodes.get(l.get(1));
            pNode.outgoing.add(cNode);
            cNode.incoming.add(pNode);
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(nodes.get(0));
        Set<Node> visited = new HashSet<>();
        while(!stack.isEmpty()){
            Node node = stack.pop();
            visited.add(node);
            for(Node neighbor : node.outgoing){
                if(!visited.contains(neighbor)){
                    count++;
                    stack.push(neighbor);
                }

            }
            for(Node neighbor : node.incoming){
                if(!visited.contains(neighbor)){
                    stack.push(neighbor);
                }

            }
        }
        return count;
    }
    static class Node {
        int value;
        List<Node> outgoing;
        List<Node> incoming;
        public Node(int value){
            this.value = value;
            outgoing = new ArrayList<>();
            incoming = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(1,0)));
        edges.add(new ArrayList<>(List.of(2,0)));
        edges.add(new ArrayList<>(List.of(1,3)));
        edges.add(new ArrayList<>(List.of(2,4)));
        System.out.println(ReorderEdges.reorderEdges(5, edges));

    }
}
