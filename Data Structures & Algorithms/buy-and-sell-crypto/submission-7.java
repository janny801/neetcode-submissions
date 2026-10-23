class Solution {
    public int maxProfit(int[] prices) 
    {
        int maxprofit =0; 
        int buy =0; 
        for(int sell =0; sell<prices.length; sell++)
        {
            //case 1 ; sell is greater then buy (profitable)
            if(prices[sell]> prices[buy])
            {
                int currentprofit = prices[sell]-prices[buy]; 
                maxprofit = Math.max(maxprofit, currentprofit);  
            }
            else
            {
                //case 2; buy is greater then sell price; so not profitable 
                //replace the curernt buy with sell price 
                buy = sell; 
            }
            
        }
        return maxprofit; 
        
    }
}
