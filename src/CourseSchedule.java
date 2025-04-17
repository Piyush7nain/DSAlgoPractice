import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    /**
     * https://leetcode.com/problems/course-schedule/description/?envType=study-plan-v2&envId=top-interview-150
     * */
    public static void main(String[] args) {
        CourseSchedule temp = new CourseSchedule();
        System.out.println(temp.canFinish(8, new int[][]{ {1,0},{0,2},{2,3}, {4,5},{3,6}, {5,7}, {5,3}, {7,1}}));
    }
    boolean cycleExists = false;
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        int[] visited = new int[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for(int[] pre : prerequisites){
            if(adjList[pre[0]]!=null)
                adjList[pre[0]].add(pre[1]);
            else{
                adjList[pre[0]] = new ArrayList<Integer>();
                adjList[pre[0]].add(pre[1]);
            }
        }
        for(int i=0; i<numCourses && !cycleExists;i++){
            if(visited[i]==0){
                DFS(i, visited,recStack,  adjList);
            }
        }
        return !cycleExists;
    }

    void DFS(int i, int[] visited,boolean[] recStack, ArrayList<Integer>[] adjList){
        if(cycleExists)
            return;
        if(recStack[i]){
            cycleExists=true;
            return;
        }
        if(visited[i]==1)
            return;

        visited[i] = 1;
        recStack[i]=true;
        if(adjList[i]==null){
            return;
        }

        for(Integer k: adjList[i]){
            DFS(k, visited,recStack, adjList);
        }
        recStack[i]= false;
    }

    boolean cycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        Set<Integer> visitedInDfs = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] pre : prerequisites){
            ArrayList<Integer> list = adjList.getOrDefault(pre[0], new ArrayList<>());
            list.add(pre[1]);
            adjList.put(pre[0], list);
        }
        for(int i=0; i<numCourses; i++){
            if(cycle){
                break;
            }
            if(visited.contains(i)){
                continue;
            }
            dfs(i, visitedInDfs, adjList, visited);
        }

        return !cycle;
    }

    void dfs(int i, Set<Integer> visitedInDfs, Map<Integer, ArrayList<Integer>> adjList, Set<Integer> visited ) {
        if(cycle)
            return;
        if(visitedInDfs.contains(i)){
            cycle = true;
            return;
        }
        if(visited.contains(i)){
            return;
        }
        if(adjList.get(i)==null){
            return;
        }
        visitedInDfs.add(i);
        visited.add(i);
        for(int k : adjList.get(i)){
            dfs(k, visitedInDfs, adjList, visited);
        }
        visitedInDfs.remove(i);
    }
}
