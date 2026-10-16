class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> record = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            record.put(c, record.getOrDefault(c, 0) + 1);
        }

        for(int j = 0; j < t.length(); j++) {
            Character i = t.charAt(j);
            if(record.get(i) == null || record.get(i) == 0) return false;
            record.put(i, record.getOrDefault(i, 0) - 1);
        }
        for(Character c : record.keySet()) {
            if(record.get(c) != 0) return false; 
        }
        return true;
    }
}
