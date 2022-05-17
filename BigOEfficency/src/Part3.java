// Name:   Shane Wild
// Class:   CS 3305/W03
// Term:   Spring 2022
// Instructor:  Betty Kretlow
// Assignment:  6-3-Big-O
public class Part3 {
    public static void main(String[] Args){
       int[] miles={0,10,20,30,40,50,60,70,80,90};
       double[] kilometers=new double[10];
       int WorstCaseEfficiency=0;
       for(int i=0; i<miles.length;i++){
           WorstCaseEfficiency++;
           kilometers[i]= miles[i] * 1.6;
           System.out.println("Miles: "+miles[i]+" Kilometers:"+ kilometers[i]);
       }
        System.out.println("Worst Case Efficiency: "+WorstCaseEfficiency);
    }
}
