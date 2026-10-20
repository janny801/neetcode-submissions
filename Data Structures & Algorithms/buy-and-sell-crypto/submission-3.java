class Solution {
    public int maxProfit(int[] prices) 
    {
        //sliding window problem 
        int maxprofit = 0; 
        int buy =0; 
        for(int sell =1; sell<prices.length; sell++)
        {
            if(prices[sell]> prices[buy])
            {
                //case 1; profitable (sell price is greater then buy price)
                int currprofit = prices[sell]- prices[buy]; 
                maxprofit = Math.max(currprofit, maxprofit); 
            }
            else
            {
                //case 2; not profitable sell 
                //the sell price becomes the new buy 
                buy = sell; 
            }
        }
        return maxprofit; 
        
    }
}
