class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : stones) maxHeap.offer(n);

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();   // heaviest
            int x = maxHeap.poll();   // second heaviest
            if (y != x) maxHeap.offer(y - x);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}