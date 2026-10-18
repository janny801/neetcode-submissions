class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>(); 
        Array.sort(nums); 

        for (int i =0; i< nums.length -2; i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                //skip duplicate start values
                continue; 
            }
            //initialize 2 ptr technique 
            int left = i+1; 
            int right = nums.length-1; 
            while(left<right)
            {
                int sum = nums[i]+ nums[left]+nums[right];
                if(sum ==0)
                {
                    //case 1; sum is equal to 0 
                    //add to valid triplet array result 
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]))
                    while(left<right && nums[left] == nums[left+1])
                    {
                        //next value for left pointer is the same so skip 
                        left++; 
                    }
                    while(left<right && nums[right]== nums[right-1])
                    {
                        //next value for right is the same so skip 
                        right --; 
                    }
                    //iterate the two pointers 
                    left ++; 
                    right --; 
                }else if(sum<0)
                {
                    //case 2; sum is less than 0 so need to increase the sum 
                    left ++; 
                    
                }
                else
                {
                    //case 3; sum is >= 0 so need to decrease the sum 
                    right --; 
                }
            }
        }
        return result; 
        
    }
}
