package LeetCode;

import java.util.*;

public class CombinationSum {
    private static Set<List<Integer>> ret;
    private static List<List<Integer>> res;
    private static List<Integer> path;
    private static int aim;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret=new HashSet<>();
        res=new ArrayList<>();
        path=new ArrayList<>();
        aim=target;
        dfs(candidates,0);
        for (List<Integer> list:ret) {
            res.add(new ArrayList<>(list));
        }
        return res;
    }
    public static void dfs(int[] c,int curSum){
        if(curSum>aim) return;
        if(curSum==aim) {
            List<Integer> list=new ArrayList<>(path);
            Collections.sort(list);
            ret.add(new ArrayList<>(list));
            return ;
        }
        for(int i=0;i<c.length;i++){
            curSum+=c[i];
            path.add(c[i]);
            dfs(c,curSum);
            path.remove(path.size()-1);
            curSum-=c[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List<Integer> x:lists) {
            System.out.println(x);
        }

    }
}
