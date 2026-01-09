package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo9 {


    //N皇后问题的解题一
 /*  static boolean []col;//用来记录列上的
   static boolean[] dig1;//用来记录主对角线
   static boolean[] dig2;//用来记录副对角线
   static List<List<String>> ret;//用来记录返回结果
   static List<String> cur;
   static StringBuffer path;
   static int len;
    public static List<List<String>> solveNQueens(int n) {
        col=new boolean[n];
        dig1=new boolean[2*n];
        dig2=new boolean[2*n];
        path=new StringBuffer();
        ret=new ArrayList<>();
        cur=new ArrayList<>();
        len=n;
        dfs(0,0);
        return ret;
    }
    public static void dfs(int x,int y){
        if(x==len) {
            change(path);
            ret.add(cur);
            cur=new ArrayList<>();
            return ;
        }
        for(int i=y;i<len;i++){
            if(!col[i] && !dig1[i-x+len] && !dig2[i+x]){//开始施行剪枝
                col[i]=dig1[i-x+len]=dig2[i+x]=true;//可以连等继续赋值
                path.append(i);//记录每次的列
                dfs(x+1,0);
                path.deleteCharAt(path.length()-1);
                col[i]=false;dig1[i-x+len]=false;dig2[i+x]=false;
            }

        }
    }
    public static List<String> change(StringBuffer path){
        String s=path.toString();
        StringBuffer ret=new StringBuffer();
        for(int i=0;i<s.length();i++){
            int num=s.charAt(i)-'0';//拿到数字
            for(int j=0;j<s.length();j++){
                if(j==num) {
                    ret.append("Q");
                    continue;
                }
                ret.append(".");
            }
            cur.add(ret.toString());
            ret=new StringBuffer();
        }
        return cur;
    }*/


    //N皇后的解题二
   static boolean[] checkCol,checkDig1,checkDig2;
   static List<List<String>> ret;
   static char[][] path;
   static int n;
   public static List<List<String>>  solveNQueens(int _n){
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
   public static void dfs(int row){//row 表示行

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

    public static void main(String[] args) {
        solveNQueens(4);
        System.out.println(solveNQueens(4));
    }
}
