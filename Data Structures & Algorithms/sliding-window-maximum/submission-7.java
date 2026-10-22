class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        //edge case 1; empty input 
        if(nums.length ==0)
        {
            return new int[0]; 
        }
        //edge case 2; window size is 1
        if(k==1)
        {
            return nums; 
        }

        //store max value for each valid window of k 
        //there are nums.length-k+1 windows 
        int[] result= new int[nums.length-k+1]; 
        int resultindex= 0; 

        //primitive integer array acting as a double ended queue(deque) ; stores indices of elements in nums
        int[] deque = new int[nums.length]; 

        int head =0; //front of deque(where the window maximum lives) 
        int tail =0; //position after the last elementin the deque

        int left =0; //left boundary of the fixed size sliding window 

        //expand right boundary of the fixed size sliding window 
        for(int right =0; right< nums.length; right++)
        {
            //find current number entering the window on the right
            int currentnum = nums[right]; 

            //remove indices whose values are smaller then the incoming number (deque is not empty wen head<tail)
            while(head<tail && nums[deque[tail-1]]<currentnum)
            {
                //remove smaller element index from back by decrementing tail 
                tail--; 
            }

            //add current element index to the back of deque 
            deque[tail] = right; 
            tail++; 

            //remove index from the front of deque if it has fallen out of the window bounds 
            if(deque[head] < left)
            {
                //remove out of bounds index from front by incrementing head 
                head++; 
            }

            //once the window reaches the full size 'k' -- record the maximum and shift the left boundary 
            if(right>=k-1)
            {
                //head index holds the max value for the current window
                result[resultindex] = nums[deque[head]]; 
                resultindex++; 

                //move left pointer over to maintain the window size for the next step 
                left++; 
            }
        }
        //return array max's collected from all windows
        return result; 
    }
}
