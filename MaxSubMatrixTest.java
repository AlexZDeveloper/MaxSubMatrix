import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSubMatrixTest 
{
    @Test
    public void smallMatrixTest()
    {
    	int[][] arr = new int[1][1];
    	arr[0][0] = 1;
    	MaxSubMatrix maxSubMatrix = new MaxSubMatrix(arr);
    	maxSubMatrix.calculate();    	
        assertEquals(1, maxSubMatrix.getSum());
        MaxSubMatrix.Coord[] targetCoords = new MaxSubMatrix.Coord[] {
        		new MaxSubMatrix.Coord(1, 1), 
        		new MaxSubMatrix.Coord(1, 1)
        		};
        
        MaxSubMatrix.Coord[] coords = maxSubMatrix.getCoords();
        assertEquals(targetCoords[0], coords[0]);
        assertEquals(targetCoords[1], coords[1]);
    }
    
    @Test
    public void matrixTest()
    {
    	int[][] arr = new int[][] {{ -1, -2, -3 },
    		{ 1, 1, -4 },
    		{ 1, 1, -5 }};
    	MaxSubMatrix maxSubMatrix = new MaxSubMatrix(arr);
    	maxSubMatrix.calculate();    	
        assertEquals(4, maxSubMatrix.getSum());
        MaxSubMatrix.Coord[] targetCoords = new MaxSubMatrix.Coord[] {
        		new MaxSubMatrix.Coord(2, 1), 
        		new MaxSubMatrix.Coord(3, 2)
        		};
        
        MaxSubMatrix.Coord[] coords = maxSubMatrix.getCoords();
        assertEquals(targetCoords[0], coords[0]);
        assertEquals(targetCoords[1], coords[1]);
    }
    
    
    
    @Test
    public void matrixTest_2()
    {
    	int[][] arr = new int[][] {
    		{14, 25, 87, 23, -20, -10, -10},
        	{14, 25, 87, 23, -20, -10, -10},
        	{14, 25, 87, 23, -20, -10, -10},
        	{14, 25, 87, 23, -20, -10, -10},
        	{14, 25, 87, 23, -20, -10, -10},
        	{14, 25, 87, 23, -20, -10, -10},
        	{14, 25, 87, 23, -20, -10, -10},
        	{14, 25, 87, 23, -20, -10, -10},
        	{14, 25, 87, 23, -20, -10, -10},
        	{14, 25, 87, 23, -300, -10, -10}};
    	MaxSubMatrix maxSubMatrix = new MaxSubMatrix(arr);
    	maxSubMatrix.calculate();    	
        assertEquals(1490, maxSubMatrix.getSum());
        MaxSubMatrix.Coord[] targetCoords = new MaxSubMatrix.Coord[] {
        		new MaxSubMatrix.Coord(1, 1), 
        		new MaxSubMatrix.Coord(10, 4)
        		};
        
        MaxSubMatrix.Coord[] coords = maxSubMatrix.getCoords();
        assertEquals(targetCoords[0], coords[0]);
        assertEquals(targetCoords[1], coords[1]);
    }
    
}
