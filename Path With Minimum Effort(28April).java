// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

// Example 1:

// Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
// Output: 2
// Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
// This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
// Example 2:

// Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
// Output: 1
// Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
// Example 3:

// Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
// Output: 0
// Explanation: This route does not require any effort.

// Constraints:

// rows == heights.length
// columns == heights[i].length
// 1 <= rows, columns <= 100
// 1 <= heights[i][j] <= 106

class Solution {
    public int minimumEffortPath(int[][] heights) {
        // Index Values
        final int ROW = 0, COL = 1, EFFORT = 2;
        // Size of array
        final int rows = heights.length;
        final int cols = heights[0].length;
        // Movement options
        final int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        // Keep track of visited vertices
        // Space Complexity O(mn)
        boolean visited[][] = new boolean[rows][cols];
        // Keep best value seen - initialize to MAX_INT
        // Space Complexity O(mn)
        // Time Complexity O(mn)
        int[][] best = new int[rows][cols];
        for (int[] b : best)
            Arrays.fill(b, Integer.MAX_VALUE);
        // Priority Queue for Lowest Path
        Queue<int[]> queue = new PriorityQueue<>((int[] v1, int[] v2) -> v1[EFFORT] - v2[EFFORT]);
        // Put starting vertex into queue
        best[0][0] = 0;
        queue.add(new int[] { 0, 0, 0 });
        // Iterate over priority queue
        // Time Compelxity up to O(mnlog(mn)) as we potentially iterate over all
        // vertices and each vertex is added to priority queue.
        // Space Complexity of Priority Queue is O(mn) and so add and remove times are
        // O(log(mn))
        while (!queue.isEmpty()) {
            // Get Lowest Cost Node
            int[] vertex = queue.remove();
            // Ignore if already seen
            if (visited[vertex[ROW]][vertex[COL]])
                continue;
            // Get current effort
            int effort = vertex[EFFORT];
            // Check if reached end
            if (vertex[ROW] == rows - 1 && vertex[COL] == cols - 1)
                return effort;
            // Mark vertex as visited
            visited[vertex[ROW]][vertex[COL]] = true;
            // Check cost of move to adjacent vertex
            for (int[] delta : deltas) {
                // Calculate row and column of adjacent node
                int row = vertex[ROW] + delta[ROW];
                int col = vertex[COL] + delta[COL];
                // Only proceed if valid row/column and not previously visited
                if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
                    // Effort is related to max height difference
                    int veffort = Math.max(effort, Math.abs(heights[row][col] - heights[vertex[ROW]][vertex[COL]]));
                    // If we already have a lower effort for this vertex then no need to add it to
                    // priority queue
                    // because it is already inthe queue with a lower cost
                    if (veffort < best[row][col]) {
                        best[row][col] = veffort;
                        queue.add(new int[] { row, col, veffort });
                    }
                }
            }
        }
        return 0;
    }
}