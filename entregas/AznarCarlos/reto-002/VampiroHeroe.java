import java.util.Scanner;

 class VampiroHeroe{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int VIDA_HEROE = 150;
        int VIDA_VAMPIRO = 60;
        final int HACHA = 7, LANZA = 15, ARCO = 30;
        final int ARAÑAZO = 5, MORDIDA = 10, BUMERANDESANGRE = 20;
        final double probabilidadExitoAtaque1Heroe = 0.5;
        final double probabilidadExitoAtaque2Heroe = 0.25;
        final double probabilidadExitoAtaque3Heroe = 0.12;
        final double probabilidadExitoARAÑAZO = 0.90;
        final double probabilidadExitoMORDIDA = 0.60;
        final double probabilidadExitoBUMERANDESANGRE = 0.40;
        final double probabilidadDefensaHeroe = 0.80;
        boolean pocionActiva = false;
        int turnosParaCurar = 0;
        final int VIDA_HEROE_MAX = 150;
        boolean defensaActivaHeroe = false;

        while (VIDA_HEROE > 0 && VIDA_VAMPIRO > 0) {

            if (pocionActiva) {
                System.out.println(" El héroe está bajo los efectos de la poción. Debe esperar " + turnosParaCurar
                        + " turnos más sin actuar.");
                turnosParaCurar--;

                if (turnosParaCurar <= 0) {
                    VIDA_HEROE = VIDA_HEROE_MAX;
                    pocionActiva = false;
                    System.out.println(" ¡La poción mágica ha surtido efecto! El héroe recupera toda su vida.");
                }

            } else {

                System.out.println("Vida del héroe: " + VIDA_HEROE);
                System.out.println("Vida del vampiro: " + VIDA_VAMPIRO);
                System.out.println(
                        "Con que arma deseas atacar? Hacha(1), Lanza(2) , Arco(3), Defensaheroe(4), pocion(5)");
                int eleccionArmaHeroe = scanner.nextInt();

                defensaActivaHeroe = false;

                if (eleccionArmaHeroe == 1) {
                    if (probabilidadExitoAtaque1Heroe >= Math.random()) {
                        VIDA_VAMPIRO = VIDA_VAMPIRO - HACHA;
                        System.out.println("El ataque con la hacha del héroe fue exitoso.");
                    } else {
                        System.out.println("El ataque con la hacha del héroe falló.");
                    }
                } else if (eleccionArmaHeroe == 2) {
                    if (probabilidadExitoAtaque2Heroe >= Math.random()) {
                        VIDA_VAMPIRO = VIDA_VAMPIRO - LANZA;
                        System.out.println("El con la lanza del héroe fue exitoso.");
                    } else {
                        System.out.println("El con la lanza del héroe falló.");
                    }
                } else if (eleccionArmaHeroe == 3) {
                    if (probabilidadExitoAtaque3Heroe >= Math.random()) {
                        VIDA_VAMPIRO = VIDA_VAMPIRO - ARCO;
                        System.out.println("El ataque con el arco del héroe fue exitoso.");
                    } else {
                        System.out.println("El ataque con el arco del héroe falló.");
                    }
                } else if (eleccionArmaHeroe == 4) {
                    if (probabilidadDefensaHeroe >= Math.random()) {
                        defensaActivaHeroe = true;
                        System.out.println("La defensa del héroe fue exitosa, solo recibe un poco de daño.");
                    } else {
                        System.out.println("La defensa del héroe falló.");
                    }
                } else if (eleccionArmaHeroe == 5) {
                    if (!pocionActiva) {
                        pocionActiva = true;
                        turnosParaCurar = 4;
                        System.out.println(
                                "El héroe bebe una poción mágica. Debe pasar 4 turnos sin actuar para que surta efecto.");
                    } else {
                        System.out.println("El heroe esta bajo el efecto de la pocion ");
                    }

                } else {
                    System.out.println("Elección inválida, se pierde el turno.");
                }
            }

            if (VIDA_VAMPIRO > 0) {

                System.out.println();
                System.out.println("Turno del vampiro para atacar...");
                int daño = 0;

                double eleccionVampiro = Math.random();
                if (eleccionVampiro < 0.33) {
                    System.out.println("El vampiro elige atacar con ataque con un arañazo.");
                    if (probabilidadExitoARAÑAZO >= Math.random()) {
                        daño = ARAÑAZO;
                        System.out.println("El ataque con las uñas del vampiro fue exitoso.");
                    } else {
                        System.out.println("El arañazo del vampiro falló.");
                    }
                } else if (eleccionVampiro < 0.66) {
                    System.out.println("El vampiro elige atacar con con su mordida.");
                    if (probabilidadExitoMORDIDA >= Math.random()) {
                        daño = MORDIDA;
                        System.out.println("La mordida del vampiro fue exitoso.");

                    } else {
                        System.out.println("la mordida del vampiro falló.");
                    }
                } else {
                    System.out.println("El vampiro elige atacar magia negra.");
                    if (probabilidadExitoBUMERANDESANGRE >= Math.random()) {
                        daño = BUMERANDESANGRE;
                        System.out.println("El ataque con la magia negra del vampiro fue exitoso.");
                    } else {
                        System.out.println("El ataque con la magia negra del vampiro falló.");
                    }
                }
                if (defensaActivaHeroe) {
                    daño = Math.max(0, daño - 5);
                    defensaActivaHeroe = false;
                    System.out.println(" El blindaje redujo el daño en 5 puntos.");
                }
                VIDA_HEROE -= daño;
                if (daño > 0) {
                    System.out.println(" El héroe recibe " + daño + " puntos de daño.");

                }
            }

        }

        if (VIDA_HEROE <= 0) {
            System.out.println(" El vampiro ha ganado.");
        } else if (VIDA_VAMPIRO <= 0) {
            System.out.println(" ¡El héroe ha ganado!");
        }

        scanner.close();
    }

}
