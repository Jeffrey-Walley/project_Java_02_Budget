//  project 02 Budget  from Youtube:  https://www.youtube.com/watch?v=uZDuvMo-4pU&list=PLtQo0sxRN7JKKla3_GAF05dySjyy3nINa&index=2
        /*
            1. enter budget
            2. enter proportion of each expense
            3. ignore further items if input exceeds 100% of budget
            4. use ArrayList to store expense portion
            5. find amount for each item
         */
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("What is your Budget: ");
        Scanner scanny = new Scanner(System.in);
        double total = scanny.nextDouble();
        double sum = 0;
        int i = 0;                                                // i is expense item index
        ArrayList<Double> proportion = new ArrayList<Double>();
        System.out.println("Enter your proportion of various expenses: ");
        System.out.println("(this program will stop when the proportion exceeds 100%");

        do {
            System.out.println("Your proportion of expense " + (i + 1) + ":");
            double value = scanny.nextDouble();
            proportion.add(value);
            sum += proportion.get(i);
            i++;
        } while (sum <= 100);
        scanny.close();
        if (sum > 100) {
            double cumulativeSum = 0.0;
            for (int x = 0; x <proportion.size() - 1;
            x++){
                cumulativeSum += proportion.get(x);
            }
            proportion.set(proportion.size() -1, 100.0 - cumulativeSum);
        }
        for (double value : proportion) {
            double expense = value * total / 100.0;
            System.out.println("Your " + value + "% equals $ " + expense);
        }
    }
}