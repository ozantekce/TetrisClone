
package UI;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{

    
    private long delay=100;
    
    private long lastTime=System.currentTimeMillis();
    
    public void keyPressed(KeyEvent e){
        
        if(delay>=(System.currentTimeMillis()-lastTime)){
            return;
        }
    
        int key =e.getKeyCode();
        
        if(key==KeyEvent.VK_W) {
            if(MyFrame.map.current!=null)
            MyFrame.map.spinCurrent();
            
        }
        else if(key==KeyEvent.VK_A) {
            if(MyFrame.map.current!=null)
            MyFrame.map.leftCurrent();
            
        }
        else if(key==KeyEvent.VK_S) {
            if(MyFrame.map.current!=null)
            MyFrame.map.dropCurrent();
            
        }
        else if(key==KeyEvent.VK_D) {
            if(MyFrame.map.current!=null)
            MyFrame.map.rightCurrent();
            
        }
        
        lastTime = System.currentTimeMillis();
    
    }
    

    
    
    
    
}    
    
    
    
    

    