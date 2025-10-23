package PiedraPapelTijera;
import java.util.Scanner;

class PiedraPapelTijeraTernario {
        public static void main(String[] args) {
                System.out.println("Listo para jugar Piedra, papel o tijera contra la computadora?");
                System.out.println("Elige: 0 para piedra, 1 para papel, 2 para tijera");
                Scanner scanner = new Scanner(System.in);

                int piedra = 0;
                int papel = 1;
                int tijera = 2;

                int jugadoPorUsuario = scanner.nextInt();
                int jugadoPorComputadora = (int) (Math.random() * 3);

                boolean uPiedra = jugadoPorUsuario == piedra;
                boolean uTijera = jugadoPorUsuario == tijera;
                boolean uPapel = jugadoPorUsuario == papel;
                boolean cPiedra = jugadoPorComputadora == piedra;
                boolean cTijera = jugadoPorComputadora == tijera;
                boolean cPapel = jugadoPorComputadora == papel;

                boolean empate = (jugadoPorUsuario == jugadoPorComputadora);

                boolean gane = (uPiedra && cTijera) ||
                                (uPapel && cPiedra) ||
                                (uTijera && cPapel);

                String resultado = empate ? "Has empatado" : gane ? "¡Ganaste!" : "¡Perdiste!";

                String eleccionUsuario = uPiedra ? "Piedra" : uPapel ? "Papel" : "Tijera";
                System.out.println("Tú elegiste: " + eleccionUsuario);

                String eleccionComputadora = cPiedra ? "Piedra" : cPapel ? "Papel" : "Tijera";
                System.out.println("La computadora eligió: " + eleccionComputadora);

                System.out.println(resultado);
        }
}