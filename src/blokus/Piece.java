package blokus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Piece {

    public static enum Block {
        ONE, TWO, I3, I4, I5, V3, L4, L5, T4, T5, O, W, U, X, P, Y, F, N, Z4, Z5, V5
    };

    private Color color;
    private int random;
    private Block block;
    private int row;
    private int column;

    Piece(Color _color, Block _block, int _row, int _column) {
        color = _color;
        block = _block;
        row = _row;
        column = _column;

    }

    Color getColor() {
        return (color);
    }

    Block getBlock() {
        return (block);
    }

    public void draw(Graphics2D g, int _row, int _column, int xdelta, int ydelta) {

        g.setColor(color);
        g.fillRect(Window.getX(_column * xdelta), Window.getY(_row * ydelta), xdelta, ydelta);

    }

    public void One(Piece board[][]) {
        board[row][column] = this;
    }

    public void Two(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
            board[row][column + 1] = this;
        }
        else if(rotation == 90){
            board[row][column] = this;
            board[row + 1][column] = this;
        }
        else if(rotation == 180){
            board[row][column] = this;
            board[row][column - 1] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
            board[row - 1][column] = this;
        }
    }

    public void I3(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
            board[row][column + 1] = this;
            board[row][column + 2] = this;
        }
        else if(rotation == 90){
            board[row][column] = this;
            board[row + 1][column] = this;
            board[row + 2][column] = this;
        }
        else if(rotation == 180){
            board[row][column] = this;
            board[row][column - 1] = this;
            board[row][column - 2] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
            board[row - 1][column ] = this;
            board[row - 2][column ] = this;
        }
    }

    public void I4(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
            board[row][column + 1] = this;
            board[row][column + 2] = this;
            board[row][column + 3] = this;
        }
        else if(rotation == 90){            
            board[row][column] = this;
            board[row + 1][column] = this;
            board[row + 2][column] = this;
            board[row + 3][column] = this;
        }
        else if(rotation == 180){
            board[row][column] = this;
            board[row][column - 1] = this;
            board[row][column - 2] = this;
            board[row][column - 3] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
            board[row - 1][column] = this;
            board[row - 2][column] = this;
            board[row - 3][column] = this;
        }
    }

    public void I5(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
            board[row][column + 1] = this;
            board[row][column + 2] = this;
            board[row][column + 3] = this;
            board[row][column + 4] = this;
        }
        else if(rotation == 90){
            board[row][column] = this;
            board[row + 1][column] = this;
            board[row + 2][column] = this;
            board[row + 3][column] = this;
            board[row + 4][column] = this;
            
        }
        else if(rotation == 180){
            board[row][column] = this;
            board[row][column - 1] = this;
            board[row][column - 2] = this;
            board[row][column - 3] = this;
            board[row][column - 4] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
            board[row - 1][column] = this;
            board[row - 2][column] = this;
            board[row - 3][column] = this;
            board[row - 4][column] = this;
        }
    }


    public void V3(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
            board[row + 1][column + 1] = this;
            board[row + 1][column] = this;
        }
        else if(rotation == 90){
            board[row][column] = this;
            board[row ][column + 1] = this;
            board[row + 1][column] = this;
        }
        else if(rotation == 180){
            board[row][column] = this;
            board[row + 1][column - 1] = this;
            board[row + 1][column] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
            board[row ][column - 1] = this;
            board[row + 1][column] = this;
        }
    }

    public void L4(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
            board[row + 1][column] = this;
            board[row + 2][column] = this;
            board[row + 2][column + 1] = this;
        }
        else if(rotation == 90){
            board[row][column] = this;
        board[row ][column+1] = this;
        board[row ][column+2] = this;
        board[row + 1][column ] = this;
        }
        else if(rotation == 180){
            board[row][column] = this;
        board[row + 1][column] = this;
        board[row + 2][column] = this;
        board[row + 2][column -1] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
        board[row ][column-1] = this;
        board[row ][column-2] = this;
        board[row + 1][column ] = this;
            
        }
    }

    public void L5(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
        board[row + 1][column] = this;
        board[row + 2][column] = this;
        board[row + 3][column] = this;
        board[row + 3][column + 1] = this;
        }
        else if(rotation == 90){
            board[row][column] = this;
        board[row ][column+1] = this;
        board[row ][column+2] = this;
        board[row + 1][column ] = this;
        board[row ][column + 3] = this;
        }
        else if(rotation == 180){
            board[row][column] = this;
        board[row + 1][column] = this;
        board[row + 2][column] = this;
        board[row + 3][column] = this;
        board[row + 3][column - 1] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
        board[row ][column-1] = this;
        board[row ][column-2] = this;
        board[row + 1][column ] = this;
        board[row ][column - 3] = this;
        }
    }

    public void T4(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
        board[row + 1][column+1] = this;       
        board[row][column +1] = this;
        board[row][column + 2] = this;
        }
        else if(rotation == 90){
             board[row][column] = this;
        board[row -1][column] = this;       
        board[row-2][column] = this;
        board[row-1][column - 1] = this;
        }
        else if(rotation == 180){
            board[row][column] = this;
        board[row - 1][column+1] = this;       
        board[row][column +1] = this;
        board[row][column + 2] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
        board[row -1][column] = this;       
        board[row-2][column] = this;
        board[row-1][column + 1] = this;      
        }
    }

    public void T5(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
            board[row + 1][column+1] = this;       
            board[row][column +1] = this;
            board[row][column + 2] = this;
            board[row + 2][column + 1] = this;
        }
        else if(rotation == 90){
            board[row][column] = this;
            board[row -1][column] = this;       
            board[row-2][column] = this;
            board[row-1][column - 1] = this;
            board[row - 1][column - 2] = this;
        }
        else if(rotation == 180){
            board[row][column] = this;
            board[row -1][column] = this;       
            board[row-2][column] = this;
            board[row-1][column + 1] = this;
            board[row - 1][column + 2] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
            board[row -1][column] = this;       
            board[row-2][column] = this;
            board[row-1][column + 1] = this;
            board[row - 1][column + 2] = this;
        }
    }

    public void O(Piece board[][],int rotation) {
        board[row][column] = this;
        board[row][column + 1] = this;
        board[row + 1][column] = this;
        board[row + 1][column + 1] = this;
    }

    public void W(Piece board[][]) {
        board[row][column] = this;
        board[row + 1][column] = this;
        board[row + 1][column + 1] = this;
        board[row + 2][column + 1] = this;
        board[row + 2][column + 2] = this;
    }

    public void U(Piece board[][],int rotation) {
        if(rotation == 0){
            board[row][column] = this;
            board[row+1][column] = this;
            board[row + 1][column + 1] = this;
            board[row + 1][column + 2] = this;
            board[row][column + 2] = this;
        }
        else if(rotation == 90){
            board[row][column] = this;
            board[row][column-1] = this;
            board[row + 1][column -1] = this;
            board[row + 2][column - 1] = this;
            board[row+2][column] = this;
        }
        else if(rotation == 180){
            board[row][column] = this;
            board[row-1][column] = this;
            board[row - 1][column -1] = this;
            board[row - 2][column - 2] = this;
            board[row][column-2] = this;
        }
        else if(rotation == 270){
            board[row][column] = this;
            board[row][column+1] = this;
            board[row + 1][column +1] = this;
            board[row + 2][column + 1] = this;
            board[row+2][column] = this;
        }
    }

    public void X(Piece board[][],int rotation) {
        board[row][column] = this;
        board[row + 1][column] = this;
        board[row + 1][column -1] = this;
        board[row + 1][column + 1] = this;
        board[row + 2][column] = this;
    }

    public void P(Piece board[][],int rotation) {
        if(rotation == 0){
        }
        else if(rotation == 90){
            
        }
        else if(rotation == 180){
            
        }
        else if(rotation == 270){
            
        }
    }

    public void Y(Piece board[][],int rotation) {
        if(rotation == 0){
        }
        else if(rotation == 90){
            
        }
        else if(rotation == 180){
            
        }
        else if(rotation == 270){
            
        }
    }

    public void F(Piece board[][],int rotation) {
        if(rotation == 0){
        }
        else if(rotation == 90){
            
        }
        else if(rotation == 180){
            
        }
        else if(rotation == 270){
            
        }
    }

    public void N(Piece board[][],int rotation) {
        if(rotation == 0){
        }
        else if(rotation == 90){
            
        }
        else if(rotation == 180){
            
        }
        else if(rotation == 270){
            
        }
    }

    public void Z4(Piece board[][],int rotation) {
        if(rotation == 0){
        }
        else if(rotation == 90){
            
        }
        else if(rotation == 180){
            
        }
        else if(rotation == 270){
            
        }
    }

    public void Z5(Piece board[][],int rotation) {
        if(rotation == 0){
        }
        else if(rotation == 90){
            
        }
        else if(rotation == 180){
            
        }
        else if(rotation == 270){
            
        }
    }

    public void V5(Piece board[][],int rotation) {
        if(rotation == 0){
        }
        else if(rotation == 90){
            
        }
        else if(rotation == 180){
            
        }
        else if(rotation == 270){
            
        }
    }

}
