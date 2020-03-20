class Car{
   String color;
   int speed;
   Car(String color, int speed){
      this.color = color;
      this.speed = speed;
   }
   public boolean equals(Object otherObject){
      if(otherObject == null)
         return false;
      if (getClass() != otherObject.getClass())
         return false;
      Car otherCar = (Car)otherObject;
      return (color.equals(otherCar.color) && speed == otherCar.speed);
   }
   public static void main(String[] args){
      Car c1 = new Car("Red", 1);
      Car c2 = new Car("Red", 1);
      System.out.println(c1.equals(c2));
   }
}