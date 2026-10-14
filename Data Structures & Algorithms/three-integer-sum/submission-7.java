class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {

        List<List<Integer>> result = new ArrayList<>(); //list stores valid triplets 
        Arrays.sort(nums); //sort in ascending order so that i can use 2pointer 

        for(int i = 0; i<nums.length-2; i++)
        {
            if (i>0 && nums[i] == nums[i-1])
            {
                //if curr is the same as prev; skip 
                //avoids creating duplicates with the same first value 
                continue; 
            }
            //2 pointer 
            int left = i+1; 
            int right = nums.length-1; 

            while (left< right) 
            {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0)
                {
                    //valid triplet found; add to results list 
                    result.add(Arrays.asList(nums[i], nums[left],nums[right])); 

                    while(left< right && nums[left] == nums[left+1])
                    {
                        //skip duplicatet values on the left side to prevent duplicates 
                        left ++; 
                    }
                    while(left<right && nums[right]== nums[right-1])
                    {
                        //skip duplicates on the right to prevent duplicates 
                        right --; 
                    }
                }
                else if(sum<0)
                {
                    //sum is too small; increment left pointer to get a larger value 
                    left++; 
                }
                else
                {
                    //sum is too large; decrement right pointer to get a smaller value 
                    right --; 
                }
            }
        }
        return result; 
        
    }
}
