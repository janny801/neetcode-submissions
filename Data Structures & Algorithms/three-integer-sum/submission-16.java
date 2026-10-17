class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>(); 
        Arrays.sort(nums); 


        //iterate until 3rd to last one since need last triplet 
        for(int i = 0; i<nums.length-2; i++)
        {
            if(i>0 && nums[i]== nums[i-1])
            {
                //if the current number we are looking at is the same as the last one then skip it 
                //so that we dont have triplets with the same starting value 
                continue; 
            }
            //initialize 2 pointer technique
            int left = i+1; 
            int right = nums.length-1; 

            while(left<right)
            {
                int sum = nums[i] + nums[left] + nums[right]; 
                if (sum ==0)
                {
                    //case 1; sum is equal to 0 
                    //add to result array
                    result.add(Arrays.asList(nums[i], nums[left], nums[right])); 
                    while(left<right && nums[left] == nums[left+1])
                    {
                        //if current left pointer is the same as the next left pointer then skip to revent duplicates 
                        left++; 
                    }
                    while(left<right && nums[right]==nums[right-1])
                    {
                        //current right pointer is same as what the right pointer is going to be next so skip 
                        right --; 
                    }
                    //iterate to new unique left and right pointers 
                    left ++; 
                    right --; 
                }
                else if(sum<0)
                {
                    //case 2; sum is less than 0 
                    //increment left pointer to increase sum 
                    left ++; 
                }
                else
                {
                    //case 3; sum is >= 0 
                    //decrement right pointer to decrease sum 
                    right --; 
                }
            }
        }
        return result 
        
    }
}
