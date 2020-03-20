public class test_number
{
   public static void main (String [] args)
   {
      int[][] x = new int[10][10];
      for(int i = 0; i < 10; i++){
         for (int j = 0; j < 10; j++){
            x[i][j] = 3;
            System.out.print(x[i][j]);
         }
         System.out.println();
      }
      // System.out.println("x: " + x);
//       System.out.println("y: " + y);
//       System.out.println("z: " + z);
   }
}