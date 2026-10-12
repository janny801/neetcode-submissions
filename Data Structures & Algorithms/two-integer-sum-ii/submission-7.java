class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        int left = 0; 
        int right = numbers.length -1; 
        while (left<right)
        {
            int currSum = numbers[left] + numbers[right];
            if (currSum == target)
            {
                //case 1; currsum equals target
                return new int[]{left +1, right+1};
            }
            else if(currSum > target)
            {
                //case 2; currsum is greater then target 
                right --; 
            }
            else
            {
                //case 3; currsum is less then or equal to target 
                left ++; 
            }
        }
        //edge case; if there is no match 
        return new int[0]; 
        
    }
}
