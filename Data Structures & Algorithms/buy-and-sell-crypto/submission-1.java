class Solution {
    public int maxProfit(int[] prices) 
    {

        int maxprofit = 0; 
        int buy =0; 
        for(int sell =1; sell<prices.length; sell++)
        {
            if(prices[sell]> prices[buy])
            {
                //case 1; profitable transaction found (selling price is higher then buying price) 
                int currprofit = prices[sell]-prices[buy]; 
                maxprofit = Math.max(maxprofit, currprofit); 
            }
            else
            {
                //case 2; selling price is less than or equal to the buying price 
                buy = sell; 
            }

        }
        return maxprofit; 
        
    }
}
