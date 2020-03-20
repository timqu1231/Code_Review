class Parent{
  private void who(){
   System.out.println("Parent:who{}");
  }
  public static void whoAmI(){
   System.out.println("Parent:whoAmI()");
  }
  public void whoAreYou(){
   who();
   System.out.println("Parent:whoAreYou()");
  }
}
class Chile extends Parent{
   private void who(){
      System.out.println("Child:who()");
   }
   public void whoAreYou(){
      who();
      System.out.println("Chile:whoAreYou()");
   }
   public static void main(String agrs[]){
      Parent p = new Chile();
      p.whoAmI();
      p.whoAreYou();
   }
}