package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list1.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curlist = new ArrayList<>();// 当前行顺序表
            List<Integer> prelist =list1.get(i-1);// 当前行的上一行顺序表
            curlist.add(1);
            for (int j = 1; j < i; j++) {
                curlist.add(prelist.get(j) + prelist.get(j - 1));
            }
            curlist.add(1);
            list1.add(curlist);

        }
        return list1;

    }
}
