class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> dupes = new HashMap<>();
        for(int num : nums) {
            if(dupes.get(num) != null) return true;
            dupes.put(num, 0);
        }
        return false;
    }
}