package UI;

import javax.swing.JPanel;


public class GamePanel extends JPanel{

    MyCanvas mc;
    
    public GamePanel(int w,int h) {
        super(null);
        this.setBounds(20, 5, w+5, h+5);
        
        mc = new MyCanvas(w+5, h+5);
        
        this.add(mc);
        
        
    }
    
    
    public void render(){
        
        mc.render();
        
    }
    
    
}
