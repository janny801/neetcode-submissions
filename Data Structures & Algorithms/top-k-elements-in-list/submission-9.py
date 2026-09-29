class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {} #maps; number -> frequency it appears
        for num in nums: 
            #fill in the count hashmap based on appearance
            if num in count: 
                count[num] +=1
            else: 
                count[num]=1


        #index = frequency appears in nums 
        # value = list of numbers with that frequency
        bucket = [] 
        for num in count: 
            freq= count[num]
            bucket[freq].append(num) #add num in index that matches frequency 
        
        #fill in result and return 
        result = []
        freq= len(bucket)-1
        while freq>0: #iterate backwards thru possible frequencies
            for num in bucket[freq]: 
                #check that specific frequency 
                result.append(num) 
                if len(result) ==k: 
                    return result 
            freq-=1

            
        
        