import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = {}
        for task in tasks: 
            if task in count: 
                count[task]+=1
            else: 
                count[task]=1
        
        heap = []
        for task in count: 
            heapq.heappush(heap, -count[task]) #push neg (maxheap) 
        cooldown =[] # (remaining count, time can be exec again)
        time = 0
        while heap or cooldown: 
            time +=1
            if heap: 
                #if something in heap 
                #exec and then put in cool down if count != 0 
                count = heapq.heappop(heap) 
                count +=1 #inc to dec count (since insert as neg in heap) 
                if count !=0: 
                    # add to cooldown 
                    cooldown.append((count, time+n)) 
            #check if cooldown has task that can be exec 
            i = 0 
            while i < len(cooldown): 
                if cooldown[i][1] == time: 
                    # add to heap and remove from cooldown 
                    heapq.heappush(heap, cooldown[i][0])
                    cooldown.pop(i)
                else: 
                    i+=1
        return time