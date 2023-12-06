package algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 * 单调栈解法
 *
 * @author songjunbao
 * @date 2023-12-06
 */
public class TrapRain {

    public static void main(String[] args) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }



    public static int trap(int[] height) {
        int ans = 0;
        //栈顶小
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                Integer top = stack.pop();
                if (stack.isEmpty())
                    break;
                Integer left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left], height[i]) - height[top];
                ans += curWidth * curHeight;
            }

            stack.push(i);
        }
        return ans;
    }
}
