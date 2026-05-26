class Solution {
    public boolean hasDuplicate(int[] nums) 
    {
        //doubvle for looop 
        //compelxity o(n^2) 
        //brute force approach check 

        for (int i = 0; i<nums.length; i++)
        {
            for (int j = i+1; j<nums.length; j++)
            {
                //if they are the same value then return true 
                if (nums[i]==nums[j])
                {
                    return true;
                }
            }
        }
        //else if passes thru the whole thing 
        //then there is no duplicates 
        return false; 
        
    }
}