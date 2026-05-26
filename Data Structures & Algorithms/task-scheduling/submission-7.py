import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = {}
        for task in tasks: 
            if task in count: 
                count[task]+=1
            else: 
                count[task]=1
        heap = [] # implemented as max heap 
        for task in count: 
            heapq.heappush(heap, -count[task]) # push the negative 
        cooldown = [] # (remaining left of same task, time can be pushed back to heap for execution)
        time = 0
        while heap or cooldown: 
            time += 1
            #check if there is task that we can execute 
            if heap: 
                count = heapq.heappop(heap) 
                count += 1
                if count != 0: 
                    #then add to cooldown 
                    cooldown.append((count, time + n))
            # check cooldown list if there is something that can be added back to heap
                # for execution 
            i = 0 
            while i < len(cooldown): 
                if cooldown[i][1] == time: 
                    # add back to heap and remove from cooldown list 
                    heapq.heappush(heap, cooldown[i][0])
                    cooldown.pop(i)
                else: 
                    i += 1
        return time