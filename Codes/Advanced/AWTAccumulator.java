import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.util.regex.*; 
 
// An AWT GUI program inherits from the top-level container java.awt.Frame
public class AWTAccumulator extends Frame implements ActionListener {
   private Label lblInput;     // Declare input Label
   private Label FirstOutput;    // Declare output Label
   private Label SecondOutput;
   private Label ThirdOutput;
   private TextField tfInput;  // Declare input TextField
   private TextField FirstREOutput; // Declare output TextField
   private TextField FirstRETrueOutput;
   private TextField SecondREOutput;      // Accumulated sum, init to 0
   private TextField SecondRETrueOutput;
   private TextField ThirdREOutput;
   private TextField ThirdRETrueOutput;
   // Constructor to setup the GUI components and event handlers
   public AWTAccumulator() {
      setLayout(new FlowLayout());
         // "super" Frame (container) sets layout to FlowLayout, which arranges
         // the components from left-to-right, and flow to next row from top-to-bottom.
      lblInput = new Label("Enter: "); // Construct Label
      add(lblInput);               // "super" Frame container adds Label component
 
      tfInput = new TextField(70); // Construct TextField
      add(tfInput);                // "super" Frame adds TextField
 
      tfInput.addActionListener(this);
         // "tfInput" is the source object that fires an ActionEvent upon entered.
         // The source add "this" instance as an ActionEvent listener, which provides
         //  an ActionEvent handler called actionPerformed().
         // Hitting "enter" on tfInput invokes actionPerformed().
 
      FirstOutput = new Label("First Regular Expression is: ");  // allocate Label
      add(FirstOutput);               // "super" Frame adds Label      
      FirstREOutput = new TextField(10); // allocate TextField
      FirstRETrueOutput = new TextField(70);
      FirstREOutput.setEditable(false);  // read-only
      add(FirstREOutput);  // "super" Frame adds TextField
      add(FirstRETrueOutput);
                          
      SecondOutput = new Label("Second Regular Expression is: ");  // allocate Label
      add(SecondOutput);               // "super" Frame adds Label 
      SecondREOutput = new TextField(10); // allocate TextField
      SecondRETrueOutput = new TextField(70);
      SecondREOutput.setEditable(false);  // read-only
      add(SecondREOutput);                // "super" Frame adds TextField
      add(SecondRETrueOutput);
      
      ThirdOutput = new Label("Third Regular Expression is: ");  // allocate Label
      add(ThirdOutput);               // "super" Frame adds Label
      ThirdREOutput = new TextField(10); // allocate TextField
      ThirdRETrueOutput = new TextField(70);
      ThirdREOutput.setEditable(false);  // read-only
      add(ThirdREOutput);                // "super" Frame adds TextField
      add(ThirdRETrueOutput);
 
      setTitle("Regular Expresson");  // "super" Frame sets title
      setSize(700, 250);  // "super" Frame sets initial window size
      setVisible(true);   // "super" Frame shows
   }
 
   // The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an anonymous instance
      new AWTAccumulator();
   }
 
   // ActionEvent handler - Called back upon hitting "enter" key on TextField
   @Override
   public void actionPerformed(ActionEvent evt) {
      // Get the String entered into the TextField tfInput, convert to int     
      String textIn = tfInput.getText();
      String s = textIn;
      System.out.println(textIn);
      boolean Firstresult, Secondresult, Thirdresult;
      Firstresult = Pattern.matches("[0]*[1]*", textIn);
      String result1 = FirstRE(s);
      FirstRETrueOutput.setText(result1);
      Secondresult = Pattern.matches("[b](bb)*(aa)*", textIn);
      String result2 = SecondRE(s);
      SecondRETrueOutput.setText(result2);
      Thirdresult = Pattern.matches("[0]*[1]*[0]", textIn);
      String result3 = ThirdRE(s);
      ThirdRETrueOutput.setText(result3);
      FirstREOutput.setText(Firstresult + ""); // Display sum on the output TextField
      SecondREOutput.setText(Secondresult + "");
      ThirdREOutput.setText(Thirdresult + "");             
   }
   
   public String FirstRE(String Input){
      String s = Input;
      String answer = " ";
      int firststate = 1;//start state = 1
      int secondstate = 2;
      int thirdstate = 3;
      int currentposition = firststate;
      for(int i=0; i < s.length(); i++){
  	      char c = s.charAt(i);        
         if (currentposition == firststate){
            if (c == '0'){
               currentposition = firststate;
            }else if (c == '1'){
               currentposition = secondstate;
            }else if (c != '0' && c!= '1'){
               currentposition = thirdstate;
            } 
         }else if (currentposition == secondstate){
            if (c == '0'){
               currentposition = thirdstate;
            }else if (c == '1'){
               currentposition = secondstate;
            }else if (c != '0' && c!= '1'){
               currentposition = thirdstate;
            }
         }else if (currentposition == thirdstate){
               currentposition = thirdstate;
         }
         answer = answer + "\n" + Character.toString(c) + "--> state" + Integer.toString(currentposition);
       }
      if (currentposition == secondstate || currentposition == firststate){
         System.out.println("Accept");
      }else if(currentposition == thirdstate){
         System.out.println("Reject");
      }
      return answer;
   }
   
   public String SecondRE(String Input){
      String s = Input;
      String answer = " ";
      int firststate = 1;//start state = 1
      int secondstate = 2;
      int thirdstate = 3;
      int fourthstate = 4;
      int fifthstate = 5;
      int currentposition = firststate;
      for(int i=0; i < s.length(); i++){
  	      char c = s.charAt(i);        
         if (currentposition == firststate){
            if (c == 'a'){
               currentposition = fifthstate;
            }else if (c == 'b'){
               currentposition = secondstate;
            }else if (c != 'a' && c!= 'b'){
               currentposition = thirdstate;
            } 
         }else if (currentposition == secondstate){
            if (c == 'a'){
               currentposition = thirdstate;
            }else if (c == 'b'){
               currentposition = firststate;
            }else if (c != 'a' && c!= 'b'){
               currentposition = fifthstate;
            }
         }else if (currentposition == thirdstate){
            if (c == 'a'){
               currentposition = fourthstate;
            }else if (c == 'b'){
               currentposition = fifthstate;
            }else if (c != 'a' && c!= 'b'){
               currentposition = fifthstate;
            }
         }else if (currentposition == fourthstate){
           if (c == 'a'){
               currentposition = thirdstate;
            }else if (c == 'b'){
               currentposition = fifthstate;
            }else if (c != 'a' && c!= 'b'){
               currentposition = fifthstate;
            } 
         }else if (currentposition == fifthstate){
               currentposition = fifthstate;
         }
         answer = answer + "\n" + Character.toString(c) + "--> state" + Integer.toString(currentposition);
       }
            if (currentposition == secondstate || currentposition == fourthstate){
         System.out.println("Accept");
      }else if(currentposition == firststate || currentposition == thirdstate || currentposition == fifthstate){
         System.out.println("Reject");
      }
      return answer;
   }
   
   public String ThirdRE(String Input){
      String s = Input;
      String answer = " ";
      int firststate = 1;//start state = 1
      int secondstate = 2;
      int thirdstate = 3;
      int rejectstate = 0;
      int currentposition;
      char firstdigit = s.charAt(0);
      boolean check = false;
      for(int j=0; j < s.length(); j++){  	      
         char a = s.charAt(j);
         if(a != '0'){
            check = true;
         }
      }
      if (check == true){
         currentposition = firststate;
         if (firstdigit == '1'){
            currentposition = secondstate;
         }
         for(int i=0; i < s.length(); i++){
     	      char c = s.charAt(i);        
            if (currentposition == firststate){
               if (c == '0'){
                  currentposition = firststate;
               }else if (c == '1'){
                  currentposition = secondstate;
               }else if (c != '0' && c!= '1'){
                  currentposition = rejectstate;
               } 
            }else if (currentposition == secondstate){
               if (c == '0'){
                  currentposition = thirdstate;
               }else if (c == '1'){
                  currentposition = secondstate;
               }else if (c != '0' && c!= '1'){
                  currentposition = rejectstate;
               }
            }else if (currentposition == thirdstate || currentposition == rejectstate){
                  currentposition = rejectstate;
            }
            answer = answer + "\n" + Character.toString(c) + "--> state" + Integer.toString(currentposition);
          }
          if (currentposition == thirdstate){
            System.out.println("Accept");
          }else if(currentposition == firststate || currentposition == secondstate || currentposition == rejectstate){
            System.out.println("Reject");
          }
      }else if (check == false){
         for(int k=0; k < s.length(); k++){
     	      char lastdigit = s.charAt(k);
            if (k == (s.length()-1)){
               currentposition = thirdstate;
               answer = answer + "\n" + Character.toString(lastdigit) + "--> state" + Integer.toString(currentposition);
            }else{
               currentposition = firststate;
               answer = answer + "\n" + Character.toString(lastdigit) + "--> state" + Integer.toString(currentposition);
            }
         }
         System.out.println("Accept");
      }
      return answer;
   }
}