class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String s: strs){
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String result=new String(chars);
            if(!map.containsKey(result)){
                map.put(result,new ArrayList<>());
            }
            map.get(result).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
