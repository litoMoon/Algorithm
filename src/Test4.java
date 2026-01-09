import java.util.*;


public class Test4 {
    public static void main(String[] args) {
        Deque<Integer> d=new LinkedList<>();
        d.push(1);
        d.push(2);
        d.push(3);
        d.push(4);
        d.push(5);
        d.push(6);
        d.push(7);
        d.push(8);
        System.out.println(d.pop());//如果按照栈来算的话输出的应该是8
        System.out.println(d.poll());//如果按照队列来算的话输出应该是1

    }
    //双端队列出队列的顺序是按照最初进队列的方式来规定这个双端队列是按照栈的方法走还是按照队列的方式走
}
