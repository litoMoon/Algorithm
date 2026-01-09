package Recursion;

import java.io.*;
import java.util.*;

public class Demo14 {
    static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read in =new Read();
    static long ans=0;
    static int len=0;
    static String s;
    public static void main(String[] args) throws IOException {
        s=in.next();
        int n=in.nextInt();
        int m=in.nextInt();
        len=s.length();
        dfs(0,n,m,0);
        System.out.println(ans);
    }
    public static void dfs(int i,long n,long m,long v){
        if(i<len){
            //先执行操作1的操作
            long x=(long)(s.charAt(i)-'0');
            long t=Math.min(9-x,n);//绝了！！！！
            dfs(i+1,n-t,m,v*10L+x+t);
            if(m>x){
                dfs(i+1,n,m-x-1,v*10L+9);//这里一定会是＋9
            }
        }else{
            ans=Math.max(ans,v);
        }
    }
}
class Read{
    StringTokenizer st=new StringTokenizer("");
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException{
        while(!st.hasMoreTokens()){
            st=new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    String nextLine() throws IOException{
        return bf.readLine();
    }
    int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    Double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
}
