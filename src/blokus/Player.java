
package blokus;

import java.awt.Color;

public class Player {
    private static Player currentTurn;
    private static int numPlayers = 4;
    private static Player players[] = new Player[4];
    private Color color;
    private int playerNum;
    
    public static void Reset(){
        
        if(players[0] == null){     
            for(int i = 0;i<numPlayers;i++){               
                players[i] = new Player(i);   
            }
        }   
        currentTurn = players[0];
    }
    
    Player(int _num){       
        playerNum = _num;
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
    public Color getColor(){
        return color;
    }

    public int getPlayerNum(){
        return playerNum;
    }
    
    public static Player GetCurrentPlayer(){
       return currentTurn;     
    }   

    public static Player GetNextPlayer(){             
        return players[(currentTurn.getPlayerNum()+1)];
    }
    public static Player getPlayer(int playerNumber){
        return players[playerNumber];
    }
}

