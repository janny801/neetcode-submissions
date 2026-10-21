class Solution {
    public int characterReplacement(String s, int k) 
    {
        //edge case; string is empty 
        if(s.length() ==0)
        {
            return 0; 
        }
        if(k>=s.length())
        {
            return s.length(); 
        }
        int[] charactercounts = new int[26];
        int left =0; 
        int maxfrequency =0; 
        int maxwindowlength =0; 
        for(int right =0; right<s.length(); right++)
        {
            char currentcharacter = s.charAt(right); 
            int charindex = currentcharacter - 'A'; 

            //inc frequency count for current character 
            charactercounts[charindex]++; 

            //update highest frequency observed within current window 
            maxfrequency = Math.max(maxfrequency, charactercounts[charindex]); 

            while((right-left+1)>k)
            {
                //if replacements needed is more then k then shorten the window 
                char leftcharacter= s.charAt(left); 
                charactercounts[leftcharacter-'A']--; 
                left++; 
            }
            maxwindowlength = Math.max(maxwindowlength, right-left+1); 
        }
        return maxwindowlength; 
    }
}
