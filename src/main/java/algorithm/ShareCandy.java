package algorithm;

/**
 * 135. 分发糖果
 *
 * @author songjunbao
 * @date 2023-12-06
 */
public class ShareCandy {

    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }


    public static int candy(int[] ratings) {
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i -1]){
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret+= pre;
                inc = pre;
            }else {
                dec ++;
                if (dec == inc){
                    dec ++;
                }
                ret+= dec;
                pre = 1;
            }


        }
        return ret;
    }
}
