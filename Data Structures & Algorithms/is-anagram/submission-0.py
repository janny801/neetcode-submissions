class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #return true if the two strings (s/t) are anagrams of each  other 
        #easy first check ; if lengths differ 
            #then they cannot be anagrams 
        if len(s) != len(t): 
            return False
        
        count ={} #hash map 
            #stores ( character, how many times it appears) 
        
        #count characters in 's' 
        for char in s: 
            if char in count: 
                count[char] +=1
            else: 
                #if not add to hashmap with seen value of 1
                count[char] =1

        #subtract counts using t
        for char in t: 
            if char not in count: 
                return False

            count[char]-=1

            if count[char]<0: 
                return False

        #all counts match 
        return True