class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        Set<Character> charset = new HashSet<>(); 
        int left =0; 
        int maxlength =0; 
        if (s.length()==0)
        {
            return 0; 
        }
        for(int right =0; right<s.length(); right++)
        {
            char currentchar = s.charAt(right); 
            while(charset.contains(currentchar))
            {
                charset.remove(s.charAt(left)); 
                left++; 
            }
            //add new unique char to charset
            charset.add(currentchar); 
            //update lengths 
            int currentlength = right -left+1; 
            maxlength = Math.max(currentlength, maxlength); 
        }
        return maxlength; 
        
    }
}
