class Solution {
    public int search(int[] nums, int target) {
        //O(N) -> search through nums to find target
        //O(LogN) -> Binary search
            //Array is in 2 parts
            //left side (acending part 1)
            //right side (acending part 2)
            //we need to find if target is in left side or right
        
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {                       // left half is sorted
                if (nums[l] <= target && target < nums[m]) r = m - 1;
                else l = m + 1;
            } else {                                        // right half is sorted
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
        }
}
