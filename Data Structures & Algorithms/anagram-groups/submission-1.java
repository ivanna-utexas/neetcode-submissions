class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        
        //loop through Strings strs 
        for(String s : strs) {
            int[] chars = new int[26];
            for(Character c : s.toCharArray()) {
                chars[c - 'a']++;
            }
            //count is alphabetical
            ans.putIfAbsent(Arrays.toString(chars), new ArrayList<>());
            ans.get(Arrays.toString(chars)).add(s);
        }

        return new ArrayList<>(ans.values());
    }

}
