package Math;

import java.util.Scanner;

//蓝桥 —————— 数字诗意
public class Demo2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int m=scan.nextInt();
        long ans=0;
        for(int i=0;i<m;i++) {
            long tmp=scan.nextLong();
            if((tmp&(tmp-1))==0) ans++;
        }
        System.out.println(ans);
    }

}
