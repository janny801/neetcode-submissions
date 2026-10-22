class Solution {
    public int characterReplacement(String s, int k) 
    {
        //edge case 1; length of string is 0 - return 0 since nothing can be replaced and that is the longest 
        if(s.length()==0)
        {
            return 0; 
        }
        //edge case 2; k>=length of string - return length of string since all characters can be replaced
        if (k>=s.length())
        {
            return s.length(); 
        }
        //initialize variables 
        int left=0; 
        int maxfrequency=0; //holds the frequency count of the most frequent character 
        int maxwindow =0; //stores the length of the longest valid substring 
        int[] charactercount = new int[26]; //holds the amt that each character occurs 

        //expand right boundary of the sliding window across the string 
        for(int right =0; right< s.length(); right++)
        {
            //find current character and its index  
            char currentcharacter = s.charAt(right); 
            int characterindex = currentcharacter - 'A'; 
            //increment frequency 
            charactercount[characterindex]++; 
            //update the max frequency 
            maxfrequency = Math.max(maxfrequency, charactercount[characterindex]); 

            //initialize variables for the current window we are looking at and the amt of characters that need to be replaced 
            int currentwindow = right - left +1; 
            int characterstoreplace = currentwindow - maxfrequency; 
            
            //if the characters that need to be replaced is less than k - then shrink the window from the left side 
            while(k> characterstoreplace)
            {
                char leftcharacter = s.charAt(left); 
                int leftcharacterindex = leftcharacter-'A'; 
                //decrement the character count for that character 
                charactercount[leftcharacterindex]--; 
                //move left pointer over 
                left ++; 

                //udpate the currentwindow and the characters to replace 
                currentwindow = right - left + 1; 
                characterstoreplace = currentwindow - maxfrequency; 
            }
            //update the max valid window that can be replaced with 'k' 
            maxwindow = Math.max(maxwindow, currentwindow); 
        }
        //return maximum valid window length 
        return maxwindow; 
        
    }
}
