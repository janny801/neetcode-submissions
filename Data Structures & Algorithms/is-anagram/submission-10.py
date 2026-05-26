class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #solve using hash map 
        #edge case; if lengths dont match cant be anagram 
        if len(s) != len(t):
            return False
        seen = {} #(key, frequency occurs)

        #add to seen based on string s 
        for char in s: 
            #if in seen then increment
            if char in seen: 
                seen[char]+=1
            else: 
                #if not seen add it to seen and set char
                seen[char]=1 
        
        #remove using string t
        for char in t: 
            if char not in seen: 
                return False
            else: 
                seen[char]-=1
            
            #edge case; if frequency goes before 0 -- false
            if seen[char]<0: 
                return False
        return True
        