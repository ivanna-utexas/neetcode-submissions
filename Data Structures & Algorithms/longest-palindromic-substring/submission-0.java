class Solution {
    public String longestPalindrome(String s) {
        int longestLength = -1;
        int longestIndex = -1;
        for(int i = 0; i < s.length(); i++) {

            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);

            int currLength = Math.max(odd, even);
            
            if(longestLength < currLength) {
                longestLength = currLength;
                longestIndex = i - ((longestLength - 1) / 2);
            }
            
        }
        return s.substring(longestIndex, longestIndex + longestLength);
    }
    private int expand(String s, int left, int right) {
        while(left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
            }
        return right - left - 1;
    }
}
