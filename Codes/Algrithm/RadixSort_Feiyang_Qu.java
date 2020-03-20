// Name:          <Feiyang>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    3

// Define a class implement radix_sort by queue operation.

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class RadixSort_Feiyang_Qu
{
   public static void main (String[] args)
   {
      System.out.print("Enter six number: ");
      Scanner input = new Scanner(System.in); 
      int array[] = new int[6];//set input array [6]
      int max_digit = 0;//set how many times of loop for check each digit of six number
      for (int i = 0 ; i < array.length; i++ ) {//loop for input
         array[i] = input.nextInt();
         if (digit_count(array[i]) > max_digit) {//update the biggest number's digit
            max_digit = digit_count(array[i]);  
         }
      }
      System.out.printf("Inputs array before sorting: ");
      for (int i = 0 ; i < array.length; i++ ) {
         System.out.print(array[i]+" ");//print original list
      }
      System.out.println(" ");
      System.out.printf("Inputs array after sorting: ");
      RadixSort_Feiyang_Qu(array,max_digit);
      for (int j = 0 ; j < array.length; j++ ) {
         System.out.print(array[j]+" ");
      }
                
   }
   
   public static void RadixSort_Feiyang_Qu(int input[], int max_digit)
   {
      ArrayList<Queue_Feiyang_Qu> sorted_list = new ArrayList<Queue_Feiyang_Qu>();
      for (int i = 0; i <= 10; i++)
      {
         sorted_list.add(new Queue_Feiyang_Qu());//0-9 queue
      }
      int power = 1;//use to instead of 10^ -- update in for loop by power = power*10
      for (int j = 0; j < max_digit; j++ )//loop for each digit
         { 
            for (int k = 0; k <= 5; k++)//loop for enqueue
               {
                  Integer check = (input[k]/power)%10; //check digit belongs to 0-9 queue     
                  sorted_list.get(check).enqueue(input[k]);
               }  
            int input_index = 0;
            for (int index = 0; index <=10; index++)//loop for dequeue 0-9 queue
            {
               while (!sorted_list.get(index).isEmpty())//loop for dequeue one number each time in each queue start queue0-->queue1-->....
               {
                  input[input_index] = sorted_list.get(index).front();//update input list 
                  sorted_list.get(index).dequeue();//dequeue from queue 0 - 9
                  input_index += 1;                 
               }
            }
            power = power*10;                       
         }  
   }  
   
   public static int digit_count(int array) //count how many digit for finding max digit of number
   {
        int count = 0; 
        while(array != 0)
        {
            array /= 10;
            ++count;
        }
        return count;
    }
}