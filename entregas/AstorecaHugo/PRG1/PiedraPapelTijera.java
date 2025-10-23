import java.util.Scanner;

class PiedraPapelTijera {

    public static void main(String[] args) {
        final int PIEDRA = 1;
        final int PAPEL = 2;
        final int TIJERA = 3;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elige: 1 (piedra), 2 (papel), 3 (tijera)");
        int jugador = teclado.nextInt();
        int ordenador = (int) (Math.random() * 3) + 1;
        System.out.println("El ordenador ha elegido: " + ordenador);
        if (jugador == ordenador) {
            System.out.println("Empate");
        } else if ((jugador == PIEDRA && ordenador == TIJERA) || (jugador == PAPEL && ordenador == PIEDRA) || (jugador == TIJERA && ordenador == PAPEL)) {
            System.out.println("¡Has ganado!");
        } else {
            System.out.println("Ha ganado PC");
        }
    }
}
