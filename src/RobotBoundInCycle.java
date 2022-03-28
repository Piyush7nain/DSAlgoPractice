public class RobotBoundInCycle {
    public static void main(String[] args) {

        System.out.println(isRobotBounded("GGRGGLGGLGGLGG"));
    }
    /**
     * After at most 4 cycles, the limit cycle trajectory returns to the initial point x = 0, y = 0.
     * That is related to the fact that 4 directions (north, east, south, west) define the repeated cycles' plane symmetry
     * We do not need to run 4 cycles to identify the limit cycle trajectory. One cycle is enough. There could be two situations here.
     *
     * First, if the robot returns to the initial point after one cycle, that's the limit cycle trajectory.
     *
     * Second, if the robot doesn't face north at the end of the first cycle, that's the limit cycle trajectory.
     * Once again, that's the consequence of the plane symmetry for the repeated cycles
     * */
    public static boolean isRobotBounded(String instructions) {

        int[] coord = new int[]{0,0};
        int[][] movements = new int[][]{{1,1},{0,-1},{1,-1},{0,1}};
        int move = 0;
        char[] arr = instructions.toCharArray();
        char c;
        int axis = movements[0][0];
        int dir = movements[0][1];
        for(int i = 0; i<arr.length;i++){
            c = arr[i];
            axis = movements[move][0];
            dir = movements[move][1];
            if(c=='G'){
                coord[axis] = coord[axis] + dir;
            }
            else if(c=='L'){
                move = (move+1)%4;
            }
            else if(c=='R'){
                move = (4 + (move-1))%4;
            }
        }

        return (coord[0]==0 && coord[1]==0) || move!=0;

    }
}
