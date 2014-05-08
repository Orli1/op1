/*
Arielle Leone
Project #6
5/10/14
Algorithm: 
1. Program welcomes user and states purpose. Calls the readInput Method twice to set two mapObjects.
2. Uses BufferedReader to read input from "state_data.txt" and stores input in mapObjects.
3. Calls method Breadth.
*/
import java.lang.*;
import java.util.*;
import java.io.*;

class Driver1{ 
   public static void main(String[] args){
     System.out.println("Welcome. This program traverses a map of the United States, printing out each State name");
     System.out.println("in the order it was visited using both depth and breadth traversal.");
     System.out.println("");
     
     Node[] mapObject1=readInput();
     Node[] mapObject2=readInput();
     Map breadthObject=new Map(mapObject1);
     Map depthObject=new Map(mapObject2);
     
     System.out.println("This program will now list the states using breadth first.");
     System.out.println("              ~~Breadth First Results~~");
     breadthObject.Breadth(mapObject1[0]);
     System.out.println("");
    // System.out.println("This program will now list the states using depth first.");
    // System.out.println("               ~~Depth First Results~~");
     //depthObject.Depth(mapObject2[0]);
  }
 public static Node[] readInput(){
      String data;
      int counter;  
      BufferedReader textdata=null;
      Node[] graph=new Node[48];
      try{
          textdata=new BufferedReader(new FileReader("state_data.txt"));
          //System.out.println("File open!"); //debugging
            
          int num=graph.length;
          for(counter=0; counter<num; counter++){
              Node newNode=new Node(counter+1, null, false);
              Node front = newNode;    
              
              data=textdata.readLine();
              // System.out.println(data); //debugging
                
               StringTokenizer token=new StringTokenizer(data);
               //System.out.println(token.nextElement()); //debugging
               do{
                    newNode.step=new Node(Integer.parseInt(token.nextToken()), null, false);
                    newNode=newNode.step;
                }while(token.hasMoreTokens());
               // System.out.println(newNode.info);  //debugging
              
                graph[counter]=front;
            }
            textdata.close();
           // Node k=graph[0];       
           // System.out.println(k.info);  //debugging
        } 
        catch(IOException e){
          System.out.println("File I/O error!");
        }
        return graph;
    }
  }  
class Map{
    public Node[] graph;
  
     public void Breadth(Node a){
       Queue myQueue = new Queue();
       States stateObject= new States();
       
       if(a.traverse==true){
         a=a.step;
         Breadth(a);
       }
       else{ 
         stateObject.printStates(a.info);
         a.traverse=true;
         myQueue.enqueue(a.info);
      
         int counter= myQueue.N;
         a.lv=0;
         counter++;
      
         do{
            int oldData=(Integer)myQueue.dequeue();
            //System.println(oldData); //debugging
            Node myNode=this.graph[oldData-1];
            int increase=myNode.lv;
            //System.println(increase); //debugging
            //myNode=myNode.step;
           
            do{
              counter++;
              int next=myNode.info;
              //System.out.println(next);//debugging
              Node nextNode=this.graph[next-1];
              //System.out.println(nextNode.info); //debugging
              
              if(nextNode.traverse!=true){
                  nextNode.traverse=true;
                  counter++;
                  nextNode.lv=increase+1;
                  //System.out.println(nextNode.lv);//debugging
                  myQueue.enqueue(nextNode.info);
                  
                  stateObject.printStates(nextNode.info);
                  System.out.println("level " +nextNode.lv);
                  System.out.println(""); 
                }
              
               else{
               ;}
               
               myNode=myNode.step;
               
            }while(myNode.step!=null);
            
        }while(!myQueue.isEmpty());      
     }
  }
   public void Depth(Node a){
       Stack myStack=new Stack();
        
       if(a.traverse==true){
        a=a.step;
        Depth(a);
        }
       else{ 
        States stateObject= new States();
        stateObject.printStates(a.info);
        a.traverse= true;
        
        for(Node node1=a; node1!=null; node1=node1.step){
      //   System.out.println(node.data); //debugging
        }
        for(Node node=a; node!=null; node=node.step){
          if(a.step!=null){
             int next=a.step.info;
             Node b=this.graph[next-1];
                
                //System.out.println(q.data);
                if(b.traverse!=true){
                  Depth(b);
                }
                else{
                ;}
             a=a.step;
            }
          else{
            ;}
        }
       } 
     }
   public Map(Node[] graph){
        this.graph = graph;
   }
}
class States{
    public void printStates(int p){
      switch(p){
            case 1: 
                System.out.println("Washington, ");
                break;
            case 2: 
                System.out.println("Oregon, ");
                break;
            case 3: 
                System.out.println("California, ");
                break;
            case 4: 
                System.out.println("Nevada, ");
                break;
            case 5: 
                System.out.println("Idaho, ");
                break;
            case 6: 
                System.out.println("Montana, ");
                break;
            case 7: 
                System.out.println("Utah, ");
                break;
            case 8: 
                System.out.println("Arizona, ");
                break;
            case 9: 
                System.out.println("Wyoming, ");
                break;
            case 10: 
                System.out.println("Colorado, ");
                break;
            case 11: 
                System.out.println("New Mexico, ");
                break;
            case 12: 
                System.out.println("Texas, ");
                break;
            case 13: 
                System.out.println("Oklahoma, ");
                break;
            case 14: 
                System.out.println("Kansas, ");
                break;
            case 15: 
                System.out.println("Nebraska, ");
                break;
            case 16: 
                System.out.println("South Dakota, ");
                break;
            case 17: 
                System.out.println("North Dakota, ");
                break;
            case 18: 
                System.out.println("Minnesota, ");
                break;
            case 19: 
                System.out.println("Iowa, ");
                break;
            case 20: 
                System.out.println("Missouri, ");
                break;
            case 21: 
                System.out.println("Arkansas, ");
                break;
            case 22: 
                System.out.println("Louisiana, ");
                break;
            case 23: 
                System.out.println("Mississippi, ");
                break;
            case 24: 
                System.out.println("Alabama, ");
                break;
            case 25: 
                System.out.println("Tennessee, ");
                break;
            case 26: 
                System.out.println("Kentucky, ");
                break;
            case 27: 
                System.out.println("Indiana, ");
                break;
            case 28: 
                System.out.println("Illinois, ");
                break;
            case 29: 
                System.out.println("Wisconsin, ");
                break;
            case 30: 
                System.out.println("Michigan, ");
                break;
            case 31: 
                System.out.println("Ohio, ");
                break;
            case 32: 
                System.out.println("West Virginia, ");
                break;
            case 33: 
                System.out.println("Pennsylvania, ");
                break;
            case 34: 
                System.out.println("New York, ");
                break;
            case 35: 
                System.out.println("Vermont, ");
                break;
            case 36: 
                System.out.println("New Hampshire, ");
                break;
            case 37: 
                System.out.println("Maine, ");
                break;
            case 38: 
                System.out.println("Massachusetts, ");
                break;
            case 39: 
                System.out.println("Rhode Island, ");
                break;
            case 40: 
                System.out.println("Connecticut, ");
                break;
            case 41: 
                System.out.println("New Jersey, ");
                break;
            case 42: 
                System.out.println("Delaware, ");
                break;
            case 43: 
                System.out.println("Maryland, ");
                break;
            case 44: 
                System.out.println("Virginia, ");
                break;
            case 45: 
                System.out.println("North Carolina, ");
                break;
            case 46: 
                System.out.println("South Carolina, ");
                break;
            case 47: 
                System.out.println("Georgia, ");
                break;
            case 48: 
                System.out.println("Florida, ");
                break;
      }}}
class Queue{
  public int N;  
  public Node first;
  public Node last;
  public Queue(){
     first = null;
     last  = null;
      N=0;
    }
    public void enqueue(Object object){
        Node oldNode = last;
        last = new Node();
        last.info= (Integer)object;
        last.step = null;
        if (isEmpty()) first = last;
        else oldNode.step= last;
    } 
    public Object dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Object data = first.info;
        first = first.step;
        if (isEmpty()) last = null;
        return data;      
    }
     public Object peek(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.info;
    }
    public boolean isEmpty(){
        return first == null;
    }
}    
class Node{
    int info;
    Node step;
    boolean traverse;
    Integer lv;
    
    public Node(){
        info=0;
        step=null;
        traverse=false;
        lv=null;
    }
     public Node(int a, Node node, boolean b){  
        info=a;
        step=node;
        traverse=b;
        lv=null;
    }
    public Node(int a, Node node, boolean b, Integer c){  
        info=a;
        step=node;
        traverse=b;
        lv=c;
    }
}
class Stack{
    public Node top;
    public void push(Node object){
        top = new Node(object.info, top, true);
    }
    public Node pop(){
        Node oldNode = top;
        Node object = peek();
        top = top.step;
        oldNode.step= null;
        return object;
    }
    public Node peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return top;
    }
    public boolean isEmpty(){
        return top == null;
    }
}