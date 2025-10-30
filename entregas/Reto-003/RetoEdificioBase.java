import java.util.Random;

public class RetoEdificioBase {

    public static void main(String[] args) {
        Random random = new Random();

        final int PLANTAS = 8;
        final int HABITACIONES = 6;

        for (int dia = 1; dia <= 7; dia++) {
            for (int hora = 1; hora <= 24; hora++) {

                System.out.println("\nDía " + dia + " - " + hora + ":00h");

                for (int planta = PLANTAS - 1; planta >= 0; planta--) {

                    // Planta baja
                    if (planta == 0) {
                        System.out.println("------------------------------------");
                        System.out.println("     ==========================");
                        System.out.println("   ==============================");
                        System.out.println(" ==================================");
                        continue;
                    }

                    System.out.print(":");

                    for (int habitacion = 1; habitacion <= HABITACIONES; habitacion++) {

                        // 70% persiana abierta
                        boolean persianaAbierta = random.nextDouble() < 0.7;
                        // 60% luz encendida
                        boolean luzEncendida = random.nextDouble() < 0.6;

                        String ventana;

                        if (persianaAbierta) {
                            ventana = "[ ]";
                        } else if (luzEncendida) {
                            ventana = "[*]";
                        } else {
                            ventana = "[º]";
                        }

                        System.out.print(ventana + ":");
                    }

                    System.out.println(" - P" + planta);
                }

                try {
                    Thread.sleep(300); // Pausa para ver el cambio (opcional)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

