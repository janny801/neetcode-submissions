class Solution {
    public int search(int[] nums, int target) 
    {
        //edge case 1; nums has no length 
        if(nums.length ==0)
        {
            return -1; 
        }
        //edge case 2; nums has length 1 
        if(nums.length==1)
        {
            //check if it is the target 
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
        int right = nums.length -1; 

        while(left<=right)
        {
            int mid = left + (right - left)/2; 
            if(nums[mid]==target)
            {
                //case 1; value at mid is equal to the target 
                return mid; 
            }
            else if(nums[mid]>target)
            {
                //case 2; value at mid is greater then the target -> search the left side 
                right = mid -1; 

                    
            }
            else
            {
                //case 3; value at mid is less than the target -> search the right side 
                left = mid +1; 
            }

            
        }
        //no matches found 
        return -1; 
    }
        
        
    }

