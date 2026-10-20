class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>(); //store valid triplets
        Arrays.sort(nums); 
        for (int i =0; i<nums.length-2; i++)
        {
            //loop for nums.length-2 since need valid triplets 
            //guaranteese at least 2 elements after i to evaluate as a triplet 
            if(i>0 && nums[i]==nums[i-1])
            {
                //this removes the case of duplicate triplets starting with the same value 
                //identical values end up next to each other (since we have sorted)
                    // thus, searching the remaining elements would result in the same combination(same triplet) -- leading to a repeated triplet 
                    //all triplet responses should be unique
                continue; 
            }
            int left = i+1; //smallest remaining value 
            int right = nums.length-1; //largest remaining value 
            while(left<right)
            {
                int currentsum = nums[i] + nums[left]+nums[right]; 
                if (currentsum ==0)
                {
                    //case 1; current sum is 0 
                    //this is valid triplet so add to result array 
                    result.add(Arrays.asList(nums[i], nums[left], nums[right])); 

                    while(left<right && nums[left]==nums[left+1])
                    {
                        //the next value of left is going to be the same so skip it 
                        left ++; 
                    }
                    while(left<right && nums[right]==nums[right-1])
                    {
                        //next value of right is going to be the same so skip it 
                        right --; 
                    }
                    //iterate pointers 
                    left ++; 
                    right --; 

                }
            }
        }
        return result; 

        
    }
}
