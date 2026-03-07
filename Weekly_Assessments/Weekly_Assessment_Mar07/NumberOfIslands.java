class Solution {
  public int numIslands(char[][] grid) {
    int ans = 0;

    for (int i = 0; i < grid.length; ++i)
      for (int j = 0; j < grid[0].length; ++j)
        if (grid[i][j] == '1') {
          bfs(grid, i, j);
          ans++;
        }

    return ans;
  }

  private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  private void bfs(char[][] grid, int row, int col) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] {row, col});
    grid[row][col] = '2'; 
    while (!queue.isEmpty()) {
      final int i = queue.peek()[0];
      final int j = queue.poll()[1];
      for (int[] dir : dirs) {
        final int x = i + dir[0];
        final int y = j + dir[1];
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length)
          continue;
        if (grid[x][y] != '1')
          continue;
        queue.offer(new int[] {x, y});
        grid[x][y] = '2';
      }
    }
  }
}
