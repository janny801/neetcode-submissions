class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        //edge case; empty string has no chars so return length of 0 
        if(s.length ==0)
        {
            return 0; 
        }
        Set<Character> charset = new HashSet<>(); 
        int left = 0; 
        int maxlength =0; 
        for(int right = 0; right<s.length(); right++)
        {
            char currentchar = s.charAt(right); 
            while(charset.contains(currentchar))
            {
                //while the set has the current char then we remove from set and skip 
                charset.remove(s.charAt(left)); 
                left++; 
            }
            //add new unique character into the set 
            charset.add(currentchar); 
            int currlength = right - left +1; 
            maxlength = Math.max(currlength, maxlength); 
        }
        return maxlength; 
    }
}
