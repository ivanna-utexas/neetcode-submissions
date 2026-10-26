class Solution {
    public int maxArea(int[] heights) {
        int r = heights.length - 1;
        int l = 0;
        int max = 0;
        while(r > l) {
            int y = Math.min(heights[r], heights[l]);
            int x = r - l;
            max = Math.max(max, y * x);
            if(heights[r] < heights[l]) {
                r--;
            } else if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
