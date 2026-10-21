class Solution {
    public int characterReplacement(String s, int k) 
    {
        if(s.length() ==0)
        {
            return 0; 
        }
        if (s.length()<=k)
        {
            return s.length(); 
        }
        int[] charcount = new int[26];
        int left = 0; 
        int maxfrequency =0; 
        int maxwindow =0; 
        
        for(int right = 0; right < s.length(); right++)
        {
            char currentchar = s.charAt(right); 
            int charindex = currentchar-'A'; 

            //increment character count 
            charcount[charindex]++;
            
            //update frequency 
            maxfrequency = Math.max(maxfrequency, charcount[charindex]); 

            while((right -left+1) - maxfrequency > k)
            {
                //while then k then we remove char at left 
                char leftchar = s.charAt(left); 
                charcount[leftchar-'A']--; 
                left++; 
            }
            maxwindow = Math.max(maxwindow, right - left +1); 


        }
        return maxwindow; 
    }
}
