class minheap: 
    def __init__(self): 
        self.heap=[]
    
    def size(self): 
        return len(self.heap)
    
    def peek(self): 
        if not self.heap: 
            return None
        return self.heap[0]
    
    def push(self,value): 
        self.heap.append(value) #add value to the end of the list 
        #keeps it as a complete binary tree, but ordering might be incorrect
        
        i = len(self.heap)-1


        #check while the node is not the root 
        while i> 0: 
            parent = (i-1)//2 

            #if child smaller then parent (bubble up) 
            if self.heap[i]< self.heap[parent]:
                #swap child and parent 
                self.heap[i], self.heap[parent] = self.heap[parent], self.heap[i]

                #move up to the parent index and continue 
                i = parent 
            else: 
                break #parent <= child already 

    def pop(self): 
        #remove and return smallest element (root) 
        if not self.heap: 
            return None 
        #if only one element remove and return 
        if len(self.heap)==1: 
            return self.heap.pop()

        top = self.heap[0] #save the root 
        self.heap[0] = self.heap.pop()

        i=0 #bubble down to restore the minheap properties
        while True: 
            #find the indices of the left and right children 
            left = 2*i+1
            right = 2*i+2
            #assume current node is the smallest for now 
            smallest = i 

            if left<len(self.heap) and self.heap[left]<self.heap[smallest]: 
                smallest = left 
            if right<len(self.heap)and self.heap[right]<self.heap[smallest]: 
                smallest = right
            
            if smallest !=i: 
                #there is a smaller child so swap 
                self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
                i = smallest 
            else: 
                #current node is smaller then both children so we done 
                break
        return top #returns original root 
             



class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        #k = largest element that we want to track 
        self.k = k 
        #keep a minheap of size k 
        self.minheap = minheap()
        
        #add initial numbers 
        for n in nums: 
            self.add(n) 
        

    def add(self, val: int) -> int:
        #add new value to the heap 
        self.minheap.push(val) 

        #if heap gets bigger then 'k' -> remove smallest value 
        if self.minheap.size() > self.k: 
            self.minheap.pop()
        
        return self.minheap.peek()
        
