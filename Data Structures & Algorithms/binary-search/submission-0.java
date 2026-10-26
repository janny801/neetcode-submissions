class Solution {
    public int search(int[] nums, int target) 
    {
        //edge case 1; nums is null or empty 
        if(nums ==null || nums.length ==0)
        {
            return -1; 
        }

        //edge case 2; single element array check 
        if(nums.length ==1)
        {
            if(nums[0]== target)
            {
                return 0; 
            }
            else
            {
                return -1; 
            }
        }

        int left = 0; 
        int right = nums.length-1; 

        while(left<=right)
        {
            //calculate mid index 
            int mid = left + (right - left) /2; 

            //case 1; target matches the middle value
            if(nums[mid]==target)
            {
                return mid; 
            }//case 2; target is greater then mid (eliminate the left half)
            else if(nums[mid] < target)
            {
                left = mid +1; //move the left pointer past mid
            }//case 3; target is smaller then mid (eliminate right half) 
            else
            {
                right = mid-1; //move right pointer over past mid 
            }


        }
        //target not found 
        return -1; 
        
    }
}
