import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        String name;
        int numInGroup;
        String country;
        int percentage;
        String item;
        double cost;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Tip Diner!");
        System.out.println("What is your name? ");
        name = scan.nextLine();
        System.out.println("Hello, " + name);
        System.out.println("How many people are in your group? ");
        numInGroup = scan.nextInt();
        scan.nextLine();
        System.out.println("What country are you in? ");
        country = scan.nextLine().toLowerCase();
        System.out.println("What is the tip percentage? (If tipping not required put 0) ");
        percentage = scan.nextInt();
        scan.nextLine();

        TipCalculator bill1 = new TipCalculator(numInGroup, percentage, country);

        boolean run = true;
        while (run) {
            while (run) {
                System.out.println("Enter your item (-1 to stop, -1 will not be recorded) ");
                item = scan.nextLine();
                if (!item.equals("-1")) {
                    System.out.println("Enter cost of item ");
                    cost = scan.nextDouble();
                    scan.nextLine();
                    bill1.addMeal(item, cost);
                }
                if (item.equals("-1")) {
                    run = false;
                }
            }
        }
        System.out.println(bill1.printReceipt());
    }
}
