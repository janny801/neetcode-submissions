class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //edge case 1; lenght of s1 is longer then s2 
        if(s1.length() > s2.length())
        {
            return false; 
        }
        //track char freq counts for both s1 and s2 
        int[] s1counts = new int[26]; 
        int[] s2counts = new int[26]; 

        //populate freq for s1 and initial window for s2 
        for(int i =0; i<s1.length(); i++)
        {
            s1counts[s1.charAt(i)-'a']++; 
            s2counts[s2.charAt(i)-'a']++; 
        }
        //ocunt matches for initial window 
        int matches =0; 
        for(int i =0; i<26; i++)
        {
            if(s1counts[i] ==s2counts[i])
            {
                matches++; 
            }
        }
        if(matches ==26)
        {
            return true; 
        }

        int left = 0; 
        //move sliding window across s2 one character at a time 
        for(int right =s1.length(); right<s2.length; right++)
        {
            int rightindex= s2.charAt(right)-'a'; 

            //expand right side of window by adding character to s2 count s
            s2counts[rightindex]++; 

            //update match counter for right character 
            if(s1counts[rightindex] == s2counts[rightindex])
            {
                matches++; 
            }
            else if(s1counts[rightindex] == s2counts[rightindex]-1)
            {
                matches--; 
            }

            int leftindex = s2.charAt(left)-'a'; //index for character leaving on the left side of the window
            //shrink left side of the window; remove char from s2 counds
            s2counts[leftindex]--; 

            //update match counter 
            if(s1counts[leftindex]==s2counts[leftindex])
            {
                matches++; 
            }
            else if(s1counts[leftindex] == s2counts[leftindex] +1)
            {
                matches--; 
            }

            left++; 

            if(matches ==26)
            {
                return true; 
            }
        }
        return false; 
        
    }
}
