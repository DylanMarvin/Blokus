
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
        private int row;
        private int column;
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

    public void draw(Graphics2D g,int _row,int _column,int xdelta,int ydelta) {
        row = _row;
        column = _column;
        g.setColor(color); 
        g.fillRect(Window.getX(column*xdelta),
        Window.getY(row*ydelta),xdelta,ydelta);
         g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.drawString("" + random, Window.getX(column*xdelta)+30,
        Window.getY(row*ydelta)+35);
            
    }
   public void one(Piece board[][]){
       board[row][column] = this;
   }
    public void two(Piece board[][]){
       board[row][column] = this;
        board[row+1][column] = this;
   }
      public void three(Piece board[][]){
       board[row][column] = this;
        board[row+1][column] = this;
          board[row+2][column] = this;
   }
        public void F(Piece board[][]){
       board[row][column] = this;
        board[row-1][column] = this;
          board[row][column+1] = this;
            board[row][column-1] = this;
             board[row+1][column+1] = this;
   }
}
