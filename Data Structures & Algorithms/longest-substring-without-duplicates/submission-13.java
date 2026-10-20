class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        Set<Character> charset = new HashSet<>(); 
        int left =0; 
        int maxlength =0; 

        for (int right =0; right <s.length(); right++)
        {
            char currchar = s.charAt(right); 
            while(charset.contains(currchar))
            {
                //triggers wen currchar is already in the charset 
                //then removes from the charset until it removes that letter that came up twice in the array 
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
