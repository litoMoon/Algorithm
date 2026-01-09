package BigInteger;

import java.math.*;
import java.util.*;
public class Demo2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        //BigInteger bi=new BigInteger();//括号中必须要赋予初始值，且初始值是字符串类型的数据
        BigInteger b=new BigInteger("1");//初始化值
        for(int i=2;i<=n;i++){
            b = b.multiply(new BigInteger(String.valueOf(i)));//初始化时需要传入的参数是字符串类型
//String.valueOf()方法是将其他类型的数据转换为字符串类型的数据
        }
        System.out.println(b);
    }
}
