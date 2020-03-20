public class Test1
{   
   public static int fun1 (int x, int y){
               
            if (x==0)
                return y;
            else
                return fun1 (x-1, x+y);
         
            }
            public static void main(String[] args) {
      
               System.out.print (fun1(5,2));
        }
    
}
