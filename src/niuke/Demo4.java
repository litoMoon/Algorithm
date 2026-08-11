package niuke;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        while(n-->0){
            //1,1,1 ; 2 3 2 ; 1 5 2
            long numA=in.nextLong();//y
            long numB=in.nextLong();//o
            long numC=in.nextLong();//u
            long sum=0;
            long cur=Math.min(numA,numB);
            cur=Math.min(cur,numC);
            numA-=cur; numB-=cur; numC-=cur;
            if(numB>=2){
                sum+=numB-1;
            }
            sum+=cur*2;
            System.out.println(sum);
        }
    }
}
