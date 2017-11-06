
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
    
    private Window.GameState gameState = Window.GameState.Menu;
    Image menu1;


    public static void main(String[] args) {
        Blokus frame = new Blokus();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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

                    
                    if(gameState == Window.GameState.Menu){
                        if(xpos >= 270 && xpos <= 570 && ypos >= 600 && ypos <= 650){
                            gameState = Window.GameState.InGame;
                        }
                        if(xpos >= 270 && xpos <= 570 && ypos >= 680 && ypos <= 730){
                            System.exit(0);
                        }
                    }
                    else if(gameState == Window.GameState.Menu2){
                        
                    }
                    else if(gameState == Window.GameState.InGame){
                         Board.AddPiecePixel(e.getX(),e.getY()); 
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
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
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
        if(gameState == Window.GameState.Menu){
           g.drawImage(menu1,0,0,Window.WINDOW_WIDTH,Window.WINDOW_HEIGHT,this);
           
           g.setColor(Color.white);
           g.fillRoundRect(270, 600, 300, 50, 10, 10);
           g.fillRoundRect(270, 680, 300, 50, 10, 10);
           
           g.setColor(Color.black);
           g.setFont(new Font("Arial", Font.PLAIN, 40));
           g.drawString("Play", 380, 638);
           g.drawString("Quit", 380, 718);
        }
        else if(gameState == Window.GameState.Menu2){
            g.drawImage(menu1,0,0,Window.WINDOW_WIDTH,Window.WINDOW_HEIGHT,this);
        }
        else if(gameState == Window.GameState.InGame){
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
//draw outline
        g.setColor(Color.BLACK);
        g.drawRect(Window.WINDOW_BORDER-5,Window.YTITLE + Window.WINDOW_BORDER-5, Window.WINDOW_WIDTH-7,Window.WINDOW_HEIGHT-37);
//draw 4 sections
        g.setColor(Color.black);
        g.drawLine(0, Window.YTITLE + Window.WINDOW_BORDER-5 + Window.YBORDER-3, Window.XBORDER+8, 
                   Window.YTITLE + Window.WINDOW_BORDER-5 + Window.YBORDER-3);
/////////////////////
        g.drawLine(Window.XBORDER + Window.getHeight2() + 10, Window.YTITLE + 3,
                   Window.XBORDER + Window.getHeight2() + 10, Window.YTITLE + Window.WINDOW_BORDER-5 + Window.YBORDER-3);
/////////////////////
        g.drawLine(Window.XBORDER + 8, Window.YTITLE + Window.WINDOW_BORDER-5 + Window.YBORDER-3 + Window.getHeight2(), 
                   Window.XBORDER + 8, Window.YTITLE + Window.WINDOW_BORDER-5 + Window.YBORDER-3 + Window.getHeight2() + Window.XBORDER + 8);
/////////////////////
        g.drawLine(Window.XBORDER + Window.getWidth2() + 8, Window.YTITLE + Window.WINDOW_BORDER-5 + Window.YBORDER-3 + Window.getHeight2(), 
                   Window.XBORDER + Window.getWidth2() + 20 + Window.XBORDER, Window.YTITLE + Window.WINDOW_BORDER-5 + Window.YBORDER-3 + Window.getHeight2());
/////////////////////

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        Board.Draw(g);
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
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            menu1 = Toolkit.getDefaultToolkit().getImage("./menu1.jpg");
            reset();
            
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