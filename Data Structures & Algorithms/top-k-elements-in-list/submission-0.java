class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int n = 0; n < nums.length; n++) {
            int count = freq.getOrDefault(nums[n], 0);
            count++;
            freq.put(nums[n], count);
        }
        int[] answer = new int[k];
        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort((a, b) -> Integer.compare(freq.get(b), freq.get(a)));
        for (int i = 0; i < k; i++) answer[i] = keys.get(i);
        return answer;
    }
}
