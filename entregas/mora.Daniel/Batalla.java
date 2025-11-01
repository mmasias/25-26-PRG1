class Batalla {

    public static void main(String[] args) {

        final int DAÑO_ESPADA = 2;
        int vidaGuerrero = 20;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;

        final int DAÑO_MORDIDA = 4;
        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;

        boolean algunMuerto = false;

        double probabilidadGOlpe = 0;

        do {
            if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                vidaVampiro = vidaVampiro - DAÑO_ESPADA;
                System.out.println("El vampiro recibe una golpe");
            } else {
                System.out.println("El vampiro esquiva el golpe ");
            }

            if (Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
                vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA;
                System.out.println("El guerrero recibe una golpe");
            } else {
                System.out.println("El guerrero esquiva el golpe ");
            }

            System.out.println("Vida guerrero [" + vidaGuerrero + "] / Vida vampiro [" + vidaVampiro + "]");

            if (vidaGuerrero >= 0 && vidaVampiro >= 0) {
                algunMuerto = vidaGuerrero <= 0 || vidaVampiro <= 0;
            }
        } while (!algunMuerto);
        String elGanador = vidaGuerrero > 0 ? "Guerrero" : "Vampiro";
        System.out.println("Ganó el " + elGanador);

    }

}
