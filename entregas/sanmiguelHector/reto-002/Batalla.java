import java.util.Scanner;

class Batalla {
    public static void main(String[] args) {
        final int ARMA_1 = 7;
        final int ARMA_2 = 15;
        final int ARMA_3 = 30;
        final double PORCENTAJE_EXITO_ARMA_1 = 0.5;
        final double PORCENTAJE_EXITO_ARMA_2 = 0.25;
        final double PORCENTAJE_EXITO_ARMA_3 = 0.12;
        final double PORCENTAJE_EXITO_DEFENSA = 0.8;
        final int REDUCCION_DAÑO_POR_PROTECCION = 5;
        final int LIMITE_DESMAYO_GUERRERO = 30;
        final int RECUPERACION_POR_TURNO = 2;
        final int VIDA_MAX_GUERRERO = 150;
        int vidaGuerrero = VIDA_MAX_GUERRERO;

        final int ATAQUE_1 = 7;
        final int ATAQUE_2 = 15;
        final int ATAQUE_3 = 30;
        final double PORCENTAJE_EXITO_ATAQUE_1 = 0.9;
        final double PORCENTAJE_EXITO_ATAQUE_2 = 0.6;
        final double PORCENTAJE_EXITO_ATAQUE_3 = 0.4;
        final int LIMITE_DESMAYO_VAMPIRO = 20;
        int vidaVampiro = 60;

        boolean algunMuerto = false;
        boolean guerreroDesmayado = false;
        boolean vampiroDesmayado = false;
        boolean bebiendoPocion = false;
        int turnosParaCurarse = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            if (vidaGuerrero <= LIMITE_DESMAYO_GUERRERO) guerreroDesmayado = true;
            if (vidaVampiro <= LIMITE_DESMAYO_VAMPIRO) vampiroDesmayado = true;

            if (guerreroDesmayado) {
                vidaGuerrero += RECUPERACION_POR_TURNO;
                System.out.println("El guerrero está desmayado y recupera 2 puntos de vida (" + vidaGuerrero + ")");
                if (vidaGuerrero > LIMITE_DESMAYO_GUERRERO) guerreroDesmayado = false;
            }

            if (vampiroDesmayado) {
                vidaVampiro += RECUPERACION_POR_TURNO;
                System.out.println("El vampiro está desmayado y recupera 2 puntos de vida (" + vidaVampiro + ")");
                if (vidaVampiro > LIMITE_DESMAYO_VAMPIRO) vampiroDesmayado = false;
            }

            if (bebiendoPocion) {
                turnosParaCurarse--;
                if (turnosParaCurarse == 0) {
                    vidaGuerrero = VIDA_MAX_GUERRERO;
                    bebiendoPocion = false;
                    System.out.println("El héroe ha terminado de beber la poción y recupera toda su vida (" + vidaGuerrero + ")");
                } else {
                    System.out.println("El héroe sigue bebiendo la poción (" + turnosParaCurarse + " turnos restantes)");
                }
            }

            if (!guerreroDesmayado && !bebiendoPocion) {
                System.out.println("Escoge una acción:");
                System.out.println("1. Atacar");
                System.out.println("2. Beber poción curativa (tarda 3 turnos)");
                int accion = scanner.nextInt();

                if (accion == 1) {
                    System.out.println("Escoge el arma de tu héroe:");
                    System.out.println("1. Arma 1: 7 puntos de daño y 50% de éxito");
                    System.out.println("2. Arma 2: 15 puntos de daño y 25% de éxito");
                    System.out.println("3. Arma 3: 30 puntos de daño y 12% de éxito");
                    int eleccion = scanner.nextInt();

                    int dañoGuerrero = 0;
                    double probExitoGuerrero = 0;

                    if (eleccion == 1) {
                        dañoGuerrero = ARMA_1;
                        probExitoGuerrero = PORCENTAJE_EXITO_ARMA_1;
                    } else if (eleccion == 2) {
                        dañoGuerrero = ARMA_2;
                        probExitoGuerrero = PORCENTAJE_EXITO_ARMA_2;
                    } else if (eleccion == 3) {
                        dañoGuerrero = ARMA_3;
                        probExitoGuerrero = PORCENTAJE_EXITO_ARMA_3;
                    } else {
                        System.out.println("Elección inválida, pierdes el turno.");
                    }

                    if (Math.random() < probExitoGuerrero) {
                        vidaVampiro -= dañoGuerrero;
                        System.out.println("El vampiro recibe una ostia (-" + dañoGuerrero + " vida)");
                    } else {
                        System.out.println("El vampiro esquiva la hostia");
                    }
                } else if (accion == 2) {
                    bebiendoPocion = true;
                    turnosParaCurarse = 3;
                    System.out.println("El héroe comienza a beber la poción...");
                } else {
                    System.out.println("Acción inválida.");
                }
            }

            if (vidaVampiro <= 0) {
                System.out.println("¡El vampiro ha muerto!");
                algunMuerto = true;
                break;
            }

            if (vidaVampiro <= LIMITE_DESMAYO_VAMPIRO) vampiroDesmayado = true;

            if (!vampiroDesmayado) {
                int ataqueVampiro = (int)(Math.random() * 3) + 1;
                int dañoVampiro = 0;
                double probExitoVampiro = 0;

                if (ataqueVampiro == 1) {
                    dañoVampiro = ATAQUE_1;
                    probExitoVampiro = PORCENTAJE_EXITO_ATAQUE_1;
                } else if (ataqueVampiro == 2) {
                    dañoVampiro = ATAQUE_2;
                    probExitoVampiro = PORCENTAJE_EXITO_ATAQUE_2;
                } else {
                    dañoVampiro = ATAQUE_3;
                    probExitoVampiro = PORCENTAJE_EXITO_ATAQUE_3;
                }

                boolean usarEscudo = false;
                if (!guerreroDesmayado && !bebiendoPocion) {
                    System.out.println("¿Deseas intentar protegerte del ataque del vampiro? (true/false)");
                    usarEscudo = scanner.nextBoolean();
                }

                if (Math.random() < probExitoVampiro) {
                    if (usarEscudo && Math.random() < PORCENTAJE_EXITO_DEFENSA) {
                        int dañoReducido = Math.max(dañoVampiro - REDUCCION_DAÑO_POR_PROTECCION, 0);
                        vidaGuerrero -= dañoReducido;
                        System.out.println("El guerrero bloquea parcialmente el ataque (-" + dañoReducido + " vida)");
                    } else {
                        vidaGuerrero -= dañoVampiro;
                        System.out.println("El guerrero recibe una mordida (-" + dañoVampiro + " vida)");
                    }
                } else {
                    System.out.println("El guerrero esquiva la mordida");
                }
            } else {
                System.out.println("El vampiro está desmayado y no puede atacar");
            }

            if (vidaGuerrero <= 0) {
                System.out.println("¡El guerrero ha muerto!");
                algunMuerto = true;
                break;
            }

            System.out.println("Vida del guerrero: " + vidaGuerrero);
            System.out.println("Vida del vampiro: " + vidaVampiro);
            System.out.println("---------------------------");

        } while (!algunMuerto);

        System.out.println("Fin de la batalla.");
        scanner.close();
    }
}