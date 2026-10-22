class Solution {
    public int characterReplacement(String s, int k) 
    {
        if(s.length()==0)
        {
            return 0; 
        }
        if(k>=s.length())
        {
            return s.length(); 
        }
        int left= 0; 
        int[] charcount = new int[26]; 
        int maxfreq= 0; 
        int maxwindow=0; 
        for(int right =0; right<s.length(); right++)
        {
            //get current char 
            char currentchar = s.charAt(right); 
            //find index
            int charindex= currentchar -'A'; 
            //update charcount 
            charcount[charindex]++;
            //udpate max freq
            maxfreq = Math.max(maxfreq, charcount[charindex]);

            //initialize current window and chars to replace
            int currwindow = right - left +1; 
            int charstoreplace = currwindow - maxfreq; 

            //if k < then chars to replace then we have to shift the window right by removing the left most char in window 
            while(charstoreplace> k )
            {
                //find left char 
                char leftchar= s.charAt(left); 
                //find char index
                int leftindex= leftchar- 'A'; 
                //dec char count 
                charcount[leftindex]--; 
                //move left over 
                left++; 
                //udpate currwindow and charstoreplace
                currwindow = right-left +1; 
                charstoreplace = currwindow - maxfreq; 
            }
            //update max window 
            maxwindow = Math.max(maxwindow, currwindow); 
        }
        return maxwindow; 
        
    }

}
