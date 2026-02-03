package LeetCode;

import java.util.HashMap;

public class PathSum{
    public HashMap<Long,Integer> map=new HashMap<>();//key=前缀和、value=前缀和出现的次数
    public int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L,1);
        dfs(root,0L,targetSum);
        return count;
    }
    public void dfs(TreeNode root,long sum,int aim){
        if(root==null) return;
        long curSum=root.val+sum;
        count+=map.getOrDefault(curSum-aim,0);
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        dfs(root.left,curSum,aim);
        dfs(root.right,curSum,aim);
        map.put(curSum,map.get(curSum)-1);//避免出现误差，记得事后及时更新 map 的值
    }
}

