package tetris;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;



public class Spot  {
    
    private int x;
    private int y;
    public static int height=30;
    public static int witdh=30;
    private Color color;
    private int c=-1;
    
    private boolean del=false;
    
    private boolean change=false;
    
    public Spot(int line, int column) {
        this.x = column*witdh;
        this.y = line*height;
        this.color=Color.white;
        change=true;
    }

    public void setColor(int c) {
        if(c==0){
            this.color=Color.WHITE;
        }
        else if(c==1){
            this.color=Color.BLUE.brighter();
        }
        else if(c==2){
            this.color=Color.BLUE.darker();
        }
        else if(c==3){
            this.color=Color.ORANGE;
        }
        else if(c==4){
            this.color=Color.YELLOW;
        }
        else if(c==5){
            this.color=Color.GREEN;
        }
        else if(c==6){
            this.color=Color.MAGENTA;
        }
        else if(c==7){
            this.color=Color.RED;
        }
        
        red=(int) (color.getRed());
        green=(int) (color.getGreen());
        blue=(int) (color.getBlue());
        
        kR=red/300;
        kG=green/300;
        kB=blue/300;
        
        if(change)return;
        
        change = this.c != c;
        
        this.c=c;
        
        
    }

    public Color getColor() {
        return color;
    }
    
    public Rectangle getBounds() {
        
      return new Rectangle((int)x,(int)y, (int) witdh, (int) height);
      

    }
    
    private int times=0;
    private double red;
    private double green;
    private double blue;
    
    private double kR;
    private double kG;
    private double kB;
    
    
    public void render(Graphics g){
        
        if(del){
            
            if(times<250){
                red-=kR;
                green-=kG;
                blue-=kB;
                
                if(red<0)red=kR;
                if(green<0)green=kG;
                if(blue<0)blue=kB;
                
            }
            else if(times>700){
                times=0;
            }
            else{
                red+=kR;
                green+=kG;
                blue+=kB;
                
                if(red>254)red=254;
                if(green>254)green=254;
                if(blue>254)blue=254;
            }
            
            g.setColor(new Color((int)red,(int)green,(int)blue)); 
            
            
            Graphics2D g2d =(Graphics2D)g;
            g.fillRect((int)x, (int)y,(int) witdh,(int) height);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, witdh, height);
            
            times++;
            c=-1;
            change=true;
            return;
        }
        
        times=0;
        
      //  if(!change)return;
        
        g.setColor(color);         
        Graphics2D g2d =(Graphics2D)g;
        g.fillRect((int)x, (int)y,(int) witdh,(int) height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, witdh, height);
        change=false;
    }

    public void setDel(boolean del) {
        
        this.del = del;
    }

    public boolean isDel() {
        return del;
    }

    public boolean isChange() {
        return change;
    }
    
    
    
    
}
