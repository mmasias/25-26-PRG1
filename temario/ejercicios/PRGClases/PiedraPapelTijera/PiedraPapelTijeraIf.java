package PiedraPapelTijera;
import java.util.Scanner;

class PiedraPapelTijeraIf {
    public static void main(String[] args) {
        System.out.println("Listo para jugar Piedra, papel o tijeracontra la computadora?");
        System.out.println("Elige: 0 para piedra, 1 para papel, 2 para tijera");
        Scanner scanner = new Scanner(System.in);
        int jugadoPorUsuario = scanner.nextInt();

        int piedra = 0;
        int papel = 1;
        int tijera = 2;

        int jugadoPorComputadora = (int) (Math.random() * 3);

        boolean uPiedra = jugadoPorUsuario == piedra;
        boolean uTijera = jugadoPorUsuario == tijera;
        boolean uPapel = jugadoPorUsuario == papel;
        boolean cPiedra = jugadoPorComputadora == piedra;
        boolean cTijera = jugadoPorComputadora == tijera;
        boolean cPapel = jugadoPorComputadora == papel;

        System.out.print("Tú elegiste: ");
        if (uPiedra) {
            System.out.println("Piedra");
        } else if (uPapel) {
            System.out.println("Papel");
        } else if (uTijera) {
            System.out.println("Tijera");
        }

        
        System.out.print("La computadora eligió: ");
        if (cPiedra) {
            System.out.println("Piedra");
        } else if (cPapel) {
            System.out.println("Papel");
        } else if (cTijera) {
            System.out.println("Tijera");
        }

        
        if (jugadoPorUsuario == jugadoPorComputadora) {
            System.out.println("¡EMPATE!");
        } else if (uPiedra && cTijera) {
            System.out.println("¡Ganaste! Piedra vence Tijera");
        } else if (uPapel && cPiedra) {
            System.out.println("¡Ganaste! Papel vence Piedra");
        } else if (uTijera && cPapel) {
            System.out.println("¡Ganaste! Tijera vence Papel");
        } else {
            System.out.println("¡Perdiste!");
        }
    }
}
