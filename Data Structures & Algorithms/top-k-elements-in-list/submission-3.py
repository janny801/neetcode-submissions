class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {} #(word, frequency) 
        for num in nums: 
            if num in count: 
                count[num]+=1
            else: 
                count[num] =1
        
        #create buckets for putting shit in 
        buckets =[] 
        for i in range(len(nums)+1): 
            buckets.append([])

        #fill in the buckets 
        for num in count: 
            freq= count[num]
            buckets[freq].append(num)

        #find the result to return 
        result =[]
        freq= len(buckets)-1
        while freq>0: 
            for num in buckets[freq]: 
                #add to the results array 
                result.append(num) 
                if len(result) ==k: 
                    return result

            freq-=1