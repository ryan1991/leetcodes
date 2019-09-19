package algorithm;

/**
 * 升序降序数组查找最大值
 *
 * 二分搜索变异
 */
public class FindCrestValue {


    public static void main(String[] args) {

        int[] attr = { 1, 2, 3, 5, 9, 6, 4 };
        System.out.println(find(attr));





    }


    /**
     * 返回峰顶索引
     */
    public static int find(int[] attr) {
        int lo = 0;
        int hi = attr.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mid == lo || mid == hi - 1) {
                return mid;
            }
            if (attr[mid] >= attr[mid - 1] && attr[mid] >= attr[mid + 1]) {
                return mid;
            } else if (attr[mid] < attr[mid - 1]) {
                hi = mid - 1;
            } else if (attr[mid] > attr[mid - 1]) {
                lo = mid + 1;
            }
        }
        return -1;
    }

}
