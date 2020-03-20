// Name:          <Feiyang>   
// Class:         CS 5000      
// Term:          Summer 2018 


//import java.util.Scanner;
//import java.io.File;
import java.io.*;
import java.util.*;


public class Project_Feiyang{
   public static String read_data() throws FileNotFoundException{
      //Scanner keyboard = new Scanner(System.in);//input file name.txt
      // String filename = "Library Manager";//scan file name
//       File file = new File(filename);//find file
//       Scanner file_data = new Scanner(file);
//       String data = file_data.nextLine();//input file data
      File file = new File("C:\\Users\\Public\\Library Manager.txt");//find file
      Scanner file_data = new Scanner(file);
      String data = file_data.nextLine();//input file data 
      return data;
   }
   
   public static void write_data(String write_command){
         try {
             File txt_file = new File("C:\\Users\\Public\\Library Manager.txt");
             FileOutputStream file = new FileOutputStream(txt_file, true);
             OutputStreamWriter input = new OutputStreamWriter(file);    
             Writer data = new BufferedWriter(input);
             data.write(write_command + " ");
             //System.getProperty("line.separator");
             data.close();
       } catch (IOException e) {
             System.err.println("Input Error");
       }
     //  try{
//          String filename= "Library Manager.txt";
//          FileWriter fw = new FileWriter(filename,true); //the true will append the new data
//          fw.write(write_command + " ");//appends the string to the file
//          fw.close();
//       }
//       catch(IOException ioe)
//       {
//          System.err.println("IOException: " + ioe.getMessage());
//       }
   }
   
   public static void main_menu(){
      System.out.print("1. Add a new book\n");
      System.out.print("2. Remove a book (input ISBN)\n");
      System.out.print("3. Check out a book (input ISBN and the due date)\n");
      System.out.print("4. Check in a book (input ISBN)\n");
      System.out.print("5. Display all book details (along with their specialization)\n");
      System.out.print("6. Display all available book details\n");
      System.out.print("7. Display all checked-out books\n");
      System.out.print("8. Exit program\n");
      System.out.println("Your opinion: ");
       // Scanner option = new Scanner(System.in);//input file name.txt
//        int input = option.nextInteger();//scan file name
//        return input;
   }
   
   public static void add_book(){
      System.out.println("Please enter following information to add book");
      System.out.println("1. Has an ISBN: (10 digits)");
      Scanner ISBN = new Scanner(System.in);//input file name.txt
      String input_1 = ISBN.nextLine();//scan file name
      //System.getProperty("line.separator");
      write_data(input_1);
      System.out.println("2. Has a title: e.g., C++ProgrammingLanguage(No Space)");
      Scanner title = new Scanner(System.in);//input file name.txt
      String input_2 = title.nextLine();//scan file name
      write_data(input_2);
      System.out.println("3. Has a type: e.g., textbook, magazine, journal, newspaper, novel, and other");
      Scanner type = new Scanner(System.in);//input file name.txt
      String input_3 = type.nextLine();//scan file name
      write_data(input_3);
      System.out.println("4. Has a publisher: e.g., TAMUC");
      Scanner publisher = new Scanner(System.in);//input file name.txt
      String input_4 = publisher.nextLine();//scan file name
      write_data(input_4);
      System.out.println("5. Has a page information (how many pages): e.g., 506");
      Scanner page = new Scanner(System.in);//input file name.txt
      String input_5 = page.nextLine();//scan file name
      write_data(input_5);
      System.out.println("6. Has a price: e.g., 20.00");
      Scanner price = new Scanner(System.in);//input file name.txt
      String input_6 = price.nextLine();//scan file name
      write_data(input_6);
      System.out.println("7. Has a publication year: e.g., 2013");
      Scanner year = new Scanner(System.in);//input file name.txt
      String input_7 = year.nextLine();//scan file name
      write_data(input_7);
      System.out.println("8. Has a status: e.g., 0=check-out, 1=checked-in/add a book");
      Scanner status = new Scanner(System.in);//input file name.txt
      String input_8 = status.nextLine();//scan file name
      write_data(input_8);
      System.out.println("9. Has a name who checked out the book: e.g., Tommy");
      Scanner name = new Scanner(System.in);//input file name.txt
      String input_9 = name.nextLine();//scan file name
      write_data(input_9);
      System.out.println("10. Has a due date: e.g., 2017/05/01");
      Scanner due = new Scanner(System.in);//input file name.txt
      String input_10 = due.nextLine();//scan file name
      write_data(input_10);
   }
   
   public static void remove_book()throws FileNotFoundException{
      System.out.println("Please enter ISBN for removing a book:");
      boolean exist = false;
      String temp_data;      
      do{
         exist = false;
         Scanner ISBN = new Scanner(System.in);//input file name.txt
         String input = ISBN.nextLine();//scan file name
         exist = ISBN_exist(input);
         //System.out.println(exist);
         temp_data = input;
         //System.out.println(temp_data);
         if (exist == true){
            System.out.println("Cannot find ISBN. Try again.");
         }
      }while(exist);
      String before = read_data();
      String temp[] = before.split(" ");//split input to several string 
      for (int i =0; i < temp.length; i++ ){//start reverse each index input by for loop 
         if (temp[i].equals(temp_data)){                              
              for (int j = 0; j < i - 10; j++){
                  //System.out.println(temp[i]);
                  //System.out.println(temp[i+10]);
                  temp[i] = temp[i+10];
                  write_data(temp[i]);
              }
         }
      }      
   }
   
   public static void check_out()throws FileNotFoundException{
      System.out.println("Please enter ISBN for checking-out a book:");
      boolean exist = false;
      String temp_data;      
      do{
         exist = false;
         Scanner ISBN = new Scanner(System.in);//input file name.txt
         String input = ISBN.nextLine();//scan file name
         exist = ISBN_exist(input);
         //System.out.println(exist);
         temp_data = input;
         //System.out.println(temp_data);
         if (exist == true){
            System.out.println("Cannot find ISBN. Try again.");
         }
      }while(exist);
      System.out.println("Please enter due date for checking-out a book:");
      Scanner due_date = new Scanner(System.in);//input file name.txt
      String input_due_date = due_date.nextLine();//scan file name
      String data = read_data();
      String temp[] = data.split(" ");//split input to several string 
      for (int i =0; i < temp.length; i++ ){//start reverse each index input by for loop 
         if (temp[i].equals(temp_data)){                                           
               temp[i + 7] = "0";
               temp[i + 9] = input_due_date;            
         }
      }
   }
   
   public static void check_in()throws FileNotFoundException{
      System.out.println("Please enter ISBN for checking-in a book:");
      boolean exist = false;
      String temp_data;      
      do{
         exist = false;
         Scanner ISBN = new Scanner(System.in);//input file name.txt
         String input = ISBN.nextLine();//scan file name
         exist = ISBN_exist(input);
         //System.out.println(exist);
         temp_data = input;
         //System.out.println(temp_data);
         if (exist == true){
            System.out.println("Cannot find ISBN. Try again.");
         }
      }while(exist);      
      String data = read_data();
      String temp[] = data.split(" ");//split input to several string 
      for (int i =0; i < temp.length; i++ ){//start reverse each index input by for loop 
         if (temp[i].equals(temp_data)){                                           
               temp[i + 7] = "1";             
         }
      }
   }
   
   public static void all_book()throws FileNotFoundException{
      String data = read_data();
      String temp[] = data.split(" ");//split input to several string 
      int book_index = 1;
      for (int i = 0; i < temp.length; i++ ){//start reverse each index input by for loop
         if (book_index % 10 != 0){          
            System.out.print(temp[i] + " ");
         }else if(book_index % 10 == 0){
            System.out.println(temp[i]);
         }
         book_index = book_index + 1;
      }
   }
   
   public static void all_available_book()throws FileNotFoundException{
      String data = read_data();
      String temp[] = data.split(" ");//split input to several string
      int book_index = 1; 
      for (int i = 7; i < temp.length; i=i+7){//start reverse each index input by for loop
         if (temp[i] == "1"){  
            for(int j = i-7; j <= 20; j++){       
               for (int k = i - 14; k < 10; k++ ){//start reverse each index input by for loop
                  if (book_index % 10 != 0){          
                     System.out.print(temp[k] + " ");
                  }else if(book_index % 10 == 0){
                     System.out.println(temp[k]);
                  }
               }
            }
            book_index = book_index + 1;
         }
      }
   }
   
   public static void check_out_book()throws FileNotFoundException{
      String data = read_data();
      String temp[] = data.split(" ");//split input to several string
      int book_index = 1; 
      for (int i = 7; i < temp.length; i=i+7){//start reverse each index input by for loop
         if (temp[i] == "0"){  
            for(int j = i-7; j <= 10; j++){       
               for (int k = i - 7; k < 10; k++ ){//start reverse each index input by for loop
                  if (book_index % 10 != 0){          
                     System.out.print(temp[k] + " ");
                  }else if(book_index % 10 == 0){
                     System.out.println(temp[k]);
                  }
               }
            }
            book_index = book_index + 1;
         }
      }
   }
   
   public static boolean ISBN_exist(String ISBN)throws FileNotFoundException{
      String data = read_data();
      String temp[] = data.split(" ");//split input to several string
      int i = 0;
      boolean exist = false;
      do{       //start reverse each index input by for loop 
         exist = false;
         if (!temp[i].equals(ISBN)){                                           
            exist = true;                
         }
         i = i + 10;
      }while(exist == true && i < temp.length);
      return exist;            
   }
   
   public static void main(String[] args) throws FileNotFoundException {
      System.out.println("Welcome to Library Manager! Press o to open.");     
      //boolean cont = true;
      //System.out.print("Welcome to Library Manager! Press o to open.");
      boolean input_valid = false; //input valid
      do{//open check
         //boolean cont = true;
         //System.out.println("1. Has an ISBN: (10 digits)");
         Scanner open = new Scanner(System.in);//input file name.txt
         String open_value = open.nextLine();
         input_valid = false;
         if (open_value.equals("o")){
            boolean cont = true;
            do{
               cont = true;
               main_menu();
               Scanner option = new Scanner(System.in);//input file name.txt
               int input = option.nextInt();//scan file name
               if (input == 1){
                  add_book();
                  System.out.println(" ");
                  System.out.print("Done!\n");   
               }else if (input == 2){
                  remove_book();
                  System.out.println(" ");
                  System.out.print("Done!\n");
               }else if (input == 3){
                  check_out();
                  System.out.println(" ");
                  System.out.print("Done!\n");
               }else if (input == 4){
                  check_in();
                  System.out.println(" ");
                  System.out.print("Done!\n");
               }else if (input == 5){
                  all_book();
                  System.out.println(" ");
                  System.out.print("Done!\n");
               }else if (input == 6){
                  all_available_book();
                  System.out.println(" ");
                  System.out.print("Done!\n");
               }else if (input == 7){
                  check_out_book();
                  System.out.println(" ");
                  System.out.print("Done!\n");
               }else if (input == 8){
                  cont = false;
                  input_valid = false;                  
               }
            }while(cont);  
            System.out.print("Thank you for using Library Manager!\n");                    
         }else if (!open_value.equals("o")){
            System.out.print("Invalid input,try again:\n");
            input_valid = true;
         }
      }while(input_valid);                
   }
}   