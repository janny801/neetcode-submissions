class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& nums, int target) 
    {
        vector<int> currentcombination; 
        vector<vector<int>> allcombinations; 

        //call backtracking 
        backtracking(0, target, nums, currentcombination, allcombinations); 


        return allcombinations; 
        
    }

    void backtracking(int index, 
    int remainingsum, 
    vector<int> &nums, 
    vector<int> &currentcombination, 
    vector<vector<int>> &allcombinations)
    {
        //base case (if remaining sum ==0 )
        // remainingsum will equal target here 
        if(remainingsum ==0)
        {
            allcombinations.push_back(currentcombination); 
            return; 
        }

        //iterate thru the array starting from current index -> end 
        for(int i =index; i< nums.size(); i++)
        {
            int currval = nums[i]; 

            if (nums[i]> remainingsum)
            {
                continue; 
                //cant be added to currentcombination --will be over the target val 
            }


            //otherwise add to currentcombinations 
            currentcombination.push_back(currval); 

            //recursive call to backtrack 
            backtracking(i, remainingsum - currval, nums, currentcombination, allcombinations); 

            //backtrack --remove the last step 
            currentcombination.pop_back(); 
        }
    }
};
