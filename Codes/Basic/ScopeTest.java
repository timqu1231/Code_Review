public class ScopeTest{ 
   public int x = 0;
   class FirstLevel{
      public int x = 1;
      void methodInFirstLevel(int x) {
         System.out.println("x = " + x);
         System.out.println("this.x = " + this.x);
         System.out.println("ScopeTest.this.x = " + ScopeTest.this.x);
      }
   }
   static class staticFirst {
      public int x = 1;
      void methodInFirstLevel(int x) {
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x); 
      }
   }
   public static void main(String[] args){
      ScopeTest st = new ScopeTest();
      ScopeTest.FirstLevel f1 = st.new FirstLevel();
      f1.methodInFirstLevel(23);
      ScopeTest.staticFirst f2 = new ScopeTest.staticFirst();
      f2.methodInFirstLevel(23);
   }
}