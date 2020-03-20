//cs5000
//Feiyang Qu
//HW3


//test
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class HW3
{  
   public static void main (String [] args)
   {
      System.out.println("Press 's' to start game: ");
      boolean cont = true;// variable for checking if play again
      do 
      {  
         //int value;//pacman number
         boolean input_check = false; //input valid
         do 
         {       
            Scanner input = new Scanner(System.in);
            String value_input = input.nextLine();
            if (!value_input.equals("s"))//limit input
            {
               System.out.print("Invalid input\n");
               input_check = true;
            }
            //value = value_input;
         }while (input_check);
         int pacman_array[][] = new int[10][10];//Pacman
         pacman_array[0][0] = 3;
         int ghost1_array[][] = new int[10][10];//Ghost
         ghost1_array[4][4] = 2;
         int ghost2_array[][] = new int[10][10];
         ghost2_array[4][5] = 2;
         int ghost3_array[][] = new int[10][10];
         ghost3_array[5][4] = 2;
         int pacman_position = 0;//pacman start at [0][0]
         int ghost1_position = 404;//ghost start at [4][4][4][5][5][4]
         int ghost2_position = 405;
         int ghost3_position = 504;
         int ghost1 = 1;//value on map position which ghost will move
         int ghost2 = 1;
         int ghost3 = 1;
         //int maze_array[][] =new int[10][10];
         int map_array[][] = new int[10][10];//map
         for (int h = 0; h < 10; h++){
            for (int s = 0; s < 10; s++){
               map_array[s][h] = 1;//pacman_position;//initial pacman value: 1
            }
            //System.out.print(pacman_array[h]+" ");
         }
         map_array[1][3] = 99;//maze wall:ghost and pacman cannnot step on
         map_array[1][4] = 99;
         map_array[1][5] = 99;
         map_array[1][6] = 99;
         map_array[1][7] = 99;
         map_array[2][3] = 99;
         map_array[2][7] = 99;
         map_array[3][3] = 99;
         map_array[3][5] = 99;
         map_array[3][7] = 99;
         map_array[4][1] = 99;
         map_array[5][6] = 99;
         map_array[6][2] = 99;
         map_array[6][4] = 99;
         map_array[7][2] = 99;
         map_array[7][4] = 99;
         map_array[7][5] = 99;
         map_array[7][6] = 99;
         map_array[8][4] = 99;
         //final map_wall[][]//wall
         //pacman_array = new int[value];
         int i = 0;
         boolean stop = false;
         // int pacman_position = 0;
//          int ghost1_position = 404;
//          int ghost2_position = 405;
//          int ghost3_position = 504;
         int beforemove_ghost1 = 1;
         int beforemove_ghost2 = 1;
         int beforemove_ghost3 = 1;
         // int temp_pacman = pacman_position;//record current pacman positon for changing value from 3 to 0 after pacman move to next position
//          int temp_ghost1 = ghost1_position;//record current ghost positoin, after ghost leave this posiiton's value should be 0 || 1
//          int temp_ghost2 = ghost2_position;
//          int temp_ghost3 = ghost3_position;
         do {            
            //for (int w = 0; w < 100; w++)
            //{
            //   map_array[w] = w + 1;//map array:fix value from 1 to 100
            //}
            
            int check = 0;
            System.out.print("----- Frame:" + i + "------------\n");
              
            for (int r = 0; r < 10; r++){//loop for map
               for (int t = 0; t < 10; t++){//loop for map 
                  //System.out.println("pacarray" + pacman_array[r]);
                  if ((r * 100 + t) == pacman_position){//check if pacman is on map array position 
                    map_array[r][t] = 3;//update that map value to pacman value
                  }else if ((r * 100 + t) == ghost1_position){
                    map_array[r][t] = 2;
                  }else if ((r * 100 + t) == ghost2_position){
                    map_array[r][t] = 2;
                  }else if ((r * 100 + t) == ghost3_position){
                    map_array[r][t] = 2;
                  // }else if ((r * 100 + t) == temp_ghost1){//?check to change value back to old value before ghost step on  
//                     map_array[r][t] = ghost1;
//                   }else if ((r * 100 + t) == temp_ghost2){//?
//                     map_array[r][t] = ghost2;
//                   }else if ((r * 100 + t) == temp_ghost3){//?
//                     map_array[r][t] = ghost3;
                  }
                  if (map_array[9][9] == 3){//stop loop when pacman at right_bottom
                    stop = true;
                  }
                  //System.out.println("P:"+pacman_array[r]);
               }
            }
            for (int j = 0; j < 10 ; j++){//print_out loop
               for (int k = 0; k < 10; k++){
                  if (map_array[j][k] == 1){                        
                     System.out.print("* "/* + map_array[j-1]*/);
                  }else if (map_array[j][k] == 2){
                     System.out.print("G "/* + map_array[j-1]*/);
                  }else if (map_array[j][k] == 3){
                     System.out.print("P ");
                  }else if (map_array[j][k] == 0){
                     System.out.print("  ");
                  }else if (map_array[j][k] == 99){                  
                     System.out.print("# ");  
                  }           
               }         
               System.out.println();                    
            }
            // map_array[(temp_ghost1) / 100][(temp_ghost1) % 100] = ghost1;
//             map_array[(temp_ghost2) / 100][(temp_ghost2) % 100] = ghost2;
//             map_array[(temp_ghost3) / 100][(temp_ghost3) % 100] = ghost3;

            int temp_pacman = pacman_position;
            int temp_ghost1 = ghost1_position;
            int temp_ghost2 = ghost2_position;
            int temp_ghost3 = ghost3_position;
            int aftermove_ghost1, aftermove_ghost2, aftermove_ghost3;
            //ghost1 = map_array[(temp_ghost1) / 100][(temp_ghost1) % 100];
            //ghost2 = map_array[(temp_ghost2) / 100][(temp_ghost2) % 100];
            //ghost3 = map_array[(temp_ghost3) / 100][(temp_ghost3) % 100];
            boolean check_pacman = false;
            boolean check_ghost1 = false;
            boolean check_ghost2 = false;
            boolean check_ghost3 = false;
            do{
               pacman_position = move(pacman_position);//move
               check_pacman = check_move(pacman_position);//check if could be moved
               if (check_pacman == true){
                  pacman_position = temp_pacman;
               }
            }while(check_pacman == true);
            do{  
               ghost1_position = move(ghost1_position);
               check_ghost1 = check_move(ghost1_position);
               if (check_ghost1 == true){
                  ghost1_position = temp_ghost1;
               }
               //ghost1 = map_array[(ghost1_position) / 100][(ghost1_position) % 100];
            }while(check_ghost1 == true);
            aftermove_ghost1 = map_array[(ghost1_position) / 100][(ghost1_position) % 100];//update value that ghost will move  
            //System.out.print(ghost1);
            do{  
               ghost2_position = move(ghost2_position);
               check_ghost2 = check_move(ghost2_position);
               if (check_ghost2 == true){
                  ghost2_position = temp_ghost2;
               }
               //ghost2 = map_array[(ghost2_position) / 100][(ghost2_position) % 100];
            }while(check_ghost2 == true);
            aftermove_ghost2 = map_array[(ghost2_position) / 100][(ghost2_position) % 100];
            //System.out.print(ghost1);
            do{  
               ghost3_position = move(ghost3_position);
               check_ghost3 = check_move(ghost3_position);
               if (check_ghost3 == true){
                  ghost3_position = temp_ghost3;
               }
               //ghost3 = map_array[(ghost3_position) / 100][(ghost3_position) % 100];
            }while(check_ghost3 == true); 
            aftermove_ghost3 = map_array[(ghost3_position) / 100][(ghost3_position) % 100];
            //System.out.print(ghost1);          
            map_array[temp_pacman / 100][temp_pacman % 100] = 0;//update map value after pacman leave this position 
            map_array[(temp_ghost1) / 100][(temp_ghost1) % 100] = beforemove_ghost1;
            map_array[(temp_ghost2) / 100][(temp_ghost2) % 100] = beforemove_ghost2;
            map_array[(temp_ghost3) / 100][(temp_ghost3) % 100] = beforemove_ghost3;
            // for (int s = 0; s < value; s++)//check #/*
//             {
//                pacman_array[s] = pacman(pacman_array[s]);                  
//                //System.out.print("pam"+pacman_position);//update pacman position
//             }  
            beforemove_ghost1 = map_array[(ghost1_position) / 100][(ghost1_position) % 100];
            beforemove_ghost2 = map_array[(ghost2_position) / 100][(ghost2_position) % 100];
            beforemove_ghost3 = map_array[(ghost3_position) / 100][(ghost3_position) % 100];        
            i++;
         }while (i <= 1000 && stop == false);                       
         
         boolean result = true; //check "Y"/"N"/invalid input"X"/
         do{
             System.out.print("Want to play again? Y/N\n");
             Scanner again = new Scanner(System.in);
             String play = again.nextLine();  
             if (!play.equals("Y")&&!play.equals("N"))
             {
                 result = true;
             } else 
             {
                 result = false;
                 if (play.equals("Y"))
                 {
                     cont = true;
                     System.out.print("Please enter again:\n");
                 } else {
                     cont = false;
                 }      
             }       
         } while (result);    
      }while (cont);
      System.out.print("Good bye, it was fun. Play again soon.");
   }
   
   // public void 2D_array(int array[][],int index_number){
//       for (int i = 0; i < 10; i++){
//          for(int j = 0; j < 10; j++){
//             array[j][i] = index_number;
//          }
//       }  
//    }
   
   public static int move(int position)//move
   {
       boolean out_map = false;
       int new_position;
       do{
           out_map = false;
           int x = position % 100;//row
           int y = position / 100;//column
           Random random = new Random(); //random number
           int direction = random.nextInt(4);//guess between 0-3 
           //System.out.println("random" + position);
           if (direction == 0)//right
           {
             if (x % 10 == 9){//check pacman out of map(10,20,30...)
               out_map = true;//random again
             }else{
               x = x + 1;
             }
           } else if (direction == 1){//left
             if (x % 10 == 0){
               out_map = true;
             }else{
               x = x - 1;
             }
           } else if (direction == 2){//down
             if(y % 10 == 9){
               out_map = true;
             }else{
               y = y + 1;
             }  
           } else if (direction == 3){//up
             if (y % 10 == 0)
             {
               out_map = true;
             }else{
               y = y - 1;
             }
           }
           new_position = y * 100 + x;
       } while (new_position != 100 && out_map == true);
       //System.out.print(pacman_position);
       return new_position;                    
   }
   
   public static boolean check_move(int position){   //check for maze which panman and ghost cannnot step on    
       if (position == 103 || position == 104 || position == 105
           || position == 106 || position == 107 || position == 203
           || position == 207 || position == 303 || position == 305
           || position == 307 || position == 401 || position == 506
           || position == 602 || position == 604 || position == 702
           || position == 704 || position == 705 || position == 706
           || position == 804){//maze
          return true;
       }else{
         return false;
       }   
   }         
}