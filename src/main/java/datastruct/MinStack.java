package datastruct;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author songjunbao
 * @date 2024-03-01
 */
public class MinStack {

    private Deque<Integer> xStack;
    private Deque<Integer> minStack;


    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}
