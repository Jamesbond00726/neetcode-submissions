class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int index=0;
        while (k > 0) {
            int maxFreq =-1, maxElement=-1;
            for (int key : map.keySet()){
                if (maxFreq < map.get(key)){
                    maxFreq= map.get(key);
                    maxElement=key;
                }
            }
            ans[index++]=maxElement;
            map.remove(maxElement);
            k--;
        }
        return ans;
    }
}
