class Solution {
    public int trap(int[] height) 
    {
        //edge case; array needs to be at least length 3
        //if array has less than 3 bars then no water can be trapped between them 
        if (height ==null || height.length<3)
        {
            //there is no height or the height is less than 3 then the amt that can be trapped is 0 
            return 0; 
        }
        //two pointers starting at both ends of the array 
        int left= 0; 
        int right = height.length-1; 

        //keep track of highest walls seen on left and right sides 
        int leftmax= 0; 
        int rightmax=0; 

        //running total of trapped water 
        int totalwater =0; 

        //process bars until the two pointers meet 
        while(left<right)
        {
            if(height[left]<=height[right])
            {
                //case 1; left side is the bottleneck (left side has a shorter height) 
                //left side is limited by a shorter or equal wall 
                if(height[left]>= leftmax)
                {
                    leftmax = height[left]; 
                }
                else
                {
                    //otherwise water trapped is determined by leftmax- currentbarheight
                    totalwater += leftmax-height[left]; 
                }
                //move left pointer inward to check next bar 
                left ++; 
            }
            else
            {
                //case 2; the right side is the bottleneck and has the shorter wall 
                if(height[right]>= rightmax)
                {
                    rightmax= height[right];
                }
                else
                {
                    totalwater +=rightmax - height[right]; 
                }
                //move right pointer inward to check the next bar 
                right --; 

            }
        }
        return totalwater; 
        
    }
}
