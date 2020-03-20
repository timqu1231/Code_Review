public class Sample 
    {
        public static void example (double[] a){
            a[0] = 1;
        }
    

        public static void main(String[] args) {
            double[] a = {0.1, 0.2, 0.3, 0.4};
            Sample.example(a);
            for (int i = 0; i < a.length; i++)
               System.out.print(a[i]);
               System.out.print(",");


    }
    
}
