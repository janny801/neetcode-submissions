class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}#map ; number-> frequency 
        for num in nums: 
            if num in count: 
                count[num]+=1
            else:
                count[num]=1

        bucket=[]
        #fill in bucket with empty [] for now 
        for i in range(len(nums)+1): 
            bucket.append([])
        #fill in bucket with values based on count 
        for num in count: 
            freq= count[num]
            bucket[freq].append(num)
        
        #fill in result and return 
        result = []
        freq= len(bucket)-1
        while freq> 0: 
            for num in bucket[freq]: 
                result.append(num) 
                if len(result) ==k: 
                    return result
            freq-=1