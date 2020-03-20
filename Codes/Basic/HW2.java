import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class HW2
{
   public static void main (String [] args)
   {
      System.out.println("How many pacmans?(1-100)");
      boolean cont = true;// variable for checking if play again
      do 
      {  
         int value;//pacman number
         boolean input_check = false; //input valid
         do 
         {       
            Scanner input = new Scanner(System.in);
            int value_input = input.nextInt();
            if (value_input > 100 || value_input < 1)//limit input
            {
               System.out.print("Invalid input\n");
               input_check = true;
            }
            value = value_input;
         }while (input_check);
         int pacman_array[] = new int[value] ;//nPacman
         for (int h = 0; h < value; h++)
         {
            pacman_array[h] = 1;//pacman_position;//initial pacman value: 1
            //System.out.print(pacman_array[h]+" ");
         }
         int map_array[] = new int[100];
         //pacman_array = new int[value];
         int i = 0;
         boolean stop = false;
         do 
         {            
            for (int w = 0; w < 100; w++)
            {
               map_array[w] = w + 1;//map array:fix value from 1 to 100
            }
            int check = 0;
            System.out.print("----- Frame:" + i + "------------\n");
              
            for (int r = 0; r < value; r++)//loop for each pacman
            {
               for (int t = 1; t <= 100; t++)//loop for map array from 1 to 100
               {
                  //System.out.println("pacarray" + pacman_array[r]);
                  if (pacman_array[r] == t)//check if value of pacman is equal to related man array position 
                  {
                    map_array[t-1] = 101;//update that map value to 101
                  }
                  if (map_array[99] == 101)//stop loop when pacman at right_bottom
                  {
                    stop = true;
                  }
                  //System.out.println("P:"+pacman_array[r]);
               }
            }
            for (int j = 1; j <= 100; j++)//print_out loop
            {
               if (j % 10 != 0)
               {
                  if (map_array[j-1] == 101)
                  {   
                     System.out.print("# "/* + map_array[j-1]*/);
                  }
                  else
                  {
                     System.out.print("* "/* + map_array[j-1]*/);
                  }              
               }         
               else if (j % 10 == 0)
               {
                  if (map_array[j-1] == 101)
                  {   
                     System.out.println("#"/* + map_array[j-1]*/);
                  }
                  else
                  {
                     System.out.println("*"/* + map_array[j-1]*/);
                  }
               }
            }
         for (int s = 0; s < value; s++)//check #/*
         {
            pacman_array[s] = pacman(pacman_array[s]);                  
            //System.out.print("pam"+pacman_position);//update pacman position
         }            
         i++;
         }while (i <= 1000 && stop == false);                       
         
         boolean result = true; //check "Y"/"N"/invalid input"X"/
         do 
         {
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
   
   public static int pacman(int pacman_position)//move
   {
       boolean out_map = false;
       do{
           out_map = false;
           Random random = new Random(); //random number
           int position = random.nextInt(4);//guess between 0-3 
           //System.out.println("random" + position);
           if (position == 0)//right
           {
             if (pacman_position % 10 == 0)//check pacman out of map(10,20,30...)
             {
               out_map = true;//random again
             }
             else
             {
               pacman_position = pacman_position + 1;
             }
           } else if (position == 1) {//left
             if (pacman_position % 10 == 1)
             {
               out_map = true;
             }
             else
             {
               pacman_position = pacman_position - 1;
             }
           } else if (position == 2) {//down
             if(pacman_position >= 91)
             {
               out_map = true;
             }
             else
             {
               pacman_position = pacman_position + 10;
             }  
           } else if (position == 3) {//up
             if (pacman_position <=10)
             {
               out_map = true;
             }
             else
             {
               pacman_position = pacman_position - 10;
             }
           }
       } while (pacman_position != 100 && out_map == true);
       //System.out.print(pacman_position);
       return pacman_position;                    
   }
}