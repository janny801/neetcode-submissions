class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& nums, int target) 
    {

        vector<vector<int>> allcombinations; 
        vector<int> currentcombination; 

        //call backtrack function 
        backtrack(0, target, nums, currentcombination, allcombinations); 


        return allcombinations; 
        
    }

    void backtrack(int index, 
    int remainingvalue, 
    vector<int> &nums, 
    vector<int> &currentcombination, 
    vector<vector<int>> &allcombinations)
    {
        //backtracking function 

        //base case (if there is no more remaining value)
        if(remainingvalue ==0)
        {
            allcombinations.push_back(currentcombination); 
            return; 
        }

        //for loop starting from index to nums.size
        for(int i = index; i< nums.size(); i++)
        {
            int currval = nums[i];


            //if currval is too large then skip 
            if(currval> remainingvalue)
            {
                continue; 
            }

            //choose ; add to currentcombination
            currentcombination.push_back(currval); 

            //backtracking recursive call
            backtrack(i, remainingvalue-currval, nums, currentcombination, allcombinations); 

            //backtrack step 
            currentcombination.pop_back();
        }

    }
};
