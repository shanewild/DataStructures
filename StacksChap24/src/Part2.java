import java.util.Scanner;
import java.util.Stack;
public class Part2 {
    // Name:   Shane Wild
// Class:   CS 3305/W03
// Term:   Spring 2022
// Instructor:  Betty Kretlow
// Assignment:  04-Part-2-Palindromes
    public static void main(String[] Args) {
        //variables
        String input = "";
        Stack<Character> stack = new Stack<>();
        char[] inputarray;
        //take string convert it to an array of chars
        System.out.println("Enter a String!");
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        inputarray = input.toCharArray();
        //put array into stack
        for (char i : inputarray) {
            stack.push(i);
        }
        //take chars out of stack compare to input
        String x = "";
        while (!stack.isEmpty()) {
            x += stack.peek();
            stack.pop();
        }
        if (x.toLowerCase().equals(input.toLowerCase())) {
            System.out.println("This is a palindrome");
        } else {
            System.out.println("This is not a palindrome");
        }
    }
}