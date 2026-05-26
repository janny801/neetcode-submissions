class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        //check lengths; if not the smae 
        //then it cannot be an anagram 
        if (s.length() != t.length())
        {
            return false; 
        }

        //frequency counter array for the 26
        //lowercase english letters
        int[] charcount = new int[26]; 
        
        //loop thru btoh strings at the same time 
        for (int i = 0; i< s.length(); i++)
        {
            //increment count for string found in s 
            charcount[s.charAt(i)-'a']++;

            //decrement count for the character found in t
            charcount[t.charAt(i) - 'a']--; 
            
        }
        
        //check the charcounts array 
        //all values should be 0 in order for it to be an anagram 
        for (int count: charcount)
        {
            if (count!=0)
            {
                return false; 
            }
        }
        return true; 
    }
}
