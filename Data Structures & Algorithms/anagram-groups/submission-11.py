class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #solve using hashmap 
        groups={}
        for word in strs: 
            count = [0] * 26
            for char in word: 
                index = ord(char) - ord('a')
                count[index]+=1
            #convert count to tuple since python
            key = tuple(count) 
            #add to corresponding group
            if key in groups: 
                #add word to that group
                groups[key].append(word)
            else: 
                groups[key] = [word]
        #return 
        return list(groups.values())