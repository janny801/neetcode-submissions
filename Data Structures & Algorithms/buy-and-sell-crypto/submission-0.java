class Solution {
    public int maxProfit(int[] prices) 
    {
        int maxprofit = 0; //track overall max profit found so far 
        int buy = 0; //pointer for the buying day (starts at the first day)
        for (int sell =1; sell<prices.length;sell++)
        {
            if(prices[sell]>prices[buy])
            {
                //case 1; profitable transaction found 
                int currprofit = prices[sell]- prices[buy]; 
                maxprofit = Math.max(maxprofit, currprofit); 
            }
            else
            {
                //case 2; found a cheaper buying day(selling price is less than or equal to the buying price )
                buy = sell; 
            }
        }
        return maxprofit; 
        
        
    }
}
