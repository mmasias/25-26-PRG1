import java.util.Scanner;

class VampiroGuerreroAvanzado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vidaGuerrero = 150;
        final int ARMA_1_GUERRERO = 7;
        final int ARMA_2_GUERRERO = 15;
        final int ARMA_3_GUERRERO = 30;
        final double PROB_EXITO_ARMA_1_GUERRERO = 0.5;
        final double PROB_EXITO_ARMA_2_GUERRERO = 0.25;
        final double PROB_EXITO_ARMA_3_GUERRERO = 0.12;
        boolean guerreroMuerto = false;
        boolean guerreroDesmayado = false;
        boolean defensaGuerrero = false;
        final int DEFENSA_VIDA = 5;
        int opcionUsuario;

        int vidaVampiro = 60;
        final int ATAQUE_1_VAMPIRO = 5;
        final int ATAQUE_2_VAMPIRO = 10;
        final int ATAQUE_3_VAMPIRO = 20;
        final double PROB_EXITO_ATAQUE_1_VAMPIRO = 0.9;
        final double PROB_EXITO_ATAQUE_2_VAMPIRO = 0.6;
        final double PROB_EXITO_ATAQUE_3_VAMPIRO = 0.4;
        boolean vampiroMuerto = false;
        boolean vampiroDesmayado = false;

        int turnosPocion = 0;
        boolean pocionActiva = false;

        String linea = "--------------------------------------------------";

        System.out.println("¡Bienvenido al juego de batalla entre el vampiro y el guerrero!");
        System.out.println("Usted se encuentra con estas armas, deberá elegir en cada turno una (1-3):");
        System.out.println();
        System.out
                .println("Arma 1: " + ARMA_1_GUERRERO + " HP. Prob. éxito: " + PROB_EXITO_ARMA_1_GUERRERO * 100 + "%");
        System.out
                .println("Arma 2: " + ARMA_2_GUERRERO + " HP. Prob. éxito: " + PROB_EXITO_ARMA_2_GUERRERO * 100 + "%");
        System.out
                .println("Arma 3: " + ARMA_3_GUERRERO + " HP. Prob. éxito: " + PROB_EXITO_ARMA_3_GUERRERO * 100 + "%");
        System.out.println();
        System.out.println(linea);
        System.out.println();

        while (!vampiroMuerto && !guerreroMuerto) {
            defensaGuerrero = false;

            if (vidaGuerrero < 30 && !guerreroDesmayado && !pocionActiva) {
                guerreroDesmayado = true;
                System.out.println("El guerrero se ha desmayado. No puede atacar ni defender este turno.");
            }

            if (vidaVampiro < 20 && !vampiroDesmayado) {
                vampiroDesmayado = true;
                System.out.println("El vampiro se ha desmayado. No puede atacar este turno.");
            }

            if (guerreroDesmayado) {
                vidaGuerrero = vidaGuerrero + 2;
                if (vidaGuerrero >= 30) {
                    guerreroDesmayado = false;
                    System.out.println("El guerrero se ha recuperado y puede volver a luchar.");
                }
            }

            if (vampiroDesmayado) {
                vidaVampiro = vidaVampiro + 2;
                if (vidaVampiro >= 20) {
                    vampiroDesmayado = false;
                    System.out.println("El vampiro se ha recuperado y puede volver a atacar.");
                }
            }

            if (pocionActiva) {
                turnosPocion--;
                if (turnosPocion == 0) {
                    pocionActiva = false;
                    vidaGuerrero = 150;
                    System.out.println("La poción ha hecho efecto. ¡El guerrero recupera toda su energía!");
                } else {
                    System.out.println("La poción está surtiendo efecto (" + turnosPocion + " turnos restantes)");
                }
            }

            int ataqueVampiro = (int) (Math.random() * 3 + 1);
            double ataqueUsuarioProb = Math.random() * 1;
            double ataqueVampiroProb = Math.random() * 1;

            if (!guerreroDesmayado && !pocionActiva) {
                System.out.println("1, 2 o 3 -> Elegir arma para atacar");
                System.out.println("4 -> Defenderse (80% de éxito, reduce ataque del vampiro en 5)");
                System.out.println("5 -> Beber poción (tarda 3 turnos en hacer efecto)");

                System.out.print("Opción elegida: ");
                opcionUsuario = scanner.nextInt();
                System.out.println();

                while (opcionUsuario < 1 || opcionUsuario > 5) {
                    System.out.println("Entrada inválida, por favor, introduzca un número entre el 1 y el 5");
                    System.out.print("Arma elegida: ");
                    opcionUsuario = scanner.nextInt();
                    System.out.println();
                }
                if (opcionUsuario == 1) {
                    System.out.println("Utilizaste el arma 1.");
                    if (PROB_EXITO_ARMA_1_GUERRERO >= ataqueUsuarioProb) {
                        System.out.println("¡El guerrero atacó al vampiro!");
                        vidaVampiro = vidaVampiro - ARMA_1_GUERRERO;
                        System.out.println("La vida del vampiro bajó a " + vidaVampiro + " HP.");
                    } else {
                        System.out.println("¡El guerrero falló su ataque!");
                    }
                } else if (opcionUsuario == 2) {
                    System.out.println("Utilizaste el arma 2.");
                    if (PROB_EXITO_ARMA_2_GUERRERO >= ataqueUsuarioProb) {
                        System.out.println("¡El guerrero atacó al vampiro!");
                        vidaVampiro = vidaVampiro - ARMA_2_GUERRERO;
                        System.out.println("La vida del vampiro bajó a " + vidaVampiro + " HP.");
                    } else {
                        System.out.println("¡El guerrero falló su ataque!");
                    }

                } else if (opcionUsuario == 3) {
                    System.out.println("Utilizaste el arma 3.");
                    if (PROB_EXITO_ARMA_3_GUERRERO >= ataqueUsuarioProb) {
                        System.out.println("¡El guerrero atacó al vampiro!");
                        vidaVampiro = vidaVampiro - ARMA_3_GUERRERO;
                        System.out.println("La vida del vampiro bajó a " + vidaVampiro + " HP.");
                    } else {
                        System.out.println("¡El guerrero falló su ataque!");
                    }

                } else if (opcionUsuario == 4) {
                    defensaGuerrero = true;
                    System.out.println("El guerrero se prepara para defenderse.");

                } else if (opcionUsuario == 5) {
                    if (!pocionActiva) {
                        pocionActiva = true;
                        turnosPocion = 3;
                        System.out
                                .println("El guerrero bebe una poción. No puede atacar ni defender durante 3 turnos.");
                    }
                }
            }

            System.out.println();

            if (!vampiroDesmayado) {
                if (vidaVampiro > 0) {
                    if (ataqueVampiro == 1) {

                        if (PROB_EXITO_ATAQUE_1_VAMPIRO >= ataqueVampiroProb) {
                            System.out.println("¡El vampiro atacó al guerrero utilizando el ataque 1!");
                            if (defensaGuerrero == true) {
                                vidaGuerrero = vidaGuerrero - ATAQUE_1_VAMPIRO + DEFENSA_VIDA;
                                System.out.println("La vida del guerrero se mantuvo " + vidaGuerrero + " HP.");
                            } else {
                                vidaGuerrero = vidaGuerrero - ATAQUE_1_VAMPIRO;
                                System.out.println("La vida del guerrero bajó a " + vidaGuerrero + " HP.");
                            }
                        } else {
                            System.out.println("¡El vampiro falló su ataque 1!");
                        }

                    } else if (ataqueVampiro == 2) {

                        if (PROB_EXITO_ATAQUE_2_VAMPIRO >= ataqueVampiroProb) {
                            System.out.println("¡El vampiro atacó al guerrero utilizando el ataque 2!");
                            if (defensaGuerrero == true) {
                                vidaGuerrero = vidaGuerrero - ATAQUE_2_VAMPIRO + DEFENSA_VIDA;
                                System.out.println("La vida del guerrero bajó a " + vidaGuerrero + " HP.");
                            } else {
                                vidaGuerrero = vidaGuerrero - ATAQUE_2_VAMPIRO;
                                System.out.println("La vida del guerrero bajó a " + vidaGuerrero + " HP.");
                            }
                        } else {
                            System.out.println("¡El vampiro falló su ataque 2!");
                        }

                    } else {

                        if (PROB_EXITO_ATAQUE_3_VAMPIRO >= ataqueVampiroProb) {
                            System.out.println("¡El vampiro atacó al guerrero utilizando el ataque 3!");
                            if (defensaGuerrero == true) {
                                vidaGuerrero = vidaGuerrero - ATAQUE_3_VAMPIRO + DEFENSA_VIDA;
                                System.out.println("La vida del guerrero bajó a " + vidaGuerrero + " HP.");
                            } else {
                                vidaGuerrero = vidaGuerrero - ATAQUE_3_VAMPIRO;
                                System.out.println("La vida del guerrero bajó a " + vidaGuerrero + " HP.");
                            }

                        } else {
                            System.out.println("¡El vampiro falló su ataque 3!");
                        }

                    }
                }
            }

            if (vidaGuerrero <= 0) {
                guerreroMuerto = true;
                System.out.println("El guerrero ha muerto! Ha ganado el vampiro con " + vidaVampiro + " HP");
            } else if (vidaVampiro <= 0) {
                vampiroMuerto = true;
                System.out.println("El vampiro ha muerto! Ha ganado el guerrero con " + vidaGuerrero + " HP");

            }
            System.out.println();
            System.out.println(linea);
            System.out.println();
        }
    }
}
