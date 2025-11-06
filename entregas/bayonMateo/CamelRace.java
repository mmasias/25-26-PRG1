
import java.util.Scanner;

public class CamelRace {

    public static void main(String[] args) {

        System.out.println("> Camel Race (Developed by Mateo Bayón)");

        final String TRACK_UPDOWN = "---+-----------+---------+---------+---------+---------+-----------+";
        final String TRACK_UP2 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String TRACK_UP3 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";

        final String STABLE = ("[J]|");
        String position = ("");
        final String CAMEL = (";--;'");

        boolean winner = false;

        int positionNumber = 0;
        int camelIn = 0;
        int camelAdvance = 0;
        int turn = 1;

        do {
            System.out.println(TRACK_UPDOWN);
            System.out.println(TRACK_UP2);
            System.out.println(TRACK_UP3);

            System.out.print(STABLE);

            for (int limit = 0; limit <= positionNumber; limit++) {
                System.out.print(" ");
            }

            System.out.println(CAMEL);

            System.out.println(TRACK_UPDOWN);

            double chance = Math.random();

            System.out.println("Turn: " + turn + " - Advenced: " + camelAdvance + " - Position: " + positionNumber);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Pick a hole: ");
            int hole = scanner.nextInt();
            System.out.println("");

            if (hole == 1) {
                if (chance < 0.6) {
                    positionNumber = positionNumber + 1;
                    camelAdvance = 1;
                } else {
                    positionNumber = positionNumber + 0;
                }
            } else if (hole == 2) {
                if (chance < 0.4) {
                    positionNumber = positionNumber + 2;
                    camelAdvance = 2;
                } else {
                    positionNumber = positionNumber + 0;
                    camelAdvance = 0;
                }
            } else if (hole == 3) {
                if (chance < 0.3) {
                    positionNumber = positionNumber + 4;
                    camelAdvance = 4;
                } else {
                    positionNumber = positionNumber + 0;
                    camelAdvance = 0;
                }
            } else if (hole == 4) {
                if (chance < 0.1) {
                    positionNumber = positionNumber + 6;
                    camelAdvance = 6;
                } else {
                    positionNumber = positionNumber + 0;
                    camelAdvance = 0;
                }
            }

            turn = turn + 1;
            if (positionNumber >= 60) {
                winner = true;
            }
        } while (winner == false);
        System.out.println("You win!");
    }
}
