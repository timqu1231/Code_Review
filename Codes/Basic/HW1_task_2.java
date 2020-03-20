/*
* Author: Feiyang Qu
* Date: 6/15/2018
* Description: HW1_task_2.java
*/
import java.util.Scanner;
import java.util.Random;

public class HW1_task_2 {
   public static void main (String [] args){
      System.out.println("Welcome to the game of Guess It!");
      System.out.println("I will choose a number between 1 and 100.");
      System.out.println("You will try to guess that number. If your guess wrong, I will tell you if\nyou guessed too high or too low.");
      System.out.println("You have 6 tries to get the number.");
      System.out.println(" ");
      System.out.println("OK, I am thinking of a number. Try to guess it.\n");
      // variable for checking if play again
      boolean cont = true;
      do {
         int i = 1; // guess 6 times--116
         boolean correct = true; // correct --> false -->end loop
         Random random = new Random(); //random number
         int random1 = random.nextInt(100) + 1;//guess between 1-100
         do {
            Scanner input = new Scanner(System.in);
            System.out.print("Your guess?");
            int data = input.nextInt();//use input
            //guess must valid then compare
            if (data > 0 && data < 101 && data > random1){
                System.out.print("Too high!\n");
                System.out.printf("(Hint:%s)\n",random1);
                i++;// increse 1 after each guess
            } else if (data > 0 && data < 101 && data < random1){
                System.out.print("Too low!\n");
                System.out.printf("(Hint:%s)\n",random1);
                i++;
            //invalid guess
            } else if (data <= 0 || data >= 101){
                System.out.print("Illegal guess. Your guess must be between 1 and 100.\n");
                i++;
            } else {
                System.out.print("**** CORRECT ****\n");
                correct = false;
            }
         } while (i < 7 && correct == true);
         boolean result = true; //check "Y"/"N"/invalid input"X"/
         do {
             System.out.print("Want to play again? Y/N\n");
             Scanner again = new Scanner(System.in);
             String play = again.nextLine();  
             if (!play.equals("Y")&&!play.equals("N")){
                 result = true;
             } else {
                 result = false;
                 if (play.equals("Y")){
                     cont = true;
                 } else {
                     cont = false;
                 }      
             }       
         } while (result);    
      }while (cont);
      System.out.print("Good bye, it was fun. Play again soon.");
   }
}  
  