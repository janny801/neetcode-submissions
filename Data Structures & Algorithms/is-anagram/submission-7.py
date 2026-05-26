class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        #edge case ; if lengths of strings arent the same 
        if len(s) != len(t): 
            return False

        seen ={}
        for char in s: 
            if char in seen: 
                seen[char] += 1
            else: 
                seen [char ]=1
        for char in t: 
            #if not in seen return false else decrement 
            if char not in seen: 
                return False
            else: 
                seen[char]-=1
            
            #check if frequency less than 0 
            if seen[char] <0 : 
                return False

        return True
        