class Solution {
    public int trap(int[] height) 
    {
        //edge case; if length of bars is less than 3 
        if(height.length<3)
        {
            return 0; 
        }
        int left = 0; 
        int right = height.length-1; 
        int leftmax = 0; 
        int rightmax=0; 
        int totalwater=0; 
        while(left<right)
        {
            if(height[left]<=height[right])
            {
                //case 1; height of left is <= height of right 
                //height of left bar is bottleneck for total water size 
                if(height[left]>= leftmax)
                {
                    leftmax= height[left]; 
                }
                else
                {
                    totalwater+=leftmax - height[left]; 
                }
                left++; 
            }
            else
            {
                //case 2; height of right is smaller then height of left 
                if(height[right]>= rightmax)
                {
                    rightmax= height[right]; 
                }
                else
                {
                    totalwater+= rightmax- height[right]; 
                }
                right --; 
            }
        }
        return totalwater; 
    }
}
