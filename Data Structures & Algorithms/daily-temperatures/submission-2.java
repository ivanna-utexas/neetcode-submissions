class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //o(n^2) implementation
        // int[] warmer = new int[temperatures.length];
        // for(int curr = 0; curr < temperatures.length - 1; curr++) {
        //     int w = curr + 1;
        //     while(w < temperatures.length && temperatures[curr] >= temperatures[w]) {
        //         w++;
        //     }
        //     if(w < temperatures.length && temperatures[curr] < temperatures[w]) {
        //         warmer[curr] = w - curr;
        //     } else {
        //         warmer[curr] = 0; 
        //     }
        // }
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return res;

    }
}
