package game.environment.hex;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import config.Config;

public class Hex{
	private boolean active;
	private int radius = 248;
	private int width = radius*2;
	private int innerWidth = (int) (width * 3/4);
	private int height = (int)(Math.sqrt(3)/2 * (radius*2)); //Also the vertical distance
	
	GameHex lGameHex;
	
	//For coordinates we'll be using an axial coordinate system.
	 
	private int x; //x position on the grid
	private int y; //y position on the grid
	
	private int lCenterX; //x Position on the canvas
	private int lCenterY; //y Position on the canvas

	public Hex(int aX, int aY, Dimension aCanvasSize){
		x = aX;
		y = aY;
		active = true;
		if((x < 0 && y < 0 && x + y < -3) || (x > 0 && y > 0 && x + y > 3)){
			active = false;
		}
		
		
		lCenterX = ((int) ((aCanvasSize.getWidth()/2)+(innerWidth*aX)));
		lCenterY = ((int) (aCanvasSize.getHeight()/2)+((height*aY))+(height*aX/2));
		lGameHex = new GameHex();
	}
	
	//Returns the corner starting at the rightmost corner
	public Point getCorner(int cornerNum){

		return new Point((int)(lCenterX+(radius * Math.cos(getAngle(cornerNum)))),
				         (int)(lCenterY+(radius * Math.sin(getAngle(cornerNum)))));
	}
	
	public int getRaddius() { return radius; }
	public int getVert()    { return height; }
	
	
	public void drawHex (int aX, int aY, Graphics g, Dimension aCanvasSize, Point aMouse){
		if(active){
			

			g.drawImage(lGameHex.getTileImage(), lCenterX-(width/2), lCenterY-(height/2)-1, null);
			
			int x[] = getHexXCoords(lCenterX);
			int y[] = getHexYCoords(lCenterY);
				
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(3));
			g2.drawPolygon(x,y,6);
			g2.setStroke(new BasicStroke(1));


			if(Config.drawingHexCoords){
				g.drawString(aX+","+aY,lCenterX, lCenterY);
				g.drawString("1",getCorner(0).x,getCorner(0).y);
			}
			
		}
	}
	
	
	public void drawSelectedHex (int aX, int aY, Graphics g, Dimension aCanvasSize, Point aMouse){
		if(active){
			if(isPointInHex(aMouse, new Point(lCenterX,lCenterY))){
				
				int x[] = getHexXCoords(lCenterX);
				int y[] = getHexYCoords(lCenterY);
				
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(4));
				g2.setColor(Color.red);
				g2.drawPolygon(x,y,6);
				g2.setStroke(new BasicStroke(1));
				g2.setColor(Color.black);

			}
		}
	}
	
	public void drawHexBorder(Graphics g, Dimension aCanvasSize, Point aMouse){
		
	}
	
	private double getAngle(double a){
		double r = ((Math.PI) / 3 * a);
		return r;
	}
	
	private int[] getHexXCoords(int center){
		int[] r = new int[6];
		r[0] = (int)(center+(radius * Math.cos(getAngle(1))));
		r[1] = (int)(center+(radius * Math.cos(getAngle(2))));
		r[2] = (int)(center+(radius * Math.cos(getAngle(3))));
		r[3] = (int)(center+(radius * Math.cos(getAngle(4))));
		r[4] = (int)(center+(radius * Math.cos(getAngle(5))));
		r[5] = (int)(center+(radius * Math.cos(getAngle(6))));
		return r;
	}
	
	private int[] getHexYCoords(int center){
		int[] r = new int[6];
		r[0] = (int)(center+(radius * Math.sin(getAngle(1))));
		r[1] = (int)(center+(radius * Math.sin(getAngle(2))));
		r[2] = (int)(center+(radius * Math.sin(getAngle(3))));
		r[3] = (int)(center+(radius * Math.sin(getAngle(4))));
		r[4] = (int)(center+(radius * Math.sin(getAngle(5))));
		r[5] = (int)(center+(radius * Math.sin(getAngle(6))));
		return r;
	}
	
	public boolean isPointInHex(Point aPoint, Point aCenter){
		if(aPoint.distance(aCenter) > radius){
			return false;
		}
		if(aPoint.getY() > aCenter.getY()+(height/2) || aPoint.getY() < aCenter.getY()-(height/2)){
			return false;
		}
		if(!isLeft(getCorner(2), getCorner(3), aPoint)){
			return false;
		}
		if(!isLeft(getCorner(3), getCorner(4), aPoint)){
			return false;
		}
		if(!isLeft(getCorner(5), getCorner(0), aPoint)){
			return false;
		}
		if(isLeft(getCorner(1), getCorner(0), aPoint)){
			return false;
		}
	
		return true;
	}
	
	private boolean isLeft(Point a, Point b, Point c){
		return ((b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x)) > 0;
	}
	

}