class Solution {
    public int findMin(int[] nums) {
        //trivial: find where it stops increasing, that will be smallest -> O(n)
        //bs: -> O(logN)
        //There has to be a solution
        // if nums[m] is < min -> explore that side of array
        // if nums[m] > min -> explore opposite side of array

        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] < nums[r]) r = m;
            else l = m + 1;
        }
        return nums[l];
    }
}
