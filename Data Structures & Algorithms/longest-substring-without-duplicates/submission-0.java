//find length of the longest substring without duplicate characters 
class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        //edge case; empty string has no chars - so return length 0 
        if(s ==null || s.length() ==0)
        {
            return 0; 
        }
        //set to store unique characters in current sliding window 
        Set<Character> charset = new HashSet<>(); 
        int left =0; //left pointer of sliding window
        int maxlength =0; //track the max length of a substring without duplicates 
        //expand right side of window character by character 
        for(int right = 0; right<s.length(); right++)
        {
            char currentchar= s.charAt(right); 
            while(charset.contains(currentchar))
            {
                //while there is a duplicate of the current character 
                //shrink the window from the left by removing characters until the duplicate is gone 
                charset.remove(s.charAt(left)); 
                left++; 
            }
            //add new unique character into the set 
            charset.add(currentchar); 

            //udpate maxlength if current window is larger 
            int currlength = right-left+1; 
            maxlength = Math.max(maxlength, currlength); 
        }
        return maxlength; 
        
    }
}
