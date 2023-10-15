import java.util.HashSet;
import java.util.Set;

/**
 *
 * 202. 快乐数
 * @author songjunbao
 * @date 2023-10-14
 */
public class HappyNum {
    public static void main(String[] args) {

        iterNum(190);

        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n){
        int totalSum = 0;
        while (n > 0){
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


    private static void iterNum(int n){
        while(n > 0){
            //获取最后一位值
            int d = n %10;
            System.out.println(d);
            n = n / 10;
        }

    }

}
