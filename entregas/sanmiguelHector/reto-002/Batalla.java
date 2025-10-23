class Batalla {
    public static void main(String[] args) {
        final int DAÑO_ESPADA = 2;
        int vidaGuerrero = 20;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;

        final int DAÑO_MORDIDA = 2;
        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;

        boolean algunMuerto = false;

        do {
            if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                vidaVampiro -= DAÑO_ESPADA;
                System.out.println("El vampiro recibe una hostia (-" + DAÑO_ESPADA + " vida)");
            } else {
                System.out.println("El vampiro esquiva la hostia");
            }

            if (vidaVampiro <= 0) {
                System.out.println("¡El vampiro ha muerto!");
                algunMuerto = true;
                break;
            }

            if (Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
                vidaGuerrero -= DAÑO_MORDIDA;
                System.out.println("El guerrero recibe una mordida (-" + DAÑO_MORDIDA + " vida)");
            } else {
                System.out.println("El guerrero esquiva la mordida");
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
    }
}