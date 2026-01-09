package Recursion;

public class Demo5 {
    static int target;
    static int sum;
    public static int findTargetSumWays(int[] nums, int _target) {
        int path=0;
        target=_target;
        dfs(nums,path,0);
        return sum;
    }
    public static void dfs(int[] nums,int path,int pos){
        if(path==target && pos==nums.length) {
            sum++; return ;
        }
        if(pos==nums.length) return ;
        path+=nums[pos];
        dfs(nums,path,pos+1);
        path-=nums[pos];
        path-=nums[pos];
        dfs(nums,path,pos+1);
        path+=nums[pos];

    }
    public static void main(String[] args) {
     //   findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
