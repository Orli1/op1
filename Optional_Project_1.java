/*
Arielle Leone
Optional Project #1
  */
import java.lang.*;
import java.util.*;
import java.io.*;

class Driver{
  public static void main(String[] args){
    String infix = "";
    String postfix = "";
    int priority=0;
    
    Driver welObj=new Driver();
    welObj.Welcome(); //outputs program purpose
    String line="";
    Stack stack =new Stack();
    Queue queue =new Queue();
    
   try{
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an infix expression: "); 
        line=sc.readLine(); 
        }
     catch (Exception e){
        e.printStackTrace();
      }
   for(int i=0; i<line.length(); i++){
     char ch = line.charAt(i);
    // System.out.println(ch);
     if(Character.isDigit(ch)){
       System.out.println(ch);
       //queue
     }    
     if(ch=='('){
     stack.push(ch);
     }
     if(ch==')'){
     stack.pop();
        while(stack.peek() != '('){
        postfix += stack.pop();
        stack.pop();}
   }
     if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
          {
       if (stack.size() <= 0){
                  stack.push(ch);
           }  
        else{
                  Character chTop = (Character) stack.peek();
                  if (chTop == '*' || chTop == '/')
                     priority = 1;
                  else
                     priority = 0;
                  if (priority == 1)
                  {
                     if (ch == '+' || ch == '-')
                     {
                        postfix += stack.pop();
                        i--;
                     }
                     else
                     { // Same
                        postfix += stack.pop();
                        i--;
                     }
                  }
                  else
                  {
                     if (ch == '+' || ch == '-')
                     {
                        postfix += stack.pop();
                        stack.push(ch);
                     }
                     else
                        stack.push(ch);
                  }
               }
     }}}
public void Welcome(){
    System.out.println("Welcome. This program takes the input of infix expressions, converts");
    System.out.println("them to postfix expressions, and evaluates the results.");
} 
}
class Node{   //from powerpoint slides
  Object data;
  Node next;
  public Node(){
    data = ""; 
    next = null;
  }
  public Node(Object d, Node n){
    data = d; 
    next =n;
  }
}
class stacklist{ //from powerpoint slides
   private Node top;
   
public void push(Object item){ 
  top = new Node(item, top);
  }
public Object pop( ){
     Node oldTop = top;
     Object item = peek();
     top = top.next;
     oldTop.next = null;
     return item;
   }
public Object peek(){
     if(isEmpty()) throw new NullPointerException();
     return top.data;
   }
public boolean isEmpty(){
 return top==null; 
  }
}
class Queue{
    public int N;               // number of elements on queue
    public Node first;    // beginning of queue
    public Node last;     // end of queue
    public Queue() {
        first = null;
        last  = null;
        N = 0;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return N;     
    }
    public Object peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.data;
    }
    public void enqueue(Object item) {
        Node oldlast = last;
        last = new Node();
        last.data = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }
    public Object dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Object data = first.data;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        return data;
    }
}
   