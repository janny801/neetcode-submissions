class Solution {
    public boolean isAnagram(String s, String t) 
    {
        //solve using osrting

        //edge case if they are not the same length 
        if (s.length() != t.length())
        {
            return false; 
        }
        
        //convert both to character arrays so that we can sort them
        char[] s_sorted= s.toCharArray(); 
        char[] t_sorted = t.toCharArray(); 

        //sort both character arrays alphabetically 
        Arrays.sort(s_sorted); 
        Arrays.sort(t_sorted); 

        //Arrays.equal checks if both arrays have the same elements
        //in the same positions 
        return Arrays.equals(s_sorted, t_sorted); 


    }
}
