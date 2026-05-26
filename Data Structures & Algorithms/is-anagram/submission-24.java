class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        //if lengths dont match then they cnanot be anagrams 
        if(s.length() !=t.length())
        {
            return false; 
        }

        //create hashmap to store character count s
        HashMap<Character, Integer> counts = new HashMap<>(); 

        //step 1; count  characters in string s
         for (int i = 0; i< s.length(); i++)
         {
            char character = s.charAt(i); 

            //check if character is alrady inside the map 
            if (counts.containsKey(character))
            {
                //if it exists then get the current count 
                //and add 1 to it 
                int current_count = counts.get(character); 
                counts.put(character, current_count +1); 
            }
            else
            {
                //if it doenst exist then make the count 1 
                counts.put(character, 1); 
            }

         }
        //step 2 ; subtract the characters in string t 
        for (int i = 0; i<t.length(); i++)
        {
            char character = t.charAt(i); 

            //if t contains a character that was never in string s 
            if (!counts.containsKey(character))
            {
                return false; 
            }

            //get the current count from the map and decrement 
            int current_count = counts.get(character); 
            counts.put(character, current_count-1); 

            //if the count drops before 0 , then t has more copies
            //then the string s has 
            if (counts.get(character)<0)
            {
                return false; 
            }
        }

        //processed both strings then all character counts are identical 
        return true; 
    }
}
