package simulate;

//Z 字形变幻
public class Demo3 {
    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        System.out.println(convert(s,4));
    }
    // 2ms 的解法
    public static String convert1(String s, int numRows) {
        if(numRows==1) return s;
        int d=2*numRows-2;//计算出公差
        StringBuilder sbu=new StringBuilder();
        int len=0;
        int len_s=s.length()-1;
        while(len<len_s){
            sbu.append(s.charAt(len));//拼接上
            len+=d;
        }
        for (int i = 1;  i<numRows-1 ; i++) {
            int cur=i;
            int curN=d-i;
            while(cur<len_s && curN<len_s){
                sbu.append(s.charAt(cur));
                sbu.append(s.charAt(curN));
                cur+=d;
                curN+=d;
            }
            if(cur<len_s)
            sbu.append(s.charAt(cur));

        }
       len=numRows-1;
        while(len<len_s){
            sbu.append(s.charAt(len));//拼接上
            len+=d;
        }
        return sbu.toString();
    }
    // 1ms的解法
    public static String convert(String s, int numRows) {
        if(numRows==1) return s;
        int d=2*numRows-2;//计算出公差
        int len=s.length();//计算出字符串的长度
        StringBuilder sbu=new StringBuilder();

        //处理第一行的内容
        for(int i=0;i<len;i+=d){
            sbu.append(s.charAt(i));
        }

        //处理中间行的内容
        for (int k = 1; k <numRows-1 ; k++) {
            for (int i = k,j=d-i; i <len || j<len ; i+=d,j+=d) { //因为 i 和 j 都有可能会发生越界，所以说两个条件都要考虑清楚
                if(i<len) sbu.append(s.charAt(i));
                if(j<len) sbu.append(s.charAt(j));
            }
        }

        //处理最后一行的内容
        for (int i = numRows-1; i <len ; i+=d) {
            sbu.append(s.charAt(i));
        }
        return sbu.toString();

    }
}
