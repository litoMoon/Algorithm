package LeetCode;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> MinStack;

    public MinStack() {
        stack=new Stack<>();
        MinStack=new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(MinStack.empty()){
            MinStack.push(val);
        }else{
            Integer peekval=MinStack.peek();
            if(peekval>=val){
                MinStack.push(val);
            }
        }
    }

    public void pop() {
        if(stack.empty()){
            return ;
        }
        int popval= stack.pop();
        if(popval==MinStack.peek()){
            MinStack.pop();
        }

    }

    public int top() {
        if(stack.empty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(MinStack.empty()) {
            return -1;
        }
        return MinStack.peek();
    }
}
