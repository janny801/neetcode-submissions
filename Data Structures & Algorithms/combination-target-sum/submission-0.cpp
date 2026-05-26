class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        vector<vector<int>> allcombinations; 
        vector<int> currentcombination; 

        //initial call to backtracking 
            // index = 0 
            // full target (remaining sum) 
        backtrack(0, target, nums, currentcombination, allcombinations); 


        return allcombinations; 

        
    }


    //int startindex and remainingsum are not passed by reference 
        // each recursive call should have its own copy of startindex and remaining sum
        //if not it breaks backtracking bc... 
            // all recursive calls would share the same variable

    //func that does the backtracking 
    void backtrack(int startindex, 
    int remainingsum, 
    vector<int> &nums, 
    vector<int> &currentcombination, 
    vector<vector<int>> &allcombinations)
    {
        //if it gets to the target after recursion is done on that path 
        if(remainingsum ==0)
        {
            allcombinations.push_back(currentcombination); 
            return; 
        }

        //try each num from startindex onwards 
        for(int i = startindex; i<nums.size(); i++)
        {
            int currval = nums[i]; 

            if (currval> remainingsum)
            {
                //skip bc too large 
                continue; 
            }

            //choose; include this candidate in the path 
            currentcombination.push_back(currval); 

            //recurse step
            backtrack(i, remainingsum-currval, nums, currentcombination, allcombinations); 

            //unchoose step 
            currentcombination.pop_back(); 

        }

    }
};


