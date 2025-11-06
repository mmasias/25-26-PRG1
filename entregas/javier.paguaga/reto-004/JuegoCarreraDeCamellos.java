import java.util.Scanner;

public class JuegoCarreraDeCamellos {

    public static void main(String[] args) {

        final String PISTA_01 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CABECERA_PISTA = "[J]";
        final String CAMELLO = " ;--;`";
        final String ESPACIO_VACIO = " ";

        final int AGUJERO_01 = 1;
        final double AGUJERO_01_PROBABILIDAD_EXITO = 0.6;
        final int AGUJERO_02 = 2;
        final double AGUJERO_02_PROBABILIDAD_EXITO = 0.4;
        final int AGUJERO_03 = 3;
        final double AGUJERO_03_PROBABILIDAD_EXITO = 0.3;
        final int AGUJERO_04 = 4;
        final double AGUJERO_04_PROBABILIDAD_EXITO = 0.1;
        final int CASILLA_FINAL = 60;

        int cantidadDeTurnos = 0;
        int posicionCamello = 0;

        boolean juegoTerminado = false;
        boolean movimientoDeAgujero01;
        boolean movimientoDeAgujero02;
        boolean movimientoDeAgujero03;
        boolean movimientoDeAgujero04;

        System.out.println("Bienvenido a la Carrera de Camellos, elige un agujero para mover a tu camello hacia la meta en la casilla " + CASILLA_FINAL + ".");

        System.out.println(PISTA_01);
        System.out.println(PISTA_02);
        System.out.println(PISTA_03);
        System.out.println(PISTA_01);
        System.out.print(CABECERA_PISTA);
        System.out.print(CAMELLO);
        System.out.println(PISTA_01);
            while (!juegoTerminado) {
                Scanner Scanner = new Scanner(System.in);
                System.out.println("Elige un agujero (1-4): ");
                int agujeroElegido = Scanner.nextInt();
                
                movimientoDeAgujero01 = (agujeroElegido == AGUJERO_01);
                movimientoDeAgujero02 = (agujeroElegido == AGUJERO_02);
                movimientoDeAgujero03 = (agujeroElegido == AGUJERO_03);
                movimientoDeAgujero04 = (agujeroElegido == AGUJERO_04);
                
                boolean AvanceDe01;
                boolean AvanceDe02;
                boolean AvanceDe04;
                boolean AvanceDe06;
                
                if (movimientoDeAgujero01) {
                    AvanceDe01 = Math.random() < AGUJERO_01_PROBABILIDAD_EXITO;
                    if (AvanceDe01) {
                        System.out.println(PISTA_01);
                        System.out.println(PISTA_02);
                        System.out.println(PISTA_03);
                        System.out.println(PISTA_01);
                        System.out.print(CABECERA_PISTA);
                        for (int j = 0; j < posicionCamello; j++) {
                            System.out.print(ESPACIO_VACIO);
                        }
                        for (int i = 0; i < 1; i++) {
                            System.out.print(ESPACIO_VACIO);
                        }
                        System.out.println(CAMELLO);
                        System.out.println(PISTA_01);
                        posicionCamello = posicionCamello + 1;
                    } else {
                        System.out.println("has fallado la pelota y no has avanzado esta vez.");
                    }
                }else if (movimientoDeAgujero02) {
                    AvanceDe02 = Math.random() < AGUJERO_02_PROBABILIDAD_EXITO;
                    if (AvanceDe02) {
                        System.out.println(PISTA_01);
                        System.out.println(PISTA_02);
                        System.out.println(PISTA_03);
                        System.out.println(PISTA_01);
                        System.out.print(CABECERA_PISTA);
                        for (int j = 0; j < posicionCamello; j++) {
                            System.out.print(ESPACIO_VACIO);
                        }
                        for (int i = 0; i < 2; i++) {
                            System.out.print(ESPACIO_VACIO);
                        }
                        System.out.println(CAMELLO);
                        System.out.println(PISTA_01);
                        posicionCamello = posicionCamello + 2;
                    } else {
                        System.out.println("has fallado la pelota y no has avanzado esta vez.");
                    }
                }else if (movimientoDeAgujero03) {
                    AvanceDe04 = Math.random() < AGUJERO_03_PROBABILIDAD_EXITO;
                    if (AvanceDe04) {
                        System.out.println(PISTA_01);
                        System.out.println(PISTA_02);
                        System.out.println(PISTA_03);
                        System.out.println(PISTA_01);
                        System.out.print(CABECERA_PISTA);
                        for (int j = 0; j < posicionCamello; j++) {
                            System.out.print(ESPACIO_VACIO);
                        }
                        for (int i = 0; i < 4; i++) {
                            System.out.print(ESPACIO_VACIO);
                        }
                        System.out.println(CAMELLO);
                        System.out.println(PISTA_01);
                        posicionCamello = posicionCamello + 4;
                    } else {
                        System.out.println("has fallado la pelota y no has avanzado esta vez.");
                    }
                } else if (movimientoDeAgujero04) {
                    AvanceDe06 = Math.random() < AGUJERO_04_PROBABILIDAD_EXITO;
                    if (AvanceDe06) {
                        System.out.println(PISTA_01);
                        System.out.println(PISTA_02);
                        System.out.println(PISTA_03);
                        System.out.println(PISTA_01);
                        System.out.print(CABECERA_PISTA);
                        for (int j = 0; j < posicionCamello; j++) {
                            System.out.print(ESPACIO_VACIO);
                        }
                        for (int i = 0; i < 6; i++) {
                            System.out.print(ESPACIO_VACIO);
                        }
                        System.out.println(CAMELLO);
                        System.out.println(PISTA_01);
                        posicionCamello = posicionCamello + 6;
                    } else {
                        System.out.println("has fallado la pelota y no has avanzado esta vez.");
                    }
                } else {
                    System.out.println("Agujero inválido. Pierdes turno.");
                }
                
                cantidadDeTurnos = cantidadDeTurnos + 1;
                
                if (posicionCamello >= CASILLA_FINAL) {
                    juegoTerminado = true;
                    System.out.println("¡Felicidades! Has ganado la carrera de camellos en " + cantidadDeTurnos + " turnos.");
                }
            }
    }
}
