
package blokus;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Board {
    private final static int NUM_ROWS = 20;
    private final static int NUM_COLUMNS = 20;  
    private final static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    
    Board(){
        
    }
    
    public static void Reset(){
        for (int zrow=0;zrow<Board.NUM_ROWS;zrow++)
        {
            for (int zcolumn=0;zcolumn<Board.NUM_COLUMNS;zcolumn++)
            {               
                 board[zrow][zcolumn] = null;
            }
        }
    }
    
    public static void AddPiecePixel(int xpixel,int ypixel) {       
        
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;

        int zcol = 0;
        int zrow = 0;
        
        zcol = (xpixel-Window.getX(0))/xdelta;
        zrow = (ypixel-Window.getY(0))/ydelta;
     
        
        
            if (true != (xpixel-Window.getX(0) > 0 && ypixel-Window.getY(0) > 0 && xpixel-Window.getX(0) < xdelta*NUM_COLUMNS && ypixel-Window.getY(0) < ydelta*NUM_ROWS))
            {                

                {                                      
//                    board[zrow][zcol] = new Piece(Color.black);
                }
                     
            }
    }

    public static void CheckWin() {

    }
          
    public static void Draw(Graphics2D g){
        //Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/Board.NUM_ROWS;
        int xdelta = Window.getWidth2()/Board.NUM_COLUMNS;
        
 //draw grid
        g.setColor(Color.black);
        for (int zi = 1;zi<Board.NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<Board.NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        
        for (int zrow=0;zrow<Board.NUM_ROWS;zrow++)
        {
            for (int zcolumn=0;zcolumn<Board.NUM_COLUMNS;zcolumn++)
            {                                              
                if (Board.board[zrow][zcolumn] != null)
                {
                    board[zrow][zcolumn].draw(g, xdelta, ydelta, zcolumn, zrow);
                    
                }  
            }
        }      
        
    }
}
