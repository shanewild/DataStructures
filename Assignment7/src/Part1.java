// Name:   Shane Wild
// Class:   CS 3305/W03
// Term:   Spring 22
// Instructor:  Betty Kretlow
// Assignment:  7-Part-1-Sorting
import java.io.File;
import java.util.Scanner;
public class Part1 {
    static class Node {
        int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    static class Linked_List {
        //Prints list
        public static void printList(Node head){
            Node i = head;
            while (i != null){
                System.out.print(i.data + " ");
                i = i.next;
            }
            System.out.println("");
        }
        //merge 2 lists
        public static Node SortedMerge(Node lst1, Node lst2){
            //Base
            if (lst1 == null) {
                return lst2;
            }
            else if (lst2 == null) {
                return lst1;
            }
            Node result;
            if (lst1.data <= lst2.data) {
                result = lst1;
                result.next = SortedMerge(lst1.next, lst2);
            }
            else {
                result = lst2;
                result.next = SortedMerge(lst1, lst2.next);
            }

            return result;
        }

        //split into two halves
        public static Node[] FrontBackSplit(Node x) {
            // base case
            if (x==null||x.next==null) {
                return new Node[]{x,null} ;
            }

            Node backward=x;
            Node forward=x.next;
            while (forward!= null) {
                forward= forward.next;
                if (forward!=null) {
                    backward = backward.next;
                    forward = forward.next;
                }
            }
            // split
            Node[] arr = new Node[]{ x, backward.next };
            backward.next = null;
            return arr;
        }

        // Sort
        public static Node MergeSort(Node head) {
            // Base case
            if (head == null || head.next == null) {
                return head;
            }

            Node[] arr = FrontBackSplit(head);
            Node first_half = arr[0];
            Node second_half = arr[1];


            first_half = MergeSort(first_half);
            second_half = MergeSort(second_half);

            // merge both sorted into 1
            return SortedMerge(first_half, second_half);

        }
        
        public static void main(String[] arguments) {
            try{
                Scanner scanner = new Scanner(new File("C:\\Users\\Shane\\OneDrive - Kennesaw State University\\Spring 2022\\Temp\\mergetest.txt"));
                int [] arr = new int [20];
                int i = 0;
                while(scanner.hasNextInt()){
                    arr[i++] = scanner.nextInt();
                }
                scanner.close();
                Node head = null;
                for (int k=0; k < arr.length; k++) {
                    head = new Node (arr[k], head);
                }
                printList(head);
                head = MergeSort(head);
                printList(head);
            }catch (Exception e){
        return;
            }


        }
    }
}