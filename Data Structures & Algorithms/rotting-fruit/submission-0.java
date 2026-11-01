class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int time = 0;

    public int orangesRotting(int[][] grid) {
        //BFS level order
        //we also need to keep track of the amount of fruit and the amount of rotton in order to see if   the whole grid became rotton
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) q.add(new int[]{r, c});   // all sources at once
                else if (grid[r][c] == 1) fresh++;
            }
        }

        int time = 0;
        while (!q.isEmpty() && fresh > 0) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {              // one minute = one level
                int[] cur = q.poll();
                for (int[] d : directions) {
                    int nr = cur[0] + d[0], nc = cur[1] + d[1];
                    if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS
                        && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }

}
