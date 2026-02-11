package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    private static List<List<Integer>> ret;
    private static List<Integer> path;
    private static boolean[] bool;
    public static List<List<Integer>> permute(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        bool=new boolean[nums.length];//用于记录当前数是否被确定
        dfs(nums);
        return ret;
    }
    public static void dfs(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(!bool[i]){
                path.add(nums[i]);
                bool[i]=true;
                dfs(nums);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        permute(nums);
    }
}
