package rainer_sieberer;

import java.util.EmptyStackException;

public class StackArray<E> implements LIFO<E>{

   private E[] stack;
   int point;
   
   @SuppressWarnings("unchecked")    
   public StackArray(){
			stack = (E[]) new Object[10];            
			point = 0;
   }
   
   //---------------------------------------------------------
   public boolean empty(){
      return point == 0;
   }
   
   //---------------------------------------------------------
   public E peek(){
      
      E next;
      
      try{
         next = stack[point - 1];
      }
      catch(IndexOutOfBoundsException e){
         System.out.println("Stack is empty!");
         throw new EmptyStackException();
      }
      
      return next;
   }
   
   //----------------------------------------------------------   
   public E pop(){
      
      E next;
      
      try{
         next = stack[point - 1];
      }
      catch(IndexOutOfBoundsException e){
         System.out.println("Stack is empty!");
         throw new EmptyStackException();
      }
      
      point--;
      stack[point] = null;
      
      return next;
   }
   
   //---------------------------------------------------------
   public E push(Object o){
      
      @SuppressWarnings("unchecked")
			E item = (E) o;
      
      if(point == stack.length){
         @SuppressWarnings("unchecked")
				 E[] help = (E[]) new Object[point * 2];
         for(int i = 0; i < stack.length; i++){
            help[i] = stack[i];
         }
         stack = help;
      }
      
      stack[point] = item;
      point++;
      return item;
   }

   //---------------------------------------------------------
   public int search(Object o){
      
      @SuppressWarnings("unchecked")
			E item = (E) o;
      int count = 1;
      
      for(int i = point - 1; i >= 0; i--){
         if(stack[i].equals(item))
            return count;
         count++;
      }
      
      return -1;
   }

   //---------------------------------------------------------
   public int getSize(){

      return point;
   }
}
