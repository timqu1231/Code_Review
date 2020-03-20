// Name:          <Feiyang>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    1

// This class defines a linked list that stores integer values.

public class LinkedList_Qu
{
   private Node head, tail;
   private int size;
  
   //constructor method to create a list object with head, tail, and size. 
   public LinkedList_Qu()
   {
      head = null;  // list head pointer
      tail = null;  // list tail pointer
      size = 0;     // list size
   }
  
   //method to add a node to the end of list
   public void addLastNode(int data) 
   {
      if (tail == null) 
         head = tail = new Node(data); //empty list
      else 
      {
         tail.next = new Node(data); //link new node as last node
         tail = tail.next; //make tail pointer points to new last node
      }
      size++; //increase list size by one
   }
   
   
   //================= your part to complete for assignment 1 =============
   
   //method to add a new node as the first node in the list
   public void addFirstNode(int data)
   {
     if (head == null)
         head = tail = new Node(data);
     else 
     {
         Node newnode = new Node(data); 
         newnode.next = head;
         head = newnode;
     } //complete this method using the pesudocode discussed in class
     size++;
   }
      
   //method to add a node at specific position, namely index
   public void addAtIndex(int index, int data)
   {
     if (index == 0)
         {
               addFirstNode(data);
         }
     else if (index >= size)
         {
               addLastNode(data);
         }
     else 
         {
               Node current = head;
               Node temp = head.next;
               for (int i = 1; i < index; i++)
               {
                    current = current.next;
                    temp = temp.next; 
               }
               temp = current.next;
               current.next = new Node(data);
               (current.next).next = temp;
               size++;
         }
      //complete this method using the pesudocode discussed in class
   }
      
   //method to remove the first node from the list
   public void removeFirstNode()
   {
      if (size == 0)
      {
       //   void;
      }
      else 
      {
          head = head.next;
          size--;
          if (head == null)
             tail = null;
      }//complete this method using the pesudocode discussed in class
   }
      
   //method to remove the last node from the list
   public void removeLastNode()
   {
     if (size == 0)
         {
         }
     else if (size == 1)
         {
         head = tail = null;
         size = 0;
         } 
     else
         {
         Node current = head;
         for (int i = 0; i < size - 2; i++)
             {
             current = current.next;
             }
         Node temp = tail;
         tail = current;
         tail.next = null;
         size --;
         }//complete this method using the pesudocode discussed in class
   }
      
   //method to remove a node at specific position,namley index
   public void removeAtIndex(int index)
   {
      if (index < 0 || index >= size) 
          {
          } 
      else if (index == 0)
          {
          removeFirstNode();
          }
      else if (index == size - 1)
          {
          removeLastNode();
          }    
      else
          {
          Node previous = head;
          for (int i = 1; i < index; i++) 
               {
               previous = previous.next;
               }
          Node current = previous.next;
          previous.next = current.next;
          size--;
          }
      //complete this method using the pesudocode discussed in class
   }
   
   //method to create a copy of the list
   public LinkedList_Qu copyList()
   {  
      //complete this method using the pesudocode discussed in class
      //This method returns a pointer to the new list, List2
      
      LinkedList_Qu List2;  //declare the list variable
      List2 = null;      //initialize the list to null
      List2 = new LinkedList_Qu();
      if (size == 0) 
          {
          } 
      else if (size == 1)
          {
          Node copyNode = new Node(head.data);
          List2.head = List2.tail = copyNode; 
          //List2.tail.next = null;
          List2.size=1;
          }
      else 
          {
          Node current = head;
          Node copyHead = new Node(head.data);
          Node copyTail = new Node(tail.data);
          List2.head = copyHead;
          List2.tail = copyTail;
          for (int i = 0;i < size-1; i++)
               {
               current = current.next;
               //Node copyAdd = new Node(List2);
               Node copyAdd = new Node(current.data);
               copyHead.next = copyAdd;
               copyHead = copyAdd;             
               }
          List2.size = size;
          }
      //Add code to perform the copying process
   
      return List2;
   }


   //================= end of your part for assignment 1 ==============

   //method to print out the list
   public void printList() 
   {
      if (head == null)  // if an empty list
         System.out.println("List is empty...");
      else               // if non-empty list
      {
         Node temp;
         temp = head;
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
