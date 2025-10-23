class GuerreroVsVampiro {
    public static void main(String[] args) {

        int vidaGuerrero = 20;
        int vidaVampiro = 10;

        final int DANO_GUERRERO = 2;
        final int DANO_VAMPIRO = 4;
        final double PROBABILIDAD_DE_ATAQUE = 0.5;

        System.out.println("¡COMIENZA LA BATALLA!");
        System.out.println("Guerrero: " + vidaGuerrero + " HP");
        System.out.println("Vampiro: " + vidaVampiro + " HP");
        System.out.println();

        while (vidaGuerrero > 0 && vidaVampiro > 0) {
            System.out.println("");
            if (Math.random() < PROBABILIDAD_DE_ATAQUE) {
                vidaVampiro = vidaVampiro - DANO_GUERRERO;
                System.out.println("¡El guerrero golpea! " + DANO_GUERRERO + " HP");
            } else {
                System.out.println("El guerrero fallo el ataque");
            }
            if (vidaVampiro > 0) {
                if (Math.random() < PROBABILIDAD_DE_ATAQUE) {
                    vidaGuerrero = vidaGuerrero - DANO_VAMPIRO;
                    System.out.println("¡El vampiro muerde! " + DANO_VAMPIRO + " HP");
                } else {
                    System.out.println("¡El vampiro fallo!");
                }
            }

            System.out.println("Guerrero: " + vidaGuerrero + " HP");
            System.out.println("Vampiro: " + vidaVampiro + " HP");
            System.out.println();
        }

        if (vidaGuerrero > 0) {
            System.out.println("¡GANÓ EL GUERRERO!");
        } else {
            System.out.println("¡GANÓ EL VAMPIRO!");
        }
    }
}