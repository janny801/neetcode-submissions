class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0 ;
        int right = numbers.length-1; 
        while (left<right) 
        {
            int currSum = numbers[left]+ numbers[right]; 

            //case 1 ; current sum matches the number
            if (currSum ==target)
            {
                return new int[]{left +1, right+1}; 
            }
            else if(currSum<target)//case 2; current sum is too small
            {
                left ++; 
            }
            else//case 3; current sum is too large
            {
                right++; 
            }
        }
        //empty array if no solution 
        return new int[0]; 
        
    }
}
