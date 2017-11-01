
package blokus;

import java.awt.Color;

public class Player {
    private static Player currentTurn;
    private static int numPlayers;
    private static Player players[] = new Player[numPlayers];
    private int points;
    private Color color;
    private int playerNum;
    
    public static void Reset(){
        if(players[0] == null){
            players[0] = new Player(Color.red,1);
            players[1] = new Player(Color.blue,2);
        }   
        currentTurn = players[0];
    }
    
    Player(Color _color,int _num){
        color = _color;
        playerNum = _num;
        
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
    
    public static void TurnChange(){
        
       if(currentTurn == players[0]){
            currentTurn = players[1];
       }
        else if(currentTurn == players[1]){
            currentTurn = players[0];
        }
       
    }
    public static void AddPoints(int player, int _points){
        players[player].points += _points;
    }
    
    public static int GetPoints(int player){
        return players[player].points;
    }
    public static Player GetOtherPlayer(){
        if(currentTurn == players[0])
            return players[1];
        return players[0];
    }
    public static Player getPlayer1(){
        return players[0];
    }
    public static Player getPlayer2(){
        return players[1];
    }

}

