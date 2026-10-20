class Solution {
    public int maxArea(int[] heights) 
    {
        int maxarea= 0; 
        int left= 0; 
        int right= heights.length-1; 
        while(left<right)
        {
            int width = right - left; 
            int height = Math.min(heights[left], heights[right]); 
            int currarea= width * heights; 
            maxarea= Math.max(currarea, maxarea); 
            //move pointer based on which height is smaller 
            //the smaller height is the one causing the bottleneck for the area 
            //there could possibly be a taller bar that could potentially give a larger area 
            if(heights[left]< heights[right])
            {
                //height at the left pointer is smaller then the right height
                left++; 
            }
            else
            {
                //height at the right pointer is shorter then left height
                right--; 
            }
        }
        return maxarea; 
        
    }
}
