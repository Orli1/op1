/*
Arielle Leone
Optional Project #1
  */
import java.util.*;
import java.io.*;

class Driver{
  public static void main(String[] args){
    String input = readstring();
    Driver welObj=new Driver();
    welObj.Welcome(); //outputs program purpose
    Driver calObj=new Driver();
    String conversion=calObj.InfixtoPostfix(input);
    System.out.println("InFix: " + input);
    System.out.println("PostFix: " + conversion);
  }
  public static String readstring(){ 
   String input="";
   try{
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an infix expression: "); 
        input=sc.readLine(); 
        }
     catch (Exception e){
        e.printStackTrace();
      }
     return input;
  }
  public String InfixtoPostfix(String input){
    Stack myS =new Stack();
    Queue myQ =new Queue();
    
    String infix = "";
    String postfix = "";
    String answer="";
    String regex= "[-+*/^x()]";
    String line="("+input+")";
    
    System.out.println(line);
    
    String[]temp=line.split(regex);
    
    System.out.println(temp);
   
    for(int i=0; i<temp.length; i++){
     String token = temp[i];
    
     System.out.println(token);
     
     char ch=token.charAt(0);
    // System.out.println(ch);
     if(Character.isDigit(ch)){
      // System.out.println(ch);
       myQ.enqueue(token);
     }    
     else if(ch=='('){
     myS.push(token);
     }
     else if(ch==')'){
     myS.pop();
        while(myS.peek() != '('){
        myQ.enqueue(myS.pop());
        }
   }
     else{
       while(!myS.isEmpty()){ ////////////////////
         while(symbol(ch) <= symbol(((String) myS.peek()).charAt(0))) 
 {
         myQ.enqueue(myS.pop());
                     }
                     myS.push(token);
       }}
                  }  
         while (!myQ.isEmpty()) {
             answer += myQ.peek();
             answer += " ";
             myQ.dequeue();
         }
         return answer;            
    }
  public int symbol(char ch){
    switch(ch){     
    case '+':
    case '-':
      return 1;
    case '*':
    case 'x':
    case '/':
      return 2;
    case '^': 
      return 3;
    default: 
      return 0;
    }
  }
  public double evaluate(String answer) {

         Stack myS = new Stack();
         Queue myQ = new Queue();
         double result = 0.0;
          
         String[]temp=answer.split("[+-^*/()]");
             for(int i=0; i<temp.length; i++){
                String token = temp[i];
                char ch=token.charAt(0);

             if (!token.equals(" ")) {
         
                 if (Character.isDigit(ch)){
                     myS.push(token);
             
                 } else {
                     float top = Float.parseFloat(String.valueOf(myS.pop()));
                     float next = Float.parseFloat(String.valueOf(myS.pop()));
                     result = calculateOperation(next, top, ch);
                    myS.push(result);
                 } 
             }
         }    
         return result;
     }
     public float calculateOperation(float top, float next, char ch){
         switch(ch){
           case '^':
                 return (int)Math.pow(top,next);
           case '+':
                 return top + next;
             case '*':
             case 'x':
                 return top * next;
             case '/':
                 return top / next;
             case '-':
                 return top - next;
             default:
                 System.out.println("Invalid operation.");
                 return 0;   
         }    
     }
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
   