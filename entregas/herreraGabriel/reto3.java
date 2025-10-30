import java.util.Random;

public class reto3 {
    public static void main(String[] args) {
        final int NUMERO_DE_PLANTAS = 7;
        final int NUMERO_DE_HABITACIONES = 6;
        final double PROBABILIDAD_PERSIANA_ABIERTA = 0.7;
        final double PROBABILIDAD_LUZ_ENCENDIDA = 0.6;
        final String VENTANA_CERRADA = "[ ]";
        final String LUZ_APAGADA = "[º]";
        final String LUZ_ENCENDIDA = "[*]";

        boolean[][] persianasAbiertas = new boolean[NUMERO_DE_PLANTAS][NUMERO_DE_HABITACIONES];
        boolean[][] lucesEncendidas = new boolean[NUMERO_DE_PLANTAS][NUMERO_DE_HABITACIONES];

        Random random = new Random();

        for (int planta = 0; planta < NUMERO_DE_PLANTAS; planta++) {
            for (int habitacion = 0; habitacion < NUMERO_DE_HABITACIONES; habitacion++) {
                persianasAbiertas[planta][habitacion] = random.nextDouble() < PROBABILIDAD_PERSIANA_ABIERTA;
                lucesEncendidas[planta][habitacion] = random.nextDouble() < PROBABILIDAD_LUZ_ENCENDIDA;
            }
        }

        System.out.println("               __/\\__");
        for (int planta = NUMERO_DE_PLANTAS - 1; planta >= 0; planta--) {
            String piso = "";
            for (int habitacion = 0; habitacion < NUMERO_DE_HABITACIONES; habitacion++) {
                piso += persianasAbiertas[planta][habitacion] ? LUZ_ENCENDIDA
                        : (lucesEncendidas[planta][habitacion] ? LUZ_ENCENDIDA : LUZ_APAGADA);
                if (habitacion < NUMERO_DE_HABITACIONES - 1) {
                    piso += "::";
                }
            }
            System.out.println(piso + " - Planta " + (planta + 1));
        }
        System.out.println("------------------------------------");
        System.out.println("     ==========================");
        System.out.println("   ==============================");
        System.out.println(" ==================================");
    }
}
