package rainer_sieberer;

import java.util.EmptyStackException;

public class StackList<E> implements LIFO<E>{
   
   private Node head;
   
   public StackList(){
      head = null;
   }
   
   //------------------------------------------------
   public boolean empty(){
      return head == null;
   }
   
   //------------------------------------------------
   public E peek(){
      
      E next;
      
      try{
         next = head.getData();
      }
      catch(NullPointerException e){
         System.out.println("Stack is empty!");
         throw new EmptyStackException();
      }
      
      return next;
   }
   
   //-------------------------------------------------
   public E pop(){
      
      E next;
      
      try{
         next = head.getData();
      }
      catch(NullPointerException e){
         System.out.println("Stack is empty!");
         throw new EmptyStackException();
      }

      head = head.getNext();
      return next;
   } 
   
   //-------------------------------------------------
   public E push(Object o){
      
      @SuppressWarnings("unchecked")
			E item = (E) o;
      Node p = new Node(item);
      
      if(empty()){
         head = p;
      }
      else{
         p.setNext(head);
         head = p;
      }
      
      return item;
   }
   
   //-------------------------------------------------
   public int search(Object o){
      
      @SuppressWarnings("unchecked")
			E item = (E) o;
      int count = 1;
      Node p = head;
      
      while(p != null){
         if(p.getData().equals(item))
            return count;

         p = p.getNext();
         count++;
      }
      
      return -1;
   }

   //-------------------------------------------------
   public int getSize(){

      int count = 0;
      Node currentNode = head;

      while ( currentNode != null ){
         count++;
         currentNode = currentNode.getNext();
      }

      return count;
   }
      
   
   //####################################################
   private class Node{
      private E data;
      private Node next;
      
      private Node(E x){
         data = x;
         next = null;
      }
      
      private E getData(){
         return data;
      }
      
      private Node getNext(){
         return next;
      }
      
      private void setNext(Node p){
         next = p;
      }
   }
}
