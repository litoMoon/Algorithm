import java.util.*;

public class Test3 {
    public static void main1(String[] args) {
        char []ch=new char[]{'a','c','d','f','g','e','r'};
        String ret=String.valueOf(ch,0,0);
        System.out.println(ret);

    }

    public static void main2(String[] args) {
        StringBuffer ret=new StringBuffer();
        ret.append(' ');
        ret.append(3);
        System.out.println(Integer.parseInt(ret.toString()));//这里由于ret存储的为 “ 3”，直接转化为数字不行
    }

    public static void main3(String[] args) {
        //结：双端队列既可以拿来实现栈也可以拿来实现队列，系统原生的双端队列就行。

        Deque<Integer> stack=new ArrayDeque<>();
        List<Integer> list=new ArrayList<>();
        Deque<Integer> onelist=new LinkedList<>();

    }

    public static void main4(String[] args) {
        final int a=10;
        //a=20; error:在这之前 a 被 final 修饰了，以至于 a 后来不能被修改为值为 20
    }

    public static void main5(String[] args) {
        int a=4;
        boolean b=(a<2) &&( ++a<5);
        System.out.println(a+" "+b);
    }

    public static void main6(String[] args) {
        short a=10,b=20,c;//short在运算符中会被隐式的转化为 int 类型
        int d;
        float f;
        f=(float)(a*3.14);//在规定中默认小数点是double类型，f是float类型，double变为float需要进行强制类型的转化
        c=(short)(a+b);//short类型在进行运算时会先将类型转换为 int 类型嘛？
        c='A'+32;
     //   c='A'+a;//int类型直接赋值给 short 类型回报错
        float f1=3.14f;
        float f2=3.24f;
        f=f1+f2;
        System.out.println(f);
    }

    public static void main(String[] args) {

    }

}
