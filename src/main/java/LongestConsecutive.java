import java.util.HashSet;

/**
 * 最长连续数
 * @author songjunbao
 * @date 2023-10-12
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};



        System.out.println(longestConsecutive(nums));


    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int max = 0;
        for (int num :  set){
            if (!set.contains(num + 1)){
                int curVal = num;
                //每个数连续长度
                int conseVal =0;
                while (set.contains(curVal)){
                    //向下找（向上也一样）
                    curVal--;
                    conseVal ++ ;
                }
                max = Math.max(max, conseVal);
            }
        }
        return max;
    }


}
