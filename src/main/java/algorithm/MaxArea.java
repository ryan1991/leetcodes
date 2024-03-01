package algorithm;

/**
 * 求数组能组成的最大面积
 *
 * @author songjunbao
 * @date 2024-01-15
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(height));
    }


    /**
     * 暴力解法
     * @param height
     * @return
     */
    public static int maxArea(int[] height){
        int len = height.length;
        int max = 0;

        for (int left = 0; left < len; left++) {
            for (int right = left + 1; right < len; right++) {
                int h = Math.min(height[left], height[right]);
                int area = (right - left) * h;
                max = Math.max(max, area);

            }

        }

        return max;
    }


    /**
     * 首尾双指针法
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height){
        int max = 0;
        int left = 0, right = height.length -1;

        while (left < right){
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            // 总是移动小的一条边
            // 如果移动大边，则新边可能变大也可能变小，但总体是变小的
            // 如果移动小边，则新边的高度可能变大，导致整体变大
            // 如果相同，则单移动一边整体还是变小，同时移动两边可能变大
            if (height[left] > height[right]){
                right -- ;
            }else if (height[left] < height[right]){
                left ++;
            }else {
                right--;
                left ++;
            }

        }
        return max;
    }



}
