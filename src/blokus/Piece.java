
package blokus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Piece{
      public static enum Block {
      ONE,TWO,THREE,F,T,V,Z,W,U,L,I,X,P,Y,N,SHORTT,SHORTZ,SQAURE,CROOKED3,SHORTI,SHORTL
    }; 
      
       private Color color;
        private int random;
        private Block block;
          Piece(Color _color,Block _block)
    {
        color = _color;
        block = _block;
        random = (int)(  Math.random()*4 + 1 );

    }
            Color getColor()
    {
        return (color);
    }
    int getRandom()
    {
        return (random);
    }

    public void draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta) {
        
        g.setColor(color); 
        g.fillRect(Window.getX(column*xdelta),
        Window.getY(row*ydelta),xdelta,ydelta);
         g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.drawString("" + random, Window.getX(column*xdelta)+30,
        Window.getY(row*ydelta)+35);
    }
    public void one(Graphics2D g,int row,int column,
    int xdelta,int ydelta){
         g.setColor(color); 
        g.fillRect(Window.getX(column*xdelta),
        Window.getY(row*ydelta),xdelta,ydelta);
         g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.drawString("" + random, Window.getX(column*xdelta)+30,
        Window.getY(row*ydelta)+35);
    }
}
