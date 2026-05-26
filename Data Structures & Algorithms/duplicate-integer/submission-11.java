class Solution {
    public boolean hasDuplicate(int[] nums) 
    {
        //pick each element one by one 
        for (int i = 0; i< nums.length; i++)
        {
            //compare it with all the 
            //other elements that come after it 
            for(int j = i+1; j< nums.length; j++)
            {
                //compare the current [i] 
                //against values in the array 
                //that come after it 
                if (nums[i] == nums[j])
                {
                    return true;
                }


            }
        }
        //return false (passes the 'if' check) 
        //to see if there is a matching value in the rest of 
        //the array 
        return false;
        //there are no duplicate elements in this array 
        
    }
}