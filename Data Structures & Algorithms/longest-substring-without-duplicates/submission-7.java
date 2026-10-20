class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        //edge case if the string length is 0 
        if (s.length()==0)
        {
            return 0; 
        }
        int left = 0; 
        int maxlength =0; 
        Set<Character> charset = new HashSet<>(); 
        for(int right =0; right<s.length(); right++)
        {
            char currentchar= s.charAt(right); 
            while(charset.contains(currentchar))
            {
                //skip until the current char is no longer there 
                charset.remove(s.charAt(left)); 
                left++; 
            }
            //add new unique char to charset 
            charset.add(currentchar); 

            //update max lengths 
            int currentlength = right - left +1; 
            maxlength = Math.max(currentlength, maxlength); 
        }
        return maxlength; 
        
    }
}
