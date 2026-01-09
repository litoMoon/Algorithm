import java.sql.Array;
import java.util.*;

public class Test11 {
    public static void main(String[] args) {
        int[]arr=new int[]{3,1,9};
        List<Integer> list=new ArrayList<>();
        int ret= Math.max(3,4);
        Set<Integer> set=new HashSet<>();

        Arrays.sort(arr);//对数组进行排序，没有返回值的存在
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(Arrays.sort(arr)));
    }
}
