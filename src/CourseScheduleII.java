import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    /**
     * https://leetcode.com/problems/course-schedule-ii/description/?envType=study-plan-v2&envId=top-interview-150
     * */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int[] pre: prerequisites) {
            if(adj[pre[1]] == null) adj[pre[1]] = new ArrayList<>();
            adj[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int curr= 0;
        while (!q.isEmpty()) {
             int course = q.poll();
             res[curr] =course;
             curr++;
             if(adj[course]==null){
                 continue;
             }
             for (int next : adj[course]) {
                 inDegree[next]--;
                 if(inDegree[next]==0){
                     q.add(next);
                 }
             }

        }

        return curr==numCourses?res:new int[0];

    }

    public static void main(String[] args) {
        CourseScheduleII temp = new CourseScheduleII();
        System.out.println(
                Arrays.toString(
                        temp.findOrder(7, new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}})));
    }
}
