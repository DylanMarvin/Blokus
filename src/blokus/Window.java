package blokus;
class Window {
    static final int XBORDER = 180; //30 + 150
    static final int YBORDER = 180; //30 + 150
    
    static final int YTITLE = 30; //30
    static final int WINDOW_BORDER = 8; //8
    static final int WINDOW_WIDTH =  840; //840 + 150
    static final int WINDOW_HEIGHT = 860; //860 + 150
    
    static int xsize = -1;
    static int ysize = -1;
    
/////////////////////////////////////////////////////////////////////////
    public static int getX(int x) {
        return (x + XBORDER + WINDOW_BORDER);
    }
    public static int getY(int y) {
        return (y + YBORDER + YTITLE );
    }
    public static int getYNormal(int y) {
        return (-y + YBORDER + YTITLE + getHeight2());
    }
    public static int getWidth2() {
        return (xsize - 2 * (XBORDER + WINDOW_BORDER));
    }
    public static int getHeight2() {
        return (ysize - 2 * YBORDER - WINDOW_BORDER - YTITLE);
    }    
}