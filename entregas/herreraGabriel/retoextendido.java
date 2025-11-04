import java.util.Random;

public class HotelSimulacionAvanzada {
    public static void main(String[] args) {
        final int NUMERO_DE_PLANTAS = 7;
        final int NUMERO_DE_HABITACIONES = 6;
        final int HORAS_POR_DIA = 24;
        final int DIAS_SEMANA = 7;

        final double PROBABILIDAD_PERSIANA_ABIERTA = 0.7;
        final double PROBABILIDAD_LUZ_ENCENDIDA = 0.6;
        final double PROBABILIDAD_RAYO = 0.2;
        final double PROBABILIDAD_MANTENIMIENTO = 0.05;

        final String VENTANA_CERRADA = "[ ]";
        final String LUZ_APAGADA = "[º]";
        final String LUZ_ENCENDIDA = "[*]";
        final String COLUMNA_AVERIADA = "[X]";
        final String PLANTA_MANTENIMIENTO = "[#]";
        final String PLANTA_VACIA = "[    ]";

        Random generador = new Random();
        int[] consumoPorDia = new int[DIAS_SEMANA];

        for (int dia = 1; dia <= DIAS_SEMANA; dia++) {
            boolean[][] persianasAbiertas = new boolean[NUMERO_DE_PLANTAS][NUMERO_DE_HABITACIONES];
            boolean[][] lucesEncendidas = new boolean[NUMERO_DE_PLANTAS][NUMERO_DE_HABITACIONES];
            boolean[] columnasAveriadas = new boolean[NUMERO_DE_HABITACIONES];
            boolean[] plantasEnMantenimiento = new boolean[NUMERO_DE_PLANTAS];

            if (generador.nextDouble() < PROBABILIDAD_RAYO) {
                int columnaRayo = generador.nextInt(NUMERO_DE_HABITACIONES);
                columnasAveriadas[columnaRayo] = true;
            }

            if (generador.nextDouble() < PROBABILIDAD_MANTENIMIENTO) {
                int plantaMantenimiento = generador.nextInt(NUMERO_DE_PLANTAS);
                plantasEnMantenimiento[plantaMantenimiento] = true;
            }

            int consumoTotalDia = 0;

            for (int hora = 0; hora < HORAS_POR_DIA; hora++) {
                int consumoHora = 0;

                for (int planta = 0; planta < NUMERO_DE_PLANTAS; planta++) {
                    for (int habitacion = 0; habitacion < NUMERO_DE_HABITACIONES; habitacion++) {
                        persianasAbiertas[planta][habitacion] = generador.nextDouble() < PROBABILIDAD_PERSIANA_ABIERTA;
                        lucesEncendidas[planta][habitacion] = generador.nextDouble() < PROBABILIDAD_LUZ_ENCENDIDA;

                        if (lucesEncendidas[planta][habitacion] && !columnasAveriadas[habitacion] && !plantasEnMantenimiento[planta]) {
                            consumoHora++;
                        }
                    }
                }

                consumoTotalDia += consumoHora;

                System.out.println("Dia " + dia + " - " + hora + ":00h Consumo hora: " + consumoHora);
            }

            consumoPorDia[dia - 1] = consumoTotalDia;
        }

        System.out.print("CONSUMOS: ");
        int suma = 0;
        for (int i = 0; i < DIAS_SEMANA; i++) {
            System.out.print("D" + (i + 1) + ": " + consumoPorDia[i] + " | ");
            suma += consumoPorDia[i];
        }
        System.out.println();
        System.out.println("Media de consumo semanal: " + (suma / DIAS_SEMANA));
    }
}
