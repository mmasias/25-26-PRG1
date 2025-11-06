class MinijuegoPelea{

    public static void main(String[] args) {
        final int DAÑO_ESPADA = 2;
        int vidaGuerrero = 20;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;

        final int DAÑO_MORDIDA = 4;
        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;

        boolean algunMuerto = false;

        double probabilidadGolpe = 0;

        do { 
            if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                vidaVampiro = vidaVampiro - DAÑO_ESPADA;
                System.out.println("El guerrero ha golpeado al vampiro y pierde " + DAÑO_ESPADA + " puntos de vida.");
            } else {
                System.out.println("El vampiro esquiva el ataque.");
            }
            if (Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
                vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA;
                System.out.println("El vampiro ha mordido al guerrero y pierde " + DAÑO_MORDIDA + " puntos de vida.");
            } else {
                System.out.println("El guerrero esquiva el ataque.");
            }
            System.out.println("Vida del guerrero: [" + vidaGuerrero + "] / Vida del vampiro: [" + vidaVampiro + "]");

            algunMuerto = vidaGuerrero <= 0 || vidaVampiro <= 0;
        } while (!algunMuerto);

        String Ganador = vidaGuerrero > 0 ? "El guerrero epico ha ganado la pelea." : "El sucio vampiro ha ganado la pelea.";
        System.out.println(Ganador);
    }
}
