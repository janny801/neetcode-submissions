class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        //edge case 1; s1 is longer then s2 
        if(s1.length() > s2.length())
        {
            return false; 
        }
        //track charcounts for all 26 lowercase english characters for both strings
        int[] s1counts = new int[26]; 
        int[] s2counts = new int[26]; 

        //populate s1 counts from s1 and initial window of s2 
        for(int i =0; i< s1.length(); i++)
        {
            //increment freq for char in s1 and s2 
            s1counts[s1.charAt(i)-'a']++; 
            s2counts[s2.charAt(i)-'a']++; 
        }
        //count how many of the 26 chars currently match in exact freq 
        int matches = 0; 
        for(int i =0; i<26; i++)
        {
            if(s1counts[i]==s2counts[i])
            {
                matches++; 
            }
        }
        //check if initial window alreday matches for all 26 characters 
        if(matches==26)
        {
            return true; 
        }
        
        //left boundary of the fixed size sliding window 
        int left =0; 

        //slide the window across s2 one character at a time 
        for(int right = s1.length(); right<s2.length(); right++)
        {
            //find right index for character entering the window on the right
            int rightindex = s2.charAt(right)-'a'; 
            //expand right side of the window by adding character to s2 counts
            s2counts[rightindex]++;

            //update match count for right character 
            if(s1counts[rightindex]==s2counts[rightindex])
            {
                matches++; 
            }
            else if(s1counts[rightindex]==s2counts[rightindex]+1)
            {
                matches--; 
            }

            //find index for character leaving the window on the left 
            int leftindex = s2.charAt(left) -'a'; 
            //shrink left side of the window --> remove character from s2 counts 
            s2counts[leftindex]--; 

            //udpate match count for the left characer 
            if(s1counts[leftindex]==s2counts[leftindex])
            {
                matches++; 
            }
            else if(s1counts[leftindex]==s2counts[leftindex]-1)
            {
                matches --; 
            }

            //move left pointer forward to maintain the proper window length of s1.length();
            left++; 

            //if all 26 characters match then we have equal frequencies ; valid permutation in string 
            if(matches ==26)
            {
                return true; 
            }
        }
        //no valid permutaitons found after clearing all windows 
        return false; 
    }
}
