package Luogu;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        int b=scan.nextInt();
//查找出a,b之间所有的符合条件的数，包含a,b
        for(int i=a;i<=b;i++){
            if(Math.sqrt(i)==(int)Math.sqrt(i)){
                int r=10;
                while(true){
                    int x=i/r;
                    int y=i%r;
                    if(x!=0 && y!=0 && isConcatenatedSquares(x,y)){
                        System.out.println(i);
                        break;
                    }
                    r*=10;
                    if(r>=i) break;
                }
            }

        }

    }
    public static boolean isConcatenatedSquares(int a,int b){
       return Math.sqrt(a)==(int)Math.sqrt(a) && Math.sqrt(b)==(int)Math.sqrt(b);
    }

}
