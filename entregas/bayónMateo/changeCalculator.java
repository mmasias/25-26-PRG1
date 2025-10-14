import java.util.Scanner;

public class changeCalculator {
    public static void main(String[] args) {

        // Amount of money needed
        Scanner questionNeeded = new Scanner(System.in);
        System.out.println("Enter the amount of money needed: ");
        int amountNeeded = questionNeeded.nextInt();

        // Amount of money spent
        Scanner questionSpent = new Scanner(System.in);
        System.out.println("Enter the amount of money spent: ");
        int amountSpent = questionSpent.nextInt();

        // Calculate change
        int change = amountSpent - amountNeeded;
        System.out.println("The change is: $" + change);

        // Change distribution
        int twoHundredBills = change > 200 ? change / 200 : 0;
        change = change - (twoHundredBills * 200);

        int oneHundredBills = change > 100 ? change / 100 : 0;
        change = change - (oneHundredBills * 100);

        int fiftyBills = change > 50 ? change / 50 : 0;
        change = change - (fiftyBills * 50);

        int twentyBills = change > 20 ? change / 20 : 0;
        change = change - (twentyBills * 20);

        int tenBills = change > 10 ? change / 10 : 0;
        change = change - (tenBills * 10);

        int fiveBills = change > 5 ? change / 5 : 0;
        change = change - (fiveBills * 5);

        int twoCoins = change > 2 ? change / 2 : 0;
        change = change - (twoCoins * 2);

        int oneCoins = change > 1 ? change / 1 : 0;

        System.out.print("Your change will be distributed as: " 
                + "[" + twoHundredBills + "]" + " $200 bills, " 
                + "[" + oneHundredBills + "]" + " $100 bills, " 
                + "[" + fiftyBills + "]" + " $50 bills, " 
                + "[" + twentyBills + "]" + " $20 bills, " 
                + "[" + tenBills + "]" + " $10 bills, " 
                + "[" + fiveBills + "]" + " $5 bills,"
                + "[" + twoCoins + "]" + "$2 coins and "
                + "[" + oneCoins + "]" + "$1 coins. Thank you for shopping!");
    }
}