class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #edge case 
        if len(s) != len(t): 
            return False
        seen ={}# (value-> index) 
        #add to seen map based on string s 
        for char in s: 
            if char in seen: 
                seen[char]+=1
            else: 
                seen[char]=1

        
        #remove from seen map based on string t 
        for char in t: 
            if char not in seen: 
                return False
            seen[char]-=1
            #edge case ; freq< 0 
            if seen[char]<0: 
                return False
        
        return True

