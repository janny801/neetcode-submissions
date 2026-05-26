class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups ={}

        for word in strs: 
            count =[0] * 26
            for char in word: 
                index = ord(char) - ord('a') 
                count[index]+=1

            key = tuple(count) 

            #add to correct corresponding group 
            if key in groups: 
                groups[key].append(word)
            else: 
                groups[key] = [word]
        return list(groups.values())
        