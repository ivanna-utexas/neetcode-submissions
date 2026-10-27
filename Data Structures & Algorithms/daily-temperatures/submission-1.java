class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] warmer = new int[temperatures.length];
        for(int curr = 0; curr < temperatures.length - 1; curr++) {
            int w = curr + 1;
            while(w < temperatures.length && temperatures[curr] >= temperatures[w]) {
                w++;
            }
            if(w < temperatures.length && temperatures[curr] < temperatures[w]) {
                warmer[curr] = w - curr;
            } else {
                warmer[curr] = 0; 
            }
        }
        return warmer;
    }
}
