class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int middle = left + ((right - left) / 2);
            if(nums[middle] > target) right = middle;
            else left = middle + 1;
        }
        if(left > 0 && nums[left - 1] == target) return left - 1;
        return -1;
    }
}
