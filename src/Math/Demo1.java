package Math;

import java.util.Scanner;

//一个省赛的感染概率题
public class Demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N=scan.nextLong();
        double p=scan.nextDouble();
        double E=Double.MAX_VALUE;
        long ret=Long.MAX_VALUE;
        for(long k=N;k>=1;k--){
            if(N%k==0){//要进行平均分组
                double P=Math.pow(1-p,k);//求出未被感染的概率
                double e=(P+(1-P)*(1+k))*N/k;
                if(k==1) e=N;//当每组只有一个人的时候，此时总的检测试剂就是N支
                if(e<=E){
                    E=e;
                    ret=k;
                }
            }
        }
        System.out.println(ret);
        scan.close();
    }
}
