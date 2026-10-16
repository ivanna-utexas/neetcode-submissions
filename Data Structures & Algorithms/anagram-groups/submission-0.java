class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        int[] touched = new int[strs.length];

        for(int i = 0; i < strs.length; i++) {
            if(touched[i] == 1) continue;
            touched[i] = 1;  
            ArrayList<String> amagrams = new ArrayList<>(); 
            amagrams.add(strs[i]);         
            for(int j = 0; j < strs.length; j++) {
                if(touched[j] != 1 && anagram(strs[i], strs[j])) {
                    touched[j] = 1;
                    amagrams.add(strs[j]);
                }
            }
            groups.add(amagrams);
        }
        return groups;
    }

    private boolean anagram(String one, String two) {
        if(one.length() != two.length()) return false;
        int[] diff = new int[27];

        for(int i = 0; i < one.length(); i++) {
            diff[one.charAt(i) - 'a']++;
            diff[two.charAt(i) - 'a']--;
        }

        for(int j = 0; j < diff.length; j++) {
            if(diff[j] != 0) return false;
        }

        return true;
    }
}
