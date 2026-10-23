class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        prefix[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        postfix[nums.length - 1] = 1;
        for(int j = nums.length - 2; j >= 0; j--) {
            postfix[j] = nums[j + 1] * postfix[j + 1];
        }

        int[] ans = new int[nums.length];
        for(int w = 0; w < ans.length; w++) {
            ans[w] = prefix[w] * postfix[w];
        }
        return ans;
    }
}  
