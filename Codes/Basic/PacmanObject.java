public class PacmanObject {
    public void move(){
        System.out.println("PacmanObject:Move()");
    }
}    
// public class Ghost extends PacmanObject {
//     public void move(){
//         super.move();
//         System.out.println("Ghost:Move ()");
//     }
// }
// public class Pacman extends PacmanObject {
//     public void move(){
//         super.move();
//         System.out.println("Pacman::Move ()");        
//     }    
//     public static void main(String[] args) {
//         PacmanObject[] objs = new PacmanObject[3];
//         //objs [3] = new PacmanObject();
//         //PacmanObject  = new Ghost ();        
//         for (int i = 0; i< objs.length; i++){
//             objs[i].move();
//         }
//     
//     }
// }