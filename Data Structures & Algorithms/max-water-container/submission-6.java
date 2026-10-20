class Solution {
    public int maxArea(int[] heights) 
    {
        int maxarea = 0; 
        int left = 0; 
        int right= heights.length-1; 
        while(left<right)
        {
            int width = right - left; 
            int height = Math.min(height[left], height[right]); 
            int currarea= width*height; 
            maxarea= Math.max(currarea, maxarea); 
            if(height[left]< height[right])
            {
                left++; 
            }
            else
            {
                right --; 
            }
        }
        return maxarea; 
        
    }
}
