class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                continue;
            }
            result = (prices[i] - min) > result ?  (prices[i] - min) : result;
        }
        return result;
    }
}
