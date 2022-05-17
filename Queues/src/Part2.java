import java.util.LinkedList;
// Name:   Shane Wild
// Class:   CS 3305/W03
// Term:   Spring 2022
// Instructor:  Betty Kretlow
// Assignment:  05-Part-2-Shoppers
//class simulating a generic queue or line
class Line{
    private LinkedList<Integer> list=new LinkedList<Integer>();
public void enqueue(int time){
    list.addLast(time);
}
public int dequeue(){
    return list.removeFirst();
}
public int getSize(){
    return list.size();
}
public int getFirst(){
    return list.getFirst();
}
}
public class Part2 {
    public static void main(String[] Args) {
        Line[] lines = new Line[5];
        for (int n = 0; n < 5; n++) {
            lines[n] = new Line();
        }
        //adds customers to begin with
        for(int i=0; i<25; i++) {
            int time = (int) (Math.floor(Math.random() * 5) + 1);
            int shortestline = 999;
            int linepos = 0;
            for (int x = 0; x <= 4; x++) {
                if (lines[x].getSize() < shortestline) {
                    shortestline = lines[x].getSize();
                    linepos = x;
                }
            }
            lines[linepos].enqueue(time);
            System.out.println("A customer has entered line " + linepos + " with " + time + " items");
        }
        int Line5Time = lines[4].getFirst();
        int Line4Time = lines[3].getFirst();
        int Line3Time = lines[2].getFirst();
        int Line2Time = lines[1].getFirst();
        int Line1Time = lines[0].getFirst();
        //loop for simulation time
        for (int n = 0; n < 10; n++) {
            //add customer at random with random amount of time to checkout
            if(Math.floor(Math.random() * 10) + 1<=3) {
                int time = (int) (Math.floor(Math.random() * 5) + 1);
                int shortestline = 999;
                int linepos = 0;
                for (int i = 0; i <= 4; i++) {
                    if (lines[i].getSize() < shortestline) {
                        shortestline = lines[i].getSize();
                        linepos = i;
                    }
                }
                lines[linepos].enqueue(time);
                System.out.println("A customer has entered line "+linepos+" with "+time+" items");
            }
            //for each line subtract the time from the customer in front, if the timer hits 0 the customer leaves.
                System.out.println("Line 1 has a time of "+Line1Time);
                Line1Time--;
                if (Line1Time <= 0) {
                    lines[0].dequeue();
                    System.out.println("A customer at line 1 has left");
                    Line1Time=lines[0].getFirst();
                }

                System.out.println("Line 2 has a time of "+Line2Time);
                Line2Time--;
                if (Line2Time <= 0) {
                    lines[1].dequeue();
                    System.out.println("A customer at line 2 has left");
                    Line2Time=lines[1].getFirst();
                }

                System.out.println("Line 3 has a time of "+Line3Time);
                Line3Time--;
                if (Line3Time <= 0) {
                    lines[2].dequeue();
                    System.out.println("A customer at line 3 has left");
                    Line3Time=lines[2].getFirst();
                }

                System.out.println("Line 4 has a time of "+Line4Time);
                Line4Time--;
                if (Line4Time <= 0) {
                    lines[3].dequeue();
                    System.out.println("A customer at line 4 has left");
                    Line4Time=lines[3].getFirst();
                }
                System.out.println("Line 5 has a time of "+Line5Time);
                Line5Time--;

                if (Line5Time <= 0) {
                    lines[4].dequeue();
                    System.out.println("A customer at line 5 has left");
                    Line5Time=lines[4].getFirst();
                }
        }
    }
}