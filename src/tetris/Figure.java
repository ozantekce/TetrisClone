package tetris;

import java.awt.Point;


public abstract class Figure {
    // line and column
    
    protected int firstColumn;
    private Point [] points = new Point[4];
    
    protected int rotation=0;
    
    private int color;
    
    
    protected int getLine(int pointNum){
        
        if(pointNum<0||pointNum>=points.length)return -1;//ERROR
        
        return points[pointNum].x;
        
        
    }
    
    protected int getColumn(int pointNum){
        
        if(pointNum<0||pointNum>=points.length)return -1;//ERROR
        
        return points[pointNum].y;
        
        
    }
    
    
    protected boolean setLine(int pointNum,int line){
        
        if(pointNum<0||pointNum>=points.length||line<0||line>=Map.NUMBEROFLINE)return false;//ERROR
        
        points[pointNum].x=line;
        
        return true;
        
        
    }
    
    protected boolean setColumn(int pointNum,int column){
        
        if(pointNum<0||pointNum>=points.length||column<0||column>=Map.NUMBEROFCOLUMN)return false;//ERROR
        
        points[pointNum].y=column;
        
        return true;
        
        
    }

    public Figure(int firstColumn,int color) {
        this.firstColumn = firstColumn;
        this.color=color;
        
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(0, 0);
        }
        create();
        
    }
    
    protected abstract void create();
    
    protected abstract boolean spin();
    
    protected abstract boolean spin2(int line,int column);
    
    protected boolean drop(){
        
        
        for (int i = 0; i < points.length; i++) {
            
            if(!Map.isEmpty(points[i].x+1, points[i].y))return false;
            
        }
        
        for (int i = 0; i < points.length; i++) {
            
            points[i].x++;
            
        }
        
        return true;
    }
    
    
    protected boolean right(){
        
        for (int i = 0; i < points.length; i++) {
            
            if(!Map.isEmpty(points[i].x, points[i].y+1))return false;
            
        }
        
        for (int i = 0; i < points.length; i++) {
            
            points[i].y++;
            
        }
        
        return true;
    }
    
    
    protected boolean left(){
        
        for (int i = 0; i < points.length; i++) {
            
            if(!Map.isEmpty(points[i].x, points[i].y-1))return false;
            
        }
        
        for (int i = 0; i < points.length; i++) {
            
            points[i].y--;
            
        }
        
        return true;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
    
    
    
    
}
