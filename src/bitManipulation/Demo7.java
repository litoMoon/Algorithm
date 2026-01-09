package bitManipulation;

public class Demo7 {
    public static void main(String[] args) {
        getSum(3,4);
        System.out.println(getSum(3,4));
    }
    public static int getSum1(int a, int b) {
        int cur=a^b; //先异或
        int sum=(a&b)<<1; //查找出需要进位的点
        while(sum!=0){
            int curN=cur;
            cur^=sum; //与查找出的点进行异或处理
            sum=(sum&curN)<<1; //继续查找是由有需要进位的点
        }
        return cur;
    }
    public static int getSum(int a, int b) {
       while(b!=0){
        int x=a^b;//先计算无进位
        int y=(a&b)<<1;//查找是否需要进位的一些点
           a=x;
           b=y;
        }
       return a;
    }
}
