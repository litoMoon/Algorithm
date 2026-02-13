package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveQueues {
    boolean[] checkCol,checkDig1,checkDig2;
    List<List<String>> ret;
    char[][] path;
    int n;
    public  List<List<String>>  solveNQueens(int _n){
        n=_n;
        checkCol=new boolean[n];
        checkDig1=new boolean[2*n];
        checkDig2=new boolean[2*n];
        ret=new ArrayList<>();
        path=new char[n][n];//创建一个字符的二维数组用来存储皇后和空白位置

        for(int i=0;i<n;i++){
            Arrays.fill(path[i],'.');//用小数点这个字符填满
        }
        dfs(0);
        return ret;
    }
    public  void dfs(int row){//row 表示行

        //返回
        if(row==n){
            List<String> tmp=new ArrayList<>();
            for(int i=0;i<n;i++){
                tmp.add(new String(path[i]));//path[i]表示的是一个一维数组，将一个一维的字符数组转化为字符串加入到字符串链表中
            }
            ret.add(new ArrayList<>(tmp));
            return ;
        }

        for(int i=0;i<n;i++){
            if(checkCol[i]==false && checkDig1[i-row+n]==false && checkDig2[i+row]==false){
                checkCol[i]=checkDig1[i-row+n]=checkDig2[i+row]=true;
                path[row][i]='Q';
                dfs(row+1);
                checkCol[i]=checkDig1[i-row+n]=checkDig2[i+row]=false;
                path[row][i]='.';
            }

        }
    }
}
