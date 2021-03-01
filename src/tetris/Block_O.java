package tetris;


public class Block_O extends Figure{

    public Block_O(int firstColumn, int color) {
        super(firstColumn,color);
    }

    
    
    @Override
    protected void create() {
        
        setLine(0, 0);
        setLine(1, 0);
        setLine(2, 1);
        setLine(3, 1);
        
        
        setColumn(0, firstColumn);
        setColumn(1, firstColumn+1);
        setColumn(2, firstColumn);
        setColumn(3, firstColumn+1);
        
        //CONTROL
        for (int i = 0; i < 4; i++) {
            if(!Map.isEmpty(getLine(i), getColumn(i))) return;//ERROR
        }
        
        
        for (int i = 0; i < 4; i++) {
            
            Map.fill(getLine(i), getColumn(i),getColor());
            
        }
        
        Map.current = this;
    }

    @Override
    protected boolean spin() {
        return true;
    }

    @Override
    protected boolean spin2(int line, int column) {
       return true;
    }
    
    
    
    
}
