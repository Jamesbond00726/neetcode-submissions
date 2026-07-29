class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        if (s.length()!=t.length()){
            return false;
        }
        for (char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c:t.toCharArray()){
            if (!map.containsKey(c)){
                return false;
            }
            map.put(c,map.get(c)-1);
            if (map.get(c)<0){
                return false;
            }    
        }
        for (int val:map.values()){
            if (val!=0){
                return false;
            }
        }
        return true;
    }
}
