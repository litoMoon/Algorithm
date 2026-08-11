package niuke;

import java.util.Scanner;

public class Demo15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        while (total-- > 0){
            int game = in.nextInt();
            int start = in.nextInt();
            in.nextLine();
            String detail = in.nextLine();
            long sum = 0;
            int count = 0;
            for (int i = 0; i < game; ){
                while (i < game && detail.charAt(i) == 'W'){
                    count++; i++;
                    if (count >= 3) sum += start;
                    else sum += 1;
                }
                while (i < game && detail.charAt(i) == 'L'){
                    count = 0;
                    sum -= 1;
                    i++;
                }

            }
            System.out.println(sum);
        }
    }
}
