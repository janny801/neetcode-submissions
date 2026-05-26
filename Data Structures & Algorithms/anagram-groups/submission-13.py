class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #dictionary that hold all anagram groups
        #key ; letter counts for a word 
        #value ; list of words that have those counts 
        groups={}

        #loop thru each word given in input list 
        for word in strs: 
            #initially create a list with 26 zeroes
            #each position represents a letter from a to z
            #value at index i is how many times that letter appears in the word 
            count = [0] *26

            # count the frequency of each letter in the word
            for char in word: 
                #convert the character into an index between 0 and 25
                index = ord(char)- ord('a')
                count[index]+=1#increase the frequency for this specific letter

            #convert the frequency list into a tuple 
            #since they are immutable allowing it to be used as dictionary keys
            #two words that are anagrams will produce the same tuple 
            key = tuple(count) 
            #store the word in the same group that matches its letter frequencies 
            if key in groups: 
                groups[key ] .append(word)
            else:
                groups[key] = [word]
        return list(groups.values())





