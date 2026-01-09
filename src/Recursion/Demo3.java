package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo3 {
    int left=0;
    int right=0;
    int sum=0;
    StringBuffer path;
    List<String> ret;
    public List<String> generateParenthesis(int n) {
        sum=n;
        path=new StringBuffer();
        ret=new ArrayList<>();
        dfs();
        return ret;

    }
    public void dfs(){
        //递归出口
        if(right==sum){
            ret.add(path.toString());
            return;
        }

        //左边剪枝
        if(left<sum) {
            path.append("(");
            left++;
            dfs();

            //回溯
            path.deleteCharAt(path.length()-1);
            left--;
        }

        //右边剪枝
        if(right<left){
            path.append(")");
            right++;
            dfs();

            //回溯
            path.deleteCharAt(path.length()-1);
            right--;
        }
    }
    public static void main(String[] args) {

    }
}
