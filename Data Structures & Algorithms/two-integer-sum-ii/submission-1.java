class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //numbers -> increasing
        //result must be 1-indexed
        int r = numbers.length - 1;
        int l = 0;
        int[] ans = new int[2];
        while(r > l) {
            if(numbers[r] + numbers[l] > target) {
                r--;
            }
            if(numbers[r] + numbers[l] < target) {
                l++;
            }
            if(numbers[r] + numbers[l] == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                return ans;
            }
        }
        return ans;
    }
}
