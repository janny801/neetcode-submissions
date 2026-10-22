class Solution {
    public String minWindow(String s, String t) 
    {
        //edge case ; target strign is longer than source string
        if(t.length()> s.length())
        {
            return ""; 
        }

        //char freq counts for uppercase and lowercase chars 
        int[] scounts= new int[128];
        int[] tcounts = new int[128]; 

        //populate required char frequencies from t and find total unique chars needed 
        int requiredmatches =0; 
        for(int i =0; i< t.length(); i++)
        {
            char currentchar = t.charAt(i); 
            if(tcounts[currentchar]==0)
            {
                //track how many unique characters from 't' must be satisfied in s
                requiredmatches++; 
            }
            tcounts[currentchar]++; 
        }

        //track how many unique characters currently meet or have more than the required frequency in t 
        int matches =0; 

        //track starting index and min length of smallest valid window found 
        int minwindowlength = Integer.MAX_VALUE; 
        int minwindowstart = 0; 

        int left =0; //left boudnary of dynamic sliding window 

        //expand right boundary of the sliding iwndow across s one char at a time 
        for(int right =0; right< s.length(); right++)
        {
            //find right char 
            char rightchar = s.charAt(right); 
            //expand right side 
            scounts[rightchar]++; 

            //udpate match counts for right char 
            if(tcounts[rightchar]>0 && scounts[rightchar]==tcounts[rightchar])
            {
                //now have same freq for char at right pointer
                matches++; 
            }

            //when all required chars from t are satisfied in s; shrink the window from teh left 
            while(matches==requiredmatches)
            {
                int currwindowlength = right - left+1; 
                //update min valid window 
                if(currwindowlength< minwindowlength)
                {
                    minwindowlength=currwindowlength; 
                    minwindowstart = left; 
                }

                //char on left 
                char leftchar = s.charAt(left); 
                //check match status before removing 
                if(tcounts[leftchar]>0 && scounts[leftchar]==tcounts[leftchar])
                {
                    //already had exact freq
                    //now not enough after removing 
                    matches--; 
                }

                //shrink left side fo window ; remove char from s counts 
                scounts[leftchar]--; 

                left++; //move left ptr to shrink window
            }
        }
        //no valid window found then return empty string
        if(minwindowlength == Integer.MAX_VALUE)
        {
            return ""; 
        }
        //return shortest substring 
        return s.substring(minwindowstart, minwindowstart+ minwindowlength); 



        
    }
}
