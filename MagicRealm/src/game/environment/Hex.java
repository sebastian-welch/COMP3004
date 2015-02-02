package game.environment;

import java.awt.Point;

public class Hex{
	private int radius = 1;
	private int size = radius * 2;
	private int horiz = size * (3/4); //Horizontal distance between hexagons
	private int height = (int)(Math.sqrt(3)/2 * size); //Also the vertical distance
	
	//For coordinates we'll be using an axial coordinate system.
	 
	private int x; //x position on the grid
	private int y; //y position on the grid
	private int z; //z position on the grid
	
	private Point centre = new Point();

	public Hex(){
		
	}
	
	//Returns the corner starting at the rightmost corner
	public Point getCorner(Point hexCentre, int size, int cornerNum){
		double angle = (2 * Math.PI) / (6 * cornerNum);
		
		return new Point((int) (hexCentre.x + size * Math.cos(angle)),
				 		 (int)(hexCentre.y + size * Math.sin(angle)));
	}
	
	public int getRaddius() { return radius; }
	public int size()       { return size;   }
	public int getHoriz()   { return horiz;  }
	public int getVert()    { return height; }
	public Point getCentre(){ return centre; }
}