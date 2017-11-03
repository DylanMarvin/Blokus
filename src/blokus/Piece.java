package blokus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Piece {

    public static enum Block {
        ONE, TWO, I3, I4, I5, 
    };

    private Color color;
    private int random;
    private Block block;
    private int row;
    private int column;

    Piece(Color _color, Block _block) {
        color = _color;
        block = _block;
        

    }

    Color getColor() {
        return (color);
    }


    public void draw(Graphics2D g, int _row, int _column, int xdelta, int ydelta) {
        row = _row;
        column = _column;
        g.setColor(color);
        g.fillRect(Window.getX(column * xdelta),Window.getY(row * ydelta), xdelta, ydelta);
        g.setColor(Color.white);

    }

    public void One(Piece board[][]) {
        board[row][column] = this;
    }

    public void Two(Piece board[][]) {
        board[row][column] = this;
        board[row + 1][column] = this;
    }

    public void Three(Piece board[][]) {
        board[row][column] = this;
        board[row + 1][column] = this;
        board[row + 2][column] = this;
    }

    public void F(Piece board[][]) {
        board[row][column] = this;
        board[row - 1][column] = this;
        board[row][column + 1] = this;
        board[row][column - 1] = this;
        board[row + 1][column + 1] = this;
    }
}
