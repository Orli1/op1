/*
Arielle Leone
Project #5
  */

import java.lang.*;
import java.util.*;
import java.io.*;

class Driver{
  public static void main(String[] args){
    Info welObj=new Info();
    welObj.Welcome();
    Node mytree = new Node();
    
    Scanner sc = new Scanner(System.in);  
    int contin=0;
    while(!(contin== 8)){
      Info OperObj=new Info();
      OperObj.Operations();
      int select =sc.nextInt();
      int num=0;
      switch(select){
      case 1:
        do{
        System.out.print("Enter an integer to insert: ");
        Tree insObj=new Tree();
        insObj.insert(sc.nextInt()); 
        System.out.print("Press '1' to insert again or '2' to exit:");
        num =sc.nextInt();
      }while(num==1);
        break;
      case 2:
        System.out.print("Enter an integer to delete: ");
       // Tree delObj=new Tree();
        //delObj.delete(sc.nextInt()); 
        break;     
      case 3:
        System.out.println("Press '1' for Inorder.");
        System.out.println("Press '2' for Preorder.");
        System.out.println("Press '3' for Postorder.");
        int print_select =sc.nextInt();
        switch(print_select){
        case 1:  
        System.out.print("Inorder: ");
        Tree inObj=new Tree();
        inObj.Inorder();
        break;
        case 2:
        System.out.print("Preorder: ");
        Tree preObj=new Tree();
        preObj.Preorder();
        break;
        case 3:
        System.out.print("Postorder: ");
        Tree postObj=new Tree();
        postObj.Postorder();
        break;
        }
        break;
      case 4:
        System.out.println("swap");
        break;
      case 5:
        System.out.println("search");
        break;
      case 6:
        System.out.println("compare");
        break;
      case 7:
        System.out.print("The node count is: ");
        Tree countObj=new Tree();
        countObj.count();
        break;
      case 8:
        System.out.println("exit");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid entry.");
        break;
      }
      System.out.println("Please enter a new command:");
    }
 }
}
class Tree{
  public Node root;
     public Tree()
     {
         root = null;
     }
     public boolean isEmpty()
     {
         return root == null;
     }
     public void insert(int data)
     {
         root = insert(root, data);
     }
  public Node insert(Node mytree, int data){ //from powerpoint slides
    if(mytree==null){
      mytree=new Node();
      mytree.data=data;
      mytree.left=null;
      mytree.right=null;
      return mytree;
    }
    else
    {
      if(data>mytree.getdata()){
      mytree.right=insert(mytree.right, data);
      return mytree;
      }
      else
      {mytree.left=insert(mytree.left, data);
       return mytree;
      }
 }  }  
  
  public int count()
  {
    return count(root);
  }
  public int count(Node mytree) //from pp slides
  {
    if(mytree ==null){
      return 0;}
    else{
     int num_count =1;
     num_count +=count(mytree.right());
     num_count+=count(mytree.left());
     return num_count;
    }
    
  }
                      
  public void Inorder(){ //left, root, right
  Inorder(root);
  }
  public void Inorder(Node mytree) //from pp slides
  {
    if(mytree !=null){
      Inorder(mytree.left());
      System.out.print(" "+mytree.getdata());
      Inorder(mytree.right());
    } 
  }
  public void Preorder(){ //root, left, right
  Preorder(root);
  }
  public void Preorder(Node mytree) 
  {
    if(mytree !=null)
    {
      System.out.print(" "+mytree.getdata());
      Preorder(mytree.left());
      Preorder(mytree.right());
    } 
  }
  public void Postorder(){ //left, right, root
  Postorder(root);
  }
  public void Postorder(Node mytree)
  {
    if(mytree !=null)
    {
      Postorder(mytree.left());
      Postorder(mytree.right());
      System.out.print(" "+mytree.getdata());
    }
  }
}
class Node{ //from powerpoint slides
 int data; 
 Node left; 
 Node right;
 
 public Node() { };
 
 public Node(int j){
   data = j; 
   left = null; 
   right = null;
 }
 public void finddata(int x){
 data=x;
 }
 public int getdata(){
   return data;
 }
 public void findleft(Node j){
 left=j;
 }
 public void findright(Node j){
 right=j;
 }
 public Node right(){
 return right;
 }
 public Node left(){
 return left;
 }
}
class Info{
 public void Welcome(){
    System.out.println("Welcome. This program takes the input of a series of numbers and creates");
    System.out.println("a binary search tree.");
  } 
 public void Operations(){
   System.out.println("To perform an operation, please enter the corresponding number:");
   System.out.println("1. Insert");
   System.out.println("2. Delete");
   System.out.println("3. Print");
   System.out.println("4. Swap");
   System.out.println("5. Search");
   System.out.println("6. Compare");
   System.out.println("7. Count");
   System.out.println("8. Exit");
 }
}