class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) 
    {


        sort(candidates.begin(), candidates.end()); 
        // sort so we can prune wen... 
            //1 ; value> remainingsum 
            //2; or if the current value is the same as the last one (prev index )
                //since we cannot have any duplicates 
        vector<int> currentcombination; 
        vector<vector<int>> allcombinations; 

        //call backtracking 
        backtracking(0, target, candidates, currentcombination, allcombinations); 


        return allcombinations; 

    }

    void backtracking(
        int index, 
        int remainingsum, 
        vector<int> &candidates, 
        vector<int> &currentcombination, 
        vector<vector<int>> &allcombinations
    )
    {
        // backtracking func 

        //base case (if remaining sum is 0)
        if (remainingsum ==0)
        {
            allcombinations.push_back(currentcombination); 
            return; 
        }


        //iterate thru choices 
        for(int i =index; i< candidates.size(); i++)
        {
            int currval = candidates[i]; 

            // prune 1; if currval > remainingsum 
            if(currval>remainingsum)
            {
                break; 
                //use break instead of continue since we sorted it 
                    // every number after this one will also be larger 
            }

            //prune 2; skip duplicates 
            if(i>index && (candidates[i]==candidates[i-1]))
            {
                // duplicate value since we sorted them in order 
                    //basically checks if the current value is the same as the last one 
                    //if it is the same --> then we skip that value 

                continue; 
                
            }

            
            //put into vector 
            currentcombination.push_back(currval); 

            //backtrack recursive call 
            backtracking(i+1, remainingsum -currval, candidates, currentcombination, allcombinations); 
            //use i+1 here since each number can only be used at most one time 


            //backtracking 
            if(!currentcombination.empty())
            {
                // remove the last added value and try the next choice 
                currentcombination.pop_back(); 

            }


        }
        
    }
};
