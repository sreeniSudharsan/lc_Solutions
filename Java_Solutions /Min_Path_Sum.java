class Solution {
   public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    
    // Create a memoization matrix to store the minimum path sum for each cell
    int[][] memo = new int[m][n];
    for (int[] row : memo) {
        Arrays.fill(row, -1);
    }
    
    // Call the helper function to find the minimum path sum
    return minPathSum(grid, 0, 0, memo);
}

private int minPathSum(int[][] grid, int i, int j, int[][] memo) {
    int m = grid.length;
    int n = grid[0].length;
    
    // Check if we have already calculated the minimum path sum for this cell
    if (memo[i][j] != -1) {
        return memo[i][j];
    }
    
    // Base case: we have reached the bottom right corner
    if (i == m - 1 && j == n - 1) {
        memo[i][j] = grid[i][j];
        return memo[i][j];
    }
    
    // Calculate the minimum path sum by moving right and down
    int rightSum = Integer.MAX_VALUE;
    int downSum = Integer.MAX_VALUE;
    if (j < n - 1) {
        rightSum = minPathSum(grid, i, j + 1, memo);
    }
    if (i < m - 1) {
        downSum = minPathSum(grid, i + 1, j, memo);
    }
    
    // Store the minimum path sum for this cell in the memoization matrix
    memo[i][j] = Math.min(rightSum, downSum) + grid[i][j];
    
    // Return the minimum path sum
    return memo[i][j];
}
}
