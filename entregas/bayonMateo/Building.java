
public class Building {

    public static void main(String[] args) {

        final String ROOF_BUILDING1 = "               __/\\__              ";
        final String ROOF_BUILDING2 = "  |    |    |  |####|  |    |    |  ";
        final String ROOF_BUILDING3 = "====================================";

        final String BASE_BUILDING1 = "     ==========================     ";
        final String BASE_BUILDING2 = "   ==============================   ";
        final String BASE_BUILDING3 = " ================================== ";

        final String separator = " _ __ ";

        System.out.println("> Building (Developed by Mateo Bayón)");
        System.out.println();

        for (int day = 0; day <= 6; day = day + 1) {
            for (int hour = 0; hour <= 23; hour = hour + 1) {
                System.out.println(ROOF_BUILDING1);
                System.out.println(ROOF_BUILDING2);
                System.out.println(ROOF_BUILDING3);
                for (int height = 0; height <= 6; height = height + 1) {
                    for (int width = 0; width <= 5; width = width + 1) {
                        System.out.print(":");

                        double chanceClosed = Math.random();
                        double chanceLight = Math.random();

                        int realHeight = 7 - height;

                        if (width == 3) {
                            System.out.print("[    ]:");
                        }

                        if (chanceClosed < 0.70) {
                            if (width == 2) {
                                System.out.print("[ ]");
                            } else if (width == 5) {
                                System.out.print("[ ]:" + separator + "P" + realHeight);
                            } else {
                                System.out.print("[ ]:");
                            }
                        } else {
                            if (chanceLight < 0.60) {
                                if (width == 2) {
                                    System.out.print("[*]");
                                } else if (width == 5) {
                                    System.out.print("[*]:" + separator + "P" + realHeight);
                                } else {
                                    System.out.print("[*]:");
                                }
                            } else {
                                if (width == 2) {
                                    System.out.print("[º]");
                                } else if (width == 5) {
                                    System.out.print("[º]:" + separator + "P" + realHeight);
                                } else {
                                    System.out.print("[º]:");
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                System.out.println(BASE_BUILDING1);
                System.out.println(BASE_BUILDING2);
                System.out.println(BASE_BUILDING3);

                System.out.println();
                System.err.println("Day " + day + " " + hour + ":00 h");
            }
        }
    }
}
