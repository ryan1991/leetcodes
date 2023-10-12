package algorithm;

/**
 *
 * 查找峰值
 * @author songjunbao
 * @date 2023-10-12
 */
public class FindPeekElement {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,1,3,5,6,4};

        System.out.println("nums1 peek index:" + findPeakElement(nums1));
        System.out.println("nums2 peek index:" + findPeakElement(nums2));
    }


    /**
     * 返回任意峰值索引
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length -1;
        while (l < r){
            int mid = l + (r -l) / 2;
            if (nums[mid] > nums[mid + 1]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

}
