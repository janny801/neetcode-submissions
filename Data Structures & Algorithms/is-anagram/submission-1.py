class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #if strings not the same length 
            #then they cannot be anagrams of each other

        if len(s) != len(t) : 
            return False

        seen = {} #hash map(char, amt its been seen) 

        #add to hashmap with string 's' first 
        for char in s: 
            #if in seen increment count 
            if char in seen: 
                seen[char]+=1
            else: 
                seen[char] =1
        
        #remove from string 't' based on seen hashmap 
        for char in t: 
            #if char not in seen return false
            if char not in seen: 
                return False
            seen[char]-=1 #decrement each time 

            #if seen[char] <0 ; return false 
            if seen[char]<0: 
                return False

        return True

        