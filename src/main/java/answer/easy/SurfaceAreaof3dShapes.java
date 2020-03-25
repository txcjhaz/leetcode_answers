package answer.easy;

/**
 * 892. 三维形体的表面积
 */
public class SurfaceAreaof3dShapes {

    public int surfaceArea(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j] > 0)
                    res += 4 * grid[i][j] + 2 - getNeighborShapeNum(grid, i, j);
            }
        }

        return res;
    }

    /**
     * 过于复杂，其实只要考虑来自四个方向的影响就行了，而不需要每个点看四周的影响，要从整体下手
     */
    public int getNeighborShapeNum(int[][] grid, int x, int y) {
        if (grid.length == 1)
            return 0;

        int curNum, topNum, downNum, leftNum, rightNum;
        curNum = grid[x][y];  // 当前方位有多少方块
        if (x > 0 && y > 0 && x < grid.length - 1 && y < grid.length - 1) {
            topNum = grid[x - 1][y]; // 上边方位有多少方块
            downNum = grid[x + 1][y]; // 下边方位有多少方块
            leftNum = grid[x][y - 1]; // 左边方位有多少方块
            rightNum = grid[x][y + 1];// 右边方位有多少方块
        } else if (x == 0 && y > 0 && y < grid.length - 1) {
            topNum = 0; // 上边方位有多少方块
            downNum = grid[x + 1][y]; // 下边方位有多少方块
            leftNum = grid[x][y - 1]; // 左边方位有多少方块
            rightNum = grid[x][y + 1];// 右边方位有多少方块
        } else if (x == grid.length - 1 && y > 0 && y < grid.length - 1) {
            topNum = grid[x - 1][y]; // 上边方位有多少方块
            downNum = 0; // 下边方位有多少方块
            leftNum = grid[x][y - 1]; // 左边方位有多少方块
            rightNum = grid[x][y + 1];// 右边方位有多少方块
        } else if (y == 0 && x > 0 && x < grid.length - 1) {
            topNum = grid[x - 1][y]; // 上边方位有多少方块
            downNum = grid[x + 1][y]; // 下边方位有多少方块
            leftNum = 0; // 左边方位有多少方块
            rightNum = grid[x][y + 1];// 右边方位有多少方块
        } else if (y == grid.length - 1 && x > 0 && x < grid.length - 1) {
            topNum = grid[x - 1][y]; // 上边方位有多少方块
            downNum = grid[x + 1][y]; // 下边方位有多少方块
            leftNum = grid[x][y - 1]; // 左边方位有多少方块
            rightNum = 0;// 右边方位有多少方块
        } else if (x == 0 && y == 0) {
            topNum = 0; // 上边方位有多少方块
            downNum = grid[x + 1][y]; // 下边方位有多少方块
            leftNum = 0; // 左边方位有多少方块
            rightNum = grid[x][y + 1];// 右边方位有多少方块
        } else if (x == 0 && y == grid.length - 1) {
            topNum = 0; // 上边方位有多少方块
            downNum = grid[x + 1][y]; // 下边方位有多少方块
            leftNum = grid[x][y - 1]; // 左边方位有多少方块
            rightNum = 0;// 右边方位有多少方块
        } else if (x == grid.length - 1 && y == 0) {
            topNum = grid[x - 1][y]; // 上边方位有多少方块
            downNum = 0; // 下边方位有多少方块
            leftNum = 0; // 左边方位有多少方块
            rightNum = grid[x][y + 1];// 右边方位有多少方块
        } else {
            topNum = grid[x - 1][y]; // 上边方位有多少方块
            downNum = 0; // 下边方位有多少方块
            leftNum = grid[x][y - 1]; // 左边方位有多少方块
            rightNum = 0;// 右边方位有多少方块
        }

        int res = 0;
        res += Math.min(curNum, leftNum);
        res += Math.min(curNum, rightNum);
        res += Math.min(curNum, topNum);
        res += Math.min(curNum, downNum);

        return res;
    }
}
