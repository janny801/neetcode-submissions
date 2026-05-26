class Solution {
    public boolean hasDuplicate(int[] nums) 
    {
        //brute force approach practice
        for (int i = 0; i <nums.length; i++)
        {
            for (int j = i+1; j< nums.length; j++)
            {
                //if same value then duplicate
                //return true
                if (nums[i] == nums[j])
                {
                    return true; 
                }
            }
        }
        //makes it out of the loop so there is no duplicates
        //return false
        return false; 
        
    }
}