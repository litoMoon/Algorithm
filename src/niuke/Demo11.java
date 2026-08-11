package niuke;

import java.util.*;

public class Demo11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.split(" ");
        StringBuilder sbu = new StringBuilder();
        for(int i = s.length-1; i >= 0; i--){
            sbu.append(s[i]);
            if(i != 0){
                sbu.append(" ");
            }
        }
        System.out.println(sbu.toString());
    }
}
