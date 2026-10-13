class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //list to store final list of valid triplets 
        List<List<Integer>> result = new ArrayList<>(); 
        //sort array in ascending 
        //so that we can use 2pointer 
        Arrays.sort(nums); 

        //iterate thru array to pick first number of triplet 
        //stop at nums-2 since we need 2 nums after index i 
        for (int i =0; i<nums.length-2; i++)
        {
            //if curr is same as prev -> skip 
            //avoid creating duplicates with the same first value 
            if (i>0 && nums[i]== nums[i-1])
            {
                continue; 
            }
            //initialize 2 pointers for remaining numbers 
            int left = i+1 //pointer starting right after i 
            int right = nums.length-1//pointer start at end of the array 

            //use 2pointer to find pairs that sum to find pairs that sum to -nums[i]
            while (left<right) 
            {
                int sum = nums[i] + nums[left] + nums[right]; 
                if(sum ==0)
                {
                    //valid triplet found ; add to result list 
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //move pointers inward to search for next potential pair 
                    left ++; 
                    right --; 


                }
                else if(sum<0)
                {
                    //sum is too small ; incr left pointer to get a larger value 
                    left++; 
                }
                else
                {
                    //sum is too large ; decr right pointer to get a smaller value 
                    right --; 
                }

            }
        }
        return result;  
        
        
    }
}
