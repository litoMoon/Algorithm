package Stack;

import java.util.*;


public class Demo3 {
    public static void main(String[] args) {
        calculate(" 3+5 / 2");
        System.out.println(calculate(" 3+5 / 2"));
    }

    public static int calculate2(String s) {
        //创建一个栈用于存储数据
        Stack<Integer> stack = new Stack<>();
        //创建变量用于存储运算符
        char ch = '+';
        int i = 0, len = s.length(), cur = 0;
        while (i < len) {
            StringBuffer ret = new StringBuffer();//使用ret来对数字进行存储
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            while (i < len && (s.charAt(i) - '0') >= 0 && (s.charAt(i) - '0') <= 9) {
                ret.append(s.charAt(i));//将所有的数字字符拼接在一起
                i++;
            }
            if (ret.length() > 0) {
                cur = Integer.parseInt(ret.toString());
                if (ch == '+') stack.push(cur);//将字符串转化为数组存入进栈中
                else if (ch == '-') stack.push(cur * (-1));//如前面的字符为负数，存入相反值进入栈中
                else if (ch == '*') {
                    int num = stack.pop();//弹出栈顶的元素
                    stack.push(num * cur);
                } else {
                    int num = stack.pop();//弹出栈顶的元素
                    stack.push(num / cur);//如果是除法是使用整除
                }
            }
            if (i < len && (s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+' || s.charAt(i) == '-')) {
                ch = s.charAt(i);//将运算符存储起来
            }
            i++;
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();//使用双端队列进行创建
        char op = '+';//记录初始的运算符
        int i = 0, len = s.length();//i用于记录循环的执行，tmp用于数字的累加,len用于记录数组的长度
        char[] chs = s.toCharArray();//将字符串转化为字符数组
        while (i < len) {
            int tmp=0;
            if (chs[i] == ' ') i++;
            else if (chs[i] >= '0' && chs[i] <= '9') {
                while (i < len && chs[i] >= '0' && chs[i] <= '9') {
                    tmp = tmp * 10 + (chs[i] - '0');//这里先算后面是为了防止数组会越界
                    i++;
                }
                if (op == '+') stack.push(tmp);
                else if (op == '-') stack.push(-1 * tmp);
                else if (op == '*') stack.push(stack.pop() * tmp);
                else stack.push(stack.pop() / tmp);
            } else {
                op = chs[i];
                i++;
            }
        }
        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
            return ret;
    }
}
//创建一个栈用于存储数据
//        Stack<Integer> stack=new Stack<>();
//创建变量用于存储运算符
//        char ch='+';
//        int i=0,len=s.length(),cur=0;
//        while(i<len){
//            StringBuffer ret=new StringBuffer();//使用ret来对数字进行存储
//            if(s.charAt(i)==' '){
//                i++;
//                continue;
//            }
//            while(i<len && (s.charAt(i)-'0')>=0 && (s.charAt(i)-'0')<=9){
//                ret.append(s.charAt(i));//将所有的数字字符拼接在一起
//                i++;
//            }
//            if(ret.length()>0) {
//                cur=Integer.parseInt(ret.toString());
//                if(ch=='+') stack.push(cur);//将字符串转化为数组存入进栈中
//                else if(ch=='-') stack.push(cur*(-1));//如前面的字符为负数，存入相反值进入栈中
//                else if(ch=='*'){
//                    int num=stack.pop();//弹出栈顶的元素
//                    stack.push(num*cur);
//                }else{
//                    int num=stack.pop();//弹出栈顶的元素
//                    stack.push(num/cur);//如果是除法是使用整除
//                }
//            }
//            if(i<len &&(s.charAt(i)=='*' ||s.charAt(i)=='/' || s.charAt(i)=='+' || s.charAt(i)=='-')){
//                ch=s.charAt(i);//将运算符存储起来
//            }
//            i++;
//        }
//        int sum=0;
//        while(!stack.isEmpty()){
//            sum+=stack.pop();
//        }
//        return sum;
//    }
//}
