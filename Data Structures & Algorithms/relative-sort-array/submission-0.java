class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans=new int[arr1.length];
        Map<Integer,Integer> map=new HashMap<>();
        for (int num: arr1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] freq=new int[1000];
        for (int j : arr1) {
            freq[j] = map.get(j);
        }
        int ind=0;
        for (int j : arr2) {
            int n = freq[j];
            int prev=ind;
            while (ind < prev + n) {
                ans[ind] = j;
                ind++;
                freq[j]--;
            }
        }
        if (ind < arr1.length) {
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 0) {
                    int prev=ind;
                    while (ind< prev +freq[i]){
                        ans[ind]=i;
                        freq[i]--;
                        ind++;
                    }
                }
            }
        }
        return ans;
    }
}