class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        //edge case; length of s1 is longer then s2 so s2 cannot have a permutation of s1 
        if(s1.length()> s2.length())
        {
            return false; 
        }
        //track char frequency counts for both s1 and s2 
        int[] s1counts= new int[26]; 
        int[] s2counts = new int[26]; 

        //populate the char frequency count for s1 and initial window for s2 
        for(int i =0; i< s1.length(); i++)
        {
            //increment freq for chars in s1 and s2
            s1counts[s1.charAt(i)-'a']++; 
            s2counts[s2.charAt(i)-'a']++;
        }

        //count matches for the initial window created 
        int matches = 0; 
        for(int i =0; i<26; i++)
        {
            if (s1counts[i]== s2counts[i])
            {
                matches++; 
            }
        }
        //check initial window if frequency count matches for all characters 
        if(matches ==26)
        {
            return true; 
        }

        //initialize left boundary for fixed size sliding window 
        int left =0; 

        //move sliding window across s2 one character at a time 
        for(int right =s1.length(); right<s2.length(); right++)
        {
            //find right index 
            int rightindex= s2.charAt(right)-'a'; 
            //expand right side of the window by adding character to s2 counts
            s2counts[rightindex]++;

            //udpate match count for right character 
            if(s1counts[rightindex]==s2counts[rightindex])
            {
                //now we have the same frequency for this right character 
                //after adding it to the freq count for the new character coming on the right
                matches++; 
            }
            else if(s1counts[rightindex]==s2counts[rightindex]-1)
            {
                //we already had the exact frequency but now there is too much 
                matches --; 
            }

            //find index for character leaving the window on the left 
            int leftindex= s2.charAt(left)-'a'; 
            //shrink left side of the window ; remove character from s2 counts 
            s2counts[leftindex]--; 

            //update match count for the left character 
            if(s1counts[leftindex]==s2counts[leftindex])
            {
                //now we have the same freq for this left character after removing the excess count from the character leaving on the left
                matches++; 
            }
            else if(s1counts[leftindex]==s2counts[leftindex]+1)
            {
                //we already had the exact frequency but now there is not enough after removing the character leaving on the left side of the window 
                matches--; 
            }
            
            //move left pointer 
            left++; 

            //check if all 26 characters now have equal frequencies 
            if(matches ==26)
            {
                return true; 
            }

        }
        //no valid permutations were found 
        return false; 
        
    }
}
