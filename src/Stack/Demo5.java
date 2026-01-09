package Stack;

import java.util.Stack;//util是包，Stack是类，这里又进行了导包又进行了导类

//验证栈序列
public class Demo5 {
    public static void main(String[] args) {
        int []push=new int[]{1,2,3,4,5};
        int []pop=new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(push, pop));

    }
    //方法一：自己创建了栈
    public static boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int i=0;
        for (int x:pushed) {
            stack.push(x);
            while(i<popped.length && !stack.isEmpty() && stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();

    }
    //方法二：使用数组来代替栈进行实现
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
     int[] stack=new int[popped.length];
     int i=-1;
     int j=0;
        for (int x:pushed) {
            stack[++i]=x;
            while(i>=0 && stack[i]==popped[j]){
                i--;
                j++;
            }
        }
     return i<0;
    }

}
