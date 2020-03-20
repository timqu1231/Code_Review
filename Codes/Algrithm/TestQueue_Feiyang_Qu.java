// Name:          <Feiyang Qu>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    3

//This is to test class TestQueue_Feiyang_Qu. Create and print out a simple list

import java.util.Scanner;

public class  TestQueue_Feiyang_Qu 
{
   public static void main (String[] args)
   {
      Queue_Feiyang_Qu myList = new Queue_Feiyang_Qu(); //create a list object
      for (int i=1; i <= 5; i++) //add 5 nodes to the list
      {
         myList.enqueue(i);
      } 
      //print out the list content
      System.out.println("Testing method Enqueue()");
      System.out.println("Please add number you want to enqueue(enter d when finish):");
      Scanner input = new Scanner(System.in);
      int add_numbers = 0;//count how many number input
      boolean number = true;//check input loop end
      int input_data;
      do  
      {
         String data = input.next();//type of input must be string, "d" -> stop input
         add_numbers++;
                
         if (data.equals("d"))//check input value for ending loop
         {
            number = false;
         }else
         {
            input_data = Integer.parseInt(data);//convert input string to int
            myList.enqueue(input_data);
         }
      } while (number);      
      System.out.println("List content before adding is:  1   2   3   4   5");//list before input is constant
      System.out.print("List content after adding is:  ");
      myList.printList();
      System.out.println(" ");       
      
      System.out.println("Testing method dequeue()");
      System.out.println("How many times dequeue you want?");
      Scanner time = new Scanner(System.in);
      int dequeue_time = time.nextInt();//ask to dequeue how many times
      System.out.println("Removing the value.");
      System.out.print("List content before dequeue is:  ");
      myList.printList();
      System.out.print("List content after dequeue is:  ");
      for (int k = 0; k < dequeue_time; k++)
      {
         myList.dequeue();
      }
      myList.printList();
      System.out.println(" ");

      System.out.println("Testing method front()");
      System.out.println("The first number is: ");
      int queue_front = myList.front();//get first number in list
      System.out.println(queue_front);
      System.out.println(" ");

      System.out.println("Testing method size()");
      System.out.println("Size of queue is: ");
      int queue_size = myList.size();//get size
      System.out.println(queue_size);
      System.out.println(" ");

      System.out.println("Testing method isEmpty()");
      System.out.println("Emptying List.");
      System.out.print("List content after removing is:  ");
      System.out.println(myList.isEmpty());//return false because empty
           
            
       
   } 
}