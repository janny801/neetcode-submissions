class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0; 
        int buy =0; 
        for(int sell =0; sell<prices.length; sell++)
        {
            if(prices[sell]> prices[buy])
            {
                //case 1; profitable 
                int currprofit = prices[sell] - prices[buy]; 
                maxprofit = Math.max(maxprofit, currprofit); 
            }
            else
            {
                //case 2; not profitable 
                buy = sell; 
            }
        }
        return maxprofit; 
        
    }
}
