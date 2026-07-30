class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String s : strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String res=new String(c);
            map.putIfAbsent(res,new ArrayList<>());
            map.get(res).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
