class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>(); 
        Arrays.sort(nums); 

        for (int i = 0; i<nums.length-2; i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                //skip duplicate start values 
                continue; 
            }
            //initialize two pointer technique 
            int left = i+1; 
            int right = nums.length-1; 
            while(left<right)
            {
                sum = nums[i]+nums[left]+nums[right]; 
                if (sum ==0)
                {
                    //case 1; sum is 0 
                    //add to result array 
                    result.add(Arrays.asList(nums[i], nums[left], nums[right])); 
                    while(left<right && nums[left]==nums[left+1])
                    {
                        //next left pointer is jus the same so skip it 
                        left ++; 
                    }
                    while(left<right && nums[right]==nums[right-1])
                    {
                        //next right pointer is the same so skip it 
                        right --; 
                    }
                    //iterate pointers to new unique values 
                    left ++; 
                    right --; 
                }else if(sum<0)
                {
                    //case 2; sum is less than 0 
                    //sum needs to get increased so increment left pointer 
                    left ++; 
                }else
                {
                    //case 3; sum is >=0 
                    //sum needs to get decreased so decrement right pointer 
                    right --; 
                }
            }
        }
        return result; 
        
    }
}
