package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import tetris.Map;


public class MyCanvas extends java.awt.Canvas{

    public MyCanvas(int width, int height) {
        
        this.setBounds(0, 0, width, height);
        
        this.addKeyListener(new KeyInput());
        
    }
    
    
    
    
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {

            this.createBufferStrategy(3);
            return;

        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        
        // START
        
        int times=0;
        for (int i = 0; i < Map.NUMBEROFLINE; i++) {
            
            for (int j = 0; j < Map.NUMBEROFCOLUMN; j++) {
                
                if(Map.spots[i][j].isChange()||Map.spots[i][j].isDel()){
                    Map.spots[i][j].render(g);
                }
                
            }
            
        }
        
        // STOP
        
        g.dispose();

        bs.show();
    }
    
    
}
