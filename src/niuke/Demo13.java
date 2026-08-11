package niuke;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Demo13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        StringBuilder sbu = new StringBuilder();
        Set<Character> set = new HashSet<>();
        char[] ch = s1.toCharArray();//将字符串转化为数组
        for(int i = 0; i < s2.length(); i++){
            set.add(s2.charAt(i));
        }
        for (int i = 0; i < ch.length; i++){
            if(set.contains(ch[i])) continue;
            sbu.append(ch[i]);
        }
        System.out.println(sbu);
    }
}
