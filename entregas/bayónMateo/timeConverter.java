import java.util.Scanner;

class timeConverter {
    public static void main(String[] args) {

        // Time that will be converted (in seconds)
        Scanner questionTime = new Scanner(System.in);
        System.out.println("Enter the amount of time (in seconds): ");
        int amountTime = questionTime.nextInt();

        // Calculate time conversion
        int days = amountTime >= 86400 ? amountTime / 86400 : 0;
        String daysPlural = days > 1 ? "days" : "day";
        amountTime = amountTime - (days * 86400);

        int hours = amountTime >= 3600 ? amountTime / 3600 : 0;
        String hoursPlural = hours > 1 ? "hours" : "hour";
        amountTime = amountTime - (hours * 3600);

        int minutes = amountTime >= 60 ? amountTime / 60 : 0;
        String minutesPlural = minutes > 1 ? "minutes" : "minute";
        amountTime = amountTime - (minutes * 60);

        int seconds = amountTime;
        String secondsPlural = seconds > 1 ? "seconds" : "second";

        // Print time conversion
        System.out.println("The time conversion is: " 
                + days + " " + daysPlural + ", " 
                + hours + " " + hoursPlural + ", " 
                + minutes + " " + minutesPlural + ", and " 
                + seconds + " " + secondsPlural + ".");
    }
}