class Solution {
    public int search(int[] nums, int target) 
    {
        //edge case 1; empty nums 
        if(nums.length ==0)
        {
            return -1; 
        }
        //edge case 2; if nums is length 1
        if(nums.length==1)
        {
            if(nums[0]==target)
            {
                return 0; 
            }
            else
            {
                return -1; 
            }
        }
        int left =0; 
        int right = nums.length-1; 

        while(left<=right)
        {
            int mid = left+(right-left)/2; 
            if(nums[mid]==target)
            {
                return mid; 
            }
            else if(nums[mid]<target)
            {
                //target greater so search right side 
                left = mid+1; 
            }
            else
            {
                //target less than mid - search left side
                right = mid-1; 
            }
        }
        //no matches found 
        return -1; 
        
    }
}
