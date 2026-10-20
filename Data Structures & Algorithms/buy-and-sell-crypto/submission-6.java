class Solution {
    public int maxProfit(int[] prices) 
    {
        int maxprofit =0; 
        int buy =0; 
        for (int sell =1 ; sell<prices.length; sell++)
        {
            if(prices[sell]>prices[buy])
            {
                //case 1; sell is greater (profitable trade) 
                int currentprofit = prices[sell]-prices[buy]; 
                maxprofit = Math.max(currentprofit, maxprofit); 
            }
            else
            {
                //case 2; buy is greater than or equal to sell price 
                //set buy to new sell 
                buy = sell; 
            }

        }
        return maxprofit; 
        
    }
}
