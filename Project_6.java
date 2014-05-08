/*
Arielle Leone
Project #6
5/10/14
*/
import java.lang.*;
import java.util.*;
import java.io.*;

class Driver1{ 
   public static void main(String[] args){
     //System.out.println("Welcome. This program traverses a map of the United States, printing out each State name");
     //System.out.println("in the order it was visited using both depth and breadth traversal.");
     Map mapObject= new Map();
     mapObject.input(); 
   }
}  
class Map{
    public Node[] graph;
    public void input(){
        this.graph=new Node[48];
        BufferedReader textdata=null;
        String data;
        int counter;
        
        try{
          textdata = new BufferedReader(new FileReader("state_data.txt"));
          //System.out.println("File open successful!"); //debugging
   
            for(counter=0; counter<this.graph.length; counter++){
                data=textdata.readLine();
              // System.out.println(data); //debugging
                
                StringTokenizer token=new StringTokenizer(data);
                //System.out.println(token.nextElement());
            
                Node newNode = new Node(counter+1, null, false);
                Node front = newNode;
                
                do{
                    newNode.next = new Node(Integer.parseInt(token.nextToken()), null, false);
                    newNode = newNode.next;
                }while(token.hasMoreTokens());
               // System.out.println(newNode.data);  //debugging
              
                this.graph[counter]=front;
            }
            textdata.close();
           // Node k=this.graph[0];
            //System.out.println("lalala");
           // System.out.println(k.data); 
        } 
        catch(IOException e){
          System.out.println("File I/O error!");
        }
       //////////////////
        System.out.println("Traversal using Depth: ");
        Depth(this.graph[0]); 
    }
    public void Depth(Node p){
        switch(p.data){
            case 1: 
                System.out.println("Washington");
                break;
            case 2: 
                System.out.println("Oregon");
                break;
            case 3: 
                System.out.println("California");
                break;
            case 4: 
                System.out.println("Nevada");
                break;
            case 5: 
                System.out.println("Idaho");
                break;
            case 6: 
                System.out.println("Montana");
                break;
            case 7: 
                System.out.println("Utah");
                break;
            case 8: 
                System.out.println("Arizona");
                break;
            case 9: 
                System.out.println("Wyoming");
                break;
            case 10: 
                System.out.println("Colorado");
                break;
            case 11: 
                System.out.println("New Mexico");
                break;
            case 12: 
                System.out.println("Texas");
                break;
            case 13: 
                System.out.println("Oklahoma");
                break;
            case 14: 
                System.out.println("Kansas");
                break;
            case 15: 
                System.out.println("Nebraska");
                break;
            case 16: 
                System.out.println("South Dakota");
                break;
            case 17: 
                System.out.println("North Dakota");
                break;
            case 18: 
                System.out.println("Minnesota");
                break;
            case 19: 
                System.out.println("Iowa");
                break;
            case 20: 
                System.out.println("Missouri");
                break;
            case 21: 
                System.out.println("Arkansas");
                break;
            case 22: 
                System.out.println("Louisiana");
                break;
            case 23: 
                System.out.println("Mississippi");
                break;
            case 24: 
                System.out.println("Alabama");
                break;
            case 25: 
                System.out.println("Tennessee");
                break;
            case 26: 
                System.out.println("Kentucky");
                break;
            case 27: 
                System.out.println("Indiana");
                break;
            case 28: 
                System.out.println("Illinois");
                break;
            case 29: 
                System.out.println("Wisconsin");
                break;
            case 30: 
                System.out.println("Michigan");
                break;
            case 31: 
                System.out.println("Ohio");
                break;
            case 32: 
                System.out.println("West Virginia");
                break;
            case 33: 
                System.out.println("Pennsylvania");
                break;
            case 34: 
                System.out.println("New York");
                break;
            case 35: 
                System.out.println("Vermont");
                break;
            case 36: 
                System.out.println("New Hampshire");
                break;
            case 37: 
                System.out.println("Maine");
                break;
            case 38: 
                System.out.println("Massachusetts");
                break;
            case 39: 
                System.out.println("Rhode Island");
                break;
            case 40: 
                System.out.println("Connecticut");
                break;
            case 41: 
                System.out.println("New Jersey");
                break;
            case 42: 
                System.out.println("Delaware");
                break;
            case 43: 
                System.out.println("Maryland");
                break;
            case 44: 
                System.out.println("Virginia");
                break;
            case 45: 
                System.out.println("North Carolina");
                break;
            case 46: 
                System.out.println("South Carolina");
                break;
            case 47: 
                System.out.println("Georgia");
                break;
            case 48: 
                System.out.println("Florida");
                break;
        }
        int nodeCounter=0;
        
        if(p.traverse==true){
        p=p.next;
        Depth(p);
        }
        else{
        Node myNode = p;
        p.traverse= true;
       
        for(Node node = myNode; node != null; node = node.next){
          System.out.println(node.data); //debugging
        }
        do{
            nodeCounter++;
            myNode=myNode.next;
        }while(myNode!= null);
        
        for(int k=0; k<nodeCounter; k++){
            if(p.next != null){
                int nextNode=p.next.data;
                Node q=this.graph[nextNode-1];
                //System.out.println(q.data);
                if(q.traverse==false){
                  Depth(q);
                }
                p = p.next;
            }
            else{
              ;}
        }}
    }
}
class Node{
    int data;
    Node next;
    boolean traverse;
    
    public Node(){
        data=0;
        next=null;
        traverse=false;
    }
    public Node(int a, Node node, boolean b) {  
        data=a;
        next=node;
        traverse=b;
    }
}
class Stack {
    public Node top;
    public void push(Node item){
        top = new Node(item.data, top, true);
    }
    public Node pop(){
        Node oldNode = top;
        Node item = peek();
        top = top.next;
        oldNode.next = null;
        return item;
    }
    public Node peek(){
        if (isEmpty()) throw new NullPointerException();
        return top;
    }
    public boolean isEmpty(){
        return top == null;
    }
}
class Queue{
    public Node first;
    public Node last;
    public void enq(Object item){
        Node oldNode = last;
        last = new Node();
        last.data = (Integer) item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldNode.next = last;
    } 
    public Object dnq(){
        if (isEmpty()) throw new NullPointerException();
        Object data = first.data;
        first = first.next;
        if (isEmpty()) last = null;
        return data;      
    }
     public Object peek(){
        if (isEmpty()) throw new NullPointerException();
        return first.data;
    }
    public boolean isEmpty(){
        return first == null;
    }
}