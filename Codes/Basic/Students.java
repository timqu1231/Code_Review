public class Students {
   private String strName;
   private int nExamScore;
   Students() {
       strName = "No Name Given";
       nExamScore = -1;
       display();
               
   }
   Students (String name, int score) {
       setData (name, score);
   }
   void setData (String name, int score){
       strName = name;
       nExamScore = score;
   }
   void display () {
       System.out.println("Name:" + strName);
       System.out.println("Score:" +nExamScore);
   }
       /**
        * @param args the command line arguments
        */
       public static void main(String[] args) {
           Students obj1 = new Students ();
           obj1.setData("Tom", 100);
           obj1.display();
           Students obj2 = new Students ("John",90);
           obj2.display();
                   
           // TODO code application logic here
       }
    
}
