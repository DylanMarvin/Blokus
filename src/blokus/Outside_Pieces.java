package blokus;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D;

public class Outside_Pieces extends Player {

    //Graphics2D g;
    
    Outside_Pieces(int num){
        super(num);
    }

    

    public static void drawPlayerNames(int xpos, int ypos, double rot, Graphics g, Player name) {
        g.translate(xpos, ypos);

        g.translate(-xpos, -ypos);
    }
    
public void drawAll(int xpos, int ypos, Graphics2D g) {
        int gapDistance = 30;

        drawPiece1(xpos,ypos,0,3,3,g);
        drawPiece2(xpos+gapDistance,ypos,0,1,1,g);
        gapDistance+=40;
        drawPiecei3(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=50;
        drawPiecei4(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=60;
        drawPiecei5(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=70;
        drawPieceV3(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=40;
        drawPieceL4(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=40;
        drawPieceL5(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=30;
        drawPieceT4(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=50;
        drawPieceT5(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=50;
        drawPieceO(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=40;
        drawPieceW(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance+=50;
        drawPieceU(xpos+gapDistance,ypos,0,0,0,g);
        gapDistance = 0;
        drawPieceX(xpos,ypos+50,0,0,0,g);
        gapDistance += 40;
        drawPieceP(xpos+gapDistance,ypos+50,0,0,0,g);
        gapDistance += 40;
        drawPieceY(xpos+gapDistance,ypos+50,0,0,0,g);
        gapDistance += 70;
        drawPieceF(xpos+gapDistance,ypos+50,0,0,0,g);
        gapDistance += 40;
        drawPieceN(xpos+gapDistance,ypos+50,0,0,0,g);
        gapDistance += 60;
        drawPieceZ4(xpos+gapDistance,ypos+50,0,0,0,g);
        gapDistance += 40;
        drawPieceZ5(xpos+gapDistance,ypos+50,0,0,0,g);
        gapDistance += 40;
        drawPieceV5(xpos+gapDistance,ypos+50,0,0,0,g);
        
        
    }

    public void drawCube(int xpos, int ypos,double rot, double xscale,double yscale,Graphics2D g) {       
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        
        g.setColor(getColor());
        int xvals4[] = {-5,5,5,-5,-5};
        int yvals4[] = {-5,-5,5,5,-5};
        
        g.fillPolygon(xvals4, yvals4, xvals4.length);
        g.setColor(Color.white);
        g.drawPolygon(xvals4, yvals4, xvals4.length);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
                       
    }
    public void drawPiece1(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        g.setColor(getColor());
        drawCube(xpos,ypos,0,1,1,g); 

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);

    }

    public void drawPiece2(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }

    public void drawPiecei3(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);                
    }

    public void drawPiecei4(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);  
        drawCube(xpos+30,ypos,0,1,1,g); 
    }

    public void drawPiecei5(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);  
        drawCube(xpos+30,ypos,0,1,1,g); 
        drawCube(xpos+40,ypos,0,1,1,g); 
    }

    public void drawPieceV3(int xpos, int ypos, double rot,double xscale,double yscale, Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
    }

    public void drawPieceL4(int xpos, int ypos, double rot,double xscale,double yscale, Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+20,0,1,1,g); 
        drawCube(xpos+10,ypos+20,0,1,1,g); 
    }

    public void drawPieceL5(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+20,0,1,1,g); 
        drawCube(xpos,ypos+30,0,1,1,g);
        drawCube(xpos+10,ypos+30,0,1,1,g); 
    }

    public void drawPieceT4(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos+10,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos+20,ypos,0,1,1,g);
        
    }

    public void drawPieceT5(int xpos, int ypos, double rot,double xscale,double yscale, Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos+10,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+20,0,1,1,g); 
        drawCube(xpos+20,ypos,0,1,1,g);
    }

    public void drawPieceO(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos+10,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+10,0,1,1,g); 
        
    }

    public void drawPieceW(int xpos, int ypos, double rot,double xscale,double yscale, Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+20,0,1,1,g); 
        drawCube(xpos+20,ypos+20,0,1,1,g);
    }

    public void drawPieceU(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos+20,ypos+10,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);
        
    }

    public void drawPieceX(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos+10,0,1,1,g);  
        drawCube(xpos,ypos+10+10,0,1,1,g); 
        drawCube(xpos-10,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos-10+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
    }

    public void drawPieceP(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos+10,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+20,0,1,1,g);
    }

    public void drawPieceY(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);  
        drawCube(xpos+30,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g);
    }

    public void drawPieceF(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos,ypos+10,0,1,1,g);
        drawCube(xpos-10,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
        drawCube(xpos-10,ypos+20,0,1,1,g);
        
    }

    public void drawPieceN(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);
        drawCube(xpos+30,ypos,0,1,1,g);
    }

    public void drawPieceZ4(int xpos, int ypos, double rot, double xscale,double yscale, Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+20,0,1,1,g);
    }

    public void drawPieceZ5(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
        drawCube(xpos+20,ypos+10,0,1,1,g);
        drawCube(xpos+20,ypos+20,0,1,1,g);
    }

    public void drawPieceV5(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+20,0,1,1,g); 
        drawCube(xpos+10,ypos+20,0,1,1,g); 
        drawCube(xpos+20,ypos+20,0,1,1,g);

    }
}