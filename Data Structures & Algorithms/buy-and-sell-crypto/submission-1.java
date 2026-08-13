class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int max=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[l]>prices[i]){
                l=i;
            }
            else {
                max=Math.max(prices[i]-prices[l],max);
            }
        }
        return max;
    }
}
