import java.util.Scanner;

class BatallaHeroeVampirosbase {

    public static void main(String[] args) {
        
        final int DAÑO_MORDIDA = 4;
        int vidaVampiro = 20;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;

        final int DAÑO_ESPADA = 2;
        int vidaGuerrero = 20;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;

        boolean algunMuerto = false;
        
        do { 
            if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                vidaVampiro = vidaVampiro - DAÑO_ESPADA;
                System.out.println("El vampiro recibe un golpe");
            } else {
                System.out.println("El vampiro esquiva el golpe");
            }
            
            if (Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
                vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA;
                System.out.println("El guerrero recibe la mordida");
            } else {
                System.out.println("El guerrero esquiva la mordida");
            }

            System.out.println("vida Guerrero [" + vidaGuerrero + "] / vida Vampiro [" + vidaVampiro + "]");

            algunMuerto = (vidaGuerrero <= 0 || vidaVampiro <= 0);
        } while (!algunMuerto);

        String elGanador = (vidaGuerrero > 0) ? "Guerrero" : "Vampiro";
        System.out.println("Ha ganado el " + elGanador);
            }
        }

