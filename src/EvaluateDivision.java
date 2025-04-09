import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    Map<String, Node> graph = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();
    double[] result ;
    boolean found;

    public double[] calcEquation(List<List<String>> equations,double[] values, List<List<String>> queries) {
        result = new double[queries.size()];
        buildGraph(equations, values);
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            Node fromNode = graph.get(from);
            Node toNode = graph.get(to);

            if(fromNode == null || toNode == null) {
                result[i] = -1.0;
            }else{
                System.out.println("Start bfs for " + fromNode.name + " to " + toNode.name);
                found = false;
                bfs(fromNode, toNode, 1.0, i);
                if(!found){
                    result[i] = -1.0;
                }
            }
        }
        return result;
    }

    void bfs(Node fromNode, Node toNode, double prev, int i) {

        if(toNode == null){
            return ;
        }
        System.out.print(" Searching from "+fromNode.name + " to " + toNode.name + " with prev " + prev + " \n");
        if(toNode == fromNode) {
            result[i] = prev;
            found = true;
            return;
        }
        visited.put(fromNode.name, true);
        for(Map.Entry<Node, Double> e: fromNode.neighbours.entrySet()){
            if(!visited.getOrDefault(e.getKey().name,false )){
                double temp = prev;
                prev = prev*e.getValue();
                bfs(e.getKey(), toNode, prev, i);
                prev = temp;
            }
        }
        visited.put(fromNode.name, false);

    }

    void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            Node fromNode = graph.getOrDefault(from, new Node(from));
            Node toNode = graph.getOrDefault(to, new Node(to));
            fromNode.neighbours.put(toNode, values[i]);
            toNode.neighbours.put(fromNode, 1/values[i]);
            graph.put(from, fromNode);
            graph.put(to, toNode);
        }
    }

    class Node{
        String name;
        Map<Node, Double> neighbours = new HashMap<>();
        Node(String name) {
            this.name = name;
        }

    }

    public static void main(String[] args) {
        EvaluateDivision eval = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(List.of(new String[]{"a", "b"})));
        equations.add(new ArrayList<>(List.of(new String[]{"b", "c"})));
        equations.add(new ArrayList<>(List.of(new String[]{"c", "d"})));
        equations.add(new ArrayList<>(List.of(new String[]{"c", "e"})));
        equations.add(new ArrayList<>(List.of(new String[]{"b", "f"})));
        double[] values = {2.0, 3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(List.of(new String[]{"a", "b"})));
        queries.add(new ArrayList<>(List.of(new String[]{"a", "c"})));
        queries.add(new ArrayList<>(List.of(new String[]{"a", "d"})));
        queries.add(new ArrayList<>(List.of(new String[]{"a", "e"})));
        queries.add(new ArrayList<>(List.of(new String[]{"a", "f"})));
        queries.add(new ArrayList<>(List.of(new String[]{"f", "e"})));
        queries.add(new ArrayList<>(List.of(new String[]{"f", "g"})));

        System.out.println(Arrays.toString(eval.calcEquation(equations, values, queries)));

    }
}
