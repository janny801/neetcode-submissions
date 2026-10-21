class Solution {
    public int characterReplacement(String s, int k) 
    {
        //edge case 1; if string length is 0 
        if(s.length()==0){
            return 0; 
        }
        //edge case 2; if k >= the length of the string s 
        if (k>=s.length())
        {
            return s.length(); 
        }
        int left = 0; 
        int[] charactercount = new int[26]; 
        int maxfrequency=0; 
        int maximumwindow =0; 
        
        for (int right = 0; right< s.length(); right++)
        {
            char currentcharacter = s.charAt(right); 
            int charindex = currentcharacter -'A'; 
            charactercount[charindex]++; 
            
            //update max frequency
            maxfrequency = Math.max(maxfrequency, charactercount[charindex]); 

            while((right-left+1)- maxfrequency > k )
            {
                char leftchar =s.charAt(left); 
                charactercount[leftchar-'A']--; 
                left++; 
            }
            maximumwindow = Math.max(maximumwindow, right - left+1); 
            

            
        }
        return maximumwindow; 
        
    }
}
