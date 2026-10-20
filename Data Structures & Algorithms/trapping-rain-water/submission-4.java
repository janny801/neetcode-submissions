class Solution {
    public int trap(int[] height) 
    {
        //edge case; there is less than 3 bars so return 0 
        if(height.length<3)
        {
            return 0; 
        }
        int left=0; 
        int right = height.length-1; 
        int leftmax = 0; 
        int rightmax =0;
        int totalwater=0; 
        while(left<right)
        {
            if(height[left]<= height[right])
            {
                //case 1; left height is less than or equal to right height 
                if(height[left]>= leftmax)
                {
                    leftmax= height[left];
                }
                else
                {
                    totalwater+= leftmax- height[left];
                }
            }
            else
            {
                //case 2; right height is less than left height 
                if(height[right]>rightmax)
                {
                    rightmax= height[right]; 
                }
                else
                {
                    totalwater += rightmax-height[right]; 
                }
            }
        }
        return totalwater; 
        
    }
}
