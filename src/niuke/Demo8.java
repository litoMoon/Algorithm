package niuke;

import java.util.Scanner;

public class Demo8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        StringBuilder sbu = new StringBuilder();
        int count = 0;
        while(num != 0){
            sbu.append(num % 10);
            count++;
            if(count == 3){
                sbu.append(",");
                count = 0;
            }
            num /= 10;
        }
        if(sbu.charAt(sbu.length()-1) == ','){
            sbu.delete(sbu.length()-1,sbu.length());
        }
        System.out.println(sbu.reverse().toString());

    }
}
