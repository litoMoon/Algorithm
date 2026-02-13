package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private static List<String> res;
    private static StringBuilder path;
    private static final char[] cur=new char[]{'(',')'};
    public static List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        path=new StringBuilder();
        path.append("(");
        dfs(n,1,0);
        return res;
    }
    public static void dfs(int n,int left_count,int right_count){
        if(right_count>left_count || left_count>n) return ;
        if(path.length()==2*n) {
            res.add(path.toString());
            return ;
        }
        for(int i=0;i<cur.length;i++){
            path.append(cur[i]);
            if(i%2==0){
                left_count++;
                dfs(n,left_count,right_count);
            }else{
                right_count++;
                dfs(n,left_count,right_count);
            }
            path.deleteCharAt(path.length()-1);
            if(i%2==0) left_count--;
            else right_count--;
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }
}
