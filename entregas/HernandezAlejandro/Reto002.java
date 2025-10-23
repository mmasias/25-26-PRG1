
import java.util.Scanner;

public class Reto002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int energiaHeroe = 150;
        int energiaVampiro = 60;
        int turno = 1;









        System.out.println("Comienza la batalla entre el Heroe y el Vampiro");

        while (energiaHeroe > 0 && energiaVampiro > 0) {
            System.out.println("Turno " + turno);
            System.out.println("Energia Heroe: " + energiaHeroe + " | Energia Vampiro: " + energiaVampiro);
            System.out.println("1. Arma 1 (daño 7, 50%)");
            System.out.println("2. Arma 2 (daño 15, 25%)");
            System.out.println("3. Arma 3 (daño 30, 12%)");
            System.out.print("Elige un arma: ");
            int opcion = sc.nextInt();




            
            int ataqueHeroe = 0;
            int probabilidadHeroe = 0;

            if (opcion == 1) {
                ataqueHeroe = 7;
                probabilidadHeroe = 50;
            } else if (opcion == 2) {
                ataqueHeroe = 15;
                probabilidadHeroe = 25;
            } else if (opcion == 3) {
                ataqueHeroe = 30;
                probabilidadHeroe = 12;
            } else {
                System.out.println("Opcion no valida, pierdes el turno");
            }

            if (Math.random() * 100 < probabilidadHeroe) {
                energiaVampiro -= ataqueHeroe;
                System.out.println("El heroe acierta y causa " + ataqueHeroe + " de daño");
            } else {
                System.out.println("El heroe falla su ataque");
            }

            if (energiaVampiro <= 0) {
                System.out.println("El heroe gana la batalla");
                break;
            }

            int ataqueElegido = (int) (Math.random() * 3) + 1;
            int ataqueVampiro = 0;
            int probabilidadVampiro = 0;

            if (ataqueElegido == 1) {
                ataqueVampiro = 5;
                probabilidadVampiro = 90;
            } else if (ataqueElegido == 2) {
                ataqueVampiro = 10;
                probabilidadVampiro = 60;
            } else {
                ataqueVampiro = 20;
                probabilidadVampiro = 40;
            }

            System.out.println("El vampiro intenta atacar");

            if (Math.random() * 100 < probabilidadVampiro) {
                energiaHeroe -= ataqueVampiro;
                System.out.println("El vampiro muerde e inflige " + ataqueVampiro + " de daño");
            } else {
                System.out.println("El vampiro falla su ataque");
            }

            if (energiaHeroe <= 0) {
                System.out.println("El vampiro gana la batalla");
                break;
            }

            turno++;
            System.out.println();
        }

        sc.close();
    }
}
