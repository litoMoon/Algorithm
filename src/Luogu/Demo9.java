package Luogu;


/*
import java.util.*;
import java.io.*;

public class Demo9 {
    //爆破题---并查集 + kruskal 算法 + 内部类
    static Read5 scan=new Read5();
   // static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int []pre;
    static int []x;
    static int []y;
    static int []r;
    public static void main(String[] args) throws IOException{
        //   Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        x=new int[n+1];
        y=new int[n+1];
        r=new int[n+1];
        for(int i=1;i<=n;i++){
            x[i]=scan.nextInt();
            y[i]=scan.nextInt();
            r[i]=scan.nextInt();
        }
        PriorityQueue<Node> queue=new PriorityQueue<>();//按照距离进行排序
        long total_c=0;
        double total_sum=0;
        pre=new int[n+1];
        for (int i = 1; i <=n; i++) {
            pre[i]=i;//最初都是指向自己
        }
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int dx=x[i]-x[j];
                int dy=y[i]-y[j];
                int r1=r[i];
                int r2=r[j];
                double distance=Math.sqrt(dx*dx+dy*dy);//表示两点之间的距离
                double sum=r1+r2;//表示两点的半径
                if(distance<=sum){
                    //直接合并
                    int x=find(i);
                    int y=find(j);
                    if(x!=y){
                        pre[x]=y;
                        total_c++;
                    }
                }else{
                    queue.offer(new Node(i,j,distance-sum));
                }

            }
        }
        while(!queue.isEmpty() && total_c< n-1){
            //弹出元素
            Node node=queue.poll();
            int x=find(node.from);
            int y=find(node.to);
            double d=node.distance;
            if(x!=y){
                pre[x]=y;
                total_c++;//记录环与环之间的边数
                total_sum+=d;
            }

        }
        System.out.printf("%.2f",total_sum);

    }
    //find 函数进行查找
    public static int find(int n){
        while(pre[n]!=n){
            pre[n]=pre[pre[n]];
            n=pre[n];
        }
        return n;
    }
}
class Node implements Comparable<Node>{
    int from;
    int to;
    double distance;

    public Node(int from, int to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
    //根据距离进行从小到达的排序
    @Override
    public int compareTo(Node o) {
        return Double.compare(this.distance,o.distance);//如果前者小于后者会返回负数，相等则返回 0，大于则是正数
    }
}
class Read5{
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

*/
