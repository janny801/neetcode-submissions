class Solution {
    public int maxArea(int[] heights) 
    {
        int maxarea = 0; //track the max area found so far 
        //use two pointers at the end of the array to max the initial width 
        int left = 0; 
        int right= heights.length-1; 
        //process pairs until the pointers meet 
        while(left<right)
        {
            int width = right - left; //width is the distance between the two lines 
            int currheight = Math.min(heights[left], heights[right]); //water capacity and height is limited by the shorter of the two heights for both pointer locations 
            int currarea= width * currheight; 
            maxarea= Math.max(maxarea, currarea); //update global max area if the current container is larger 
            //iterate the smaller pointer (whichever between the left and right pointers has the shortest height)
            if(heights[left]<heights[right])
            {
                //left has shorter height
                left++; 
            }
            else
            {
                //right has smaller height 
                right--; 
            }
        }
        return maxarea; 
        
    }
}
