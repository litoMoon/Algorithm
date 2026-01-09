package String;

public class Demo3 {
    public static void main(String[] args) {
        String a="10010";
        String b="0001";
        System.out.println(addBinary(a, b));


    }

    //将任何字符转化为字符串的最快的方法就是直接+"",这样可以将变量转换为字符串，且不会产生空格
    public static String addBinary1(String a, String b) {
       // int minlen=Math.max(a.length(),b.length());
        int t=0,sum=0;
        StringBuilder sbu=new StringBuilder();// 使用 sbu 来进行拼接
        int j = b.length()-1,i = a.length()-1;
        for (; j >=0 && i>=0 ; j--,i--) {//i代表的是a，j代表的是b
            sum=Integer.parseInt(a.charAt(i)+"")+Integer.parseInt(b.charAt(j)+"")+t;//将字符串中的字符转换为数字相加
            sbu.append(sum%2);
            t=sum/2;//计算是否会有进位
        }
        if(j==-1){
            for(;i>=0;i--){
                sum=Integer.parseInt(a.charAt(i)+"")+t;//将字符串中的字符转换为数字相加
                sbu.append(sum%2);
                t=sum/2;//计算是否会有进位
            }
        }else{
            for(;j>=0;j--){
                sum=Integer.parseInt(b.charAt(j)+"")+t;//将字符串中的字符转换为数字相加
                sbu.append(sum%2);
                t=sum/2;//计算是否会有进位
            }
        }
        if(t!=0) sbu.append(t);
        sbu.reverse();//将字符串进行翻转
       return sbu.toString();//将最终结果进行返回
    }

    //方法二--在方法一的方法上进行了一下优化
    public  static String addBinary(String a, String b) {
        int cur1=a.length()-1;//字符串a的长度
        int cur2=b.length()-1;
        int t=0;//t用来记录每次需要变化的结果
        StringBuilder ret=new StringBuilder();//用来记录最终需要返回的结果
        while(cur1>=0 || cur2>=0 || t!=0){//这里 t 不等于0，防止漏掉最后的1
            if(cur1>=0) t+=a.charAt(cur1--)-'0';//将数字字符转化为数字
            if(cur2>=0) t+=b.charAt(cur2--)-'0';
            ret.append((char)(t%2+'0'));
            t/=2;

        }
        //反转ret
        ret.reverse();
        //将ret转化为字符串并返回
       return  ret.toString();

    }
}
