class Solution {
    public int characterReplacement(String s, int k) 
    {
        //edge case; empty string 
        if(s.length()==0)
        {
            return 0; 
        }
        //edge case; if k is large enough to cover the whole string, return the total length 
        if(k>=s.length())
        {
            return s.length(); 
        }
        int[] charactercounts = new int[26]; //tracks character counts across uppercase english alphabet

        int leftboundary= 0; 
        int maxfrequency = 0; 
        int maxwindowlength=0; 

        //expand right boundary across the string 
        for(int rightboundary=0; rightboundary<s.length(); rightboundary++)
        {
            char currentcharacter = s.charAt(rightboundary); 
            int charindex = currentcharacter -'A'; 

            //increment frequency count for current character 
            charactercounts[charindex]++;

            //update highest frequency observed in any character within the current window 
            maxfrequency = Math.max(maxfrequency, charactercounts[charindex]); 

            //window length; rightboundary-leftboundary+1
            //number of chars to replace = window length -maxfrequency
            //if replacements needed exceeds 'k' - the window is invalid -> shrink from the left side 
            while((rightboundary-leftboundary+1) - maxfrequency > k )
            {
                //shrink the window from the left side
                char leftcharacter = s.charAt(leftboundary); 
                charactercounts[leftcharacter - 'A']--; 
                leftboundary++; 
            }
            //get max valid window size 
            maxwindowlength = Math.max(maxwindowlength, rightboundary-leftboundary+1); 
        }
        return maxwindowlength; 
        
        
    }
}
