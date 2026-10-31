class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max-heap: farthest point on top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(dist(b), dist(a))
        );

        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) maxHeap.poll();   // kick out the farthest
        }

        int[][] ans = new int[k][];
        for (int i = 0; i < k; i++) ans[i] = maxHeap.poll();
        return ans;
    }

    private int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];   // squared distance from origin
    }
}