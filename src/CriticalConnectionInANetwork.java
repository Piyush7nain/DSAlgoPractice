import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriticalConnectionInANetwork {

    //https://leetcode.com/problems/critical-connections-in-a-network/description/

    int dist =0;
    List<List<Integer>> criticalConnections;
    int[] tin;
    int[] low;
    int[] visited;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        criticalConnections   = new ArrayList<List<Integer>>();
        tin          = new int[n];
        low         = new int[n];
        visited   = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(List<Integer> connection : connections){
            List<Integer> node1 = map.getOrDefault(connection.get(0), new ArrayList<>());
            List<Integer> node2 = map.getOrDefault(connection.get(1), new ArrayList<>());
            node1.add(connection.get(1));
            node2.add(connection.get(0));
            map.put(connection.get(0),node1);
            map.put(connection.get(1),node2);
        }

        dfs(0, -1, map);

        return criticalConnections;
    }

    public void dfs(int currentNode, int parent, Map<Integer,List<Integer>> map) {
        visited[currentNode] = 1;
        tin[currentNode] = low[currentNode] = dist++;
        for(Integer connection : map.getOrDefault(currentNode, new ArrayList<>())){
            if(visited[connection] == 0){
                dfs(connection, currentNode, map);
                low[currentNode] = Math.min(low[currentNode], low[connection]);
            }else if(connection != parent){
                low[currentNode] = Math.min(low[currentNode], tin[connection]);
            }

            if(low[connection] > tin[currentNode]){
                criticalConnections.add(Arrays.asList(currentNode, connection));
            }
        }

    }

    public static void main(String[] args) {
        CriticalConnectionInANetwork network = new CriticalConnectionInANetwork();
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        List<List<Integer>> cc = network.criticalConnections(4, connections);
        System.out.println(cc);

    }
}
