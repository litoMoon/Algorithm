package Sort;
import java.util.*;
public class Demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] x=new int[n];
        int[] y=new int[n];
        int[] z=new int[n];

        //依次输入值
        for(int i=0;i<n;i++){
            x[i]=scan.nextInt();
        }
        for(int i=0;i<n;i++){
            y[i]=scan.nextInt();
        }
        for(int i=0;i<n;i++){
            z[i]=scan.nextInt();
        }

        //依次算出差值
        for(int i=0;i<n;i++){
            int a=x[i];
            int b=y[i];
            int c=z[i];
            x[i]=a-b-c;
            y[i]=b-a-c;
            z[i]=c-a-b;
        }
        //分别进行排序
        Arrays.sort(x);
        Arrays.sort(y);
        Arrays.sort(z);

        //记录最终的结果那些东西
        long d=-1,sumx=0,sumy=0,sumz=0;
        for(int i=n-1;i>=0;i--){
            sumx+=x[i];
            sumy+=y[i];
            sumz+=z[i];
            if(sumx>0 || sumy>0 || sumz>0){
                d=n-i;
            }
        }

        System.out.println(d);

        scan.close();
    }
}
