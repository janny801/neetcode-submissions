class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>(); 

        Arrays.sort(nums); 

        for(int i =0; i<nums.length -2; i++)
        {
            if(i>0 && nums[i] == nums[i-1])
            {
                //if curr is the same as prev; then skip 
                //avoids creating duplicates with the same first value 
                continue; 
            }
            //initialize 2 pointer technique
            int left = i+1; 
            int right = nums.length-1; 

            while(left<right)
            {
                int sum = nums[i] + nums[left] +nums[right]; 
                if (sum ==0)
                {
                    //case 1; sum is 0 , this is a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]))

                    while(left< right && nums[left] == nums[left+1])
                    {
                        //skip duplicate values on the left side 
                        left++; 
                    }
                    while(left< right && nums[right]== nums[right-1]) 
                    {
                        //skip duplicate values on the right side
                        right --; 
                    }
                    left ++; 
                    right --; 
                    
                }
                else if(sum<0)
                {
                    //case 2; sum is less than 0 
                    //sum is too small so increment the left pointer to find a larger sum 
                    left++; 
                }
                else
                {
                    //case 3; sum is too large 
                    //decrement the right pointer to get a smaller value 
                    right --; 
                }
            }
        }
        return result; 
        
    }
}
