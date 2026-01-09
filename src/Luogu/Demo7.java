package Luogu;

import java.util.Scanner;

public class Demo7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] array=new int[n];
        scan.nextLine();
        while(scan.hasNext()){
            String str=scan.nextLine();
            if(str.charAt(0)=='a') {
                array[0]++;
            }else if(str.charAt(0)=='q') {
                System.out.println(FindMinNumber(array));
            }else {
                String []s=str.split(" ");
                int tmp=Integer.parseInt(s[1]);
                if(array[0]>array[tmp])array[tmp]++;
            }

        }
        scan.close();
    }
    public static int FindMinNumber(int[] array) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++) {
            if(min>array[i]) {
                min=array[i];
            }
        }
        return min;
    }

}
