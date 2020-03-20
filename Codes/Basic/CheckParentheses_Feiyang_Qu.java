// Name:          <Feiyang Qu>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    2

//This class is for CheckParentheses. Input and print out a simple list

import java.util.Scanner;

public class CheckParentheses_Feiyang_Qu
{
   public static void main (String[] args)
   {
      do // do...while loop to let to repeat enter 
            {
            System.out.print("Enter a expression: ");
            Scanner input = new Scanner(System.in); 
            String data = input.nextLine();//scan input and copy into linked list
            System.out.printf("Input String: %s\n",data);
            System.out.print("Judgement: ");
            int judgement = CheckParentheses_Feiyang_Qu(data); //return from check parentheses method
         if (judgement == 0)
             {
             System.out.print("Valid Expression\n");
             }
         else
             {
             System.out.print("Invalid Expression\n");
             }
         
            }
      while (true);
   }
   
   public static int CheckParentheses_Feiyang_Qu(String input)
   {
      Stack_Feiyang_Qu myList = new Stack_Feiyang_Qu();
      int digit = input.length();//get size of user's input
      for (int i = 0; i < digit; i++ )//for loop to check each index if "(" or ")"
         { 
           String temp = input.substring(i,i+1);//split string to substring
           if (temp.equals("("))
               {
                              
                myList.push(temp);//push "(" in list
                
               }
           else if (temp.equals(")"))
               {
                  if (myList.pop() == true)
                  {
                  myList.pop();//pop ")" from list
                  }
                  else //eg. 1+) , return 1 --> (push-pop) != 0 --> invalid
                  {
                  return 1;
                  }
               }
        }
      int result = myList.size();//if size !=0, invalid
      return result;
  }  
}