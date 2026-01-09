package Recursion;

public class Demo8 {
   static boolean[] ret;
   static int sum;
    public static int countArrangement(int n) {
        ret=new boolean[n+1];
        dfs(n,1);
        return sum;
    }
    public static void dfs(int n,int k){
        if(k==n+1) {
            sum++;
            return ;
        }
        for(int i=1;i<=n;i++){
            if(!ret[i] && (i%k==0 || k%i==0)){
                ret[i]=true;
                dfs(n,k+1);
                ret[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        countArrangement(1);
        System.out.println(countArrangement(1));
    }
}
