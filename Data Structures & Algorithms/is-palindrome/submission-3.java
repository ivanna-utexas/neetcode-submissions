class Solution {
    public boolean isPalindrome(String s) {
        String current = s.toLowerCase();
        int right = 0;
        int left = s.length() - 1;
        while(right < left && right < s.length() && left >= 0) {
            if(!Character.isLetterOrDigit(current.charAt(right))) {
                right++;
                continue;
            }
            if(!Character.isLetterOrDigit(current.charAt(left))) {
                left--;
                continue;
            }
            if(current.charAt(right) != current.charAt(left)) {
                return false;
            }
            right++;
            left--;
        }
        return true;
    }
}
