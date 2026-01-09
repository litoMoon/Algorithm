package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
    List<Integer> path;//用来记录路径
    List<List<Integer>> ret;//用来记录返回结果
    public List<List<Integer>> combine(int n, int k) {
        path=new ArrayList<>();
        ret=new ArrayList<>();

        dfs(n,k);
        return ret;
    }
    public void dfs(int n,int k){
        if(path.size()==k){
            ret.add(new ArrayList<>(path));
        }

    }
    public static void main(String[] args) {

    }
}
