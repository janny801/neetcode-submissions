#isalnum() checks if current character is an alphanumeric value 

class Solution:
    def isPalindrome(self, s: str) -> bool:
        left = 0 
        right = len(s)-1 
        #continue checking chars until the two pointers meet or cross 
        while left < right: 
            #skip any character from the left side that is not a letter or a digit 
            while left < right and not s[left].isalnum(): 
                left +=1 
            #skip any char from the right side that is not a letter or a digit 
            while left < right and not s[right].isalnum(): 
                right -=1
            #convert both left and right to lowercase -- check if matching (if they dont then return false) 
            if s[left].lower() != s[right].lower():
                return False
            
            #iterate both pointers 
            #increase left index  , dec right index 
            left +=1 
            right -=1
        
        #if both pointers crossed without finding anything that didnt match 
        #then it is a valid palindrome 
        return True
            


        