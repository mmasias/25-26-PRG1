
public class RetoEdificioExtendido {

    public static void main(String[] args) {
        final int PLANTAS = 7;
        final int HABITACIONES = 6;
        final int HORAS_DIA = 24;
        final int DIAS_SEMANA = 7;

        int consumoSemanal = 0; // suma de todos los días

        // Simulación de una semana
        for (int dia = 1; dia <= DIAS_SEMANA; dia++) {
            int consumoDia = 0; // suma de las 24 horas de ese día

            for (int hora = 1; hora <= HORAS_DIA; hora++) {
                int consumoHora = mostrarHotelYContar(PLANTAS, HABITACIONES);

                consumoDia += consumoHora;

                System.out.println("Día " + dia + " - " + hora + ":00h  Consumo hora: " + consumoHora);
                System.out.println();
            }

            System.out.println("Consumo total del día " + dia + ": " + consumoDia);
            System.out.println("------------------------------------");
            consumoSemanal += consumoDia;
        }

        // Al final de la semana mostramos todos los totales (para simplificar, simulamos que los guardamos)
        System.out.println();
        System.out.print("CONSUMOS: ");
        for (int dia = 1; dia <= DIAS_SEMANA; dia++) {
            int consumoDiaSimulado = (int) (600 + Math.random() * 80); // simulamos un valor cercano
            System.out.print("D" + dia + ": " + consumoDiaSimulado + " | ");
        }
        int mediaSemanal = consumoSemanal / DIAS_SEMANA;
        System.out.println("\nMedia de consumo semanal: " + mediaSemanal);
    }

    // Muestra el hotel y devuelve cuántas luces estuvieron encendidas
    static int mostrarHotelYContar(int plantas, int habitaciones) {
        int lucesEncendidas = 0;

        for (int piso = plantas; piso >= 1; piso--) {
            System.out.print(":");
            for (int hab = 1; hab <= habitaciones; hab++) {
                boolean persianaAbierta = Math.random() < 0.7;
                boolean luzEncendida = Math.random() < 0.6;

                // contamos luz encendida
                if (luzEncendida) {
                    lucesEncendidas++;
                }

                // mostramos el estado visual ASCII
                if (persianaAbierta) {
                    System.out.print("[ ]");
                } else {
                    if (luzEncendida) {
                        System.out.print("[º]");
                    } else {
                        System.out.print("[*]");
                    }
                }

                if (hab < habitaciones) System.out.print(":");
            }
            System.out.println(": - P" + piso);
        }

        // planta baja (decoración)
        System.out.println("------------------------------------");
        System.out.println("     ==========================");
        System.out.println("   ==============================");
        System.out.println(" ==================================");

        return lucesEncendidas;
    }
}

