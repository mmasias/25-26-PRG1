package WhacAMole;
import java.util.Scanner;

public class WhacAMole {
    public static void main(String[] args) {

        System.out.println("-----WHACAMOLE-----");
        System.out.println("¡Bienvenido!");
        System.out.println("Te explicamos las reglas.");
        System.out.println("Tendras 15 intentos para intentar pegarle al monigote, este aparecera aleatoriamente en las siguientes casillas:");
            System.out.println(" (1) (2)  (3)  (4)");
            System.out.println(" (5) (6)  (7)  (8)");
            System.out.println(" (9) (10) (11) (12)");
            System.out.println("(13) (14) (15) (16)");
        System.out.println("¿Como se si le he pegado?");
        System.out.println("Aca te muestro los simbolos");
        System.out.println("Agujero: (  )");
        System.out.println("Agujero con Monigote: [&&]");
        System.out.println("Agujero golpeado sin Monigote: [[]]");
        System.out.println("Agujero golpeado con Monigote: [**]");
        System.out.println("Al finalizar los 15 turnos se mostrara tu numero de aciertos");
        System.out.println("---¡Empecemos a jugar! ¡Mucha suerte!---");
        

        Scanner scanner = new Scanner(System.in);

        int aciertoJugador = 0;
        for (int turno = 15; turno >= 1; turno--) {
            System.out.println("Escoje un numero para la casilla que quieres golpear");
            System.out.println("Tienes " + turno + " turnos");
            System.out.println("Numero a elegir: ");
            int golpe = scanner.nextInt();

            final int DIMENSION = 4;
            final int NUMERO_DE_AGUJEROS = 16;
            int monigote = (int) (Math.random() * NUMERO_DE_AGUJEROS) + 1;
            boolean acierto = monigote == golpe;
            int contador = 0;

            if (monigote != golpe) {
                System.out.println("No has acertado, sigue intentando");
            } else {
                System.out.println("¡Acertaste!");
            }

            for (int j = 1; j <= DIMENSION; j++) {
                for (int i = 1; i <= DIMENSION; i++) {
                    contador++;
                    if (acierto && contador == monigote) {
                        aciertoJugador++;
                        System.out.print("[**]");
                    } else if (contador == monigote) {
                        System.out.print("[&&]");
                    } else if (contador == golpe) {
                        System.out.print("[[]]");
                    } else {
                        System.out.print("(  )");
                    }
                }
                System.out.println();
            }

        }
        System.out.println("---FIN DEL JUEGO---");
        System.out.println("Tus aciertos fueron " + aciertoJugador);
        scanner.close();
    }
}
