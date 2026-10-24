class Solution {
    public int maxProfit(int[] prices) 
    {
        int maxprofit = 0; 
        int buy =0; 

        for(int sell = 0; sell<prices.length; sell++)
        {
            
            if(prices[sell]> prices[buy])
            {
                //case 1; profitable - find current profit and then check if it is the max profit 
                int currentprofit = prices[sell] - prices[buy];
                maxprofit = Math.max(currentprofit, maxprofit); 
            }
            else
            {
                //case 2; not profitable - buy here instead 
                buy = sell; 
            }
        }
        return maxprofit; 
        
    }
}
