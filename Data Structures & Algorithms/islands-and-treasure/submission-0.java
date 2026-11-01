class Solution {

    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        //put all treasure chests in a queue
        //traverse the queue using bfs adding distances
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> chests = new LinkedList<>();

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 0) {
                    chests.add(new int[]{r, c});
                }
            }
        }

        //bfs to mark the grid
        int distance = 1;
        while(!chests.isEmpty()) {
            int level = chests.size();
            for(int l = 0; l < level; l++) {
                int[] cur = chests.poll();
                for(int[] dir : directions) {
                    int nr = dir[0] + cur[0], nc = dir[1] + cur[1];
                    if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS
                    && grid[nr][nc] == INF) {
                        grid[nr][nc] = distance;
                        chests.add(new int[] {nr, nc});
                    }
                }
            }
            distance++;
        }
    }
}
