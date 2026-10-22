class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        //edge case 1; empty array input; return empty array 
        if(nums.length==0)
        {
            return new int[0]; 
        }
        //edge case 2; window size is 1 - every element is its own max 
        if(k==1)
        {
            return nums; 
        }

        int[] result= new int[nums.length-k+1]; //stores max value for each window 
        int resultindex=0; 

        //primitive integer array acting as double ended queue(deque); stores indices of elements in nums 
        int[] deque = new int[nums.length]; 

        int head =0; //ponts to front of deque(where the window's maximum value is located at that index)
        int tail =0; //points to position after the last element in deque (position after the current window) 
        int left=0; //left boundary of fixed sized sliding window 

        //expand right boundary of the sliding window across the nums array 
        for(int right=0; right< nums.length; right++)
        {
            //find current number entering the window on the right
            int currentnum = nums[right]; 
            
            //remove indices whose values are smaller than the incoming number 
            //deque is not empty when head<tail 
            while(head<tail && nums[deque-1]< currentnum)
            {
                //remove smaller elements index from the back by decrementing the tail 
                tail--; 
            }

            //add current element index to the back of deque
            deque[tail] = right; 
            tail++; 

            //remove index from deque if it has fallen outside of the active windows bounds
            if(deque[head]<left)
            {
                //remove out of bounds index from front by incrementing head 
                head++; 
            }

            //once the window reaches full size of k; record the max and then shift the left boundary 
            if(right>=k-1)
            {
                //head index always holds the maximum value for the current window 
                result[resultindex] = nums[deque[head]];
                resultindex++; 

                //move left pointer over to maintain window size k for next step 
                left++; 
            }
        }
        return result; 
        
    }
}
