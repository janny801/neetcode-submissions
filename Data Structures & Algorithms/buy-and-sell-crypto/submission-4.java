class Solution {
    public int maxProfit(int[] prices) 
    {
        int buy =0; 
        int maxprofit = 0; 
        for (int sell =1; sell<prices.length; sell++)
        {
            if(prices[sell]> prices[buy])
            {
                //case 1; sell prices is higher so this window is profitable 
                int currprofit = prices[sell]-prices[buy]; 
                maxprofit = Math.max(currprofit, maxprofit); 
            }
            else
            {
                //case 2; buy price is the same or equal to sell price
                //set buy price to the sell price 
                buy = sell;
            }
        }
        return maxprofit; 
        
    }
}
