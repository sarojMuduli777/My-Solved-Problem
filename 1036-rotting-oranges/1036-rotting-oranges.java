class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-->0) {
                Pair rOrange = queue.remove();
                int row = rOrange.row;
                int col = rOrange.col; 

                // If i hava a frsh orange on above.
                if (row-1 >= 0 && grid[row-1][col] == 1) {
                    grid[row-1][col] = 2;
                    queue.add(new Pair(row-1, col));
                }

                // If i hava a frsh orange down.
                if (row+1 < n && grid[row+1][col] == 1) {
                    grid[row+1][col] = 2;
                    queue.add(new Pair(row+1, col));
                }

                // If i hava a frsh orange on left.
                if (col-1 >= 0 && grid[row][col-1] == 1) {
                    grid[row][col-1] = 2;
                    queue.add(new Pair(row, col-1));
                }

                // If i hava a frsh orange on right.
                if (col+1 < m && grid[row][col+1] == 1) {
                    grid[row][col+1] = 2;
                    queue.add(new Pair(row, col+1));
                }
            }
            level++;
        }

        // Check is their any frsh orange left in grid.
        for (int row[] : grid) {
            for (int orange : row) {
                if (orange == 1) {
                    return -1;
                }
            }
        }

        // If their is no rotten orange then level must be zeor so return 0
        // otherwise return level - 1 because first orange is already rotten.
        return level == 0 ? 0 : --level;
    }
}