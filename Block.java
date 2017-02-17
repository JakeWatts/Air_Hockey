//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{


	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y, int wid, int ht, Color col){
		xPos=x;
		yPos=y;
		width=wid; height=ht; color=col;
	}
	public Block(int x, int y, int wid, int ht){
		xPos=x;
		yPos=y;
		width=wid; height=ht; color=Color.BLACK;
	}
	public Block(int x, int y){
		xPos=x; yPos=y; width=25; height=25; color=Color.BLACK;
	}
	
	public int getX(){
		   return xPos;
	   }
	public int getY(){
		   return yPos;
	   }
	public int getWidth(){
		   return width;
	   }
	public int getHeight(){
		   return height;
	   }
	public Color getColor(){
		return color;
	}
	
	
	
	
	
	
	
   //add the other set methods
	public void setPos(int x, int y){
		xPos=x;
		yPos=y;
	}
   public void setX(int x){
	   xPos=x;
   }
   public void setY(int y){
	   yPos=y;
   }
   public void setWidth(int w){
	   width=w;
   }
   public void setHeight(int h){
	   height=h;;
   }

   public void setColor(Color col)
   {
	   color = col;

   }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
	public boolean equals(Object obj)
	{
		Block a= (Block) obj;
		return a.getX()==getX()&&a.getY()==getY();



	}   

   //add the other get methods
    

   //add a toString() method  - x , y , width, height, color
	public String toString(){
		return xPos+" " +yPos+" "+width+ " "+height+" "+color;
	}
}