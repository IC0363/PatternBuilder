import bridges.connect.Bridges;
import bridges.validation.RateLimitException;

import java.io.IOException;

import bridges.base.Color;
import bridges.base.ColorGrid;

public class Pattern
{

	// SAMPLE PROBLEM: method to draw sample  (use this as a template)
	public static void drawSample(ColorGrid grid, Bridges bridges) throws RateLimitException, IOException {
		//Display a two-eyeballs pattern to the grid (two meager beady eyes -- how lame)
		// first eyeball
		grid.set(5, 6, new Color("yellow"));
		// second eyeball
		grid.set(5, 9, new Color("yellow"));
		// call to the Bridges object called ‘bridges’ -- set the data structure to the Grid type
		bridges.setDataStructure(grid);
		// call to the Bridges object called ‘bridges’ -- show the ColorGrid object called ‘grid’
		bridges.visualize();
	}  // end method drawSample()


    // YOUR METHODS (for problems 1 through 7)  HERE:
    // PROBLEM 1: method to draw horizontal stripes
  public static void drawHorizontalStripes(ColorGrid grid, Bridges bridges, Color color1, Color color2) throws RateLimitException, IOException {
        int numRows = grid.getHeight();
        int numCols = grid.getWidth();
		Color color;

        for (int row = 0; row < numRows; row++) {
            if (row % 2 == 0) {
    			color = color1;
			} else {
    			color = color2;
			}
            for (int col = 0; col < numCols; col++) {
                grid.set(row, col, color);
            }
        }
        bridges.setDataStructure(grid);
        bridges.visualize();
    }

	// PROBLEM 2: method to draw vertical stripes
	public static void drawVerticalStripes(ColorGrid grid, Bridges bridges, Color color1, Color color2) throws RateLimitException, IOException {
        int numRows = grid.getHeight();
        int numCols = grid.getWidth();
		Color color;

        for (int row = 0; row < numCols; row++) {
            if (row % 2 == 0) {
    			color = color1;
			} else {
    			color = color2;
			}

            for (int col = 0; col < numRows; col++) {
                grid.set(col, row, color);
            }
        }
        bridges.setDataStructure(grid);
        bridges.visualize();
    }



	// PROBLEM 3: method to draw checkerboard
	public static void drawCheckerboard(ColorGrid grid, Bridges bridges, Color color1, Color color2) throws RateLimitException, IOException {
        int numRows = grid.getHeight();
        int numCols = grid.getWidth();
		Color color;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
				if ((row + col) % 2 == 0) {
    				color = color1;
				} else {
    				color = color2;
					}	

                grid.set(row, col, color);
            }
        }
        bridges.setDataStructure(grid);
        bridges.visualize();
    }





	// PROBLEM 4: method to draw border
public static void drawBorder(ColorGrid grid, Bridges bridges, Color borderColor, Color interiorColor) throws RateLimitException, IOException {
        int numRows = grid.getHeight();
        int numCols = grid.getWidth();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (row == 0 || row == numRows - 1 || col == 0 || col == numCols - 1) {
                    grid.set(row, col, borderColor);
                } else {
                    grid.set(row, col, interiorColor);
                }
            }
        }
        bridges.setDataStructure(grid);
        bridges.visualize();
    }


	// PROBLEM 5: method to draw X
	public static void drawX(ColorGrid grid, Bridges bridges, Color color1, Color color2) throws RateLimitException, IOException {
		int numRows = grid.getHeight();
		int numCols = grid.getWidth();
		int smallerDimension;
		if (numRows < numCols) {
    		smallerDimension = numRows;
		} else {
    		smallerDimension = numCols;
		}
	
		for (int i = 0; i < smallerDimension; i++) {
			if (i % 2 == 0) {
				grid.set(i, i, color1);
				grid.set(numRows - 1 - i, i, color2);
			} else {
				grid.set(i, i, color2);
				grid.set(numRows - 1 - i, i, color1);
			}
			if (i == numRows - 1 - i && numRows == numCols) { 
				grid.set(i, i, color1);
			}
		}
		bridges.setDataStructure(grid);
		bridges.visualize();
	}
	
	




	// PROBLEM 6: method to draw diagonal split
	public static void drawDiagSplit(ColorGrid grid, Bridges bridges, Color color1, Color color2) throws RateLimitException, IOException {
		int numRows = grid.getHeight();
		int numCols = grid.getWidth();
		for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (col <= row) {
                    grid.set(row, col, color1);
                } else {
                    grid.set(row, col, color2);
                }
            }
        }
        bridges.setDataStructure(grid);
        bridges.visualize();
    }


	


	// PROBLEM 7: method to draw 4 quadrants
	public static void drawQuadrants(ColorGrid grid, Bridges bridges, Color color1, Color color2, Color color3,Color color4) throws RateLimitException, IOException {
	int numRows = grid.getHeight();
	int numCols = grid.getWidth();
	
	int midRows = numRows/2;
	int midCols = numCols/2;

	for(int row = 0; row<numRows; row++){
		for(int col =0; col<numCols;col++){
			if(row<midRows && col<midCols){
				grid.set(row,col,color1);
			}
			else if(row<midRows && col >= midCols){
				grid.set(row,col,color2);
			}
			else if(row>=midRows && col<midCols){
			grid.set(row,col,color3);
			}
			
			else{
				grid.set(row,col,color4);

			}
		}
	}
	bridges.setDataStructure(grid);
	bridges.visualize();


}



}// end class