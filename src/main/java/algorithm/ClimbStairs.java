package algorithm;

/**
 * 爬楼梯
 */
public class ClimbStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs(3));

    }


    public static int climbStairs(int n) {
        if(n==1)return 1;
        int sum[]=new int[n+1];
        sum[0]=0;sum[1]=1;sum[2]=2;
        for(int i=3;i<=n;i++){
            sum[i]=sum[i-2]+sum[i-1];
        }
        return sum[n];
    }


}
