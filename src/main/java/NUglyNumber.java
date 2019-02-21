/**
 * 1开始，从小到大，第n个丑数
 *
 **/
public class NUglyNumber {

    public static void main(String[] args) {
        int n = 2000;
        System.out.println(violentSolve(n));
        System.out.println(efficientSolve(n));
    }


    /**
     * 暴力解法
     */
    public static int violentSolve(int n){
        long start = System.currentTimeMillis();
        int count = 0;
        int num = 0;
        while (count < n){
            num ++;
            if(UglyNumber.isUgly(num)){
                count++;
            }

        }
        System.out.println(" time:"+ (System.currentTimeMillis() - start));
        return num;
    }


    public static int efficientSolve(int n){
        long start = System.currentTimeMillis();

        int[] arr = new int[n];
        arr[0] = 1;
        int temp2 = 0;
        int temp3 = 0;
        int temp5 = 0;


        int next = 1;
        while (next < n){
            int min =Math.min( Math.min(arr[temp2] * 2, arr[temp3] * 3), arr[temp5] * 5);
            arr[next] = min;
            while (arr[temp2] * 2 <= min){
                temp2 ++;
            }
            while (arr[temp3] * 3 <= min){
                temp3 ++;
            }
            while (arr[temp5] * 5 <= min){
                temp5 ++;
            }

            next ++;
        }

        System.out.println("better time:"+ (System.currentTimeMillis() - start));

        return arr[n - 1];


    }

}
