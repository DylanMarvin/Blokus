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
    
    public static void AddPiecePixel(int xpixel, int ypixel,Piece.Block block) {
        
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
                if(checkPieceH(zrow,zcol,1) && checkPieceV(zrow,zcol,1)){
                    board[zrow][zcol] = piece;                           
                    Player.switchTurns();
                }
            }
            
            else if (piece.getBlock() == Piece.Block.TWO) {
                if(checkPieceH(zrow,zcol,2) && checkPieceV(zrow,zcol,2)){
                    piece.Two(board);
                    Player.switchTurns();
                }
            }
            else if (piece.getBlock() == Piece.Block.I3) { 
                if(checkPieceH(zrow,zcol,3 ) && checkPieceV(zrow,zcol,3)){
                    piece.I3(board);
                        Player.switchTurns();
                }
            }
            else if (piece.getBlock() == Piece.Block.I4) {         
                if(checkPieceH(zrow,zcol,4) && checkPieceV(zrow,zcol,4)){
                    piece.I4(board);
                    Player.switchTurns();
                }
            }
            else if (piece.getBlock() == Piece.Block.I5) {  
                if(checkPieceH(zrow,zcol,5) && checkPieceV(zrow,zcol,5)){
                    piece.I5(board);
                    Player.switchTurns();
                }
            }
            else if (piece.getBlock() == Piece.Block.L4) {
                if(checkPieceL(zrow,zcol,3)){
                    piece.L4(board);
                    Player.switchTurns();
                }
            }
            else if (piece.getBlock() == Piece.Block.L5) { 
                if(checkPieceL(zrow,zcol,4)){
                    piece.L5(board);
                    Player.switchTurns();
                }
            }
            else if (piece.getBlock() == Piece.Block.N) {        
                if(checkPieceN(zrow,zcol,4)){
                    piece.N(board);
                    Player.switchTurns();
                }
            }
            else if (piece.getBlock() == Piece.Block.O) { 
                if(checkPieceO(zrow,zcol,2)){
                    piece.O(board);
                    Player.switchTurns();
                }           
            }
            else if (piece.getBlock() == Piece.Block.W) {  
                if(checkPieceW(zrow,zcol,2)){
                    piece.W(board);
                    Player.switchTurns();
                }           
            
            }
            else if (piece.getBlock() == Piece.Block.T4) {  
                 if(checkPieceT4(zrow,zcol,4)){
                piece.T4(board);
                Player.switchTurns();
                 }
            }
            else if (piece.getBlock() == Piece.Block.T5) {    
                if(checkPieceT5(zrow,zcol,5)){
                piece.T5(board);
                Player.switchTurns();
                }
            }
            else if (piece.getBlock() == Piece.Block.U) { 
                
                piece.U(board);
                Player.switchTurns();
            }
            else if (piece.getBlock() == Piece.Block.V3) {
                if(checkPieceV3(zrow,zcol,5)){                
                piece.V3(board);
                Player.switchTurns();
                }
            }
            else if (piece.getBlock() == Piece.Block.V5) {                
                piece.V5(board);
                Player.switchTurns();
            }
            else if (piece.getBlock() == Piece.Block.F) {                
                piece.F(board);
                Player.switchTurns();
            }
            else if (piece.getBlock() == Piece.Block.P) {                
                piece.P(board);              
                Player.switchTurns();
            }
            else if (piece.getBlock() == Piece.Block.X) {                
                piece.X(board);
                Player.switchTurns();
            }
            else if (piece.getBlock() == Piece.Block.Y) {                
                piece.Y(board);
                Player.switchTurns();
            }
            else if (piece.getBlock() == Piece.Block.Z4) {                
                piece.Z4(board);
                Player.switchTurns();
            }
            else if (piece.getBlock() == Piece.Block.Z5) {                
                piece.Z5(board);
                Player.switchTurns();
            }
            

        }
    }
    private static boolean checkPieceH(int zrow,int zcol,int val){
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
    private static boolean checkPieceV(int zrow,int zcol,int val){
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
    private static boolean checkPieceL(int zrow,int zcol,int val){
        
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
    private static boolean checkPieceO(int zrow,int zcol,int val){
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
    
    private static boolean checkPieceN(int zrow,int zcol,int val){
        
            for(int j = 1;j>-1;j--){
                    if(zrow+j == -1){
                        return false;
                    }               
                    if(j == 0){
                        for(int i = 0;i<val/2;i++){
                            if(zcol+i == NUM_COLUMNS){
                                return false;
                            }
                            if(board[zrow+j][zcol+i] != null){
                                       return false;
                            }    
                        }
                    }
                    else if(j<0){
                        for(int i = 0;i<val;i++){
                            if(zcol+i == NUM_COLUMNS){
                                return false;
                            }
                            if(board[zrow+j][zcol+i] != null){
                                       return false;
                            }    
                        }
                    }
            }
            return true;
        }
    
    private static boolean checkPieceW(int zrow,int zcol,int val){
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
     
     private static boolean checkPieceT4(int zrow,int zcol,int val){
        if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol+1] == null &&       
        board[zrow][zcol +1] == null &&
        board[zrow][zcol + 2] == null){
            return(true);
        }
        return(false);
        }
     
      private static boolean checkPieceT5(int zrow,int zcol,int val){
        if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol+1] == null &&       
        board[zrow][zcol +1] == null &&
        board[zrow][zcol + 2] == null &&
        board[zrow + 2][zcol + 1] == null){
            return(true);
        }
        return(false);
        }
      
      private static boolean checkPieceV3(int zrow,int zcol,int val){
        if(board[zrow][zcol] == null &&
        board[zrow + 1][zcol+1] == null &&       
        board[zrow + 1][zcol] == null){
            return(true);
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

       