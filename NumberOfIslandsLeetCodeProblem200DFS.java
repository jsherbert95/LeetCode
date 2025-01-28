class Solution {

    // Declare public rowLength and colLength variables so we can access them across
    // the class.
    public int rowLength;
    public int colLength;

    public int numIslands(char[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;

        // Edge case check, if the grid is null or empty, return 0. Efficiency is key.
        if (grid == null || rowLength == 0 || colLength == 0)
            return 0;

        int islandCounter = 0;

        // Loop through. If the current grid location is a piece of land, perform Depth
        // First Search (DFS) recursively on that cell's right, left, up, and down
        // neighbors.
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    // DFS will explore the entire island, marking all its cells as visited. Once
                    // all recursive DFS calls for this island finish, the recursion stack "pops
                    // out" back to this point, ensuring the entire island is processed before
                    // moving to the next cell.
                    islandCounter++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandCounter;
    }

    private void dfs(char[][] grid, int row, int col) {
        // Base Case: If we go out of bounds or hit water ('0'), stop and return. The
        // base case is always first, and is the condition that tells recursion to stop.
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || grid[row][col] == '0')
            return;
        // Mark the current cell as visited by turning '1' to '0'.
        grid[row][col] = '0';

        // Recursive calls: explore all 4 directions.
        // Each call will check if the neighboring cell is part of the island.
        dfs(grid, row + 1, col); // Move Down
        dfs(grid, row - 1, col); // Move up
        dfs(grid, row, col + 1); // Move Right
        dfs(grid, row, col - 1); // Move Left

        // When all 4 directions are fully explored (all the recursive calls for the
        // current cell are complete), the function naturally returns to the previous
        // call in the stack.
        // This process is called backtracking, where we finish exploring one path and
        // return or "pop back" to the previous call in the stack to explore other
        // unvisited paths.

    }
}
