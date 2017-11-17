package blokus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

public class Board {
    
    private final static int NUM_ROWS = 20;
    private final static int NUM_COLUMNS = 20;    
    private final static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    
    Board() {
        
    }
    
    public static void Reset() {
        for (int zrow = 0; zrow < Board.NUM_ROWS; zrow++) {
            for (int zcolumn = 0; zcolumn < Board.NUM_COLUMNS; zcolumn++) {                
                board[zrow][zcolumn] = null;
            }
        }
    }
    
    public static void CheckWin() {
        
    }
    
    public static void AddPiecePixel(int xpixel, int ypixel,Piece.Block block,int rotation) {
        
        int ydelta = Window.getHeight2() / NUM_ROWS;
        int xdelta = Window.getWidth2() / NUM_COLUMNS;
        
        int zcol = 0;
        int zrow = 0;
        
        if (xpixel - Window.getX(0) > 0
                && ypixel - Window.getY(0) > 0
                && xpixel - Window.getX(0) < xdelta * NUM_COLUMNS
                && ypixel - Window.getY(0) < ydelta * NUM_ROWS) {
            
            zcol = (xpixel - Window.getX(0)) / xdelta;
            zrow = (ypixel - Window.getY(0)) / ydelta;

//            if(board[zrow][zcol] != null ){
//                
//           board[zrow][zcol] = null;
//            }
//            


            Piece piece = new Piece(Player.GetCurrentPlayer().getColor(), block, zrow, zcol);
            
            if(Player.GetCurrentPlayer().getFirstPiece() == true){
                System.out.println(zcol);
                if(Player.GetCurrentPlayer() == Player.getPlayer(1)){                    
                    if(zrow != 0 || zcol != 0){                        
                        return;
                    }
                    else{
                        Player.getPlayer(1).setFirstPiece();
                    }
                }
                else if(Player.GetCurrentPlayer() == Player.getPlayer(2)){                    
                    if(zrow != 0 || zcol != 19){                        
                        return;
                    }
                    else{
                        Player.getPlayer(2).setFirstPiece();
                    }
                }
                else if(Player.GetCurrentPlayer() == Player.getPlayer(3)){                    
                    if(zrow != 19 || zcol != 19){                        
                        return;
                    }
                    else{
                        Player.getPlayer(3).setFirstPiece();
                    }
                }
                else if(Player.GetCurrentPlayer() == Player.getPlayer(4)){                    
                    if(zrow != 19 || zcol != 0){                        
                        return;
                    }
                    else{
                        Player.getPlayer(4).setFirstPiece();
                    }
                }
            }
            
            if (piece.getBlock() == Piece.Block.ONE) { 
                if(checkPieceH(zrow,zcol,1,rotation) && checkPieceV(zrow,zcol,1,rotation)){
                    board[zrow][zcol] = piece;
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(0);
                    Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            
            else if (piece.getBlock() == Piece.Block.TWO) {
                if(checkPieceH(zrow,zcol,2,rotation) && checkPieceV(zrow,zcol,2,rotation)){

                    piece.Two(board,rotation);
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(1);
                    Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            else if (piece.getBlock() == Piece.Block.I3) { 
                if(checkPieceH(zrow,zcol,3,rotation ) && checkPieceV(zrow,zcol,3,rotation)){
                    piece.I3(board,rotation);
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(2);
                    Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            else if (piece.getBlock() == Piece.Block.I4) {         
                if(checkPieceH(zrow,zcol,4,rotation) && checkPieceV(zrow,zcol,4,rotation)){
                    piece.I4(board,rotation);
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(3);
                    Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            else if (piece.getBlock() == Piece.Block.I5) {  
                if(checkPieceH(zrow,zcol,5,rotation) && checkPieceV(zrow,zcol,5,rotation)){
                    piece.I5(board,rotation);
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(4);
                    Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            else if (piece.getBlock() == Piece.Block.L4) {
                if(checkPieceL(zrow,zcol,3,rotation)){
                    piece.L4(board,rotation);
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(6);
                    Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            else if (piece.getBlock() == Piece.Block.L5) { 
                if(checkPieceL(zrow,zcol,4,rotation)){
                    piece.L5(board,rotation);                    
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(7); 
                    Player.GetCurrentPlayer().setCompletedC(Challenge.checkChallenge());
                    if(Player.getCompletedC() == false)
                        Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            else if (piece.getBlock() == Piece.Block.N) {        
                if(checkPieceN(zrow,zcol,4,rotation)){
                    piece.N(board,rotation);
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(17);
                    Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            else if (piece.getBlock() == Piece.Block.O) { 
                if(checkPieceO(zrow,zcol,2,rotation)){
                    piece.O(board,rotation);
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(10);
                    Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }           
            }
            else if (piece.getBlock() == Piece.Block.W) {  
                if(checkPieceW(zrow,zcol,2,rotation)){
                    piece.W(board,rotation);
                    Player.GetCurrentPlayer().getOutsidePieces().changePiece(11);
                    Player.switchTurns();
                    Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }           
            
            }
            else if (piece.getBlock() == Piece.Block.T4) {  
                 if(checkPieceT4(zrow,zcol,4,rotation)){
                piece.T4(board,rotation);
                Player.GetCurrentPlayer().getOutsidePieces().changePiece(9);
                Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                 }
            }
            else if (piece.getBlock() == Piece.Block.T5) {    
                if(checkPieceT5(zrow,zcol,5,rotation)){
                piece.T5(board,rotation);              
                Player.GetCurrentPlayer().getOutsidePieces().changePiece(8);          
                Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            else if (piece.getBlock() == Piece.Block.U) {

                if(checkPieceU(zrow,zcol,5,rotation)){
                    piece.U(board,rotation);
                Player.GetCurrentPlayer().getOutsidePieces().changePiece(12);
                Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }
            else if (piece.getBlock() == Piece.Block.V3) {
                if(checkPieceV3(zrow,zcol,5,rotation)){                
                piece.V3(board,rotation);
                Player.GetCurrentPlayer().getOutsidePieces().changePiece(5);
                Player.GetCurrentPlayer().setCompletedC(Challenge.checkChallenge());
                if(Player.getCompletedC() == false)
                    Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }

            else if (piece.getBlock() == Piece.Block.V5) {
              if(checkPieceV5(zrow,zcol,5,rotation)){                
                piece.V5(board,rotation);
                   Player.GetCurrentPlayer().getOutsidePieces().changePiece(20);
                Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
              }
            }

            else if (piece.getBlock() == Piece.Block.F) {
                if(checkPieceF(zrow,zcol,5,rotation)){                
                piece.F(board,rotation);
                   Player.GetCurrentPlayer().getOutsidePieces().changePiece(16);
                Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }

            else if (piece.getBlock() == Piece.Block.P) { 
                if(checkPieceP(zrow,zcol,5,rotation)){
                piece.P(board,rotation);              
                   Player.GetCurrentPlayer().getOutsidePieces().changePiece(14);
                Player.switchTurns();
                }
            }

            else if (piece.getBlock() == Piece.Block.X) {
                if(checkPieceX(zrow,zcol,5,rotation)){
                piece.X(board,rotation);
                   Player.GetCurrentPlayer().getOutsidePieces().changePiece(13);
                Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
                }
            }

            else if (piece.getBlock() == Piece.Block.Y) {
                if(checkPieceY(zrow,zcol,5,rotation)){                
                piece.Y(board,rotation);
                   Player.GetCurrentPlayer().getOutsidePieces().changePiece(15);
                Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
            }
            }
            else if (piece.getBlock() == Piece.Block.Z4) {
                 if(checkPieceZ4(zrow,zcol,5,rotation)){    
                piece.Z4(board,rotation);
                   Player.GetCurrentPlayer().getOutsidePieces().changePiece(18);
                if(Player.getCompletedC() == false)
                    Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
            }
            }
            else if (piece.getBlock() == Piece.Block.Z5) {                

                if(checkPieceZ5(zrow,zcol,5,rotation)){    
                piece.Z5(board,rotation);
                Player.GetCurrentPlayer().getOutsidePieces().changePiece(19);
                Player.GetCurrentPlayer().setCompletedC(Challenge.checkChallenge());
                if(Player.getCompletedC() == false)
                Player.switchTurns();
                Challenge.setChallenges(Player.GetCurrentPlayer().getOutsidePieces());
            }
            }
            

        }
    }
   //////////////////////////////////////////////////////////////////////////////
    private static boolean checkPieceH(int zrow,int zcol,int val,int rotation){
        for(int i = 0;i<val;i++){
            if(zcol+i == NUM_COLUMNS){
                return false;
            }
            if(board[zrow][zcol+i] != null){
                       return false;
            }    
        }
        return(true);
    }
    private static boolean checkPieceV(int zrow,int zcol,int val,int rotation){
        for(int i = 0;i<val;i++){
            if(zrow+i == NUM_ROWS){
                return false;
            }
            if(board[zrow+i][zcol] != null){
                       return false;
            }    
        }
        return(true);
    }
    private static boolean checkPieceL(int zrow,int zcol,int val,int rotation){
        
            for(int j = 0;j<2;j++){
                    if(zcol+j == NUM_COLUMNS){
                        return false;
                    }               
                for(int i = 0;i<val;i++){
                    if(zrow+i == NUM_ROWS){
                        return false;
                    }
                    if(j >0){
                        i = val-1;
                    }
                    if(board[zrow+i][zcol+j] != null){
                               return false;
                    }    
                }
            }
            return true;
        }
    private static boolean checkPieceO(int zrow,int zcol,int val,int rotation){
        for(int j = 0;j<val;j++){
            if(zcol+j == NUM_COLUMNS){
                    return false;
                }
            for(int i = 0;i<val;i++){
                if(zrow+i == NUM_ROWS){
                    return false;
                }
                if(board[zrow+i][zcol+j] != null){
                           return false;
                }    
            }
        }
        return(true);
    }
   ////////////////////////////////////////////////////////////////////////////////////////////// 
    private static boolean checkPieceN(int zrow,int zcol,int val,int rotation){
        if(rotation == 00){
             if(board[zrow][zcol] == null &&
        board[zrow ][zcol+1] == null &&       
        board[zrow-1][zcol +1] == null &&
        board[zrow-1][zcol + 2] == null &&
        board[zrow-1][zcol + 3] == null             ){
            return(true);
        }
        }
        else if(rotation == 90){
         if(board[zrow][zcol] == null&&
        board[zrow+1][zcol ] == null&&
        board[zrow +1][zcol + 1] == null&&
        board[zrow +2][zcol + 1] == null&&
        board[zrow +3][zcol + 1] == null){
            return(true);
        }
        }
        else if(rotation == 180){
         if(board[zrow][zcol] == null&&
        board[zrow][ zcol-1] == null&&
        board[zrow + 1][zcol - 1] == null&&
        board[zrow + 1][zcol - 2] == null&&
        board[zrow + 1][zcol - 3] == null){
            return(true);
        }
        }
        else if(rotation == 270){
            if(
        board[zrow][zcol] == null&&
        board[zrow-1][zcol] == null&&
        board[zrow - 1][zcol - 1]== null&&
        board[zrow - 2][zcol - 1] == null&&
        board[zrow - 3][zcol - 1] == null){
             return(true);
        }
        }     
        return(false);
        }
    
    private static boolean checkPieceW(int zrow,int zcol,int val,int rotation){
        if(rotation == 0){
        if(board[zrow][zcol] == null &&
        board[zrow+1 ][zcol] == null &&       
        board[zrow+1][zcol +1] == null &&
        board[zrow+2][zcol + 1] == null &&
        board[zrow+2][zcol + 2] == null             ){
            return(true);
        }
        }
        else if(rotation == 90){
            if(board[zrow][zcol] == null &&
        board[zrow ][zcol-1] == null &&
        board[zrow + 1][zcol -1] == null &&
        board[zrow + 1][zcol -2] == null &&
        board[zrow + 2][zcol - 2] == null){
                return true;
            } 
        }
        else if(rotation == 180){
           if(board[zrow][zcol] == null &&
        board[zrow - 1][zcol] == null &&
        board[zrow - 1][zcol - 1] == null &&
        board[zrow -2][zcol - 1] == null &&
        board[zrow - 2][zcol -2] == null){
               return true;
           } 
        }
        else if(rotation == 270){
            if(board[zrow][zcol] == null &&
        board[zrow ][zcol+1] == null &&
        board[zrow - 1][zcol + 1] == null &&
        board[zrow - 1][zcol + 2] == null &&
        board[zrow - 2][zcol + 2] == null ){
                return true;
            }
        }
        return(false);
        }
     //////////////////////////////////////////////////////////////
     private static boolean checkPieceT4(int zrow,int zcol,int val,int rotation){
          if(rotation == 0){
        if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol+1] == null &&       
        board[zrow][zcol +1] == null &&
        board[zrow][zcol + 2] == null){
            return(true);
        }
          }
        else if(rotation == 90){
             if(board[zrow][zcol]  == null &&
        board[zrow +1][zcol] == null &&      
        board[zrow+2][zcol]  == null &&
        board[zrow+1][zcol - 1]  == null){
                  return(true);
             }
        }
        else if(rotation == 180){
            if(board[zrow][zcol] == null &&
        board[zrow - 1][zcol-1]  == null &&   
        board[zrow][zcol -1]  == null &&
        board[zrow][zcol - 2] == null){
                 return(true);
            }
        }
        else if(rotation == 270){
            if(board[zrow][zcol]  == null &&
        board[zrow -1][zcol]  == null &&
        board[zrow-2][zcol]  == null &&
        board[zrow-1][zcol + 1]  == null){
             return(true);
        }    
        }
        return(false);
        }
     
      private static boolean checkPieceT5(int zrow,int zcol,int val,int rotation){
          if(rotation == 0){
        if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol+1] == null &&       
        board[zrow][zcol +1] == null &&
        board[zrow][zcol + 2] == null &&
        board[zrow + 2][zcol + 1] == null){
            return(true);
        }
          }
        else if(rotation == 90){
            if(board[zrow][zcol]  == null &&
            board[zrow +1][zcol]  == null &&    
            board[zrow+2][zcol]  == null &&
            board[zrow+1][zcol - 1]  == null &&
            board[zrow + 1][zcol - 2]  == null){
                return(true); 
            }
        }
        else if(rotation == 180){
            if(board[zrow][zcol]  == null &&
            board[zrow ][zcol -1]  == null &&      
            board[zrow][zcol-2]  == null &&
            board[zrow-1][zcol - 1]  == null &&
            board[zrow - 2][zcol -1]  == null){
                return(true); 
            }
        }
        else if(rotation == 270){
            if(board[zrow][zcol]  == null &&
            board[zrow -1][zcol]  == null && 
            board[zrow-2][zcol]  == null &&
            board[zrow-1][zcol + 1]  == null &&
            board[zrow - 1][zcol + 2]  == null){
             return(true);
        }
        }
        return(false);
        }
      
      private static boolean checkPieceV3(int zrow,int zcol,int val,int rotation){
        if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol+1] == null &&       
        board[zrow + 1][zcol] == null){
            return(true);
        }
        else if(rotation == 90){
            if(board[zrow][zcol] == null &&    
            board[zrow ][zcol -1] == null &&    
            board[zrow + 1][zcol-1] == null){
             return(true);
        }    
        }
        else if(rotation == 180){
            if(board[zrow][zcol] == null &&    
            board[zrow - 1][zcol - 1] == null &&    
            board[zrow - 1][zcol] == null){
             return(true);
        }    
        }
        else if(rotation == 270){
            if(board[zrow][zcol] == null &&    
            board[zrow ][zcol + 1] == null &&    
            board[zrow - 1][zcol+1] == null){
             return(true);
        }
        }
        return(false);
      }
        ///////////////////////////////////////////////////////////////////////////
        
       private static boolean checkPieceV5(int zrow,int zcol,int val,int rotation){
           if(rotation == 90){
        if(board[zrow][zcol] == null &&
        board[zrow + 2][zcol+1] == null &&
        board[zrow + 1][zcol+1] == null &&
        board[zrow + 1][zcol] == null &&
        board[zrow+2][zcol] == null  ){
            return(true);
        }
           }
         else if(rotation == 90){
            if(board[zrow][zcol] == null &&
            board[zrow][zcol - 1] == null &&
            board[zrow][zcol - 2] == null &&
            board[zrow+1][zcol -2] == null &&
            board[zrow+2][zcol -2] == null){
             return(true);
         } 
        }
        else if(rotation == 180){
            if(board[zrow][zcol]== null &&
            board[zrow - 2][zcol - 1] == null &&
            board[zrow - 2][zcol - 2] == null &&
            board[zrow-1][zcol] == null &&
            board[zrow-2][zcol] == null){
            return(true);
        } 
            
        }
        else if(rotation == 270){
            if(board[zrow][zcol] == null &&
            board[zrow+2][zcol -1] == null &&
            board[zrow+2][zcol -2] == null &&
            board[zrow+1][zcol] == null &&
            board[zrow+2][zcol] == null){
            return(true);
        } 
        }
        return(false);
        }
     private static boolean checkPieceP(int zrow,int zcol,int val,int rotation){
        if(board[zrow][zcol] == null&&
        board[zrow + 1][zcol] == null&&
        board[zrow][zcol + 1] == null&&
        board[zrow + 1][zcol + 1] == null&&
        board[zrow + 2][zcol] == null){
            return(true);
        }
        return(false);
        }
     ///////////////////////////////////////////////////////////////////////////
      private static boolean checkPieceF(int zrow,int zcol,int val,int rotation){
           if(rotation == 0){
        if(board[zrow][zcol] == null &&
        board[zrow] [zcol +1] == null &&
        board[zrow - 1][zcol ] == null &&
        board[zrow][zcol - 1] == null&&
        board[zrow + 1][zcol +1] == null){
            return(true);
        }
           }
        else if(rotation == 90){
            
         if(board[zrow][zcol]== null &&
        board[zrow+1][zcol ] == null &&
        board[zrow - 1][zcol] == null &&
        board[zrow-1][zcol - 1] == null &&
        board[zrow ][zcol + 1] == null){
            return true;
        } 
        }
        else if(rotation == 180){
                    if(board[zrow][zcol] == null &&
        board[zrow][zcol + 1] == null &&
        board[zrow - 1][zcol] == null &&
        board[zrow][zcol - 1] == null &&
        board[zrow + 1][zcol - 1] == null){
            return true;
        } 
        }
        else if(rotation == 270){
                    if(board[zrow][zcol] == null &&
        board[zrow][zcol + 1] == null &&
        board[zrow - 1][zcol+1] == null &&
        board[zrow][zcol - 1] == null &&
        board[zrow + 1][zcol ] == null){
            return true;
        }}
        return(false);
      }
      
      private static boolean checkPieceU(int zrow,int zcol,int val,int rotation){
           if(rotation == 0){
        if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol] == null &&       
        board[zrow+1][zcol +1] == null &&
        board[zrow+1][zcol + 2] == null &&
        board[zrow][zcol + 2] == null){
            return(true);
        }
                  }
        else if(rotation == 90){
            if(board[zrow][zcol] == null &&
            board[zrow][zcol-1] == null &&
            board[zrow + 1][zcol -1] == null &&
            board[zrow + 2][zcol - 1] == null &&
            board[zrow+2][zcol] == null){
            return true;
        }
        }
        else if(rotation == 180){
            if(board[zrow][zcol] == null &&
            board[zrow-1][zcol] == null &&
            board[zrow - 1][zcol -1] == null &&
            board[zrow - 1][zcol - 2] == null &&
            board[zrow][zcol-2] == null){
                  return true;
                  }
        }
        else if(rotation == 270){
            if(board[zrow][zcol] == null &&
            board[zrow][zcol+1] == null &&
            board[zrow + 1][zcol +1] == null &&
            board[zrow + 2][zcol + 1] == null &&
            board[zrow+2][zcol] == null){
                  return true;
        }
        }
        return(false);
      }
      ///////////////////////////////////////////////////////////////////////////////////
      private static boolean checkPieceX(int zrow,int zcol,int val,int rotation){
          if(rotation == 0){
        if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol] == null &&       
        board[zrow+1][zcol -1] == null &&
        board[zrow+1][zcol + 1] == null &&
        board[zrow+2][zcol ] == null){
            return(true);
        }
          }
        else if(rotation == 90){
           if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol-1] == null &&
        board[zrow - 1][zcol -1] == null &&
        board[zrow][zcol - 1] == null &&
        board[zrow ][zcol-2] == null){
              return(true);
        }
        }
        else if(rotation == 180){
            if(board[zrow][zcol] == null &&
        board[zrow -1][zcol] == null &&
        board[zrow -2][zcol ] == null &&
        board[zrow -1][zcol + 1] == null &&
        board[zrow - 1][zcol -1] == null){
                 return(true); 
            }
        }
        else if(rotation == 270){
            if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol+1] == null &&
        board[zrow - 1][zcol +1] == null &&
        board[zrow ][zcol + 1] == null &&
        board[zrow ][zcol+2] == null){
              return(true);
        }
        }
        return(false);
        }
   
       private static boolean checkPieceY(int zrow,int zcol,int val,int rotation){
           if(rotation == 90){
        if(board[zrow][zcol] == null &&
        board[zrow][zcol+1] == null &&       
        board[zrow+1][zcol +1] == null &&
        board[zrow][zcol + 2] == null &&
        board[zrow][zcol +3] == null){
            return(true);
        }
           }
        else if(rotation == 90){
           if( board[zrow][zcol] == null &&
            board[zrow+1][zcol] == null &&
            board[zrow +2][zcol] == null &&
            board[zrow+3][zcol ] == null &&
            board[zrow+1][zcol -1] == null){
            
        }
        }
        else if(rotation == 180){
                    if(board[zrow][zcol] == null &&
        board[zrow][zcol-1 ] == null &&
        board[zrow ][zcol -2] == null &&
        board[zrow][zcol -3] == null &&
        board[zrow-1][zcol -1] == null){
                        
                    }
        }
        else if(rotation == 270){
                    if(board[zrow][zcol] == null &&
        board[zrow-1][zcol ] == null &&
        board[zrow -2][zcol ] == null &&
        board[zrow-3][zcol ] == null &&
        board[zrow-1][zcol +1] == null){
                        
                    }
        }
        return(false);
        }
        private static boolean checkPieceZ5(int zrow,int zcol,int val,int rotation){
            if(rotation == 0){
        if(board[zrow][zcol] == null &&
        board[zrow+1][zcol] == null &&       
        board[zrow+1][zcol +1] == null &&
        board[zrow+1][zcol + 2] == null &&
        board[zrow+2][zcol +2] == null){
            return(true);
        }
            }
        else if(rotation == 90){
                    if(board[zrow][zcol] == null &&
        board[zrow ][zcol-1] == null &&
        board[zrow + 1][zcol -1] == null &&
        board[zrow + 2][zcol -1] == null &&
        board[zrow + 2][zcol - 2] == null){
                      return(true);  
                    }
        }
        else if(rotation == 180){
                    if(board[zrow][zcol] == null &&
        board[zrow ][zcol-1] == null &&
        board[zrow + 1][zcol -1] == null &&
        board[zrow + 2][zcol -1] == null &&
        board[zrow + 2][zcol - 2] == null){
                       return(true); 
                    }
        }
        else if(rotation == 270){
                    if(board[zrow][zcol] == null &&
        board[zrow ][zcol+1] == null &&
        board[zrow - 1][zcol + 1] == null &&
        board[zrow - 2][zcol + 1] == null &&
        board[zrow - 2][zcol + 2] == null){
                       return(true); 
                    }
        }
        return(false);
        }
        private static boolean checkPieceZ4(int zrow,int zcol,int val,int rotation){
            if(rotation == 0){
        if(board[zrow][zcol] == null &&
        board[zrow+1][zcol] == null &&       
        board[zrow+1][zcol +1] == null &&
        board[zrow+2][zcol + 1] == null){
            return(true);
        }
            }
         else if(rotation == 90){
                    if(board[zrow][zcol]== null &&   
        board[zrow ][zcol-1]== null &&   
        board[zrow + 1][zcol - 1]== null &&   
        board[zrow + 1][zcol - 2]== null){   
                       return(true); 
        }
         }
        else if(rotation == 180){
                    if(board[zrow][zcol]== null &&   
        board[zrow - 1][zcol]== null &&   
        board[zrow - 1][zcol + 1]== null &&   
        board[zrow - 2][zcol + 1]== null ){   
                        return(true);
        }
        }
        else if(rotation == 270){
                    if(board[zrow][zcol]== null &&   
        board[zrow ][zcol+1]== null &&   
        board[zrow - 1][zcol + 1]== null &&   
        board[zrow - 1][zcol + 2]== null ){   
                        return(true);
        }
        }
        return(false);
        
        }
    
    public static void Draw(Graphics2D g,Image image,Blokus obj) {
        int ydelta = Window.getHeight2() / NUM_ROWS;
        int xdelta = Window.getWidth2() / NUM_COLUMNS;

        //draw grid
        g.setColor(Color.black);
        for (int zi = 1; zi < NUM_ROWS; zi++) {
            g.drawLine(Window.getX(0), Window.getY(zi * ydelta),
                    Window.getX(Window.getWidth2()), Window.getY(zi * ydelta));
        }
        
        for (int zi = 1; zi < NUM_COLUMNS; zi++) {
            g.drawLine(Window.getX(zi * xdelta), Window.getY(0),
                    Window.getX(zi * xdelta), Window.getY(Window.getHeight2()));
        }
       g.drawImage(image,Window.getX(0),Window.getY(0),Window.getWidth2(),Window.getHeight2(),obj);
        
        for (int zi = 0; zi < NUM_ROWS; zi++) {
            for (int zx = 0; zx < NUM_COLUMNS; zx++) {
                if (board[zi][zx] != null) {
                    board[zi][zx].draw(g, zi, zx, xdelta, ydelta);
                }
            }
        }
    }

}

       