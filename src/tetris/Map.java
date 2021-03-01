package tetris;


public class Map {
    
    
    public static final int NUMBEROFLINE=20;
    public static final int NUMBEROFCOLUMN=10;
    
    
    public static int array[][] = new int[NUMBEROFLINE][NUMBEROFCOLUMN];
    
    public static Spot spots[][] = new Spot[NUMBEROFLINE][NUMBEROFCOLUMN];
    
    
    public static Figure current;
    
    
    public Map() {
        
        for (int i = 0; i < NUMBEROFLINE; i++) {
            
            for (int j = 0; j < NUMBEROFCOLUMN; j++) {
                
                spots[i][j]=new Spot(i, j);
                
            }
            
        }
        
    }
    
    public static boolean isEmpty(int line,int column){
        
        if(line<0||line>=array.length||column<0||column>=array[0].length){
            
            return false;//ERROR
            
        }
        
        return array[line][column]==0;
        
    }
    
    
    public static boolean empty(int line,int column){
        
        if(line<0||line>=array.length||column<0||column>=array[0].length){
            
            return false;//ERROR
            
        }
        
        if(array[line][column]==0)return false;//ERROR
        
        array[line][column]=0;
        
        return true;
    }
    
    public static boolean fill(int line,int column,int color){
        
        if(line<0||line>=array.length||column<0||column>=array[0].length){//ERROR
            
            return false;
            
        }
        
        if(array[line][column]!=0)return false;//ERROR
        
        array[line][column]=color;
        
        return true;
    }
    
    
    
    
    public void controlLines(){
        
        boolean first=false;
        
        for (int i = 0; i < NUMBEROFLINE; i++) {
            
            if(controlLine(i)){
                clearLine(i);
                first = true;
            }
            else{
                if(first)break;
            }
            
            
        }
        
        
    }
    
    private void clearLine(int i){
        
        for (int j = 0; j < NUMBEROFCOLUMN; j++) {
            array[i][j]=0;
            spots[i][j].setDel(true);
        }
        arrangeMap(i);
        
    }
    
    private void arrangeMap(int i){
        
        if(i<=0)return;
        
        for (int j = i; j > 0; j--) {
            boolean allofzero=true;
            for (int k = 0; k < NUMBEROFCOLUMN; k++) {
                
                if(array[j-1][k]!=0)allofzero=false;
                
                array[j][k]=array[j-1][k];
                array[j-1][k]=0;
            }
            
            if(allofzero){
                break;
            }
            
        }
        
    }
    
    
    
    private boolean controlLine(int line){
        
        if(line<0||line>=array.length)return false;//ERROR
        
        for (int i = 0; i < array[line].length; i++) {
            
            if(array[line][i]==0)return false;
            
        }
        
        return true;
    }
    
    
    public void addBlock_I(int firstColumn){
        
        if(current!=null)return;
        
        if(firstColumn<0||firstColumn>=array[0].length-3){
            return;//ERROR
        }
        
        int color = (int) (Math.random()*7)+1;
        
        new Block_I(firstColumn,color);
        
        
        
    }
    
    public void addBlock_O(int firstColumn){
        
        if(current!=null)return;
        
        if(firstColumn<0||firstColumn>=array[0].length-1){
            return;//ERROR
        }
        int color = (int) (Math.random()*7)+1;
        new Block_O(firstColumn,color);
        
        
        
    }
    
    public void addBlock_T(int firstColumn){
        
        if(current!=null)return;
        
        if(firstColumn<1||firstColumn>=array[0].length-1){
            return;//ERROR
        }
        int color = (int) (Math.random()*7)+1;
        new Block_T(firstColumn,color);
        
        
        
    }
    
    public void addBlock_S(int firstColumn){
        
        if(current!=null)return;
        
        if(firstColumn<1||firstColumn>=array[0].length-1){
            return;//ERROR
        }
        int color = (int) (Math.random()*7)+1;
        new Block_S(firstColumn,color);
        
        
        
    }
    
    public void addBlock_Z(int firstColumn){
        
        if(current!=null)return;
        
        if(firstColumn<0||firstColumn>=array[0].length-2){
            return;//ERROR
        }
        int color = (int) (Math.random()*7)+1;
        new Block_Z(firstColumn,color);
        
        
        
    }
    
    public void addBlock_J(int firstColumn){
        
        if(current!=null)return;
        
        if(firstColumn<0||firstColumn>=array[0].length-2){
            return;//ERROR
        }
        int color = (int) (Math.random()*7)+1;
        new Block_J(firstColumn,color);
        
        
        
    }
    
    public void addBlock_L(int firstColumn){
        
        if(current!=null)return;
        
        if(firstColumn<2||firstColumn>=array[0].length){
            return;//ERROR
        }
        int color = (int) (Math.random()*7)+1;
        new Block_L(firstColumn,color);
        
        
        
    }
    
    
    
    private int randomArray [] = {0,1,2,3,4,5,6};
    private int randomSize=7;
    
    public void resetRandomSize(){
        randomSize=7;
    }
    
    public static boolean gameover=false;
    
    public void randomBlock(){
        
        if(current!=null)return;
        
        
        if(randomSize==1){
            gameover=true;
            return;
        }
        
        int r2 = (int) (Math.random()*randomSize);
        
        int last = randomArray[randomSize-1];
        int r=randomArray[r2];
        randomArray[r2]=last;
        randomArray[randomSize-1] = r;
        
        randomSize--;
        
        if(r==0){
            addBlock_I((NUMBEROFCOLUMN/2)-2);
        }
        else if(r==1){
            addBlock_J((NUMBEROFCOLUMN/2)-2);
        }
        else if(r==2){
            addBlock_L((NUMBEROFCOLUMN/2));
        }
        else if(r==3){
            addBlock_O((NUMBEROFCOLUMN/2)-1);
        }
        else if(r==4){
            addBlock_S((NUMBEROFCOLUMN/2)-1);
        }
        else if(r==5){
            addBlock_T((NUMBEROFCOLUMN/2)-1);
        }
        else if(r==6){
            addBlock_Z((NUMBEROFCOLUMN/2)-2);
        }
        
    }
    
    public boolean dropCurrent(){
        
        if(current==null)return false;
        
        boolean result;
        
        for (int i = 0; i < 4; i++) {
            
            Map.empty(current.getLine(i), current.getColumn(i));
            
        }
        
        result=current.drop();
        
        for (int i = 0; i < 4; i++) {
            Map.fill(current.getLine(i), current.getColumn(i),current.getColor());
        }
        
        if(!result)current=null;
        
        return result;
        
    }
    
    
    public boolean rightCurrent(){
        
        if(current==null)return false;
        
        boolean result;
        
        for (int i = 0; i < 4; i++) {
            
            Map.empty(current.getLine(i), current.getColumn(i));
            
        }
        
        result=current.right();
        
        for (int i = 0; i < 4; i++) {
            Map.fill(current.getLine(i), current.getColumn(i),current.getColor());
        }
        
        return result;
        
    }
    
    
    public boolean leftCurrent(){
        
        if(current==null)return false;
        
        boolean result;
        
        for (int i = 0; i < 4; i++) {
            
            Map.empty(current.getLine(i), current.getColumn(i));
            
        }
        
        result=current.left();
        
        for (int i = 0; i < 4; i++) {
            Map.fill(current.getLine(i), current.getColumn(i),current.getColor());
        }
        
        return result;
        
    }
    
    public boolean spinCurrent(){
        if(current==null)return false;
        
        boolean result;
        
        for (int i = 0; i < 4; i++) {
            
            Map.empty(current.getLine(i), current.getColumn(i));
            
        }
        
        result=current.spin();
        
        for (int i = 0; i < 4; i++) {
            Map.fill(current.getLine(i), current.getColumn(i),current.getColor());
        }
        
        return result;
    }
    
    
    public void arrangeSpots(){
        
        for (int i = 0; i < NUMBEROFLINE; i++) {
            
            for (int j = 0; j < NUMBEROFCOLUMN; j++) {
                
                
                
                spots[i][j].setColor(array[i][j]);
                
                
                spots[i][j].setDel(false);
            }
            
        }
        
        
    }
    
    
    
    public void print(){
        
        for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < array[0].length; j++) {
                
                System.out.print(array[i][j]);
                
            }
            System.out.println("");
        }
        
        
    }
    
}
