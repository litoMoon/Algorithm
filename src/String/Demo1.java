package String;

public class Demo1{
    //解法一：两两进行比较
    public static String longestCommonPrefix1(String[] strs) {
        String ret=strs[0];// ret 先等于 strs[0]
        for (int i = 1; i < strs.length; i++) {
            ret=findCommon(ret,strs[i]);//找相同
        }
        return ret;
    }
    public static String findCommon(String ret,String s){
        int minlen=Math.min(ret.length(),s.length());
        int i = 0;
        for (; i < minlen && s.charAt(i)==ret.charAt(i); ) {
          i++;
        }
        return s.substring(0,i);//将sbu转化为字符串
    }

    //解法二：所有字符串同时开始进行比较
    public static String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char tmp = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(i==strs[j].length() || strs[j].charAt(i)!=tmp) return strs[0].substring(0,i);
            }
        }
        return strs[0];

    }

    public static void main(String[] args) {
        String[] strs=new String[]{"car","cir"};
        System.out.println(longestCommonPrefix(strs));//打印返回的字符串
    }

}
