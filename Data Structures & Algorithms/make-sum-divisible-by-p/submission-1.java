class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = (int)(total % p);

        if (target == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            int rem = (int)(prefix % p);

            int needed = (rem - target + p) % p;

            if (map.containsKey(needed)) {
                int len = i - map.get(needed);

                if (len < nums.length) {
                    ans = Math.min(ans, len);
                }
            }

            map.put(rem, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}