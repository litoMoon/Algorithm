package Math;

//全部错排乱
public class Demo3 {
    static long[][]c;
    public static void main(String[] args) {
        long ret1=D(14);//求出全部错乱排列
        c=new long[30][30];
        long ret2=C(c);
        System.out.println(ret1*ret2*1L);


    }
    public static long C(long[][]c) {
        for(int i=0;i<c[0].length;i++) {
            for(int j=0;j<=i;j++) {
                if(j==0) c[i][j]=1;
                else c[i][j]=(c[i-1][j-1]+c[i-1][j]);
            }
        }
        return c[28][14];
    }
    public static long D(long n) {
        long ret=0;
        if(n==1) return 0;
        if(n==2) return 1;
        return (n-1)*(D(n-1)+D(n-2));
    }


}
