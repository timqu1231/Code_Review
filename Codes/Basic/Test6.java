public class Test6
{
    public static void main(String[] args){
         double[] a = {0.1, 0.2, 0.3, 0.4};
         double[] b = new double[4];
         System.out.println(a);
         System.out.println(b);
         b = a;
         System.out.println(a);
         System.out.println(b);

    }
}