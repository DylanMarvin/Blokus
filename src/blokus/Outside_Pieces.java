package blokus;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D;

public class Outside_Pieces extends Player {

    boolean pieces[] = new boolean[numPieces];
    //Graphics2D g;
    
    Outside_Pieces(int num){
        super(num);
        for(int i = 0;i<numPieces;i++){
            pieces[i] = true;
        }
    }

    

    public static void drawPlayerNames(int xpos, int ypos, double rot, Graphics g, Player name) {
        g.translate(xpos, ypos);

        g.translate(-xpos, -ypos);
    }
    
    
    public void drawAll(double xpos, double ypos,double rot, double xscale,double yscale, Graphics2D g) {
        int gapXDistance = 15;
        int gapYDistance = 15;
        
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        if(pieces[0] == true)
            drawPiece1(xpos,ypos,0,1,1,g,this);
        if(pieces[1] == true)
            drawPiece2(xpos+gapXDistance,ypos,0,1,1,g,this);
            gapXDistance+=25;
        if(pieces[2] == true)
            drawPiecei3(xpos+gapXDistance,ypos,0,1,1,g,this);
            gapXDistance+=35;
        if(pieces[3] == true)
            drawPiecei4(xpos+gapXDistance,ypos,0,1,1,g,this);
            gapXDistance+=45;
        if(pieces[4] == true)
            drawPiecei5(xpos+gapXDistance,ypos,0,1,1,g,this);
            gapXDistance+=55;
        if(pieces[5] == true)
            drawPieceV3(xpos+gapXDistance,ypos,0,1,1,g,this);
            gapXDistance+=25;
        if(pieces[6] == true)
            drawPieceL4(xpos+gapXDistance,ypos,0,1,1,g,this);
            gapXDistance+=25;
        if(pieces[7] == true)
            drawPieceL5(xpos+gapXDistance,ypos,0,1,1,g,this);
            gapXDistance+=20;
        if(pieces[8] == true)
            drawPieceT5(xpos+gapXDistance+5,ypos,0,1,1,g,this);
            gapXDistance+=40;
        if(pieces[9] == true)
            drawPieceT4(xpos+gapXDistance,ypos,0,1,1,g,this);
        if(pieces[10] == true)
            drawPieceO(xpos,ypos+gapYDistance,0,1,1,g,this);
            gapXDistance=0;
            gapXDistance+=25;
        if(pieces[11] == true)
            drawPieceW(xpos+gapXDistance,ypos+gapYDistance,0,1,1,g,this);
            gapXDistance+=35;
        if(pieces[12] == true)
            drawPieceU(xpos+gapXDistance,ypos+gapYDistance,0,1,1,g,this);
            gapXDistance+=45;
        if(pieces[13] == true)
            drawPieceX(xpos+gapXDistance,ypos+gapYDistance,0,1,1,g,this);
            gapXDistance += 25;
        if(pieces[14] == true)
            drawPieceP(xpos+gapXDistance,ypos+gapYDistance,0,1,1,g,this);
            gapXDistance += 25;
        if(pieces[15] == true)
            drawPieceY(xpos+gapXDistance,ypos+25,0,1,1,g,this);
            gapXDistance += 115;
        if(pieces[16] == true)
            drawPieceF(xpos+10,ypos+42,0,1,1,g,this);
            gapXDistance = 0;
            gapXDistance += 35;
        if(pieces[17] == true)
            drawPieceN(xpos+gapXDistance,ypos+52,0,1,1,g,this);
            gapXDistance += 50;
        if(pieces[18] == true)
            drawPieceZ4(xpos+gapXDistance-5,ypos+42,0,1,1,g,this);
            gapXDistance += 60;
        if(pieces[19] == true)
            drawPieceZ5(xpos+gapXDistance+140,ypos+42,0,1,1,g,this);
            gapXDistance += 50;
        if(pieces[20] == true)
            drawPieceV5(xpos+gapXDistance+55,ypos+42,0,1,1,g,this);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawCube(double xpos, double ypos,double rot, double xscale,double yscale,Graphics2D g) {       
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
    
    public void drawPiece1(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,rot,1,1,g); 
    
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);

    }

    public void drawPiece2(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPiecei3(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);  
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPiecei4(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);  
        drawCube(xpos+30,ypos,0,1,1,g); 
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPiecei5(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);  
        drawCube(xpos+30,ypos,0,1,1,g); 
        drawCube(xpos+40,ypos,0,1,1,g); 
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceV3(double xpos, double ypos, double rot,double xscale,double yscale, Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceL4(double xpos, double ypos, double rot,double xscale,double yscale, Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+20,0,1,1,g); 
        drawCube(xpos+10,ypos+20,0,1,1,g); 
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceL5(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+20,0,1,1,g); 
        drawCube(xpos,ypos+30,0,1,1,g);
        drawCube(xpos+10,ypos+30,0,1,1,g); 
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceT4(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos+10,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos+20,ypos,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceT5(double xpos, double ypos, double rot,double xscale,double yscale, Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos+10,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+20,0,1,1,g); 
        drawCube(xpos+20,ypos,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceO(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos+10,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+10,0,1,1,g); 
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceW(double xpos, double ypos, double rot,double xscale,double yscale, Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+20,0,1,1,g); 
        drawCube(xpos+20,ypos+20,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceU(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos+20,ypos+10,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceX(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos+10,0,1,1,g);  
        drawCube(xpos,ypos+10+10,0,1,1,g); 
        drawCube(xpos-10,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos-10+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceP(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos+10,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+20,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceY(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);  
        drawCube(xpos+30,ypos,0,1,1,g); 
        drawCube(xpos+10,ypos+10,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceF(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos,ypos+10,0,1,1,g);
        drawCube(xpos-10,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
        drawCube(xpos-10,ypos+20,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceN(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos,0,1,1,g);
        drawCube(xpos+20,ypos,0,1,1,g);
        drawCube(xpos+30,ypos,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceZ4(double xpos, double ypos, double rot, double xscale,double yscale, Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+20,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceZ5(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);
        drawCube(xpos,ypos+10,0,1,1,g);
        drawCube(xpos+10,ypos+10,0,1,1,g);
        drawCube(xpos+20,ypos+10,0,1,1,g);
        drawCube(xpos+20,ypos+20,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }

    public void drawPieceV5(double xpos, double ypos, double rot, double xscale,double yscale,Graphics2D g,Player player) {
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        drawCube(xpos,ypos,0,1,1,g);  
        drawCube(xpos,ypos+10,0,1,1,g); 
        drawCube(xpos,ypos+20,0,1,1,g); 
        drawCube(xpos+10,ypos+20,0,1,1,g); 
        drawCube(xpos+20,ypos+20,0,1,1,g);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
    }
    
    public void changePiece(int num){
        pieces[num] = false;
    }
    public boolean checkPiece(int num){
        return(pieces[num]); 
        
    }
}