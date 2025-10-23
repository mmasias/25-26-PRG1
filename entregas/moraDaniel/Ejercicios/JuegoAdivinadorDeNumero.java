package entregas.moraDaniel.Ejercicios;

import java.util.Scanner;

class JuegoAdivinadorDeNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int NUMERO_MINIMO = 1;
        final int NUMERO_MAXIMO = 100;

        int numeroPensado = (int) (Math.random() * NUMERO_MAXIMO) + NUMERO_MINIMO;
        System.out.println("Estoy pensando un número entre el " + NUMERO_MINIMO + " y el " + NUMERO_MAXIMO);
        System.out.println("Puede que sea el " + numeroPensado);
        System.out.println("A ver si lo adivinas ...");

        boolean haAdivinado = false;
        int numeroDeIntentos = 0;
        int contadorCalientesSeguidos = 0;

        while (!haAdivinado) {
            numeroDeIntentos = numeroDeIntentos + 1;
            System.out.println("Ingrese el número que piensas que es : ");
            int valorDeUsuario = scanner.nextInt();
            int diferencia = Math.abs(numeroPensado - valorDeUsuario);
            haAdivinado = valorDeUsuario == numeroPensado;

            String solucion = "";

            if (haAdivinado) {
                solucion = "Adivinaste";
            } else {
                if (diferencia <= 5) {
                    solucion = "Caliente";
                    contadorCalientesSeguidos = contadorCalientesSeguidos + 1;
                } else if (diferencia <= 10) {
                    solucion = "Tibio";
                    contadorCalientesSeguidos = 0;
                } else {
                    solucion = "Frio";
                    contadorCalientesSeguidos = 0;
                }

                solucion = solucion + " No adivinaste";

                if (valorDeUsuario > numeroPensado) {
                    solucion = solucion + ". Es menor";
                } else {
                    solucion = solucion + ". Es mayor";
                }
                if (contadorCalientesSeguidos >= 2) {
                    int cambio = (int) (Math.random() * 5) + 1;
                    boolean sumar = Math.random() < 0.5;
                    if (sumar) {
                        numeroPensado = Math.min(NUMERO_MAXIMO, numeroPensado + cambio);
                    } else {
                        numeroPensado = Math.max(NUMERO_MINIMO, numeroPensado - cambio);
                    }
                    System.out.println("  El ordenador estornudó... (y quizás cambió de número)");
                    System.out.println("Puede que sea el " + numeroPensado);
                    contadorCalientesSeguidos = 0;
                }
            }
            System.out.println(solucion);
        }
        System.out.println("Lo hiciste en : " + numeroDeIntentos + " intento(s)");
        scanner.close();
    }

}
