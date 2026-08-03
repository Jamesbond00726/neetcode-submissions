class Solution {
    public int longestConsecutive(int[] nums) { 
        Set<Integer> set=new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int maxLen=0;
        for (int s:set){
            if (!set.contains(s-1)){
                int count=1;
                int cur=s;
                while (set.contains(cur+1)){
                    cur++;
                    count++;
                }
                maxLen=Math.max(count,maxLen);
            }
        }
        return maxLen;
    }
}
