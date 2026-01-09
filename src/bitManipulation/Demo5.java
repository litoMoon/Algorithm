package bitManipulation;

//等会自己实现 hash 版本的判定字符是否唯一
public class Demo5 {
    public static  boolean isUnique(String astr) {
        //利用鸽巢原理可以断定出
        if(astr.length()>26) return false;
        int bitLow=0;
        for(int i=0;i<astr.length();i++){
            int x=astr.charAt(i)-'a'; //用 x 表示需要移动的位数
            if(((bitLow>>x)&1)==1) return false;
            else bitLow|=1<<x; //左移右边填补的都是 0
        }
        return true;
    }

    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(isUnique(s));
    }
}
