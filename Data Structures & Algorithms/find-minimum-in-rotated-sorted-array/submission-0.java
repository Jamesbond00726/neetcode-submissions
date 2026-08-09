class Solution {
    public int findMin(int[] nums) {
        int pivot=pivot(nums);
        if (pivot==nums.length-1) return nums[0];
        else return nums[pivot+1];
    }
    private int pivot(int[] nums){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if (mid < r && nums[mid]>nums[mid+1]) return mid;
            if (mid>l && nums[mid]<nums[mid-1]) return mid-1;
            if (nums[l]>=nums[mid]) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}
