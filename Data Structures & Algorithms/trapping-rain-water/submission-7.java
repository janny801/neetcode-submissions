class Solution {
    public int trap(int[] height) 
    {
        if(height.length<3)
        {
            return 0; 
        }
        int left= 0; 
        int right= height.length-1; 
        int leftmax=0; 
        int rightmax=0; 
        int maxwater=0; 
        while(left<right)
        {
            if(height[left]<=height[right])
            {
                //case 1; height of left is smaller or equal to right 
                if(height[left]>= leftmax)
                {
                    leftmax= height[left]; 
                }
                else
                {
                    maxwater+= leftmax- height[left]; 
                }
                left++; 
            }
            else
            {
                //case 2; height of right is smaller 
                if(height[right]>= rightmax)
                {
                    rightmax= height[right]; 
                }
                else
                {
                    maxwater+=rightmax-height[right]; 
                }
                right --; 
            }
        }
        return maxwater; 
        
    }
}
