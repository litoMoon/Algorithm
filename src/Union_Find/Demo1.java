package Union_Find;

import java.util.Scanner;

public class Demo1 {
    //并查集代码的书写---按照高度进行合并
    static int[] h;//h 表示树的高度
    static int[] p;//p 表示节点
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        p=new int[n+1];//下标表示孩子  数组值表示当前孩纸指向的另一个孩子
        h=new int[n+1];
        //对数组 p 进行初始化
        initial(n);
        while(m-->0){
            int op=scan.nextInt();
            int x=scan.nextInt();
            int y=scan.nextInt();
            if(op==1){
                union(x,y);
            }else if(op==2){
                x=find(x);
                y=find(y);
                if(x==y) System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }
    //初始化代码
    public static void initial(int n){
        for(int i=0;i<n;i++){
            p[i]=i;//并查集初始化时，最初各个点都指向自己
            h[i]=1;//初始可以看作每个节点都是根节点，并且每个节点看作树且高度为1
        }
    }
    //对其进行合并的操作
    public static void union(int x,int y){
        int rootx=find(x);
        int rooty=find(y);
        if(rootx!=rooty){
            if(h[rootx]>h[rooty]){
                p[rooty]=rootx;
            }else if(h[rootx]<h[rooty]){
                p[rootx]=rooty;
            }else{
                p[rootx]=rooty;
                h[rooty]++;//++就行，当左右两边相等时，这个时候合并数目会+1
            }
        }
    }
    //查找操作用递归的方式进行书写
    public static int find(int m){
        if(p[m]==m) return m;
        else return p[m]=find(p[m]);
    }
}
