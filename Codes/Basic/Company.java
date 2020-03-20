class Company{
   public void address(){
         System.out.println("Address of Company");
   }
}

class eBay extends Company{

      public static void main(String[] args){
         Company a = new Company();
         Company b = new eBay();
         a.address();
         b.address();
      }
}