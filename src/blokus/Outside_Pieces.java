package blokus;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Outside_Pieces extends Player {

    Outside_Pieces(int num){
        super(num);
    }

    

    public static void drawPlayerNames(int xpos, int ypos, double rot, Graphics g, Player name) {
        g.translate(xpos, ypos);

        g.translate(-xpos, -ypos);
    }
    
    public void drawAll(int xpos, int ypos, Graphics g) {
        g.translate(xpos, ypos);
        int gapDistance = 30;

        drawPiece1(xpos,ypos,0,g);
        drawPiece2(xpos+gapDistance,ypos,0,g);
        gapDistance+=40;
        drawPiecei3(xpos+gapDistance,ypos,0,g);
        gapDistance+=50;
        drawPiecei4(xpos+gapDistance,ypos,0,g);
        gapDistance+=60;
        drawPiecei5(xpos+gapDistance,ypos,0,g);
        gapDistance+=70;
        drawPieceV3(xpos+gapDistance,ypos,0,g);
        gapDistance+=40;
        drawPieceL4(xpos+gapDistance,ypos,0,g);
        
        g.translate(-xpos, -ypos);
    }

    public void drawCube(int xpos, int ypos, Graphics g) {
        g.translate(xpos, ypos);

        g.setColor(getColor());
        int xvals4[] = {0, 10, 10, 0, 0};
        int yvals4[] = {0, 0, 10, 10, 0};
        
        g.fillPolygon(xvals4, yvals4, xvals4.length);
        g.setColor(Color.white);
        g.drawPolygon(xvals4, yvals4, xvals4.length);
        g.translate(-xpos, -ypos);
    }
    public void drawPiece1(int xpos, int ypos, double rot, Graphics g) {
        g.setColor(getColor());
        drawCube(xpos,ypos,g);        
    }

    public void drawPiece2(int xpos, int ypos, double rot, Graphics g) {
        drawCube(xpos,ypos,g);
        drawCube(xpos+10,ypos,g);
    }

    public void drawPiecei3(int xpos, int ypos, double rot, Graphics g) {
        drawCube(xpos,ypos,g);
        drawCube(xpos+10,ypos,g);
        drawCube(xpos+20,ypos,g);                
    }

    public void drawPiecei4(int xpos, int ypos, double rot, Graphics g) {
        drawCube(xpos,ypos,g);
        drawCube(xpos+10,ypos,g);
        drawCube(xpos+20,ypos,g);  
        drawCube(xpos+30,ypos,g); 
    }

    public void drawPiecei5(int xpos, int ypos, double rot, Graphics g) {
        drawCube(xpos,ypos,g);
        drawCube(xpos+10,ypos,g);
        drawCube(xpos+20,ypos,g);  
        drawCube(xpos+30,ypos,g); 
        drawCube(xpos+40,ypos,g); 
    }

    public void drawPieceV3(int xpos, int ypos, double rot, Graphics g) {
        drawCube(xpos,ypos,g);  
        drawCube(xpos,ypos+10,g); 
        drawCube(xpos+10,ypos+10,g); 
    }

    public void drawPieceL4(int xpos, int ypos, double rot, Graphics g) {
        drawCube(xpos,ypos,g);  
        drawCube(xpos,ypos+10,g); 
        drawCube(xpos,ypos+20,g); 
        drawCube(xpos+10,ypos+10+10,g); 
    }

    public void drawPieceL5() {

    }

    public void drawPieceT4() {

    }

    public void drawPieceT5() {

    }

    public void drawPieceO() {

    }

    public void drawPieceW() {

    }

    public void drawPieceU() {

    }

    public void drawPieceX() {

    }

    public void drawPieceP() {

    }

    public void drawPieceY() {

    }

    public void drawPieceF() {

    }

    public void drawPieceN() {

    }

    public void drawPieceZ4() {

    }

    public void drawPieceZ5() {

    }

    public void drawPieceV5() {

    }
}
