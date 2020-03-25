package answer.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class SurfaceAreaof3dShapesTest {
    private SurfaceAreaof3dShapes surfaceAreaof3dShapes = new SurfaceAreaof3dShapes();

    @Test
    public void surfaceArea() {
        int[][] grid = new int[][]{{1, 0}, {0, 2}};
        assertEquals(16, surfaceAreaof3dShapes.surfaceArea(grid));
    }

    @Test
    public void surfaceArea1() {
        int[][] grid = new int[][]{{2,2,2},{2,1,2},{2,2,2}};
        assertEquals(46, surfaceAreaof3dShapes.surfaceArea(grid));
    }

    @Test
    public void surfaceArea2() {
        int[][] grid = new int[][]{{2}};
        assertEquals(10, surfaceAreaof3dShapes.surfaceArea(grid));
    }


    @Test
    public void getNeighborShapeNum() {
        int[][] grid = new int[][]{{1, 2}, {3, 4}};
        assertEquals(2, surfaceAreaof3dShapes.getNeighborShapeNum(grid, 0, 0));
        assertEquals(3, surfaceAreaof3dShapes.getNeighborShapeNum(grid, 0, 1));
        assertEquals(4, surfaceAreaof3dShapes.getNeighborShapeNum(grid, 1, 0));
        assertEquals(5, surfaceAreaof3dShapes.getNeighborShapeNum(grid, 1, 1));
    }

    @Test
    public void getNeighborShapeNum2() {
        int[][] grid = new int[][]{{1, 0}, {0, 2}};
        assertEquals(0, surfaceAreaof3dShapes.getNeighborShapeNum(grid, 0, 0));
        assertEquals(0, surfaceAreaof3dShapes.getNeighborShapeNum(grid, 0, 1));
        assertEquals(0, surfaceAreaof3dShapes.getNeighborShapeNum(grid, 1, 0));
        assertEquals(0, surfaceAreaof3dShapes.getNeighborShapeNum(grid, 1, 1));
    }
}