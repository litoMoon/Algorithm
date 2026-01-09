package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo6 {

    //方法一
    /*List<List<Integer>> ret;
    List<Integer> path;
    int aim,sum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        aim=target;
        ret=new ArrayList<>();
        path=new ArrayList<>();
        Arrays.sort(candidates);//先将数组排序一下子，默认是从小到大进行的排序
        dfs(candidates,0);
        return ret;
    }
    public void dfs(int[] nums,int pos){
        //递归出口
        if(sum==aim) {
            ret.add(new ArrayList<>(path));
            return;
        }
        if(sum>aim) return ;
        for(int i=pos;i<nums.length;i++){
            path.add(nums[i]);
            sum+=nums[pos];
            dfs(nums,i);//进行递归，剪枝

            //恢复现场
            path.remove(path.size()-1);
            sum-=nums[pos];
        }
    }*/

    //方法二
    
}
