class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        left = 0 
        longest = 0
        for right in range(len(s)): 
            #remove chars until the duplicate is gone 
            while s[right] in seen: 
                seen.remove(s[left])
                left +=1
            
            #add current char 
            seen.add(s[right])

            #update longest substring 
            longest = max(longest, right - left+1)

        return longest
        