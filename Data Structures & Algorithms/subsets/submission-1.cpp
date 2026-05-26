class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) 
    {
        vector<int> currentcombination; 
        vector<vector<int>> allsubsets; 


        //call backtracking func 
            //parameters; 
                // index, nums vector, currentcombination, allsubsets   

        backtracking(0, nums, currentcombination, allsubsets); 
        return allsubsets; 
        
    }
    void backtracking(
        int index, 
        vector<int> &nums, 
        vector<int> &currentcombination, 
        vector<vector<int>> &allsubsets
    )
    {
        // base case (if we get to the end of nums vec)
        if(index == nums.size())
        {
            allsubsets.push_back(currentcombination); 
            return; 
        }

        //recursive cases 

        //choice 1; dont include in currentcombination 
        backtracking(index+1, nums, currentcombination, allsubsets); 

        //choice 2; include in currentcombination
        currentcombination.push_back(nums[index]);
        backtracking(index+1, nums, currentcombination, allsubsets);


        //backtracking step 
        currentcombination.pop_back(); 



    }
};
