package algorithm;

/**
 * 汉明距离
 */
public class HammingDistance {
    public static void main(String[] args) {

        System.out.println( hammingDistance(1, 4));



    }

    public static int hammingDistance(int x, int y){
        int temp = x^y;
        return Integer.bitCount(temp);
    }


}
