class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<int[]> cells = new ArrayList<>();

        // Step 1: Collect all coordinates (r, c) in the matrix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cells.add(new int[]{r, c});
            }
        }

        // Step 2: Sort the list based on Manhattan distance from (rCenter, cCenter)
        cells.sort((a, b) -> {
            int distA = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int distB = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return distA - distB; // Sort in increasing order of distance
        });

        // Step 3: Convert List<int[]> to int[][] array to return
        int[][] result = new int[cells.size()][2];
        for (int i = 0; i < cells.size(); i++) {
            result[i] = cells.get(i);
        }

        return result;
    }
}
