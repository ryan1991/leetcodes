/**
 * 丑数：
 * 包含因子  2、 3、 5 的数称作丑数， 第一个丑数是1
 **/
public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(isUgly(5));
    }



    public static boolean isUgly(int n){

        while (n % 2 == 0){
            n /= 2;
        }

        while (n % 3 == 0){
            n /= 3;
        }

        while (n % 5 == 0){
            n /= 5;
        }

        return n == 1;
    }

}
