class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups ={}

        for word in strs: 
            #frequency array for the 26 chars
            count = [0] * 26 
            for char in word: 
                index= ord(char) - ord('a')
                count[index]+=1

            #convert count array to tuple 
            key = tuple(count) 

            #add word to corresponding group  
            if key in groups: 
                #
                groups[key].append(word) 
            else: 
                #if not add new group 
                groups[key] = [word]
        #return the groups map 
        return list(groups.values())
        