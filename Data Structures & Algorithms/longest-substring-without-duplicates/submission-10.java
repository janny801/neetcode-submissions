class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        Set<Character> charset = new HashSet<>(); 
        int left =0; 
        int maxlength =0; 
        if (s.length() ==0)
        {
            //edge case; length 0 will have longest substring length of 0 
            return 0; 
        }
        for (int right =0; right <s.length(); right++)
        {
            char currchar = s.charAt(right); 
            while(charset.contains(s.charAt(left)))
            {
                //checks if there is a character that we have already seen so we can remove from the charset and iterate the pointers
                charset.remove(s.charAt(left)); 
                left++; 
            }
            //add unique character to the set 
            charset.add(currchar); 

            //calc current length and update max length 
            int currlength = right - left+1; 
            maxlength = Math.max(maxlength, currlength); 

        }
        return maxlength; 
        
    }
}
