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
    
public void drawAll(int xpos, int ypos,double rot, double xscale,double yscale, Graphics2D g) {
        int gapXDistance = 15;
        int gapYDistance = 15;
        
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawPiece1(xpos,ypos,0,1,1,g);
        drawPiece2(xpos+gapXDistance,ypos,0,1,1,g);
        gapXDistance+=25;
        drawPiecei3(xpos+gapXDistance,ypos,0,1,1,g);
        gapXDistance+=35;
        drawPiecei4(xpos+gapXDistance,ypos,0,1,1,g);
        gapXDistance+=45;
        drawPiecei5(xpos+gapXDistance,ypos,0,1,1,g);
        gapXDistance+=55;
        drawPieceV3(xpos+gapXDistance,ypos,0,1,1,g);
        gapXDistance+=25;
        drawPieceL4(xpos+gapXDistance,ypos,0,1,1,g);
        gapXDistance+=25;
        drawPieceL5(xpos+gapXDistance,ypos,0,1,1,g);
        gapXDistance+=20;
        drawPieceT5(xpos+gapXDistance+5,ypos,0,1,1,g);
        gapXDistance+=40;
        drawPieceT4(xpos+gapXDistance,ypos,0,1,1,g);
        drawPieceO(xpos,ypos+gapYDistance,0,1,1,g);
        gapXDistance=0;
        gapXDistance+=25;
        drawPieceW(xpos+gapXDistance,ypos+gapYDistance,0,1,1,g);
        gapXDistance+=35;
        drawPieceU(xpos+gapXDistance,ypos+gapYDistance,0,1,1,g);
        gapXDistance+=45;
        drawPieceX(xpos+gapXDistance,ypos+gapYDistance,0,0,0,g);
        gapXDistance += 25;
        drawPieceP(xpos+gapXDistance,ypos+gapYDistance,0,0,0,g);
        gapXDistance += 25;
        drawPieceY(xpos+gapXDistance,ypos+25,0,0,0,g);
        gapXDistance += 115;
        drawPieceF(xpos+10,ypos+42,0,0,0,g);
        gapXDistance = 0;
        gapXDistance += 35;
        drawPieceN(xpos+gapXDistance,ypos+52,0,0,0,g);
        gapXDistance += 50;
        drawPieceZ4(xpos+gapXDistance,ypos+42,0,0,0,g);
        gapXDistance += 60;
        drawPieceZ5(xpos+gapXDistance+140,ypos+42,0,0,0,g);
        gapXDistance += 50;
        drawPieceV5(xpos+gapXDistance+55,ypos+42,0,0,0,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawCube(int xpos, int ypos,double rot, double xscale,double yscale,Graphics2D g) {       
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        
        g.setColor(getColor());
        int xvals4[] = {-5,5,5,-5,-5};
        int yvals4[] = {-5,-5,5,5,-5};
        g.fillPolygon(xvals4, yvals4, xvals4.length);
        
        g.setColor(Color.LIGHT_GRAY);
        g.drawPolygon(xvals4, yvals4, xvals4.length);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
                       
    }
    public void drawPiece1(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g); 

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);

    }

    public void drawPiece2(int xpos, int ypos, double rot, double xscale,double yscale,Graphics2D g) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
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