package Binary_search;

import java.io.*;
import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Demo13 {
        //快读模板
        static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        static Read in=new Read();
        static int len;
        static int n;
        public static void main(String[] args) throws IOException{
            //输出阀门数和管道长度
            n=in.nextInt();
            len=in.nextInt();
            long [][]l=new long[n][2];
            for(int i=0;i<n;i++){
                l[i][0]=in.nextInt();//存储会开的阀门
                l[i][1]=in.nextInt();//存储阀门开的时长
            }
            long left=0,right=2000000020;
            while(left<right){
                long mid=left+((right-left)>>1);//防止溢出
                if(check(mid,l)){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            System.out.println(right);
        }
        public static boolean check(long time,long[][]l){
            pair[] pairs=new pair[n+2];
            int cnt=0;
            long lastleft=0,lastright=0;
            for(int i=0;i<n;i++){
                if(l[i][1]<=time){
                    pair p=new pair(l[i][0]-(time-l[i][1]),l[i][0]+(time-l[i][1]));
                    pairs[cnt++]=p;
                }
            }
            Arrays.sort(pairs,0,cnt);//只需要排序 0-cnt即可
            lastright=0;
            for(int i=0;i<cnt;i++){
                if(pairs[i].x>lastright+1) return false;//这里的意思是如果最左边的值在第一个阀门之后的话，这个结果是不满足的
                lastright=Math.max(pairs[i].y,lastright);
            }
            if(lastright<len) return false;
            return true;
        }

    }

class pair implements Comparable<pair>{
    long x;
    long y;

    public pair(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(pair o) {
        return Long.compare(x,o.x);//默认按照从小到大进行的排序
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

}
