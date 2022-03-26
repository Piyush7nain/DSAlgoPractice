import java.util.ArrayList;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule temp = new CourseSchedule();
        System.out.println(temp.canFinish(2, new int[][]{ {1,0}}));
    }
    boolean cycleExists = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
}
