import java.util.Scanner;

class batalla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        final int DAÑO_ESPADA_HEROE = 7;
        final int DAÑO_ESCOPETA_HEROE = 15;
        final int DAÑO_PISTOLA_HEROE = 30;
        int vidaGuerrero = 150;
        final double PORCENTAJE_EXITO_ESPADA = 0.5;
        final double PORCENTAJE_EXITO_ESCOPETA = 0.25;
        final double PORCENTAJE_EXITO_PISTOLA = 0.12;

        final int MORDIDA_VAMPIRO = 5;
        final int PATADA_VAMPIRO = 10;
        final int PUÑETAZO_VAMPIRO = 20;
        int vidaVampiro = 160;
        final double PORCENTAJE_EXITO_MORDIDA = 0.9;
        final double PORCENTAJE_EXITO_PATADA = 0.6;
        final double PORCENTAJE_EXITO_PUÑETAZO = 0.4;

        boolean algunMuerto = false;

        do {

            System.out.print("¿Que arma quieres usar? (ESPADA = 7, ESCOPETA = 15, PISTOLA = 30): ");
            int armaUsar = scanner.nextInt();

            if (Math.random() < PORCENTAJE_EXITO_ESPADA) {
                vidaVampiro = vidaVampiro - DAÑO_ESPADA_HEROE;
                System.out.println("El guerrero ha acertado un golpe de ESPADA");
            } else if (Math.random() < PORCENTAJE_EXITO_ESCOPETA) {
                vidaVampiro = vidaVampiro - DAÑO_ESCOPETA_HEROE;
                System.out.println("El guerrero ha acertado un golpe de ESCOPETA");
            } else if (Math.random() < PORCENTAJE_EXITO_PISTOLA) {
                vidaVampiro = vidaVampiro - DAÑO_PISTOLA_HEROE;
                System.out.println("El guerrero ha acertado un golpe de PISTOLA");
            } else {
                System.out.println("El guerrero ha fallado el golpe");
            }
         
            if (Math.random() < PORCENTAJE_EXITO_MORDIDA) {
                vidaGuerrero = vidaGuerrero - MORDIDA_VAMPIRO;
                System.out.println("El guerrero recibe una MORDIDA");
            } else if (Math.random() < PORCENTAJE_EXITO_PATADA) {
                vidaGuerrero = vidaGuerrero - PATADA_VAMPIRO;
                System.out.println("El guerrero recibe una PATADA");
            } else if (Math.random() < PORCENTAJE_EXITO_PUÑETAZO) {
                vidaGuerrero = vidaGuerrero - PUÑETAZO_VAMPIRO;
                System.out.println("El guerrero recibe un PUÑETAZO");
            } else {
                System.out.println("El guerrero esquiva");
            }

            System.out.println("Vida Guerrero [" + vidaGuerrero + "] / Vida Vampiro [" + vidaVampiro + "]");

            algunMuerto = vidaGuerrero <= 0 || vidaVampiro <= 0;
        } while (!algunMuerto);

        String elGanador = vidaGuerrero > 0 ? "Guerrero" : "Vampiro";
        System.out.println("Ganó el" + elGanador);
    }
}