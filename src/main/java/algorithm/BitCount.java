package algorithm;

import java.util.Arrays;


/**
 * 比特计数
 */
public class BitCount {
    public static void main(String[] args) {
        int[] result = countBits(5);
        System.out.println(Arrays.toString(result));
    }

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i=1; i<=num; i++){
            if(i%2 == 1){
                result[i] = result[i - 1] + 1;
            }else {

                result[i] = result[i/2];
            }

        }

        return result;

    }


}
