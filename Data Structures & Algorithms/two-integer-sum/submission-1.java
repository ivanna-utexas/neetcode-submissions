class Solution {
    public int[] twoSum(int[] nums, int target) {
       int j = 0;
       int[] output = new int[2];
       for(int i = 0; i < nums.length; i++) {
            j = 0;
            while(j < nums.length) {
                if(i != j && nums[i] + nums[j] == target) {
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
                j++;
            }
       }
       return output;
    }
}
