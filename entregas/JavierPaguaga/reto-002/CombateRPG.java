
import java.util.Scanner;

public class CombateRPG {

    public static void main(String[] args) {

        int vidaGuerrero = 150;
        final int GUERRERO_VIDA_MINIMA_DESMAYO = 30;
        final int DAÑO_Defendido = 5;
        final double PROBABILIDAD_DE_DEFENDERSE = 0.8;
        final int DAÑO_LATIGO = 7;
        final double PROBABILIDAD_DE_LATIGO_GOLPEAR = 0.5;
        final int DAÑO_ESPADA = 15;
        final double PROBABILIDAD_DE_ESPADA_GOLPEAR = 0.25;
        final int DAÑO_HACHA = 30;
        final double PROBABILIDAD_DE_HACHA_GOLPEAR = 0.12;
        final int TIEMPO_PARA_RECUPERARSE_GUERRERO = 3;
        int turnosEnRecuperacionGuerrero = 0;

        int vidaVampiro = 60;
        final int VAMPIRO_VIDA_MINIMA_DESMAYO = 20;
        final int DAÑO_GARRA = 5;
        final double PROBABILIDAD_DE_GARRA_GOLPEAR = 0.9;
        final int DAÑO_MORDIDA = 10;
        final double PROBABILIDAD_DE_MORDIDA_GOLPEAR = 0.6;
        final int DAÑO_CHUPA_SANGRE = 20;
        final double PROBABILIDAD_DE_CHUPA_SANGRE_GOLPEAR = 0.40;

        Boolean guerreroRecuperandose = false;
        Boolean guerreroDesmayado = false;
        Boolean vampiroDesmayado = false;
        Boolean guerreroSeDefende = false;
        Boolean guerreroVivo = true;
        Boolean vampiroVivo = true;
        Boolean algunMuerto = false;

        System.out.println("Comienza el combate entre el Guerrero y el Vampiro!");
        System.out.println("-----------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        while (!algunMuerto) {
            if (guerreroVivo && !guerreroDesmayado && !guerreroRecuperandose) {

                System.out.println("Elige el ataque del guerrero: 1 (Látigo) 2 (Espada) 3(Hacha) 4 (Defenderse) 5 (poción curativa)");
                int eleccionGuerrero = scanner.nextInt();

                if (eleccionGuerrero == 1) {
                    if (Math.random() < PROBABILIDAD_DE_LATIGO_GOLPEAR) {
                        vidaVampiro = vidaVampiro - DAÑO_LATIGO;
                        System.out.println("El guerrero golpea al vampiro con su látigo.");
                    } else {
                        System.out.println("El vampiro esquiva el látigo.");
                    }
                } else if (eleccionGuerrero == 2) {
                    if (Math.random() < PROBABILIDAD_DE_ESPADA_GOLPEAR) {
                        vidaVampiro = vidaVampiro - DAÑO_ESPADA;
                        System.out.println("El guerrero golpea al vampiro con su espada.");
                    } else {
                        System.out.println("El vampiro esquiva la espada.");
                    }
                } else if (eleccionGuerrero == 3) {
                    if (Math.random() < PROBABILIDAD_DE_HACHA_GOLPEAR) {
                        vidaVampiro = vidaVampiro - DAÑO_HACHA;
                        System.out.println("El guerrero golpea al vampiro con su hacha.");
                    } else {
                        System.out.println("El vampiro esquiva el hacha.");
                    }
                } else if (eleccionGuerrero == 4) {
                    if (Math.random() < PROBABILIDAD_DE_DEFENDERSE) {
                        guerreroSeDefende = true;
                        System.out.println("El guerrero se defiende del próximo ataque del vampiro, recibiendo menos daño.");
                    } else {
                        System.out.println("El guerrero no logra defenderse.");
                    }
                } else if (eleccionGuerrero == 5) { guerreroRecuperandose = true;
                    System.out.println("El guerrero usa una poción curativa, se recuperarla en tres turnos.");
                }
                else {
                    System.out.println("Elección inválida. El guerrero pierde su turno.");
                }

            } else if (guerreroVivo && guerreroDesmayado && !guerreroRecuperandose) {
                System.out.println("El guerrero está desmayado y no puede atacar.");
                vidaGuerrero = vidaGuerrero + 2;
            } else if (guerreroVivo && guerreroRecuperandose) {
                System.out.println("El guerrero está recuperándose y no puede atacar.");
                turnosEnRecuperacionGuerrero = turnosEnRecuperacionGuerrero + 1;
                if (turnosEnRecuperacionGuerrero >= TIEMPO_PARA_RECUPERARSE_GUERRERO) {
                    guerreroRecuperandose = false;
                    turnosEnRecuperacionGuerrero = 0;
                    vidaGuerrero = 150;
                    System.out.println("El guerrero ha terminado de recuperarse y recupero toda su vida.");
                }
            }

            if (vidaGuerrero <= GUERRERO_VIDA_MINIMA_DESMAYO) {
                guerreroDesmayado = true;
            } else {
                guerreroDesmayado = false;
            }

            if (vidaVampiro <= 0) {
                algunMuerto = true;
                vampiroVivo = false;
            }

            if (vampiroVivo && !vampiroDesmayado) {
                int eleccionVampiro = (int) (Math.random() * 3) + 1;
                if (eleccionVampiro == 1) {
                    if (Math.random() < PROBABILIDAD_DE_GARRA_GOLPEAR) {
                        vidaGuerrero = vidaGuerrero - DAÑO_GARRA;
                        System.out.println("El vampiro ataca al guerrero con sus garras.");
                        if (guerreroSeDefende) {
                            vidaGuerrero = vidaGuerrero + DAÑO_Defendido;
                            guerreroSeDefende = false;
                            System.out.println("El guerrero se defendió y recibió menos daño.");
                        }
                    } else {
                        System.out.println("El guerrero esquiva las garras.");
                    }
                } else if (eleccionVampiro == 2) {
                    if (Math.random() < PROBABILIDAD_DE_MORDIDA_GOLPEAR) {
                        vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA;
                        System.out.println("El vampiro Muerde al guerrero con sus dientes.");
                        if (guerreroSeDefende) {
                            vidaGuerrero = vidaGuerrero + DAÑO_Defendido;
                            guerreroSeDefende = false;
                            System.out.println("El guerrero se defendió y recibió menos daño.");
                        }
                    } else {
                        System.out.println("El guerrero esquiva la mordida.");
                    }
                } else {
                    if (Math.random() < PROBABILIDAD_DE_CHUPA_SANGRE_GOLPEAR) {
                        vidaGuerrero = vidaGuerrero - DAÑO_CHUPA_SANGRE;
                        System.out.println("El vampiro Chupa la sangre del guerrero.");
                        if (guerreroSeDefende) {
                            vidaGuerrero = vidaGuerrero + DAÑO_Defendido;
                            guerreroSeDefende = false;
                            System.out.println("El guerrero se defendió y recibió menos daño.");
                        }
                    } else {
                        System.out.println("El guerrero esquiva el intento de chupar su sangre.");
                    }
                }

            } else if (vampiroVivo && vampiroDesmayado) {
                System.out.println("El vampiro está desmayado y no puede atacar.");
                vidaVampiro = vidaVampiro + 2;
            }

            if (vidaVampiro <= VAMPIRO_VIDA_MINIMA_DESMAYO) {
                vampiroDesmayado = true;
            } else {
                vampiroDesmayado = false;
            }

            if (vidaGuerrero <= 0) {
                algunMuerto = true;
                guerreroVivo = false;
            }

            System.out.println("Guerrero [" + vidaGuerrero + "] / Vampiro [" + vidaVampiro + "]");

            if (guerreroSeDefende) {
                guerreroSeDefende = false;
            }
        }
        scanner.close();

        String ganador;

        if (guerreroVivo) {
            ganador = "guerrero";
        } else {
            ganador = "vampiro";
        }
        System.out.println("¡El combate ha terminado! El ganador es: El " + ganador);
    }
}
