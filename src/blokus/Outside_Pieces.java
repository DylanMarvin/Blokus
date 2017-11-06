
package blokus;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class Outside_Pieces extends Piece{
    
    Outside_Pieces(Color color, Block block){
        super(color, block,0,0);
    }
    
    public void drawAll(){
        
    }
    
    public static void drawPlayerNames(int xpos,int ypos,double rot,Graphics g,Player name){
        g.translate(xpos,ypos);
        
        
        
        g.translate(-xpos,-ypos);
    }
    
    public static void drawPiece1(int xpos,int ypos,double rot,Graphics g){
        g.translate(xpos,ypos);
        
        g.setColor(Color.BLACK);
        int xvals4[] = {400,400,600,600,400};          
        int yvals4[] = {400,200,200,400,400};
        System.out.println("Test");       
        g.fillPolygon(xvals4,yvals4,xvals4.length);
        
        g.translate(-xpos,-ypos);
    }
    public void drawPiece2(){
        
    }
    public void drawPiecei3(){
        
    }
    public void drawPiecei4(){
        
    }
    public void drawPiecei5(){
        
    }
    public void drawPieceV3(){
        
    }
    public void drawPieceL4(){
        
    }
    public void drawPieceL5(){
        
    }
    public void drawPieceT4(){
        
    }
    public void drawPieceT5(){
        
    }
    public void drawPieceO(){
        
    }
    public void drawPieceW(){
        
    }
    public void drawPieceU(){
        
    }
    public void drawPieceX(){
        
    }
    public void drawPieceP(){
        
    }
    public void drawPieceY(){
        
    }
    public void drawPieceF(){
        
    }
    public void drawPieceN(){
        
    }
    public void drawPieceZ4(){
        
    }
    public void drawPieceZ5(){
        
    }
    public void drawPieceV5(){
        
    }    
}
