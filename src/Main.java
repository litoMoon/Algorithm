
import java.util.*;
import java.io.*;

public class Main {
    //快速输出
    static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    //快速输出
    static Read sc=new Read();
    static int N=2010;
    static Map<Integer, List<int[]>> map=new HashMap<>();
    static boolean[][] st=new boolean[N][N];
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int n,m;
    public static void main(String[] args) throws IOException{
        n=sc.nextInt();
        m=sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x1=sc.nextInt()-1;
            int y1=sc.nextInt()-1;
            int x2=sc.nextInt()-1;
            int y2=sc.nextInt()-1;
            //传送门的建立
            //  add(x1,y1,x2,y2);
            add(x2,y2,x1,y1);
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{n-1,n-1});
        st[n-1][n-1]=true;
        //累计答案
        int ans=0;
        //计算层数
        int x=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
                int[] curr=queue.poll();
                int a=curr[0],b=curr[1];
                //累加答案
                ans+=x;
                if (map.containsKey(a*n+b)){
                    List<int[]> list=map.get(a*n+b);
                    for (int[] g:list){
                        if (!st[g[0]][g[1]]){
                            queue.offer(g);
                            st[g[0]][g[1]]=true;
                        }
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int newX=a+dx[i];
                    int newY=b+dy[i];
                    if (newX>=0&&newX<n&&newY>=0&&newY<n&&!st[newX][newY]){
                        queue.offer(new int[]{newX,newY});
                        st[newX][newY]=true;
                    }
                }
            }
            x++;
        }
        out.printf("%.2f",ans*1.0/(n*n));
    }
    public static void add(int x1,int y1,int x2,int y2){
        if (!map.containsKey(x1*n+y1)) map.put(x1*n+y1,new ArrayList<>());
        map.get(x1*n+y1).add(new int[]{x2,y2});
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
    double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
}

