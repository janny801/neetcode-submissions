class Solution {
    public int maxArea(int[] heights) 
    {
        int maxarea= 0; 
        int left = 0; 
        int right= heights.length-1; 

        while(left<right)
        {
            int width = right - left; 
            int height = Math.min(heights[left], heights[right]); 
            int currarea= width * height; 
            int maxarea= Math.max(currarea, maxarea); 
            if(heights[left]< heights[right])
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
