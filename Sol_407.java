import java.util.*;

class Sol_407 {
    private static class Cell {
        int row, col, height;
        Cell(int r, int c, int h) {
            row = r; col = c; height = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m == 0) return 0;
        int n = heightMap[0].length;
        if (n == 0) return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        // Step 1: Push all boundary cells
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int trapped = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: Process cells from heap
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int[] d : dirs) {
                int nr = cell.row + d[0];
                int nc = cell.col + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                trapped += Math.max(0, cell.height - heightMap[nr][nc]);
                pq.offer(new Cell(nr, nc, Math.max(heightMap[nr][nc], cell.height)));
            }
        }
        return trapped;
    }
}
