// Name:          <Feiyang>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    4

//import java.util.Scanner;
//import java.io.File;
import java.io.*;
import java.util.*;


public class RemoveDuplicates_Feiyang{
   public static void main(String[] args) throws FileNotFoundException {
      boolean cont = true;// variable for checking if play again
      do{
         cont = true;
         System.out.println("Read a file or Type text?(Press r/t)");
         BST_Feiyang<String> tree = new BST_Feiyang<>();
         boolean input_valid = false; //input valid
         do{
            input_valid = false;
            Scanner check = new Scanner(System.in); 
            String input_check = check.nextLine();//input r/t
            if (input_check.equals("r")){//read .txt file
               System.out.print("Please give file name(.txt):\n");              
               Scanner keyboard = new Scanner(System.in);//input file name.txt
               String filename = keyboard.nextLine();//scan file name
               File file = new File(filename);//find file
               Scanner file_data = new Scanner(file);
               String data = file_data.nextLine();//input file data
               System.out.println("Original Text:");
               System.out.println(data);
               //System.out.println(" ");
               //String data = readFile(filename);
               int i = 0;
               boolean type_split = true;//check any more data need split 
               do{ 
                  String[] temp = data.split(" "); //split string by space
                  tree.insert(temp[i]);//intsert data into tree without duplicate
                  if (i+1 >=temp.length){//end split when false
                     type_split = false;
                  }
                  i++;
               }while(type_split);
               System.out.println("Processed Text:");
               tree.inorder();//inorder print file
               System.out.println(" ");
            }else if (input_check.equals("t")){//for type text
               System.out.print("Please typing inputs:\n");
               Scanner type_input = new Scanner(System.in);//type the text
               String type = type_input.nextLine();
               System.out.println("Original Text:");
               System.out.println(type);
               //System.out.println(" ");
               int i = 0;
               boolean type_split = true;
               do{ 
                  String[] temp = type.split(" ");//split input string 
                  //System.out.println(temp[i]);
                  tree.insert(temp[i]);
                  if (i+1 >= temp.length)
                  {
                     type_split = false;
                     //if (temp[i+1].equals(null)){
                       //type_split = false;
                     //}
                  }                 
                  i++;
                 // tree.inorder(temp[i]);
               }while(type_split);
               System.out.println("Processed Text:");
               tree.inorder();
               System.out.println(" ");
            }else{
               System.out.print("Invalid input,try again\n");
               input_valid = true;
            }
         }while(input_valid);
         
         
         boolean result = true; //check "Y"/"N"/invalid input"X"/
         do{
            System.out.print("\nWant to remove duplicates again? Y/N\n");//chekc for new - input
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
      }while(cont);
   }
}   