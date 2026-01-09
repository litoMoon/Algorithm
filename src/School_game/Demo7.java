package School_game;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Demo7 {
    public static void main1(String[] args) {
        String s1,s2;
        s1="hello java";
//        s2=new String("hello java");
//        if(s1.equals(s2)) System.out.println("case 1");
//        if(s1==s2){
//            System.out.println("case2");
//            System.out.println(s1.compareTo(s2));
//        }
        String.format(s1, 12);
        System.out.println(String.format(s1, 12));

        //boolean 类型无法进行类型转换
        boolean b=true;//Inconvertible types ---> 不可兑换类型
      //  int m=(int)b;
    }

    public static void main2(String[] args) {
        A a;
        int t=10;
        a=new A();//此时a=5
        a.setM(t);//此时a=10
        System.out.println("a.m="+a.getM());
        System.out.println("t="+t);
        test(a);
        System.out.println("a.m="+a.getM());
    }

    public static void main3(String[] args) throws IOException {
//        File file=new File("c:\\data\\data.txt");
//        BufferedReader br;
//        String data;
//        br=new BufferedReader(file);
//        data=br.readLine();
//        System.out.println("文件内容：");
//        while(data!=-1){ //条件有错？？？但是也可以是抛出异常啊？为什么要说必须使用try-catch
//            System.out.println(data);
//            data=br.readLine();
//        }
    }
    static void test(A ba){
        ba.setM(20);
    }
}
class A{
    int m;
    public A (){
        m=5;
    }
    public void setM(int n){
        m=n;
        n++;
    }
    public int getM(){
        return m;
    }
}
