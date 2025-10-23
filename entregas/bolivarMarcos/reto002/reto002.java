package entregas.bolivarMarcos.reto002;

public class reto002 {
    public static void main(String[] args) {

        final int DAÑO_HEROE = 2;
        int vidaheroe = 20;
        final double PROBABILIDAD_EXITO_HEROE = 0.5;

        final int DAÑO_VAMPIRO = 4;
        int vidaVampiro = 10;
        final double PROBABILIDAD_EXITO_VAMPIRO = 0.5;
        boolean alguienVivo = true;
        boolean vampiroVivo = true;
        while (alguienVivo) {

            if (Math.random() < PROBABILIDAD_EXITO_HEROE) {
                System.out.println("El vampiro se lleva un tajo!!");
                vidaVampiro = vidaVampiro - DAÑO_HEROE;
            } else {
                System.out.println("El vampiro esquivó el ataque!!");
            }

            if (vidaVampiro <= 0) {
                vampiroVivo = false;
                alguienVivo = false;
            }

            if (vampiroVivo) {
                if (Math.random() < PROBABILIDAD_EXITO_VAMPIRO) {
                    System.out.println("El heroe se lleva un mordisco!!");
                    vidaheroe = vidaheroe - DAÑO_VAMPIRO;
                } else {
                    System.out.println("El heroe ha esquivado el mordisco!!");
                }
            }
            System.out.println("La vida del heroe es [" + vidaheroe + "]/La vida del vampiro es [" + vidaVampiro + "]");
            if (vidaheroe <= 0 || !vampiroVivo) {
                if (vampiroVivo) {
                    System.out.println("El vampiro mató al heroe!!");

                } else {
                    System.out.println("El heroe mató al vampiro!!");
                }
                alguienVivo = false;
            }

        }

    }
}