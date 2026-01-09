package School_game;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextInt()){
            int h=scan.nextInt();
            int l=scan.nextInt();
            int x=0,y=0;
            y=(4*h-l)/2;
            x=h-y;
            if(l%2==1 || x<0|| y<0)
                System.out.println("No answer");
            else  System.out.println(y+" "+x);
        }

    }
}
