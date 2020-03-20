// Name:          <Feiyang>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    3

// Define a class implement queue operation.

public class Queue_Feiyang_Qu
{
   private Node first, last;
   private int size;
  
   //constructor method to create a list object with first, last, and size. 
   public Queue_Feiyang_Qu()
   {
      first = null;  // list first pointer
      last = null;  // list last pointer
      size = 0;     // list size
   }
  
         
   //method to enqueue in the list
   public void enqueue(int data)
   {
     if (first == null)
         first = last = new Node(data);
     else 
     {
         Node newNode = new Node(data); 
         last.next = newNode;
         last = last.next;
     } 
         size++;
   }
      
  
      
   //method to remove the first node from the list
   public void dequeue()
   {
      if (size == 0)
      {
       //   void;
      }
      else 
      {
          Node current = first;
          first = first.next;
          current.next = null; //disconnect first node
          size--;
          if (first == null)
             last = null;
      }
   }
      
   //method to return front
   public int front()
   {
      return first.data;
   }
   
   //method to return size
   public int size()
   {
      return size;
   }
   
   //method to Empty
   public boolean isEmpty()
   {
      return (size == 0);
   }


   //method to print out the list
   public void printList() 
   {
      if (first == null)  // if an empty list
         System.out.println("List is empty...");
      else               // if non-empty list
      {
         Node temp;
         temp = first;
         while (temp != null)
         {
            System.out.print(temp.data + "   ");
            temp = temp.next;
         }
         System.out.println();
      }
   }
  
   //class to create nodes of the list as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}
