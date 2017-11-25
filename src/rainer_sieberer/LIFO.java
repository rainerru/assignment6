package rainer_sieberer;

public interface LIFO<E>{
   
   //Tests if this stack is empty.
   public boolean empty();
   
   //Looks at the object at the top of this stack without removing it from the stack.
   public E peek();
   
   //Removes the object at the top of this stack and returns that object as the value of this function.
   public E pop();
   
   //Pushes an item onto the top of this stack.
   public E push(Object item);
   
   //Returns the 1-based position where an object is on this stack.
   public int search(Object o);

   //Returns the size of the stack.
   public int getSize();
}