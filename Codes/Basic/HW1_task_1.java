/*
* Author: Feiyang Qu
* Date: 6/15/2018
* Description: HW1_task_1.java
*/
public class HW1_task_1
{
   public static void main (String[] args)
   {  
      System.out.println("Dec  OCT    HEX    Symbol");
         for (int i = 0; i <= 128; i++)//for loop from 0-128
            {
            System.out.format("%d\t\t",i); //print Dec
            System.out.format("%o\t\t", i); //print Oct
            System.out.format("%X\t\t",i);    // print Hex    
            System.out.println((char)i);  // print symbol    
            }
   }
}