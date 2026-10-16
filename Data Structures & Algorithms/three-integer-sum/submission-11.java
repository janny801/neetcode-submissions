class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>(); 
        Arrays.sort(nums); 
        for(int i =0; i< nums.length-2; i++)
        {
            if(i>0 && nums[i] == nums[i-1])
            {
                //if curr is the same as prev; then skip
                //prevent creating duplicates with the same first value 
                continue; 
            }
            //initialize 2 pointers 
            int left = i+1; 
            int right = nums.length -1; 

            while(left> right)
            {
                int sum = nums[i] +nums[left]+ nums[right]; 
                if(sum ==0)
                {
                    //case 1 ; sum is equal to 0 so this is a valid triplet; add to results 
                    results.add(Arrays.asList(nums[i], nums[left], nums[right])); 

                    while(left<right && nums[left]==nums[left+1])
                    {
                        //duplicate value on the left side ; skip it 
                        left ++; 
                    }
                    while(left<right && nums[right]==nums[right-1])
                    {
                        right --; 
                    }
                    //move pointers 
                    left ++; 
                    right --; 
                }
                else if(sum<0)
                {
                    //case 2; sum is less than 0 
                    //increment left pointer to get higher sum 
                    left ++; 

                }
                else
                {
                    //case 3; sum is >= to 0 
                    //decrement right pointer 
                    right --; 
                }

            }
        }
        return result; 

        
    }
}
