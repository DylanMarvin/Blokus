
package blokus;

import java.awt.Color;

public class Player {
    private static Player currentTurn;
    private static int numPlayers;
    private static Player players[] = new Player[4];
    private int points;
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
    public int getPoints(){
        return points;
    }
    public void setPoints(int _points){
        points = _points;
    }
    public int getPlayerNum(){
        return playerNum;
    }
    
    public static Player GetCurrentPlayer(){
        
        if(currentTurn == players[0])
            return players[0];
        else 
            return players[1];
        
    }   
    public static void AddPoints(int player, int _points){
        players[player].points += _points;
    }
    
    public static int GetPoints(int player){
        return players[player].points;
    }
    public static Player GetNextPlayer(){             
        return players[(currentTurn.getPlayerNum()+1)];
    }
    public static Player getPlayer(int playerNumber){
        return players[playerNumber];
    }
}

