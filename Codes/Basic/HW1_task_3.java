/*
* Author: Feiyang Qu
* Date: 6/15/2018
* Description: HW1_task_3.java
*/
import java.util.Scanner;
import java.util.Random;

public class HW1_task_3
{
   public static void main (String [] args)
   {
      System.out.println("Welcome to the game of Rock-Paper-Scissors.");
      boolean cont = true;//cont = false --> end loop
      do
         {
            System.out.println("You can press a 'r' button for Rock, 'p' for Paper, and 's' for Scissors.");
            System.out.print("Press any key when ready or press 'q' to quit Any key not 'q'\n");
            Scanner again = new Scanner(System.in);
            String play = again.nextLine();//ask play or quit
            if (play.equals("q"))
            {
               cont = false;//quit
            }
            else
            {
               System.out.print("\nRock! Paper! Scissors!");
               Random random = new Random();
               int random1 = random.nextInt(3) + 1;
               Scanner input = new Scanner(System.in);
               String data = input.nextLine();//user input 'p','r','s'
               if ((data.equals("r")&&random1 == 1) || (data.equals("p")&&random1 == 2) || (data.equals("s")&&random1 == 3))//3 possibles
                  {
                     if (data.equals("r"))
                        {
                        System.out.println("Rock (You) vs Rock (Computer): Draw!!\n");
                        }
                     else if (data.equals("p"))
                        {
                        System.out.println("Paper (You) vs Paper (Computer): Draw!!\n");
                        }
                     else
                        {
                        System.out.println("Scissors (You) vs Scissors (Computer): Draw!!\n");
                        }
                  }
               else if ((data.equals("r")&&random1 == 3) || (data.equals("p")&&random1 == 1) || (data.equals("s")&&random1 == 2))
                  {
                     if (data.equals("r"))
                        {
                        System.out.println("Rock (You) vs Scissors (Computer): You Win!!\n");
                        }
                     else if (data.equals("p"))
                        {
                        System.out.println("Paper (You) vs Rock (Computer): You Win!!\n");
                        }
                     else
                        {
                        System.out.println("Scissors (You) vs Paper (Computer): You Win!!\n");
                        }               
                  }
               else if ((data.equals("r")&&random1 == 2) || (data.equals("p")&&random1 == 3) || (data.equals("s")&&random1 == 1))
                  {
                     if (data.equals("r"))
                        {
                        System.out.println("Rock (You) vs Paper (Computer): You lose!!\n");
                        }
                     else if (data.equals("p"))
                        {
                        System.out.println("Paper (You) vs Scissors (Computer): You lose!!\n");
                        }
                     else
                        {
                        System.out.println("Scissors (You) vs Rock (Computer): You lose!!\n");
                        }  
                   }             
               else  //check invliad -->'x'                 
                  {
                     System.out.print("Invalid input. Your input must be 'r' or 'p' or 's'.\n");
                  }
             }
        } while (cont);
        System.out.print("Good bye, it was fun. Play again soon.");
   }
}