//given ; numbers are sorted in nondecreasing order 

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; 
        int right = numbers.length-1

        //loop until the two pointers meet 
        while (left<right)
        {
            int currSum = numbers[left] +numbers[right]

            //case 1: current sum matches the target
            if (currSum == target)
            {
                return new int[]{left +1, right +1}; 
            }
            else if (currSum<target)
            {
                //case 2; sum is too small so move left pointer to increase sum 
                left++;
            }
            else 
            {
                //case 3; sum is too large so dec right pointer to decrease the sum 
                right --; 
            }

        }
        //empty arrray if no solution 
        return new int[0]
    }
}
