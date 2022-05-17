// Name:   Shane Wild
// Class:   CS 3305/W03
// Term:   Spring 2022
// Instructor:  Betty Kretlow
// Assignment:  04-Part-1-Stacks
class Stack<T>{
    private int[] arr;
   private int top1;
   private int top2;
   private int size;
   //constructor
   Stack(int size){
       arr=new int[size];
       this.size=size;
       top1= -1;
       top2= size;
    }
    //if array isnt full push t on top
    public void push_a(int t){
    if (top1+1<top2){
    top1++;
    arr[top1]=t;
    }
    else{
        System.out.println("Stack overflow");
        System.exit(-1);
    }
        //if array isnt full push t on bottom of array.
    }
    public void push_b(int t){
        if (top1+1!=top2){
            top2--;
            arr[top2]=t;
        }
        else{
            System.out.println("Stack overflow");
            System.exit(-1);
        }
    }
    //if array isnt empty pops top object out
    public int pop_a(){
    if(top1>=0){
        int temp= arr[top1];
        top1--;
        return temp;
    }
        return (-1);
    }
    //if array isnt empty pops bottom object out
    public int pop_b(){
if(top2<=size){
    int temp=arr[top2];
    top2++;
    return temp;
}
else{
    return (-1);
}
    }
    public boolean is_empty(){
       if(top1==-1&&top2==size){
           return true;
       }
       else{
           return false;
       }
    }
    public boolean is_full(){
       if (top1+1==top2){
           return true;
       }
       else {
           return false;
       }
    }
}
public class main {
    public static void main(String[] Args){
Stack stack=new Stack(10);
stack.push_a(1);
stack.push_a(2);
stack.push_a(3);
stack.push_b(4);
stack.push_b(5);
stack.push_b(6);
System.out.println(stack.pop_a());
System.out.println(stack.pop_a());
System.out.println(stack.pop_a());
System.out.println(stack.pop_b());
System.out.println(stack.pop_b());
System.out.println(stack.pop_b());
    }
}
