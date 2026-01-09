package Luogu;

import java.math.BigInteger;
import java.util.Scanner;

public class Demo6 {
    public static void main1(String[] args){
        long m=0,n=0,num=0,ret=0,sum=0;
        int i=0;
        Scanner scan=new Scanner(System.in);
        m=scan.nextLong();//周一到周五的题量
        n=scan.nextLong();//周六周天的题量
        num=scan.nextLong();//总的题量
        long []arr=new long[]{m,m,m,m,m,n,n};
        while(sum<num){
            sum+=arr[i%7];
            i++;
            ret++;
        }
        System.out.println(ret);
    }
    public static void main2(String[] args){
        long m=0,n=0,num=0,sum=0,i=0;
        Scanner scan=new Scanner(System.in);
        m=scan.nextLong();//周一到周五的题量
        n=scan.nextLong();//周六周天的题量
        num=scan.nextLong();//总的题量
//long []arr=new long[]{m,m,m,m,m,n,n};
//while(sum<num){
//sum+=arr[i%7];
//i++;
//ret++;
//}
        for( ; ;i++){
            if((i%7)<5) sum+=m;
            else sum+=n;
            if(sum>=num){

                System.out.println(i+1);
                break;
            }
        }
    }
    public static void main(String[] args){
        long m=0,n=0,num=0,sum=0;
        long i=0;
        Scanner scan=new Scanner(System.in);
        m=scan.nextLong();//周一到周五的题量
        n=scan.nextLong();//周六周天的题量
        num=scan.nextLong();//总的题量
        long weeks=num/(5*m+2*n);
        num-=weeks*(5*m+2*n);
        for(; ;i++){
            if((i%7)<5) sum+=m;
            else sum+=n;
            if(sum>=num){
                System.out.println(weeks*7+(i+1));
                break;
            }
        }
    }

}
