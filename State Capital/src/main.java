import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String[] Args) {
        String[][] StateCapitals = {{"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Maryland", "Annapolis"},
                {"Minnesota", "Saint Paul"},
                {"Iowa", "Des Moines"},
                {"Maine", "Augusta"},
                {"Kentucky", "Frankfort"},
                {"Indiana", "Indianapolis"},
                {"Kansas", "Topeka"},
                {"Louisiana", "Baton Rouge"},
                {"Oregon", "Salem"},
                {"Oklahoma", "Oklahoma City"},
                {"Ohio", "Columbus"},
                {"North Dakota", "Bismark"},
                {"New York", "Albany"},
                {"New Mexico", "Santa Fe"},
                {"New Jersey", "Trenton"},
                {"New Hampshire", "Concord"},
                {"Nevada", "Carson City"},
                {"Nebraska", "Lincoln"},
                {"Montana", "Helena"},
                {"Missouri", "Jefferson City"},
                {"Mississippi", "Jackson"},
                {"Massachusettes", "Boston"},
                {"Michigan", "Lansing"},
                {"Pennslyvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}};
        Random rand = new Random();
        int score=0;
        String answer;
        Scanner scan=new Scanner(System.in);
        for (int i =1; i<=5;i++){

            int n = rand.nextInt(50);
            System.out.println("Question "+i+": What is the capital of "+StateCapitals[n][0]);
            answer=scan.nextLine();
            if (answer.toLowerCase().equals(StateCapitals[n][1].toLowerCase())){
                score++;
                System.out.println("Correct! Your score is "+score);
            }
            else{
                System.out.println("Incorrect, the answer was "+StateCapitals[n][1]);
            }
        }

        System.out.println("You finished the game with a score of "+score);
    }
}

