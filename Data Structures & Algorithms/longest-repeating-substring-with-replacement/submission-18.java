class Solution {
    public int characterReplacement(String s, int k) 
    {
        //edge case 1; length of string is 0 -> so return 0 
        if(s.length()==0)
        {
            return 0; 
        }
        //edge case 2; length of string is less than k 
        //return the length of the string since all characters can be replaced
        if(k>=s.length())
        {
            return s.length(); 
        }
        //initialize variables 
        int left = 0; 
        int maxfreq=0; //stores the count of the majority character appears in a window (only updates when the window expands on the right)
        int[] charcount = new int[26]; //array that holds the count a character appears in the current window 
        int maxwindow =0; 

        //expand the right boundary of the sliding window across the string 
        for(int right =0; right<s.length(); right++)
        {
            char currentcharacter= s.charAt(right); 
            //find index of character 
            int charindex = currentcharacter -'A'; 
            //increment character count 
            charcount[charindex]++; 
            //update frequency 
            maxfreq= Math.max(maxfreq, charcount[charindex]);

            //calculate the current window length and amt of characters that need to be replaced 
            int currentwindowlength = right - left+1; 
            int charstoreplace = currentwindowlength - maxfreq; 

            //if replacements exceed 'k' -> shrink the window from the left side 
            while(charstoreplace > k)
            {
                //find the left character
                char leftcharacter = s.charAt(left); 
                //find index of the left character and decrement 
                charcount[leftcharacter -'A']--; 
                //move the left portion inwards 
                left++; 

                //update currentwindow length and chars to replace 
                currentwindowlength = right - left+1; 
                charstoreplace = currentwindowlength -maxfreq; 
            }
            //update the max window length 
            maxwindow = Math.max(maxwindow, currentwindowlength); 
        }
        return maxwindow; 
        
    }
}
