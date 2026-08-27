class Solution:

    def encode(self, strs: List[str]) -> str:
        #build encoded string attaching length and delimiter "#"
        encoded = []
        for s in strs: 
            encoded.append(f"{len(s)}#{s}")#formats string to desired format 
            # len(s): gets the length 
            # "#": inserts delimiter after the length 
            # {s}: inserts the original string after the "#"
        return "".join(encoded) #join into one continuous string


    def decode(self, s: str) -> List[str]:
        #parse the encoded string back into the list format (as it was before we had encoded it) 
        result = []
        i=0

        #iterate thru the entire string 
        while i<len(s): 
            #find where the delimiter is "#" in order to get the length of the current string
            j =i
            while s[j] != "#": 
                j+=1
            
            #get the length and slice the string 
            length = int(s[i:j])
            start = j+1 
            end = start + length 
            result.append(s[start:end])

            # move pointer to the next encoded block 
            i = end 
        
        return result 



