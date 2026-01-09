package HashMap;

public class Demo2 {
    //注意题目已知所有元素均为小写字母
    public static boolean CheckPermutation(String ss1, String ss2) {
        int[] hash=new int[26];
        int len1=ss1.length();
        int len2=ss2.length();
        if(len1!=len2) return false;
        for (int i = 0; i < len1; i++) {
            hash[ss1.charAt(i)-'a']++;
            hash[ss2.charAt(i)-'a']--;
        }
        for (int i = 0; i < hash.length; i++) {
            if(hash[i]!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1="cuhv";
        String str2="vscu";
        System.out.println(CheckPermutation(str1, str2));
    }
}
