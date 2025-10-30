class Batalla {
    public static void main(String[] args) {

        final int DAÑO_ESPADA = 2;
        int vidaGuerrero = 20;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;

        final int MORDIDA = 4;
        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;

        boolean algunMuerto = false;

        do {
            
            if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                vidaVampiro = vidaVampiro - DAÑO_ESPADA;
                System.out.println("¡El vampiro recibe la ostia!");
            } else {
                System.out.println("¡El vampiro esquiva la ostia!");
            }

            boolean vampiroVivo = vidaVampiro > 0;

            
            if (vampiroVivo) {
                if (Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
                    vidaGuerrero = vidaGuerrero - MORDIDA;
                    System.out.println("¡El guerrero recibe la ostia!");
                } else {
                    System.out.println("¡El guerrero esquiva la ostia!");
                }
            }

            
            System.out.println("vidaGuerrero [" + vidaGuerrero + "] / vidaVampiro [" + vidaVampiro + "]");

            boolean guerreroVivo = vidaGuerrero > 0;

            algunMuerto = !guerreroVivo || !vampiroVivo;

        } while (!algunMuerto);

        String elGanador = vidaGuerrero > 0 ? "Guerrero" : "Vampiro";
        System.out.println("Ganó el " + elGanador);
    }
}