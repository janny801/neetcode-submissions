class Solution {
    public String minWindow(String s, String t) 
    {
        //edge case; target string is longer then source string 
        if(t.length()> s.length())
        {
            return ""; 
        }

        //track char freq counts for both uppercase and lowercase english letters
        int[] scounts = new int[26]; 
        int[] tcounts = new int[26]; 

        //populate required character frequencies from t and determine the total unique characters needed
        int requiredmatches =0; 
        for(int i =0; i< t.length(); i++)
        {
            char currentchar = s.charAt(i); 
            if(tcounts[currentchar]==0)
            {
                //track how many unique characters from t must be satisified in s
                requiredmatches++; 
            }
            tcounts[currentchar]++;
        }

        int matches = 0; //unique characters that currently meet or have more then the required frequnecy in 't' 

        //track starting index and minimum length of the smallest valid window found 
        int minwindowlength = Integer.MAX_Value; 
        int minwindowstart = 0; 

        int left =0; //left boundary of dynamic sliding window 

        //expand right boundary of the sliding window across 's' one character at a time 
        for(int right=0; right< s.length(); right++)
        {
            //find right char and its ascii value 
            char rightchar = s.charAt(right); 

            //expand right side of the window by adding character to scounts
            scounts[rightchar]++; 

            //update match count for right character 
            if(tcounts[rightchar]>0 && scounts[rightchar]== tcounts[rightchar])
            {
                //now there is the same frequency for this right character - after adding it to the freq count for the new character coming on the right 
                matches ++; 
            }

            //when all required characters from t are satisfied, try to shrink the window from the left 
            while(matches ==requiredmatches)
            {
                int currwindowlength = right -left+1; 

                //update minimum valid window 
                if(currwindowlength< minwindowlength)
                {
                    minwindowlength = currwindowlength; 
                    minwindowstart = left; 
                }

                //find char leaving the window on the left 
                char leftchar = s.charAt(left); 

                //check match status before removing the character on the left 
                if(tcounts[leftchar]>0 && scounts[leftchar] == tcounts[leftchar])
                {
                    //we already had the exact frequency , but now there is not enough after removing the character leaving on the left side 
                    matches --; 
                }

                //shrink left side of the window ; remove character from scounts 
                scounts[leftchar]--;

                //move left pointer over to shrink the window 
                left++; 
            }
        }
        //if no valid window was found thru the entire traversal then return empty string 
        if(minwindowlength==Integer.MAX_VALUE)
        {
            return ""; 
        }
        //return shortest valid substring from s
        return s.substring(minwindowstart, minwindowstart + minwindowlength); 

        
    }
}
