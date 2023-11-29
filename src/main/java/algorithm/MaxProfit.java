package algorithm;

/**
 * 121. 买卖股票的最佳时机
 * 122. 买卖股票的最佳时机 II
 * @author songjunbao
 * @date 2023-11-26
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }


    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }


    /**
     * 所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0)
                profit += tmp;
        }
        return profit;
    }

}
