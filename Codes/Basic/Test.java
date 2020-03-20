class Top{
     public String f(Object o) {return "Top:f";}
}

class Sub extends Top{
      public String f(Object o) {return "Sub:f1";}
      public String f(String s) {return "Sub:f2";}
}

public class Test{
   public static void main(String[] args){   
        Sub sub = new Sub();
        Top top = sub;
        String str = "String";
        Object obj = str;
        System.out.println(top.f(str));
        System.out.println(top.f(obj));
        System.out.println(sub.f(str));
        System.out.println(sub.f(obj));
   }
}