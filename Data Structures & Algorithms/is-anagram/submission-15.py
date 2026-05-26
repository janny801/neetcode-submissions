class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #edge case ; if length of strings are not the same 
        if len(s) != len(t): 
            return False
        seen = {} #stores num-> value 
        #add to map based on string 's' 
        for char in s: 
            if char in seen: 
                seen[char]+=1
            else: 
                seen[char]=1
        
        #remove from the hashmap based on string 't' 
        for char in t: 
            #if current char not in seen 
            #then it is impossible for the strings to be an anagram 
            if char not in seen: 
                return False
            seen[char]-=1
            if seen[char] <0: 
                return False
        return True
        