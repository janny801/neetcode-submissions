class Solution 
{
    public boolean hasDuplicate(int[] nums) 
    {
        //edge case 
        //empty array or single element array 
        if (nums ==null || nums.length<=1)
        {
            return false; 
        }


        // use quicksort helper function 
        quicksort(nums, 0, nums.length-1); 


        //check adjacent values to see if there is duplicate
        for (int i = 0; i< nums.length-1; i++)
        {
            //check neighboring elements
            if (nums[i]==nums[i+1])
            {
                return true; 
            }
        }
        //passes all checks so no duplicates
        return false; 
        
    }

    //private helper function quicksort
    private void quicksort(int[] array, int low, int high)
    {
        //base case; if the segment has 1 or 0 elements
        //then it is already sorted
        if (low>= high)
        {
            //if low is greater then it is to the right of high 
            //if low = high then they are looking at the same value 
            //stopping condition meaning we have looked at a
            return; 
        }
        // choose middle element as the pivot 
        int pivotindex = low +(high - low) /2; 
        int pivot = array[pivotindex]; 

        //make iterators i and j to move from left to right 
        int i = low; 
        int j = high; 

        //partition around the pivot 
        while (i<= j)
        {
            //find element on the left side that should be on the right 
            while(array[i] < pivot) //while this is valid 
            {
                i++;
            }
            //find an index on the right side of the pivot
            //that should be on the left side 
            while (array[j] >pivot)
            {
                j--; 
            }

            //if i is still to the left of or equal to j 
            //then swap the values at those indices
            if (i<=j)
            {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                //move the pointers past the swapped elements 
                i++; 
                j--; 
            }
        }
        //recursively sort both parittions 

        //left side
        if (low <j)
        {
            quicksort(array, low, j); 
        }

        //right side 
        if(high > i)
        {
            quicksort(array, i, high); 
        }

    }
}