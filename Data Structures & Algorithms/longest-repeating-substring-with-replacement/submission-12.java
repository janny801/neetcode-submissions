class Solution {
    public int characterReplacement(String s, int k) 
    {
        if (s.length()==0)
        {
            //edge case 1; length of string 0 
                //longest can be 0 -> return 
            return 0; 
        }
        if (k>= s.length())
        {
            //edge case 2; k is greater then all chars can be replaced -> return s.length
            return s.length(); 
        }
        int left =0; 
        int[] charcount= new int[26]; 
        int frequency =0; 
        int maxwindow = 0; 
        for (int right =0; right< s.length(); right++)
        {
            char currentchar = s.charAt(right); 
            int charindex = currentchar - 'A'; 
            charcount[charindex]++; 
            frequency = Math.max(frequency, charcount[charindex]); 

            
            while ((right-left+1)- frequency > k)
            {
                char leftchar = s.charAt(left); 
                charcount[leftchar-'A']--; 
                left++; 
            }
            //update max window 
            maxwindow = Math.max(maxwindow, right-left+1); 


        }
        return maxwindow; 
        
    }
}
