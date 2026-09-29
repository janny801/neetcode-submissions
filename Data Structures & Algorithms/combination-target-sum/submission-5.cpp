class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& nums, int target) 
    {
        vector<int> currentcombination; 
        vector<vector<int>> allcombinations; 

        //call backtracking 

        return allcombinations; 

        
    }

    void backtracking(int index, 
    int remainingsum, 
    vector<int> &nums, 
    vector<int> &currentcombination, 
    vector<vector<int>> &allcombinations)
    {
        // base case 
        if(remainingsum ==0)
        {
            // remaningsum ==0 (it is the same as the target value)
            allcombinations.push_back(currentcombination);
            return; 
        }

        //iterate thru the whole nums array (starting with the current index) 
        for(int i = index; i<nums.size(); i++)
        {
            int currval = nums[i]; 

            //if curr val > remainingsum (it will be over targetval --continue) 
            if(currval> remainingsum)
            {
                continue; 
            }



            currentcombination.push_back(currval); 

            //backtracking call 
            backtracking(index, remainingsum, nums, currentcombination, allcombinations); 



            //backtrack 
            currentcombination.pop_back(); 



        }
    }
};
