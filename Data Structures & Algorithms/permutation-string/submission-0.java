class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] need = new int[26];
        int[] window = new int[26];
        int len = s1.length();

        for (int i = 0; i < len; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need, window)) return true;

        for (int r = len; r < s2.length(); r++) {
            window[s2.charAt(r) - 'a']++;         // add new char on the right
            window[s2.charAt(r - len) - 'a']--;   // drop old char on the left
            if (Arrays.equals(need, window)) return true;
        }
        return false;
    }
}
