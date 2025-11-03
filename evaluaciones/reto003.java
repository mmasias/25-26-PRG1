import java.util.Random;

public class reto003{
static final int PISOS = 8;
    static final int HABITACIONES_POR_PISO = 8;
    static final double PROB_PERSIANA_ABIERTA = 0.7;
    static final double PROB_LUZ_ENCENDIDA = 0.6;

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("Simulación del hotel (una hora):\n");

        for (int piso = PISOS - 1; piso >= 1; piso--) {
            System.out.print("Piso " + piso + ": ");
            for (int hab = 0; hab < HABITACIONES_POR_PISO; hab++) {
                if (hab == 3) {
                    System.out.print(" [E] "); // Ascensor en la posición 4
                    continue;
                }

                boolean persianaAbierta = rand.nextDouble() < PROB_PERSIANA_ABIERTA;
                boolean luzEncendida = rand.nextDouble() < PROB_LUZ_ENCENDIDA;

                if (persianaAbierta) {
                    System.out.print(luzEncendida ? " [º] " : " [·] ");
                } else {
                    System.out.print(" [x] ");
                }
            }
            System.out.println();
        }

        System.out.println("\nPlanta baja: Áreas comunes");
    }
}

