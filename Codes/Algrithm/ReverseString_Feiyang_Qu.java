// Name:          <Feiyang Qu>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    2

//This is to test class LinkedList. Create and print out a simple list

import java.util.Scanner;

public class ReverseString_Feiyang_Qu
{
   public static void main (String[] args)
   {
      System.out.print("Enter a string: ");
      Scanner input = new Scanner(System.in); //scan user input
      String data = input.nextLine(); //brind input to data
      System.out.printf("Input String: %s\n",data);
      System.out.print("Resversed String: ");
      ReverseString_Feiyang_Qu(data);//call reverse function
      
   }
   
   public static void ReverseString_Feiyang_Qu(String input)
   {
      Stack_Feiyang_Qu myList = new Stack_Feiyang_Qu();//crear linked list
      String temp[] = input.split(" ");//split input to several string 
      char char1;
      for (int i =0; i < temp.length; i++ )//start reverse each index input by for loop
         { 
           myList.push(temp[i]);//push value in linked list
         }
      while (myList.isEmpty() != true) //print value after push,and then pop to prepare next 
         { 
           System.out.print(myList.top()+" ");
           myList.pop();
           }
   }
}          