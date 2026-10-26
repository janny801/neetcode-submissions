class Solution {
    public int search(int[] nums, int target) {
        //edge case 1; empty nums 
        if(nums.length ==0)
        {
            return -1; 
        }

        //edge case 2; if single element array 
        if(nums.length ==1)
        {
            //check if target
            if(nums[0] == target)
            {
                return 0; 
            }
            else
            {
                return -1; 
            }
        }
        
        int left =0; 
        int right = nums.length -1; 
        
        while(left<=right)
        {
            int mid = left + (right - left) /2; 

            if(nums[mid] == target) // case 1; value at mid == target
            {
                return mid; 
            }
            else if(nums[mid]< target) //case 2; value at mid is less than target - search right half 
            {
                left = mid +1; 
            }
            else // case 3; value at mid is more then the target - search left half 
            {
                right = mid -1; 
            }

            
        }
    }
    //no matches found 
    return -1; 
}
