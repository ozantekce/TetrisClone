
package UI;

import java.awt.HeadlessException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import tetris.Map;


public class MyFrame extends JFrame implements Runnable{
//w=300 h=600
    
    private GamePanel gp;
    public static Map map;
    
    
    public MyFrame(String name, int w, int h) throws HeadlessException {
        super(name);
        
        map = new Map();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(w+50, h+50);

        this.getContentPane().setLayout(null);
        
        gp = new GamePanel(w,h);
        
        this.getContentPane().add(gp);
        this.setVisible(true);
        
        
        
    }

    int gameSpeed=10;
    private Thread thread;
    private boolean run=false;
    
    @Override
    public void run() {
        
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(run){

         long now = System.nanoTime();
         delta += (now - lastTime) / ns;
         lastTime = now;

         while(delta >= 1){
          tick();
          
          
          updates++;
          delta--;

         }
         render();
         frames++;
         
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

         if(System.currentTimeMillis() - timer > 1000){
          timer += 1000;
          System.out.println("FPS: " + frames + " TICKS: " + updates);
          frames = 0;
          updates = 0;
         }


        }

    }
    
    
    
    public void Start() {
        thread = new Thread(this);
        thread.start();
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public boolean isRun() {
        return run;
    }
    
    
    public void render(){
        
        
        gp.render();
        
        
    }

    private int times=0;
    public void tick(){
        
        times++;
        if(map.current==null){
            map.controlLines();
            long delay=500;
            long current = System.currentTimeMillis();
            while (System.currentTimeMillis()-current<=delay) {                            
                render();
            }
            map.randomBlock();
            if(Map.gameover){
                run = false;
                return;
            }
            else{
                map.resetRandomSize();
            }
            times=0;
            
        }
        map.arrangeSpots();
        if(times>=50){
            map.dropCurrent();
            times = 0;
        }
    }
    
    
    
    
}
