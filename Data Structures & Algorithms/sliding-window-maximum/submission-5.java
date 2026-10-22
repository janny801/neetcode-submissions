class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        //edge case 1 ; empty array check 
        if(nums.length==0)
        {
            return new int[0]; 
        }
        //edge case 2; window size is 1 
        if (k==1)
        {
            return nums; 
        }
        int numlength = nums.length; 

        //prefixmax[i] ; stores the max from the start of the block until index i 
        int[] prefixmax= new int[numlength]; 
        
        //suffixmax[i]; stores the max from index i to the end of the block 
        int[] suffixmax= new int[numlength]; 

        //build prefix max (left to right within each block of size k ) 
        for(int i =0; i<numlength; i++)
        {
            if(i%k==0)
            {
                //if we are at the start of a block of size k then restart the max 
                prefixmax[i]= nums[i]; 
            }
            else
            {
                prefixmax[i] = Math.max(prefixmax[i-1], nums[i]); 
            }
        }

        //build suffix max (right to left within each block of size k ) 
        for(int i = numlength-1; i>=0; i--)
        {
            //if we are at the end of a block of size k or at the end of the array (restart the max) 
            if(i==numlength-1 || (i+1)%k ==0)
            {
                suffixmax[i] = nums[i]; 
            }
            else
            {
                suffixmax[i] = Math.max(suffixmax[i+1], nums[i]); 
            }
        }

        //store the maximum value for each valid window 
        int[] reuslt = new int[numlength -k+1]; 

        //compute the maximum for each window 
        for(int i =0; i<result.length; i++)
        {
            int left = i; 
            int right = i+k-1; 

            //the window max is hte max of the suffix from 'left' and the prefix up to 'right' 
            result[i] = Math.max(suffixmax[left], prefixmax[right]); 
        }
        return result; 
    }
}
