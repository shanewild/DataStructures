import java.util.LinkedList;
// Name:   Shane Wild
// Class:   CS 3305/W02
// Term:   Spring 2022
// Instructor:  Sharon Perry
// Assignment:  3 – Part 1 Iterator
public class main {
    static void printRange(int x, int y) {
        boolean print=false;
        java.util.LinkedList<Integer> list = new java.util.LinkedList();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(75);
        list.add(4);
        list.add(4);
        list.add(8);
        list.add(9);
        for(Integer z: list){
            if(z.intValue()==x){
                print=true;
            }
            if (z.intValue()==y){
                print=false;
            }
            if (print){
                System.out.print(z+" ");
            }

        }
    }
    static void remove_repetitions(){
        int q=0;
        int p=0;
        java.util.LinkedList<Integer> list = new java.util.LinkedList();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(75);
        list.add(4);
        list.add(4);
        list.add(8);
        list.add(9);
        for (int i=0;i<list.size()-1; i++){
            p=list.get(i);
            q=list.get(i+1);
            if (p==q){
                list.remove(i+1);
                i--;
            }
        }
for(Integer x: list){
    System.out.print(x+" ");
        }
    }
    public static void main(String[] Args){
        int x=1;
        int y=2;
        printRange(x,y);
        System.out.println("\n");
remove_repetitions();
    }
}
