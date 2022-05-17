// Name:   Shane Wild
// Class:   CS 3305/W03
// Term:   Spring 2022
// Instructor:  Betty Kretlow
// Assignment:  2 Recursion
import java.util.Scanner;
public class C18Recursion {
    public static String recursionDemo(int callnum, String whitespace, int n){
        String note="";
        if (callnum>=n){ //base
            return note;
        }
        else{
            callnum++;
            if(callnum!=1) {
                whitespace += "\t";
            }
            note+=whitespace+"This line was written by call number "+callnum+".\n"+ recursionDemo(callnum, whitespace, n);
            note+=whitespace+"This line was ALSO written by call number "+callnum+".\n";

        }
        return note;
    }
    public static double sumover(int n){
        if (n<=0){ //base
            return 0;
        }
        else{
            return(double)1/n+sumover(n-1);
        }

    }
       public static void main(String[] Args){
        Scanner scan=new Scanner(System.in);
           System.out.println("Pick a number!");
           int response=scan.nextInt();

        System.out.println(recursionDemo(0,"", response));
        System.out.println(sumover(response));
    }
}