class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        //edge case 1; if s1 is longer then s2 a permutation cannot fit inside s2
        if(s1.length()> s2.length())
        {
            return false; 
        }
        //track char counts for all 26 lowercase english letters
        int[] targetcounts=new int[26]; 
        int[] windowcounts= new int[26]; 

        //populate target counts from from s1 and initial window counts of s2
        for(int i =0; i<s1.length(); i++)
        {
            //increment target freqency count for char in s1 
            targetcounts[s1.charAt(i)-'a']++;
            //inc window counts for char in s2
            windowcounts[s2.charAt(i)-'a']++; 

        }

        //count how many of the 26 characters currently match in exact frequency 
        int matches = 0; 
        for(int i =0; i<26; i++)
        {
            if(targetcounts[i]==windowcounts[i])
            {
                matches++; 
            }
        }
        //check if the initial window already matches all 26 characters 
        if(matches ==26)
        {
            return true; 
        }

        //left boundary of the fixed sized sliding window 
        int left = 0; 

        //slide the window across s2 one character at a time 
        for(int right =s1.length(); right<s2.length(); right++)
        {
            //find right index for charater entering the window on the right 
            int rightindex= s2.charAt(right) -'a'; 
            //expand right side of window by adding character to window counts 
            windowcounts[rightindex]++; 

            //update match count for right character 
            if(windowcounts[rightindex]== targetcounts[rightindex])
            {
                matches++; 
            }
            else if(windowcounts[rightindex]==targetcounts[rightindex]+1)
            {
                matches--; 
            }

            //find index for character leaving window on the left 
            int leftindex = s2.charAt(left)-'a'; 
            //shrink left side of the window ; remove character from window counts 
            windowcounts[leftindex]--; 

            //update match count for the left character
            if(windowcounts[leftindex] == targetcounts[leftindex])
            {
                matches++; 
            }
            else if(windowcounts[leftindex]==targetcounts[leftindex]-1)
            {
                matches --; 
            }

            //move left pointer forward to maintain window length of s1.length
            left++; 

            //if all 26 characters have equal frequencies; we found a valid permutation
            if (matches ==26)
            {
                return true; 
            }

        }
        //no valid permutation found after clearing all windows 
        return false; 
        
    }
}
