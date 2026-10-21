class Solution {
    public int characterReplacement(String s, int k) 
    {
        //edge case; length of s is 0 
        if(s.length()==0)
        {
            return 0; 
        }
        //edge case ; k is larger then length of string 
        if(k>=s.length())
        {
            return s.length(); 
        }
        int left=0; 
        int[] charcounts = new int[26]; 
        int maxfrequency =0; 
        int maxwindowlength=0; 
        for(int right=0; right<s.length(); right++)
        {
            char currentcharacter = s.charAt(right); 
            int charindex = currentcharacter - 'A'; 
            //increment count 
            charactercount[charindex]++; 

            //update max frequency 
            maxfrequency = Math.max(maxfrequency, charactercount[charindex]); 

            while((right-left+1)-maxfrequency > k )
            {
                char leftchar = s.charAt(left); 
                charactercount[leftchar-'A']--; 
                left++; 
            }
            maxwindowlength = Math.max(maxwindowlength, right-left+1); 
        }
        return maxwindowlength; 


        
    }
}
