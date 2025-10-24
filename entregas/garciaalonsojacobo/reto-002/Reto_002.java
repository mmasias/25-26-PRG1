public class Reto_002 {
    public static void main(String[] args) {

        int VIDA_GUERRERO = 20;
        final int DAÑO_HACHA_GUERRERO = 2;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;

        int VIDA_VAMPIRO = 10;
        final int DAÑO_MORDIDA_VAMPIRO = 4;
        final double PORCENTAJE_EXITO_VAMPRIO = 0.5;

        boolean algunMuerto = false;

        do {
            boolean vampiroVivo = VIDA_VAMPIRO >= 0;
            boolean guerreroVivo = VIDA_GUERRERO >= 0;
            boolean golpe_Exitoso_Guerrero = Math.random() < PORCENTAJE_EXITO_GUERRERO;
            boolean mordisco_Exitoso_Vampiro = Math.random() < PORCENTAJE_EXITO_VAMPRIO;

            if (guerreroVivo) {

                if (golpe_Exitoso_Guerrero) {
                    VIDA_VAMPIRO = VIDA_VAMPIRO - DAÑO_HACHA_GUERRERO;
                    System.out.println("El guerrero ha atacado al vampiro");
                    System.out.println();
                } else {
                    System.out.println("El vampiro ha esquivado el golpe");
                    System.out.println();
                }
            }
            if (vampiroVivo) {

                if (mordisco_Exitoso_Vampiro) {
                    VIDA_GUERRERO = VIDA_GUERRERO - DAÑO_MORDIDA_VAMPIRO;
                    System.out.println("El vamprio ha mordido al guerrero");
                    System.out.println();
                } else {
                    System.out.println("El guerrero a esquivado el golpe ");
                    System.out.println();
                }
            }
            System.out.println("vida del vampiro= " + "[" + VIDA_VAMPIRO + "]" + " / " + "Vida del guerrero= " + "["
                    + VIDA_GUERRERO + "]");
            System.out.println();
            algunMuerto = !guerreroVivo || !vampiroVivo;
            vampiroVivo = VIDA_VAMPIRO >= 0;
            guerreroVivo = VIDA_GUERRERO >= 0;
        } while (!algunMuerto);

        System.out.println("El ganador es : " + (VIDA_GUERRERO < 0 ? " ¡EL VAMPRIO!" : " ¡EL GUERRERO!"));

    }
}
