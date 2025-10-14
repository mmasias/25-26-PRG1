import java.util.Scanner;

class finalPriceCalculator {
    public static void main(String[] args) {

        // Price for a singular item
        Scanner questionPrice = new Scanner(System.in);
        System.out.println("Enter the base price for the item (in cents): ");
        int ammountPrice = questionPrice.nextInt();

        // Ammount of items being purchased
        Scanner questionItems = new Scanner(System.in);
        System.out.println("Enter the ammount of items being purchased: ");
        int ammountItems = questionItems.nextInt();

        // Ammount IVA applied
        Scanner questionIVA = new Scanner(System.in);
        System.out.println("Enter the type of IVA applied (21, 10 or 4): ");
        int ivaType = questionIVA.nextInt();
        
        double ivaTypeApplied = (ivaType == 21) ? 0.21 : (ivaType == 10) ? 0.10 : (ivaType == 4) ? 0.04 : 1;
        String ivaTypeAppliedString = (ivaType == 21) ? "21%" : (ivaType == 10) ? "10%" : (ivaType == 4) ? "4%" : "0%";

        //Ammount of discount applied
        double discountType = (ammountItems >= 100) ? 0.15 : (ammountItems >= 50) ? 0.10 : (ammountItems >= 10) ? 0.05 : 1;
        String discountTypeString = (discountType == 0.15) ? "15%" : (discountType == 0.10) ? "10%" : (discountType == 0.05) ? "5%" : "0%";

        // Calculate final prices
        double BasePrice = ammountPrice / 100;
        double finalBasePrice = (ammountPrice + (ammountPrice * ivaTypeApplied) - (ammountPrice * discountType)) / 100;
        double finalTotalPrice = finalBasePrice * (ammountItems / 1);

        // Display everything
        System.out.println("The base price is: $" + BasePrice);
        System.out.println("The IVA applied is: $" + ivaTypeAppliedString);
        System.out.println("The discount applied is: " + discountTypeString);
        System.out.println("The final price for one unit is: " + finalBasePrice);
        System.out.println("The total price is: $" + finalTotalPrice);
        }
    }