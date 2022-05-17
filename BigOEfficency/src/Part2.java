// Name:   Shane Wild
// Class:   CS 3305/W03
// Term:   Spring 2022
// Instructor:  Betty Kretlow
// Assignment:  6-2-Big-O
import java.util.Scanner;
public class Part2 {

    public static void main(String[] Args){
        Scanner scan=new Scanner(System.in);
        int y= scan.nextInt();
        for (int x=0;x<=y;x++){
            System.out.println("Current time = "+x);
        }
        System.out.println("Worst case = "+y);

    }
}
