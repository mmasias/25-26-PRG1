import java.util.Scanner;

public class AdivinadorNumeros {

    public static void main(String[] args) {
        final int NUMERO_MAXIMO = 100;
        final int NUMERO_MINIMO = 1;
        Scanner Scanner = new Scanner(System.in);
        int numeroPensado = (int) (Math.random() * NUMERO_MAXIMO) + 1;

        System.out.println("Estoy pensando un numero entre el 1 y el 100");
        System.out.println("¡ADIVINALO!");
        System.out.println("NO TE DIRE CUAL ES EL NUMERO PENSADO " + numeroPensado);
        int contadorCaliente = 0;
        boolean puedeJugar = true;
        int numeroDeIntentos = 0;
        boolean haAdivinado = false;
        final int NUMERO_MAXIMO_INTENTOS = 10;
        final int CALIENTE = 5;
        final int TIBIO = 10;

        while (puedeJugar) {
            numeroDeIntentos = numeroDeIntentos + 1;
            String solucion = "";
            int solucionUsuario = Scanner.nextInt();
            haAdivinado = solucionUsuario == numeroPensado;

            final int CAMBIO_ALEATORIO_MAXIMO = 5;
            int cambio_Aleatorio = (int) (Math.random() * CAMBIO_ALEATORIO_MAXIMO) + 1;

            if (contadorCaliente >= 2) {
                if (Math.random() < 0.5) {
                    numeroPensado = numeroPensado + cambio_Aleatorio;
                } else {
                    numeroPensado = numeroPensado - cambio_Aleatorio;
                }

                if (numeroPensado < NUMERO_MINIMO) {
                    numeroPensado = NUMERO_MINIMO;
                }
                if (numeroPensado > NUMERO_MAXIMO) {
                    numeroPensado = NUMERO_MAXIMO;

                }
                System.out.println("el sistema ha cambiado un poco ;)" + numeroPensado);
                contadorCaliente = 0;
            }

            int diferencia = Math.abs(solucionUsuario - numeroPensado); 

            if (haAdivinado) {
                solucion = "Has adivinado!!";
            } else {
                solucion = "No has adivinado";
                if (solucionUsuario < numeroPensado) {
                    solucion = solucion + " es mayor!!";
                } else
                    solucion = solucion + " es menor!!";
            }

            if (haAdivinado) {

            } else if (diferencia <= CALIENTE) {
                System.out.println("CALIENTE");
                contadorCaliente++;
            } else if (diferencia <= TIBIO) {
                System.out.println("TIBIO");
            } else {
                System.out.println("FRIO");
                contadorCaliente = 0;
            }

            puedeJugar = !haAdivinado && numeroDeIntentos < NUMERO_MAXIMO_INTENTOS;

            if (haAdivinado) {
                System.out.println(solucion);
                System.out.println(
                        "Lo lograste en: " + numeroDeIntentos + (numeroDeIntentos == 1 ? " intento" : " intentos"));
            } else {
                System.out.println(solucion);
                System.out.println();
            }
            if (!puedeJugar && !haAdivinado) {
                System.out.println("Se te acabron los intentos, el numero pensado era: " + numeroPensado);
            }

        }
        Scanner.close();
    }
}
