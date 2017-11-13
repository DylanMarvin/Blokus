
package blokus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Player {
    private static Player currentTurn;
    private static int numPlayers = 4;
    private static Player players[] = new Player[4];
    private Color color;
    private int playerNum;
    private Outside_Pieces Pieces; 
    private int numPieces;
    
    public static void Reset(){
        
        if(players[0] == null){     
            for(int i = 0;i<numPlayers;i++){               
                players[i] = new Player(i+1); 
                players[i].Pieces = new Outside_Pieces(i+1);
            }
        }   
        currentTurn = players[0];
    }
    
    Player(int _num){       
        playerNum = _num;
        numPieces = 21;
        if(playerNum == 1){
            color = Color.blue;            
        }
        else if(playerNum == 2){
            color = Color.yellow; 
        }
        else if(playerNum == 3){
            color = Color.red;          
        }
        else if(playerNum == 4){
            color = Color.green;          
        }
        
    }
    public static void Draw(Graphics2D g,Blokus obj) {
        for(int i = 0;i<numPlayers;i++){
            players[i].draw(g);
        }
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        if(playerNum == 1)
            Pieces.drawAll(12, 27, 0, 2.1, 2.1, g);
        else if(playerNum == 2)
            Pieces.drawAll(26, -403, 90, 2.1, 2.1, g);
        else if(playerNum == 3)
            Pieces.drawAll(-406, -417, 180, 2.1, 2.1, g);
        else if(playerNum == 4)
            Pieces.drawAll(-417, 12, 270, 2.1, 2.1, g);
        
    }
    public Color getColor(){
        return color;
    }

    public int getPlayerNum(){
        return playerNum;
    }
    
    public static Player GetCurrentPlayer(){
       return currentTurn;     
    }   
    public static void switchTurns(){
        int val = currentTurn.getPlayerNum();
        val++;
        if(val <= 4){
            currentTurn = Player.getPlayer(val);
        }
        else{
            val = 1;
            currentTurn = Player.getPlayer(val);
        }
    }
      public static Player switchPlayer(){
            if(currentTurn == players[0]){
                currentTurn = players[1];
            }
            else
                currentTurn = players[0];
           return(currentTurn);
       }

    public static Player GetNextPlayer(){             
        return players[(currentTurn.getPlayerNum()+1)];
    }
    public static Player getPlayer(int playerNumber){
        return players[playerNumber-1];
    }
}

