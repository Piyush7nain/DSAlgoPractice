import java.util.HashMap;
import java.util.List;
import java.util.Random;


final class Value{
    private final int value;
    private Random r = new Random();
    public Value(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    @Override
    public int hashCode() {
        return value;
    }
    public boolean equals(Object obj){
        return obj instanceof Value && this.value == ((Value) obj).value;

    }
}
public class TestExamples {
    public static void main(String[] args) {
        Value value = new Value(10);
        HashMap<Value, Object> map = new HashMap<>();
        Value value2 = new Value(10);
        map.put(value, "Hello World");
        map.put(value2, "Hi There");
        System.out.println(map.get(value));

        Integer integer = new Integer(10);
        value2.equals(integer);
    }

}

class Printer<T>{

    T toPrint;

    public Printer(T toPrint){
        this.toPrint = toPrint;
    }
    public void print(){
        System.out.println(toPrint);

    }
    public void printList(List<?> list){
        System.out.println(list);
    }
}
