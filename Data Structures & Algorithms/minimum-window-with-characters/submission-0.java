class Solution {
    public String minWindow(String s, String t) 
    {
        //edge case ; target string is longer then source string 
        if(t.length()> s.length())
        {
            return ""; 
        }

        //track char frequency counts for both uppercase and lowercase english letters 
        int[] scounts =new int[128]; 
        int[] tcounts = new int[128]; 

        //populate required character frequencies from t and determine total unique characters needed
        int requiredmatches =0; 
        for(int i =0; i<t.length(); i++)
        {
            char currentchar = t.charAt(i); 
            if(tcounts[currentchar]==0)
            {
                //track how many unique characters from t must be satisfied in s 
                requiredmatches++; 
            }
            tcounts[currentchar]++; 
        }
        //track how many unique characters currently meet or have more then the required frequency in t 
        int matches =0; 

        //track the starting index and minimum length of the smallest valid window found 
        int minwindowlength = Integer.MAX_VALUE; 
        int minwindowstart = 0; 

        //left boundayr of dynamic sliding window 
        int left =0; 

        //expand right boundayr of the sliding window across s one character at a time 
        for(int right =0; right<s.length(); right++)
        {
            //find right char and its ascii value 
            char rightchar = s.charAt(right); 

            //expand right side of the window by adding character to scount s
            scounts[rightchar]++;

            //update match count for right character 
            if(tcounts[rightchar]>0 && scounts[rightchar]==tcounts[rightchar])
            {
                //now we have the same frequency for this right character 
                //after adding it to the freq coutn for the new character coming on the right 
                matches++; 
            }

            //when al required characters from t are satisfied try to shrink the window from the left 
            while(matches==requiredmatches)
            {
                int currentwindowlength = right - left+1; 

                //update minimum valid window 
                if(currentwindowlength< minwindowlength)
                {
                    minwindowlength = currentwindowlength; 
                    minwindowstart = left; 
                }

                //find character leaving the window on the left 
                char leftchar = s.charAt(left); 

                //check match status before removing the character from the left 
                if(tcounts[leftchar]>0 && scounts[leftchar]== tcounts[leftchar])
                {
                    //we already had the exact frequency 
                    //but now there is not enough after removing the character leaving on the left side of the window 
                    matches --; 
                }

                //shrink left side of the window; remove character from s counts 
                scounts[leftchar]--; 

                //move left pointer over to shrink the window 
                left++; 
            }
        }
        //if no valid window was found thru the entire traversal -> return empty string 
        if(minwindowlength == Integer.MAX_VALUE)
        {
            return ""; 
        }
        //return the shortest valid substring extracted from s
        return s.substring(minwindowstart, minwindowstart + minwindowlength); 
        
    }
}
