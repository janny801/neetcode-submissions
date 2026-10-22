class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        //edge case; empty input - return empty array 
        if (nums.length==0)
        {
            return new int[0]; 
        }
        
        //edge case 2; window size is 1 - every element is its own maximum 
        if(k==1)
        {
            return nums; 
        }

        //store max value for each valid window size of k -- there are exactly (nums.length-k+1) windows
        int[] result = new int[nums.length-k+1]; 
        int resultindex= 0; 

        //integer array acting as double ended queue stores indices of elements in nums  
        int[] deque = new int[nums.length]; 

        //head points to front of deque (where the max lives) 
        //tail points to the position after the element in deque
        int tail; 

        int left=0; //left boundary of fixed size sliding window 

        //expand right boundary of sliding window across nums 
        for(int right =0; right<nums.length; right++)
        {
            //find current number that is entering the window on the right 
            int currentnum = nums[right]; 
            
            //remove indices whose values are smaller than the incoming number 
            while(head<tail && nums[deque[tail-1]]<currentnum)
            {
                //remove smaller element index from back by decrementing tail 
                tail--; 
            }

            //add current element index to the back of deque
            deque[tail] = right; 
            tail++; 

            //remove index from front of deque if it has fallen out of active window bounds
            if(deque[head]<left)
            {
                //remove out of bounds index from front by incrementing head
                head++; 
            }

            //once the window reaches full size k , record the maximum , then shift the left boundary 
            if(right>=k-1)
            {
                //head index always holds max value for the current window 
                result[resultindex] = nums[deque[head]];
                resultindex++; 

                //move left pointer over to maintain the window size k for the next step 
                left++; 
            }
        }
        return result; 
    }
}
