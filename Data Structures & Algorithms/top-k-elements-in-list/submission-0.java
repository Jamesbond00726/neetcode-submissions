class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for (int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        while (k>0){
            int maxFreq=-1;
            int maxElement=-1;
            for (int key:map.keySet()){
              if (map.get(key)>maxFreq){
                  maxFreq=map.get(key);
                   maxElement =key;
                }
            }
            list.add(maxElement);
            map.remove(maxElement);
            k--;
        }
        int []ans=new int[list.size()];
        for (int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
