package game.environment.hex;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class HexGrid {
	
	private Hex[][] lGrid; //DO NOT ACCESS GRID VIA ARRAY, USE GET METHOD
	private Hex lCenterHex;
	private int lRadius;
	private Dimension lCanvasSize;
	
	public HexGrid(int aRadius, Dimension aCanvasSize){
		lRadius = aRadius;
		lGrid = new Hex[(2*aRadius)+1][(2*aRadius)+1];
		
		for(int y = 0; y < (2*aRadius)+1; y++){
			for(int x = 0; x < (2*aRadius)+1; x++){
				lGrid[x][y] = new Hex(x-lRadius,y-lRadius, aCanvasSize);
				if(x == (aRadius) && y == (aRadius)){
					lCenterHex = lGrid[x][y];
				}
			}
		}
		lCanvasSize = aCanvasSize;
	}
	
	//NOTE: Converts x-y array to a fictional grid with negative x and y coords
	public Hex getHex(int aX, int aY){
		return lGrid[aX+(lRadius)][aY+(lRadius)];
	}
	
	
	public void drawGrid(Graphics g, Dimension aCanvasSize, Point aMouse){
		for(int y = -lRadius; y <= lRadius; y++ ){
			for(int x = -lRadius; x <= lRadius; x++){
				getHex(x,y).drawHex(x,y,g, aCanvasSize, aMouse);
			}
		}
		
		//DrawSelected
		for(int y = -lRadius; y <= lRadius; y++ ){
			for(int x = -lRadius; x <= lRadius; x++){
				getHex(x,y).drawSelectedHex(x,y,g, aCanvasSize, aMouse);
			}
		}
	}

	public Dimension getCanvasSize() {
		return lCanvasSize;
	}

	
	
	


}