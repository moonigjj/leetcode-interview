/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

import java.util.LinkedList;

/**
 *155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * @author tangyue
 * @version $Id: MinStack.java, v 0.1 2019-07-22 16:21 tangyue Exp $$
 */
public class MinStack {

    private LinkedList<Integer> minStack = new LinkedList<>();

    private LinkedList<Integer> stack = new LinkedList<>();


    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

    }

    public MinStack() {

    }

    public void push(int x) {

        stack.push(x);
        if (minStack.size() == 0 || minStack.peek() >= x) {
            minStack.push(x);
        }

    }

    public void pop() {
       if (checkStack(stack)) {
           if (stack.peek().equals(minStack.peek())) {
               minStack.pop();
           }
           stack.pop();
       }
    }

    public int top() {
        if (checkStack(stack)) {
            return stack.peek();
        } else {
            return 0;
        }
    }

    public int getMin() {
        if (checkStack(minStack)){
            return minStack.peek();
        } else {
            return 0;
        }
    }

    private boolean checkStack(LinkedList stack) {
        return stack.size() != 0;
    }
}
