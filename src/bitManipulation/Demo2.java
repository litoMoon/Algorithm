package bitManipulation;

public class Demo2 {
    public static int[] countBits1(int n) {
        int[] ret=new int[n+1];
        for (int i = 0; i <= n; i++) {
            int count=0,cur=i;
            while(cur!=0){
                cur &=cur-1;
                count++;
            }
            ret[i]=count;
        }
        return ret;
    }

    public static void main(String[] args) {
        for (int x :countBits(5)) {
            System.out.print(x+" ");
        }
    }
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        if (n == 0) {
            return res;
        }
        getCountBits(res, 1, 1);
        return res;
    }
    public static void getCountBits(int[] res, int x, int count) {
        int n = res.length-1;
        if (x<=n){
            res[x]=count;
            getCountBits(res, x*2, count);
            getCountBits(res, x*2+1, count+1);
        }
    }
}
