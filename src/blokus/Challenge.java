package blokus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

public class Challenge {
    
    private static int numChallenges = 3;
    private static Challenge challenges[] = new Challenge[numChallenges];
    private int challengeNum;
    private String description;
    private boolean active;
    private Outside_Pieces piece;
    private static Challenge currentChallenge;

    Challenge(int num,Outside_Pieces _piece) {
        challenges[num-1] = this;
        challengeNum = num;
        setDescription(num);
        active = true;
        piece = _piece;
    }
    private void setDescription(int num){
        if(num == 1){
            description = "Place The V3 Piece This Turn";          
        }
        else if(num == 2){
            description = "Place The L5 Piece This Turn";
        }
        else if(num == 3){
            description = "Place The Z5 Piece This Turn";
        }
    }
    public static void setChallenges(Outside_Pieces piece1){
        challenges[0] = new Challenge(1,piece1);
        challenges[1] = new Challenge(1,piece1);
        challenges[2] = new Challenge(1,piece1);
        setCurrentChallenge();
    }
    public static void setCurrentChallenge(){
        int val = (int) (Math.random()*10+1);
        if(val == 10){
            val = (int) (Math.random()*3+1);           
            currentChallenge = challenges[val-1];
            currentChallenge.challengeNum = val;
            currentChallenge.setDescription(val);
            System.out.println("val:" +val);
            
            if(currentChallenge.challengeNum == 1){
                if(Player.GetCurrentPlayer().getOutsidePieces().checkPiece(5) == false){
                    currentChallenge.active = false;
                }
            }
            else if(currentChallenge.challengeNum == 2){
                if(Player.GetCurrentPlayer().getOutsidePieces().checkPiece(7) == false){
                    currentChallenge.active = false;
                }
            }
            else if(currentChallenge.challengeNum == 3){
                if(Player.GetCurrentPlayer().getOutsidePieces().checkPiece(19) == false){
                    currentChallenge.active = false;
                }
            }
        }
    }
    public static boolean checkChallenge(){
        if(currentChallenge.challengeNum == 1){
            if(currentChallenge.piece.checkPiece(5) == false)
                return true;
        }
        else if(currentChallenge.challengeNum == 2){
            if(currentChallenge.piece.checkPiece(7) == false)
                return true;
        }
        else if(currentChallenge.challengeNum == 3){
            if(currentChallenge.piece.checkPiece(19) == false)
                return true;
        }
        return false;
    }
    
    
    public void Draw(Graphics2D g) {
        if(active == true){
            //Box and Black Outline
            g.setColor(Color.WHITE);
            g.fillRect(Window.getWidth2()/2+13, Window.getHeight2()/2+10, 350, 200);
            g.setColor(Color.black);
            g.drawRect(Window.getWidth2()/2+13, Window.getHeight2()/2+10, 350, 200);

            //Challenge Title
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.setColor(Color.black);
            g.drawString("Challenge #" + challengeNum, 310, 300);

            //X In Corner
            g.setFont(new Font("Arial", Font.BOLD, 35));
            g.setColor(Color.red);
            g.drawString("X",590 , 285);
            g.setColor(Color.black);
            g.drawRect(588, 260, 25, 25);

            //Challenge Description
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.setColor(Color.black);
            g.drawString(""+description,295 , 350);
            
            if(challengeNum == 1)
                piece.drawPieceV3(420/2.1, 380/2.1, 0, 2.1, 2.1, g, Player.GetCurrentPlayer());
            else if(challengeNum == 2)
                piece.drawPieceL5(420/2.1, 375/2.1, 0, 2.1, 2.1, g, Player.GetCurrentPlayer());
            else if(challengeNum == 3)
                piece.drawPieceZ5(420/2.1, 385/2.1, 0, 2.1, 2.1, g, Player.GetCurrentPlayer());
        }
    }
    public void setActive(boolean _active){
        active = _active;
        System.out.println(active);
        
    }
    public boolean getActive(){
        return active;
    }
    public static Challenge getCurrentChallenge(){
        return currentChallenge;
    }

}

       