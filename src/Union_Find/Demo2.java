package Union_Find;

import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Demo2 {
    static int[]p;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int ret=Integer.MAX_VALUE;
        p=new int[n+1];
        initial(n);
        while(m-->0){
            int x=scan.nextInt();
            int y=scan.nextInt();
            union(x,y);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            int root=find(i);//find()方法不就是可以查找当前节点的根节点是社么
            map.put(root,map.getOrDefault(root,0)+1);//设置值的大小
        }
        int ans=n;
        for(int x:map.values()){
            ans=Math.min(x,ans);
        }
        System.out.println(ans);
    }
    public static void initial(int m){
        for (int i = 0; i <=m; i++) {
            p[i]=i;
        }
    }
    public static void union(int x,int y){
        int rootx=find(x);
        int rooty=find(y);
        if(rootx!=rooty){
            p[rootx]=rooty;
        }
    }
    public static int find(int x){
        if(p[x]==x) return x;
        else return p[x]=find(p[x]);
    }
}