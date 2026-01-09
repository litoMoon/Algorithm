import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
//        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(1,4);
        System.out.println(list);
    }
}
