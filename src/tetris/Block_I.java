package tetris;


public class Block_I extends Figure{

    public Block_I(int firstColumn,int color) {
        super(firstColumn,color);
        
    }

    @Override
    protected void create() {
        
        setLine(0, 0);
        setLine(1, 0);
        setLine(2, 0);
        setLine(3, 0);
        
        
        setColumn(0, firstColumn);
        setColumn(1, firstColumn+1);
        setColumn(2, firstColumn+2);
        setColumn(3, firstColumn+3);
        
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
        

        boolean con;

        if(rotation%4==0){
            int Tl0=getLine(0)-1,Tc0=getColumn(0)+2;
            int Tl1=Tl0+1,Tc1=Tc0;
            int Tl2=Tl0+2,Tc2=Tc0;
            int Tl3=Tl0+3,Tc3=Tc0;

            con = Map.isEmpty(Tl0, Tc0) && Map.isEmpty(Tl1, Tc1) && Map.isEmpty(Tl2, Tc2) && Map.isEmpty(Tl3, Tc3);

            if(con){
                setLine(0, Tl0);
                setColumn(0, Tc0);
                
                setLine(1, Tl1);
                setColumn(1, Tc1);
                
                setLine(2, Tl2);
                setColumn(2, Tc2);
                
                setLine(3, Tl3);
                setColumn(3, Tc3);
                rotation++;
                return true;
            }

        }
        else if(rotation%4==1){
            int Tl0=getLine(0)+2,Tc0=getColumn(0)+1;
            int Tl1=Tl0,Tc1=Tc0-1;
            int Tl2=Tl0,Tc2=Tc0-2;
            int Tl3=Tl0,Tc3=Tc0-3;

            con = Map.isEmpty(Tl0, Tc0) && Map.isEmpty(Tl1, Tc1) && Map.isEmpty(Tl2, Tc2) && Map.isEmpty(Tl3, Tc3);

            if(con){
                setLine(0, Tl0);
                setColumn(0, Tc0);
                
                setLine(1, Tl1);
                setColumn(1, Tc1);
                
                setLine(2, Tl2);
                setColumn(2, Tc2);
                
                setLine(3, Tl3);
                setColumn(3, Tc3);
                rotation++;
                return true;
            }

        }
        else if(rotation%4==2){
            int Tl0=getLine(0)+1,Tc0=getColumn(0)-2;
            int Tl1=Tl0-1,Tc1=Tc0;
            int Tl2=Tl0-2,Tc2=Tc0;
            int Tl3=Tl0-3,Tc3=Tc0;

            con = Map.isEmpty(Tl0, Tc0) && Map.isEmpty(Tl1, Tc1) && Map.isEmpty(Tl2, Tc2) && Map.isEmpty(Tl3, Tc3);

            if(con){
                setLine(0, Tl0);
                setColumn(0, Tc0);
                
                setLine(1, Tl1);
                setColumn(1, Tc1);
                
                setLine(2, Tl2);
                setColumn(2, Tc2);
                
                setLine(3, Tl3);
                setColumn(3, Tc3);
                rotation++;
                return true;
            }

        }
        else if(rotation%4==3){
            int Tl0=getLine(0)-2,Tc0=getColumn(0)-1;
            int Tl1=Tl0,Tc1=Tc0+1;
            int Tl2=Tl0,Tc2=Tc0+2;
            int Tl3=Tl0,Tc3=Tc0+3;

            con = Map.isEmpty(Tl0, Tc0) && Map.isEmpty(Tl1, Tc1) && Map.isEmpty(Tl2, Tc2) && Map.isEmpty(Tl3, Tc3);

            if(con){
                setLine(0, Tl0);
                setColumn(0, Tc0);
                
                setLine(1, Tl1);
                setColumn(1, Tc1);
                
                setLine(2, Tl2);
                setColumn(2, Tc2);
                
                setLine(3, Tl3);
                setColumn(3, Tc3);
                rotation++;
                return true;
            }

        }
        
        int array[] ={0,-1,+1,-2,+2};
        
        for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < array.length; j++) {
                
                if(spin2(array[i], array[j])){
                    return true;
                }
                
            }
            
        }
        
        return false;
        
        
    }
    
    
    
    @Override
    protected boolean spin2(int line, int column) {
        
        
        

        boolean con;

        if(rotation%4==0){
            int Tl0=getLine(0)-1+line,Tc0=getColumn(0)+2+column;
            int Tl1=Tl0+1,Tc1=Tc0;
            int Tl2=Tl0+2,Tc2=Tc0;
            int Tl3=Tl0+3,Tc3=Tc0;

            con = Map.isEmpty(Tl0, Tc0) && Map.isEmpty(Tl1, Tc1) && Map.isEmpty(Tl2, Tc2) && Map.isEmpty(Tl3, Tc3);

            if(con){
                setLine(0, Tl0);
                setColumn(0, Tc0);
                
                setLine(1, Tl1);
                setColumn(1, Tc1);
                
                setLine(2, Tl2);
                setColumn(2, Tc2);
                
                setLine(3, Tl3);
                setColumn(3, Tc3);
                rotation++;
                return true;
            }

        }
        else if(rotation%4==1){
            int Tl0=getLine(0)+2+line,Tc0=getColumn(0)+1+column;
            int Tl1=Tl0,Tc1=Tc0-1;
            int Tl2=Tl0,Tc2=Tc0-2;
            int Tl3=Tl0,Tc3=Tc0-3;

            con = Map.isEmpty(Tl0, Tc0) && Map.isEmpty(Tl1, Tc1) && Map.isEmpty(Tl2, Tc2) && Map.isEmpty(Tl3, Tc3);

            if(con){
                setLine(0, Tl0);
                setColumn(0, Tc0);
                
                setLine(1, Tl1);
                setColumn(1, Tc1);
                
                setLine(2, Tl2);
                setColumn(2, Tc2);
                
                setLine(3, Tl3);
                setColumn(3, Tc3);
                rotation++;
                return true;
            }

        }
        else if(rotation%4==2){
            int Tl0=getLine(0)+1+line,Tc0=getColumn(0)-2+column;
            int Tl1=Tl0-1,Tc1=Tc0;
            int Tl2=Tl0-2,Tc2=Tc0;
            int Tl3=Tl0-3,Tc3=Tc0;

            con = Map.isEmpty(Tl0, Tc0) && Map.isEmpty(Tl1, Tc1) && Map.isEmpty(Tl2, Tc2) && Map.isEmpty(Tl3, Tc3);

            if(con){
                setLine(0, Tl0);
                setColumn(0, Tc0);
                
                setLine(1, Tl1);
                setColumn(1, Tc1);
                
                setLine(2, Tl2);
                setColumn(2, Tc2);
                
                setLine(3, Tl3);
                setColumn(3, Tc3);
                rotation++;
                return true;
            }

        }
        else if(rotation%4==3){
            int Tl0=getLine(0)-2+line,Tc0=getColumn(0)-1+column;
            int Tl1=Tl0,Tc1=Tc0+1;
            int Tl2=Tl0,Tc2=Tc0+2;
            int Tl3=Tl0,Tc3=Tc0+3;

            con = Map.isEmpty(Tl0, Tc0) && Map.isEmpty(Tl1, Tc1) && Map.isEmpty(Tl2, Tc2) && Map.isEmpty(Tl3, Tc3);

            if(con){
                setLine(0, Tl0);
                setColumn(0, Tc0);
                
                setLine(1, Tl1);
                setColumn(1, Tc1);
                
                setLine(2, Tl2);
                setColumn(2, Tc2);
                
                setLine(3, Tl3);
                setColumn(3, Tc3);
                rotation++;
                return true;
            }

        }

        
        return false;
        
        
    }
    
    
}
