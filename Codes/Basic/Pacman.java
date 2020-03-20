public class Pacman extends PacmanObject {
    public void move(){
        super.move();
        System.out.println("Pacman::Move()");        
    }    
    public static void main(String[] args) {
        PacmanObject[] objs = new PacmanObject[3];
        
        objs[0] = new Pacman();
        objs[1] = new Ghost();
        objs[2] = new Ghost();        
        
        for (int i = 0; i< objs.length; i++){
            objs[i].move();
        }
    
    }
}