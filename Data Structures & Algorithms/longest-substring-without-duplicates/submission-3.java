class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length() ==0)
        {
            return 0; 
        }
        int left = 0; 
        Set<Character> charset = new HashSet<>(); 
        int maxlength =0; 
        for(int right =0;right<s.length(); right++)
        {
            char currentchar= s.charAt(right); 
            while(charset.contains(currentchar))
            {
                //remove and iterate
                charset.remove(s.charAt(left)); 
                left++; 
            }
            //add new unique char to set 
            charset.add(currentchar); 

            //find new max length 
            int currentlength = right - left +1; 
            maxlength = Math.max(currentlength, maxlength); 
        }
        return maxlength; 
        
    }
}
