
public class RetoEdificioBase {

    public static void main(String[] args) {
        final int PLANTAS = 7;
        final int HABITACIONES = 6;

        for (int dia = 1; dia <= 7; dia++) {
            for (int hora = 1; hora <= 24; hora++) {
                System.out.println("Día " + dia + " - " + hora + ":00h");
                mostrarHotel(PLANTAS, HABITACIONES);
                System.out.println();
            }
        }
    }

    static void mostrarHotel(int plantas, int habitaciones) {
        for (int piso = plantas; piso >= 1; piso--) {
            System.out.print(":");
            for (int hab = 1; hab <= habitaciones; hab++) {
                System.out.print(generarVentana());
                if (hab < habitaciones) System.out.print(":");
            }
            System.out.println(": - P" + piso);
        }
        System.out.println("------------------------------------");
        System.out.println("     ==========================");
        System.out.println("   ==============================");
        System.out.println(" ==================================");
    }

    static String generarVentana() {
        double probPersianaAbierta = Math.random(); // 0–1
        double probLuzEncendida = Math.random();

        boolean persianaAbierta = probPersianaAbierta < 0.7;
        boolean luzEncendida = probLuzEncendida < 0.6;

        if (persianaAbierta) {
            return "[ ]";
        } else {
            if (luzEncendida) {
                return "[º]";
            } else {
                return "[*]";
            }
        }
    }
}
