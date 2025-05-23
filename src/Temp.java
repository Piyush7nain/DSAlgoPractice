import java.util.*;

public class Temp {



    private class Pair{
        int start;
        int end;
        public Pair(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    public static void main(String[] args) {

        example ex = new example();
        Number n1 = new Integer(10);
        Integer n2 = new Integer(10);

        ex.sum(10);

    }
}
class example{

    void sum(Number a){
        System.out.println("Number method called");
    }
    void sum(Integer a){
        System.out.println("Integer method called");
    }
}