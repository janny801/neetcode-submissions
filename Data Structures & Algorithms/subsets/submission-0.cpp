class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) 
    {
        vector<vector<int>> allsubsets; 
        vector<int> current; 

        backtrack(0, nums, current, allsubsets); 

        return allsubsets; 


        
    }

    void backtrack(int index,
     vector<int> &nums, 
     vector<int> &current, 
     vector<vector<int>> &allsubsets)
     {
        //base case 
        if(index ==nums.size())
        {
            allsubsets.push_back(current); 
            return; 
        }

        //recursive calls 
        //choice 1; exclude 
        backtrack(index+1, nums, current, allsubsets); 

        //choice 2; include 
        current.push_back(nums[index]); 
        backtrack(index+1, nums, current, allsubsets); 

        //backtracking step 
        current.pop_back(); 
     }


};
