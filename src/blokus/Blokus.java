package blokus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Blokus extends JFrame implements Runnable {

    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    boolean yes;
    double Xpos;
    double Ypos;
    int rotation;

    private Window.GameState gameState = Window.GameState.Menu;
    Image menu1;
    Image board;
    Image menu2;
    
    private Piece.Block selectedPiece = null;

    Color color;
    Color color2;

    Color colorOne;
    Color colorTwo;
    Color colorThree;
    Color colorFour;

    
    public static void main(String[] args) {
        Blokus frame = new Blokus();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Blokus");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    public Blokus() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int xpos = e.getX();
                int ypos = e.getY();

                System.out.println("Xpos:" + xpos + " Ypos:" + ypos);

                if (e.BUTTON1 == e.getButton()) {

                    if (gameState == Window.GameState.Menu) {

                        if (xpos >= 270 && xpos <= 570 && ypos >= 600 && ypos <= 650) {
                            gameState = Window.GameState.Menu2;
                        }
                        if (xpos >= 270 && xpos <= 570 && ypos >= 680 && ypos <= 730) {
                            System.exit(0);
                        }
                        

                    }
                    else if (gameState == Window.GameState.Menu2) {
                        if(xpos >= 5 && xpos <= 440 && ypos >= 5 && ypos <= 450){
                             gameState = Window.GameState.InGame;
                        }
                        if(xpos >= 5 && xpos <= 440 && ypos >= 450 && ypos <= 895){
                             gameState = Window.GameState.InGame;
                        }
                        if(xpos >= 450 && xpos <= 865 && ypos >= 25 && ypos <= 450){
                             gameState = Window.GameState.InGame;
                        }
                        if(xpos >= 450 && xpos <= 865 && ypos >= 450 && ypos <= 895){
                             gameState = Window.GameState.InGame;

                        }

                    } else if (gameState == Window.GameState.InGame) {
                        /////////
                        if (Player.GetCurrentPlayer() == Player.getPlayer(1)) {
                            if (selectedPiece != null) {
                                Board.AddPiecePixel(xpos, ypos, selectedPiece,rotation);
                                selectedPiece = null;
                                rotation = 0;
                            } else {
                                selectedPiece = null;
                            }

                            if (xpos >= 15 && xpos <= 35 && ypos >= 45 && ypos <= 65 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(0)) {
                                selectedPiece = Piece.Block.ONE;

                            } else if (xpos >= 45 && xpos <= 88 && ypos >= 47 && ypos <= 65 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(1)) {
                                selectedPiece = Piece.Block.TWO;

                            } else if (xpos >= 98 && xpos <= 160 && ypos >= 47 && ypos <= 65 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(2)) {
                                selectedPiece = Piece.Block.I3;

                            } else if (xpos >= 170 && xpos <= 255 && ypos >= 47 && ypos <= 65 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(3)) {
                                selectedPiece = Piece.Block.I4;

                            } else if (xpos >= 265 && xpos <= 370 && ypos >= 47 && ypos <= 65 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(4)) {
                                selectedPiece = Piece.Block.I5;

                            } else if (xpos >= 380 && xpos <= 420 && ypos >= 47 && ypos <= 88 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(5)) {
                                selectedPiece = Piece.Block.V3;

                            } else if (xpos >= 435 && xpos <= 475 && ypos >= 47 && ypos <= 109 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(6)) {
                                selectedPiece = Piece.Block.L4;

                            } else if (xpos >= 487 && xpos <= 530 && ypos >= 47 && ypos <= 130 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(7)) {
                                selectedPiece = Piece.Block.L5;

                            } else if (xpos >= 540 && xpos <= 600 && ypos >= 47 && ypos <= 110 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(8)) {
                                selectedPiece = Piece.Block.T5;

                            } else if (xpos >= 613 && xpos <= 675 && ypos >= 47 && ypos <= 88 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(9)) {
                                selectedPiece = Piece.Block.T4;

                            } else if (xpos >= 15 && xpos <= 55 && ypos >= 75 && ypos <= 115 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(10)) {
                                selectedPiece = Piece.Block.O;

                            } else if (xpos >= 68 && xpos <= 130 && ypos >= 75 && ypos <= 140 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(11)) {
                                selectedPiece = Piece.Block.W;

                            } else if (xpos >= 140 && xpos <= 203 && ypos >= 75 && ypos <= 120 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(12)) {                                
                                selectedPiece = Piece.Block.U;
                                
                            } else if (xpos >= 215 && xpos <= 275 && ypos >= 75 && ypos <= 140 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(13)) {                                
                                selectedPiece = Piece.Block.X;
                                
                            } else if (xpos >= 285 && xpos <= 330 && ypos >= 75 && ypos <= 140 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(14)) {
                                selectedPiece = Piece.Block.P;
                                
                            } else if (xpos >= 340 && xpos <= 425 && ypos >= 100 && ypos <= 140 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(15)) {
                                selectedPiece = Piece.Block.Y;
                                
                            } else if (xpos >= 15 && xpos <= 75 && ypos >= 135 && ypos <= 200 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(16)) {
                                selectedPiece = Piece.Block.F;
                                
                            } else if (xpos >= 88 && xpos <= 170 && ypos >= 155 && ypos <= 200 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(17)) {
                                selectedPiece = Piece.Block.N;
                                
                            } else if (xpos >= 180 && xpos <= 225 && ypos >= 135 && ypos <= 200 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(18)) {
                                selectedPiece = Piece.Block.Z4;
                                
                            } else if (xpos >= 540 && xpos <= 600 && ypos >= 135 && ypos <= 200 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(19)) {
                                selectedPiece = Piece.Block.V5;
                                
                            } else if (xpos >= 615 && xpos <= 675 && ypos >= 135 && ypos <= 200 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(20)) {
                                selectedPiece = Piece.Block.Z5;
                                
                            }
                        } /////////
                        else if (Player.GetCurrentPlayer() == Player.getPlayer(2)) {
                            if (selectedPiece != null) {
                                Board.AddPiecePixel(xpos, ypos, selectedPiece,rotation);
                                selectedPiece = null;
                                rotation = 0;
                            } else {
                                selectedPiece = null;
                            }

                            if (xpos >= 840 && xpos <= 860 && ypos >= 44 && ypos <= 66 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(0)) {
                                
                                selectedPiece = Piece.Block.ONE;

                            } else if (xpos >= 840 && xpos <= 860 && ypos >= 76 && ypos <= 118 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(1)) {
                                selectedPiece = Piece.Block.TWO;

                            } else if (xpos >= 840 && xpos <= 860 && ypos >= 129 && ypos <= 192 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(2)) {
                                selectedPiece = Piece.Block.I3;

                            } else if (xpos >= 840 && xpos <= 860 && ypos >= 202 && ypos <= 286 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(3)) {
                                selectedPiece = Piece.Block.I4;

                            } else if (xpos >= 840 && xpos <= 860 && ypos >= 296 && ypos <= 402 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(4)) {
                                selectedPiece = Piece.Block.I5;

                            } else if (xpos >= 820 && xpos <= 860 && ypos >= 411 && ypos <= 452 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(5)) {
                                selectedPiece = Piece.Block.V3;

                            } else if (xpos >= 800 && xpos <= 860 && ypos >= 464 && ypos <= 507 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(6)) {
                                selectedPiece = Piece.Block.L4;

                            } else if (xpos >= 777 && xpos <= 860 && ypos >= 516 && ypos <= 558 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(7)) {
                                selectedPiece = Piece.Block.L5;

                            } else if (xpos >= 800 && xpos <= 860 && ypos >= 571 && ypos <= 632 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(8)) {
                                selectedPiece = Piece.Block.T5;

                            } else if (xpos >= 820 && xpos <= 860 && ypos >= 643 && ypos <= 706 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(9)) {
                                selectedPiece = Piece.Block.T4;

                            } else if (xpos >= 787 && xpos <= 830 && ypos >= 44 && ypos <= 86 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(10)) {
                                selectedPiece = Piece.Block.O;

                            } else if (xpos >= 766 && xpos <= 830 && ypos >= 97 && ypos <= 158 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(11)) {
                                selectedPiece = Piece.Block.W;

                            } else if (xpos >= 787 && xpos <= 830 && ypos >= 170 && ypos <= 234 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(12)) {
                                selectedPiece = Piece.Block.U;

                            } else if (xpos >= 766 && xpos <= 830 && ypos >= 245 && ypos <= 305 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(13)) {
                                selectedPiece = Piece.Block.X;

                            } else if (xpos >= 766 && xpos <= 830 && ypos >= 318 && ypos <= 360 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(14)) {
                                selectedPiece = Piece.Block.P;

                            } else if (xpos >= 766 && xpos <= 808 && ypos >= 369 && ypos <= 453 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(15)) {
                                selectedPiece = Piece.Block.Y;

                            } else if (xpos >= 709 && xpos <= 773 && ypos >= 44 && ypos <= 107 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(16)) {
                                selectedPiece = Piece.Block.F;

                            } else if (xpos >= 709 && xpos <= 751 && ypos >= 117 && ypos <= 202 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(17)) {
                                selectedPiece = Piece.Block.N;

                            } else if (xpos >= 709 && xpos <= 773 && ypos >= 211 && ypos <= 253 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(18)) {
                                selectedPiece = Piece.Block.Z4;

                            } else if (xpos >= 709 && xpos <= 773 && ypos >= 570 && ypos <= 632 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(19)) {
                                selectedPiece = Piece.Block.V5;

                            } else if (xpos >= 709 && xpos <= 773 && ypos >= 643 && ypos <= 706 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(20)) {
                                selectedPiece = Piece.Block.Z5;

                            }
                        } /////////
                        else if (Player.GetCurrentPlayer() == Player.getPlayer(3)) {

                            if (selectedPiece != null) {
                                Board.AddPiecePixel(xpos, ypos, selectedPiece,rotation);
                                selectedPiece = null;
                                rotation = 0;
                            } else {
                                selectedPiece = null;
                            }

                            if (xpos >= (15 + 185) && xpos <= (35 + 185) && ypos >= (45 + 680) && ypos <= (65 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(0)) {
                                selectedPiece = Piece.Block.ONE;

                            } else if (xpos >= (45 + 185) && xpos <= (88 + 185) && ypos >= (47 + 680) && ypos <= (65 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(1)) {
                                selectedPiece = Piece.Block.TWO;

                            } else if (xpos >= (98 + 185) && xpos <= (160 + 185) && ypos >= (47 + 680) && ypos <= (65 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(2)) {
                                selectedPiece = Piece.Block.I3;

                            } else if (xpos >= (170 + 185) && xpos <= (255 + 185) && ypos >= (47 + 680) && ypos <= (65 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(3)) {
                                selectedPiece = Piece.Block.I4;

                            } else if (xpos >= (265 + 185) && xpos <= (370 + 185) && ypos >= (47 + 680) && ypos <= (65 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(4)) {
                                selectedPiece = Piece.Block.I5;

                            } else if (xpos >= (380 + 185) && xpos <= (420 + 185) && ypos >= (47 + 680) && ypos <= (88 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(5)) {
                                selectedPiece = Piece.Block.V3;

                            } else if (xpos >= (435 + 185) && xpos <= (475 + 185) && ypos >= (47 + 680) && ypos <= (109 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(6)) {
                                selectedPiece = Piece.Block.L4;

                            } else if (xpos >= (487 + 185) && xpos <= (530 + 185) && ypos >= (47 + 680) && ypos <= (130 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(7)) {
                                selectedPiece = Piece.Block.L5;

                            } else if (xpos >= (540 + 185) && xpos <= (600 + 185) && ypos >= (47 + 680) && ypos <= (110 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(8)) {
                                selectedPiece = Piece.Block.T5;

                            } else if (xpos >= (613 + 185) && xpos <= (675 + 185) && ypos >= (47 + 680) && ypos <= (88 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(9)) {
                                selectedPiece = Piece.Block.T4;

                            } else if (xpos >= (15 + 185) && xpos <= (55 + 185) && ypos >= (47 + 680) && ypos <= (115 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(10)) {
                                selectedPiece = Piece.Block.O;

                            } else if (xpos >= (68 + 185) && xpos <= (130 + 185) && ypos >= (75 + 680) && ypos <= (140+680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(11)) {
                                selectedPiece = Piece.Block.W;

                            } else if (xpos >= (140 + 185) && xpos <= (203 + 185) && ypos >= (75 + 680) && ypos <= (120 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(12)) {
                                selectedPiece = Piece.Block.U;

                            } else if (xpos >= (215 + 185) && xpos <= (275 + 185) && ypos >= (75 + 680) && ypos <= (140 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(13)) {
                                selectedPiece = Piece.Block.X;

                            } else if (xpos >= (285 + 185) && xpos <= (330 + 185) && ypos >= (75 + 680) && ypos <= (140 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(14)) {
                                selectedPiece = Piece.Block.P;

                            } else if (xpos >= (340 + 185) && xpos <= (425 + 185) && ypos >= (100 + 680) && ypos <= (140 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(15)) {
                                selectedPiece = Piece.Block.Y;

                            } else if (xpos >= (15 + 185) && xpos <= (75 + 185) && ypos >= (135 + 680) && ypos <= (200 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(16)) {
                                selectedPiece = Piece.Block.F;

                            } else if (xpos >= (88 + 185) && xpos <= (170 + 185) && ypos >= (155 + 680) && ypos <= (200 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(17)) {
                                selectedPiece = Piece.Block.N;

                            } else if (xpos >= (180 + 185) && xpos <= (225 + 185) && ypos >= (135 + 680) && ypos <= (200 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(18)) {
                                selectedPiece = Piece.Block.Z4;

                            } else if (xpos >= (540 + 185) && xpos <= (600 + 185) && ypos >= (135 + 680) && ypos <= (200 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(19)) {
                                selectedPiece = Piece.Block.V5;

                            } else if (xpos >= (615 + 185) && xpos <= (675 + 185) && ypos >= (135 + 680) && ypos <= (200 + 680) && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(20)) {
                                selectedPiece = Piece.Block.Z5;

                            }
                        } /////////
                        else if (Player.GetCurrentPlayer() == Player.getPlayer(4)) {
                            if (selectedPiece != null) {
                                Board.AddPiecePixel(xpos, ypos, selectedPiece,rotation);
                                selectedPiece = null;
                                rotation = 0;
                            } else {
                                selectedPiece = null;
                            }

                            if (xpos >= 15 && xpos <= 35 && ypos >= 860 && ypos <= 885 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(0)) {
                                selectedPiece = Piece.Block.ONE;

                            } else if (xpos >= 15 && xpos <= 35 && ypos >= 808 && ypos <= 850 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(1)) {
                                selectedPiece = Piece.Block.TWO;
                                
                            } else if (xpos >= 15 && xpos <= 35 && ypos >= 735 && ypos <= 800 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(2)) {
                                selectedPiece = Piece.Block.I3;
                                
                            } else if (xpos >= 15 && xpos <= 35 && ypos >= 640 && ypos <= 725 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(3)) {
                                selectedPiece = Piece.Block.I4;
                                
                            } else if (xpos >= 15 && xpos <= 35 && ypos >= 525 && ypos <= 630 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(4)) {
                                selectedPiece = Piece.Block.I5;
                                
                            } else if (xpos >= 15 && xpos <= 55 && ypos >= 475 && ypos <= 510 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(5)) {
                                selectedPiece = Piece.Block.V3;
                                
                            } else if (xpos >= 15 && xpos <= 75 && ypos >= 420 && ypos <= 460 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(6)) {
                                selectedPiece = Piece.Block.L4;
                                
                            } else if (xpos >= 15 && xpos <= 100 && ypos >= 370 && ypos <= 400 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(7)) {
                                selectedPiece = Piece.Block.L5;
                                
                            } else if (xpos >= 15 && xpos <= 80 && ypos >= 305 && ypos <= 370 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(8)) {
                                selectedPiece = Piece.Block.T5;
                                
                            } else if (xpos >= 15 && xpos <= 60 && ypos >= 220 && ypos <= 280 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(9)) {
                                selectedPiece = Piece.Block.T4;
                                
                            } else if (xpos >= 50 && xpos <= 85 && ypos >= 840 && ypos <= 880 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(10)) {
                                selectedPiece = Piece.Block.O;
                                
                            } else if (xpos >= 50 && xpos <= 110 && ypos >= 766 && ypos <= 830 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(11)) {
                                selectedPiece = Piece.Block.W;
                                
                            } else if (xpos >= 50 && xpos <= 90 && ypos >= 700 && ypos <= 760 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(12)) {
                                selectedPiece = Piece.Block.U;
                                
                            } else if (xpos >= 50 && xpos <= 110 && ypos >= 620 && ypos <= 680 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(13)) {
                                selectedPiece = Piece.Block.X;
                                
                            } else if (xpos >= 50 && xpos <= 110 && ypos >= 565 && ypos <= 610 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(14)) {
                                selectedPiece = Piece.Block.P;
                                
                            } else if (xpos >= 65 && xpos <= 111 && ypos >= 475 && ypos <= 555 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(15)) {
                                selectedPiece = Piece.Block.Y;
                                
                            } else if (xpos >= 100 && xpos <= 165 && ypos >= 820 && ypos <= 880 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(16)) {
                                selectedPiece = Piece.Block.F;
                                
                            } else if (xpos >= 125 && xpos <= 165 && ypos >= 725 && ypos <= 805 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(17)) {
                                selectedPiece = Piece.Block.N;
                                
                            } else if (xpos >= 105 && xpos <= 165 && ypos >= 660 && ypos <= 700 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(18)) {
                                selectedPiece = Piece.Block.Z4;
                                
                            } else if (xpos >= 100 && xpos <= 165 && ypos >= 295 && ypos <= 360 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(19)) {
                                selectedPiece = Piece.Block.V5;
                                
                            } else if (xpos >= 100 && xpos <= 165 && ypos >= 220 && ypos <= 285 && Player.GetCurrentPlayer().getOutsidePieces().checkPiece(20)) {
                                selectedPiece = Piece.Block.Z5;
                            }
                        }
                        /////////

                    }

                }

                if (e.BUTTON3 == e.getButton()) {
                    reset();
                }
                //System.out.println("Xpos: " + xpos + "  Ypos: " + ypos);

                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseScrolled(MouseEvent e) {

                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                int xpos = e.getX();
                int ypos = e.getY();
                Xpos = xpos;
                Ypos = ypos;
                if(gameState == Window.GameState.Menu){
                    if (xpos >= 270 && xpos <= 570 && ypos >= 600 && ypos <= 650) {
                        color = Color.yellow;
                    } else {
                        color = Color.white;
                    }
                }
                else if(gameState == Window.GameState.Menu2){
                    if (xpos >= 270 && xpos <= 570 && ypos >= 680 && ypos <= 730) {
                        color2 = Color.yellow;
                    } else {
                        color2 = Color.white;
                    }
                     if(xpos >= 5 && xpos <= 865 && ypos >= 5 && ypos <= 450){
                                 colorTwo = Color.YELLOW;
                            }
                     else {
                        colorTwo = Color.white;
                    }
                            if(xpos >= 5 && xpos <= 440 && ypos >= 450 && ypos <= 895){
                                   colorThree = Color.YELLOW;
                            }
                            else {
                        colorThree = Color.white;
                    }
                           
                            if(xpos >= 450 && xpos <= 865 && ypos >= 450 && ypos <= 895){
                                      colorFour = Color.YELLOW;
                            }
                            else {
                        colorFour = Color.white;
                    }
                }
                else if(gameState == Window.GameState.InGame){

                }
          
//          System.out.println(xpos);
//          System.out.println(ypos);
                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                } else if (e.VK_R == e.getKeyCode()) {
                    rotation += 90;
                    if(rotation >270)
                        rotation = 0;
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////

    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////

    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////

    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
        if (gameState == Window.GameState.Menu) {
            g.drawImage(menu1, 0, 0, Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT, this);

            g.setColor(color);
            g.fillRoundRect(270, 600, 300, 50, 10, 10);
            g.setColor(color2);
            g.fillRoundRect(270, 680, 300, 50, 10, 10);

            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("Play", 380, 638);
            g.drawString("Quit", 380, 718);
        } else if (gameState == Window.GameState.Menu2) {
            g.setColor(Color.black);
            g.drawImage(menu2, 1, 1, Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT, this);
            g.setFont(new Font("Arial", Font.PLAIN, 65));
            g.drawString("Select Number of Players", 80, 100);
            g.setColor(colorOne);
            g.setFont(new Font("Arial", Font.BOLD, 150));
            
             g.setColor(colorTwo);
            g.drawString("2", 400, 275);
             g.setColor(colorThree);
            g.drawString("3", 150, 700);
             g.setColor(colorFour);
            g.drawString("4", 600, 700);
        } else if (gameState == Window.GameState.InGame) {
//fill background

            g.setColor(Color.white);
            g.fillRect(0, 0, Window.xsize, Window.ysize);

            int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
            int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};

//fill border
            g.setColor(Color.white);
            g.fillPolygon(x, y, 4);
// draw border
            g.setColor(Color.black);
            g.drawPolyline(x, y, 5);
//Color Player's Side when it's their turn
            if(Player.GetCurrentPlayer() == Player.getPlayer(1)){
                g.setColor(Color.BLACK);
                g.fillRect(Window.WINDOW_BORDER - 5, Window.YTITLE + Window.WINDOW_BORDER - 5, 
                        Window.XBORDER + Window.getHeight2() + 5, Window.WINDOW_BORDER - 8 + Window.YBORDER - 3);
            }
            if(Player.GetCurrentPlayer() == Player.getPlayer(2)){
                g.setColor(Color.BLACK);
                g.fillRect(688,34,192,677);
            }
            if(Player.GetCurrentPlayer() == Player.getPlayer(3)){
                g.setColor(Color.BLACK);
                g.fillRect(188,710,700,200);
            }
            if(Player.GetCurrentPlayer() == Player.getPlayer(4)){
                g.setColor(Color.BLACK);
                g.fillRect(0,211,188,700);
            }
///////////////////////
//draw outline
            g.setColor(Color.BLACK);
            g.drawRect(Window.WINDOW_BORDER - 5, Window.YTITLE + Window.WINDOW_BORDER - 5, Window.WINDOW_WIDTH - 7, Window.WINDOW_HEIGHT - 37);
//draw 4 sections (Top Left)
            g.setColor(Color.black);
            g.drawLine(0, Window.YTITLE + Window.WINDOW_BORDER - 5 + Window.YBORDER - 3, Window.XBORDER + 8,
                    Window.YTITLE + Window.WINDOW_BORDER - 5 + Window.YBORDER - 3);
///////////////////// (Top Right)
            g.drawLine(Window.XBORDER + Window.getHeight2() + 8, Window.YTITLE + 3,
                    Window.XBORDER + Window.getHeight2() + 8, Window.YTITLE + Window.WINDOW_BORDER - 5 + Window.YBORDER - 3);
///////////////////// (Bottom Left)
            g.drawLine(Window.XBORDER + 8, Window.YTITLE + Window.WINDOW_BORDER - 5 + Window.YBORDER - 3 + Window.getHeight2(),
                    Window.XBORDER + 8, Window.YTITLE + Window.WINDOW_BORDER - 5 + Window.YBORDER - 3 + Window.getHeight2() + Window.XBORDER + 8);
///////////////////// (Bottom Right)
            g.drawLine(Window.XBORDER + Window.getWidth2() + 8, Window.YTITLE + Window.WINDOW_BORDER - 5 + Window.YBORDER - 3 + Window.getHeight2(),
                    Window.XBORDER + Window.getWidth2() + 20 + Window.XBORDER, Window.YTITLE + Window.WINDOW_BORDER - 5 + Window.YBORDER - 3 + Window.getHeight2());
/////////////////////

            if (animateFirstTime) {
                gOld.drawImage(image, 0, 0, null);
                return;
            }


        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }

        Board.Draw(g,board,this);
        Player.Draw(g, this);
        
        if(selectedPiece != null ){
            if(Player.GetCurrentPlayer() == Player.getPlayer(1)){
                if(selectedPiece == Piece.Block.ONE ){
                    Player.GetCurrentPlayer().getOutsidePieces().drawPiece1(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.TWO ){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I3 ){        
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I5 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.V3 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.L4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.L5 ){              
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.T5 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.T4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.O ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceO(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.W ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceW(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.U ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceU(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.X ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceX(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.P){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceP(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Y){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceY(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.F){      
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceF(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.N){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceN(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Z4){     
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.V5){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Z5){    
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }

            }
            else if(Player.GetCurrentPlayer() == Player.getPlayer(2)){
                if(selectedPiece == Piece.Block.ONE ){               
                    Player.GetCurrentPlayer().getOutsidePieces().drawPiece1(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.TWO ){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I3 ){        
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I5 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.V3 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.L4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.L5 ){              
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.T5 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.T4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.O ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceO(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.W ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceW(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.U ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceU(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.X ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceX(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.P){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceP(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Y){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceY(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.F){      
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceF(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.N){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceN(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Z4){     
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.V5){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Z5){    
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }

            }
            else if(Player.GetCurrentPlayer() == Player.getPlayer(3)){
                if(selectedPiece == Piece.Block.ONE ){               
                    Player.GetCurrentPlayer().getOutsidePieces().drawPiece1(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.TWO ){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I3 ){        
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I5 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.V3 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.L4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.L5 ){              
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.T5 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.T4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.O ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceO(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.W ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceW(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.U ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceU(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.X ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceX(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.P){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceP(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Y){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceY(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.F){      
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceF(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.N){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceN(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Z4){     
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.V5){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Z5){    
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }

            }
            else if(Player.GetCurrentPlayer() == Player.getPlayer(4)){
                if(selectedPiece == Piece.Block.ONE ){               
                    Player.GetCurrentPlayer().getOutsidePieces().drawPiece1(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.TWO ){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiece2rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I3 ){        
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei3rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.I5 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPiecei5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.V3 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV3rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.L4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.L5 ){              
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceL5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.T5 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.T4 ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceT4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.O ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceO(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceOrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.W ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceW(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceWrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.U ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceU(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceUrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.X ){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceX(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceXrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.P){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceP(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceProt270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Y){               
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceY(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceYrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.F){      
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceF(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceFrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.N){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceN(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceNrot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Z4){     
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ4rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.V5){   
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceV5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }
                else if(selectedPiece == Piece.Block.Z5){    
                    if(rotation == 0)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 90)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot90(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 180)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot180(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                    if(rotation == 270)
                        Player.GetCurrentPlayer().getOutsidePieces().drawPieceZ5rot270(Xpos/2.4, Ypos/2.4, 0, 2.4, 2.4, g, Player.GetCurrentPlayer());
                }

            }
        }

        }

        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }

/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Player.Reset();
        Board.Reset();
        gameState = Window.GameState.Menu;
        color = Color.white;
        color2 = Color.white;
        selectedPiece = null;
        rotation = 0;
    }
/////////////////////////////////////////////////////////////////////////

    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            menu1 = Toolkit.getDefaultToolkit().getImage("assets/images/menu1.jpg");
            board = Toolkit.getDefaultToolkit().getImage("assets/images/board.png");
            menu2 = Toolkit.getDefaultToolkit().getImage("assets/images/menu2.jpg");
            reset();

        }
        if(Player.GetCurrentPlayer() == Player.getPlayer(3)){
            
        }

    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////

    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
/////////////////////////////////////////////////////////////////////////

}
