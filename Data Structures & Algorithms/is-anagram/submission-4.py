class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #valid anagram (s,t) 

        #edge case; not same size (so cant be anagrams) 
        if len(s) != len(t): 
            return False

        seen ={} #hash map that stores (value, freq) 

        #go thru string 's' and add to seen hashmap 
        for i in s: 
            #if i is in seen increment the frequency 
            if i in seen: 
                seen[i] +=1 
            else: 
                seen[i] =1
        
        #go thru string 't' and -=1 from seen
        for j in t: 
            #if j not in seen then return false
            if j not in seen: 
                return False
            seen[j] -=1
            #if frequencies dont match also return false
            if seen[j] <0: 
                return False
            
        return True
        