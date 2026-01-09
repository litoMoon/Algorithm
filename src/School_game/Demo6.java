package School_game;

import java.util.Scanner;

public class Demo6 {
    public static void main(String []args){
        Scanner scan=new Scanner(System.in);
        int m=scan.nextInt();
        int n=scan.nextInt();
        int []f=new int[m];
        int []g=new int[n];
        for(int i=0;i<m;i++){
            f[i]=scan.nextInt();
        }
        for(int i=0;i<n;i++){
            g[i]=scan.nextInt();
        }
        int ret=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ret=Math.min(ret,Math.abs(f[i]-g[j]));
            }
        }
        System.out.println(ret);
    }
}
