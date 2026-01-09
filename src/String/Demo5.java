package String;

public class Demo5 {
    public static void main(String[] args) {
        String s1="123";
        String s2="456";
        multiply(s1, s2);
        System.out.println(multiply(s1, s2));

    }
    //方法二
    public static String multiply(String num1, String num2) {
        StringBuilder ret=new StringBuilder();
        int len=num1.length()+num2.length()-1;
        int []cur=new int[len];//创建数组来存储最终的值

        //第一步 准备需要使用的东西
        for (int i = 0,k=num1.length()-1; i < num1.length() && k>=0; i++,k--) {
            for (int j = 0,p=num2.length()-1; j < num2.length() && p>=0; j++,p--) {
                cur[i+j]+=(num1.charAt(k)-'0')*(num2.charAt(p)-'0');
            }
        }

        //进行处理进位问题
        int t=0,curN=0;
        while(curN<len || t!=0){
            if(curN<len) t+=cur[curN++];
            ret.append(t%10);
            t/=10;
        }

        //处理前导 0 的问题
        while(ret.length()>1 && ret.charAt(ret.length()-1)=='0'){ //ret.length()>1，是为了防止全是0，然后全删掉了
            ret.deleteCharAt(ret.length()-1);
        }

        //处理完所有问题开始返回
        return ret.reverse().toString();

    }

    //方法一
    public String multiply1(String num1, String num2) {
        StringBuilder ret=new StringBuilder();
        int len=num1.length()+num2.length()-1;
        int []cur=new int[len];//创建数组来存储最终的值
        for (int i = 0,k=num1.length()-1; i < num1.length() && k>=0; i++,k--) {
            for (int j = 0,p=num2.length()-1; j < num2.length() && p>=0; j++,p--) {
                cur[i+j]+=(num1.charAt(k)-'0')*(num2.charAt(p)-'0');
            }
        }
        int t=0;
        for (int i = 0; i < len; i++) {
            cur[i]+=t;
            t=cur[i]/10;
            ret.append(cur[i]%10) ;
        }
        if(t!=0) ret.append(t);
        String s=ret.reverse().toString();//转化为字符串了
        int curLen=0;
        while(curLen<s.length() && s.charAt(curLen)=='0'){
            curLen++;
        }
        if(curLen==s.length()) return "0";
        return s.substring(curLen,s.length());
    }
}
