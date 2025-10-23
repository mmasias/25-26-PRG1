import java.util.Scanner;

class PeleaHeroe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int DANO_ESPADA = 7;
        final int DANO_HACHA = 15;
        final int DANO_LANZA = 30;
        int vidaGuerrero = 150;
        final double PORCENTAJE_EXITO_ESPADA = 0.5;
        final double PORCENTAJE_EXITO_HACHA = 0.25;
        final double PORCENTAJE_EXITO_LANZA = 0.12;

        final int DANO_MORDIDA = 5;
        final int DANO_GARRA = 10;
        final int DANO_PATADA = 20;
        int vidaVampiro = 60;
        final double PORCENTAJE_EXITO_MORDIDA = 0.9;
        final double PORCENTAJE_EXITO_GARRA = 0.6;
        final double PORCENTAJE_EXITO_PATADA = 0.4;

        boolean algunMuerto = false;
        boolean guerreroMuerto = false;
        boolean vampiroMuerto = false;

        System.out.println("COMIENZA LA BATALLA!");
        System.out.println("Guerrero: " + vidaGuerrero + " HP | Vampiro: " + vidaVampiro + " HP");
        System.out.println("------------------------------------");

        do {
            if (!guerreroMuerto) {

                int arma_seleccionada;

                System.out.println("Elige el arma con el que quieres atacar al vampiro:");
                System.out.println("1. Espada (Dano: " + DANO_ESPADA + ", Probabilidad de exito: "
                        + (PORCENTAJE_EXITO_ESPADA * 100) + "%)");
                System.out.println("2. Hacha (Dano: " + DANO_HACHA + ", Probabilidad de exito: "
                        + (PORCENTAJE_EXITO_HACHA * 100) + "%)");
                System.out.println("3. Lanza (Dano: " + DANO_LANZA + ", Probabilidad de exito:" +
                        (PORCENTAJE_EXITO_LANZA * 100) + "%");
                arma_seleccionada = scanner.nextInt();

                if (arma_seleccionada <= 0 || arma_seleccionada > 3) {
                    System.out.println("Selecciona un numero entre 1 y 3");

                } else if (arma_seleccionada == 1) {
                    if (Math.random() < PORCENTAJE_EXITO_ESPADA) {
                        vidaVampiro = vidaVampiro - DANO_ESPADA;
                        System.out.println("El vampiro se comio el golpe (Vida del vampiro: " + vidaVampiro);
                    } else {
                        System.out.println("El vampiro esquivo tu ataque");
                    }
                } else if (arma_seleccionada == 2) {
                    if (Math.random() < PORCENTAJE_EXITO_HACHA) {
                        vidaVampiro = vidaVampiro - DANO_HACHA;
                        System.out.println("El vampiro se comio el golpe (Vida del vampiro: " + vidaVampiro);
                    } else {
                        System.out.println("El vampiro esquivo tu ataque");
                    }
                } else if (arma_seleccionada == 3) {
                    if (Math.random() < PORCENTAJE_EXITO_LANZA) {
                        vidaVampiro = vidaVampiro - DANO_LANZA;
                        System.out.println("El vampiro se comio el golpe (Vida del vampiro: " + vidaVampiro);
                    } else {
                        System.out.println("El vampiro esquivo tu ataque");
                    }
                }
            }

            vampiroMuerto = vidaVampiro <= 0;

            if (!vampiroMuerto) {
                int ataque_vampiro = (int) (Math.random() * 3);

                System.out.println("Turno del Vampiro...");

                if (ataque_vampiro == 0) {
                    if (Math.random() < PORCENTAJE_EXITO_MORDIDA) {
                        vidaGuerrero = vidaGuerrero - DANO_MORDIDA;
                        System.out.println(
                                "Te muerde! Has recibido " + DANO_MORDIDA + " (Tu vida: " + vidaGuerrero + ")");
                    } else {
                        System.out.println("El vampiro intento morderte pero has esquivado el ataque!!");
                    }
                } else if (ataque_vampiro == 1) {
                    if (Math.random() < PORCENTAJE_EXITO_GARRA) {
                        vidaGuerrero = vidaGuerrero - DANO_GARRA;
                        System.out.println("Te ataca con sus garras! Has recibido " + DANO_GARRA + " (Tu vida: "
                                + vidaGuerrero + ")");
                    } else {
                        System.out.println("El vampiro lanzo un zarpazo pero has esquivado el ataque!!");
                    }
                } else if (ataque_vampiro == 2) {
                    if (Math.random() < PORCENTAJE_EXITO_PATADA) {
                        vidaGuerrero = vidaGuerrero - DANO_PATADA;
                        System.out.println(
                                "Te dio una patada! Has recibido " + DANO_PATADA + " (Tu vida: " + vidaGuerrero + ")");
                    } else {
                        System.out.println("El vampiro intento patearte pero has esquivado el ataque!!");
                    }
                }

                guerreroMuerto = vidaGuerrero <= 0;
            }

            algunMuerto = guerreroMuerto || vampiroMuerto;

            if (!algunMuerto) {
                System.out.println("...");
            }

        } while (!algunMuerto);
        {
            String elGanador = vidaGuerrero <= 0 ? "El vampiro te ha vencido" : "Has Ganado!!!";

            System.out.println("\n--- BATALLA TERMINADA ---");
            System.out.println(elGanador);
            System.out.println("Vida de guerrero: [" + vidaGuerrero + "]");
            System.out.println("Vida de vampiro: [" + vidaVampiro + "]");
        }
    }
}