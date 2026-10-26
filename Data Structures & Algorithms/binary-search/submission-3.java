class Solution {
    public int search(int[] nums, int target) {
        //edge case 1; nums is empty 
        if(nums.length ==0)
        {
            return -1
        }
        //edge case 2; nums has length 1 
        if(nums.length ==1)
        {
            if(nums[0] == target)
            {
                return 0; 
            }
            else
            {
                return -1; 
            }
        }

        int left = 0; 
        int right = nums.length -1; 
        while(left<=right)
        {
            int mid = left + (right - left) /2; 
            if(nums[mid]==target)
            {
                //c1; nums is equal target
                return mid; 
            }
            else if(nums[mid]< target)
            {
                //c2; mid value less than target- search right 
                left = mid +1; 

            }
            else
            {
                //c3; mid value greater then target- search left 
                right - mid -1; 
            }
        }
        //no matches found 
        return -1;
        
    }
}
