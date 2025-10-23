public class Reto_002 {
    public static void main(String[] args) {

        final int DAÑO_ESPADA = 2;
        int vidaGuerrero = 20;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;

        final int DAÑO_MORDIDA = 4;
        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;

        boolean algunMuerto = false;
        boolean guerreroVivo = true;
        boolean vampiroVivo = true;

        do {
            if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                vidaVampiro = vidaVampiro - DAÑO_ESPADA;
                System.out.println("El vampiro recibe daño");
            } else {
                System.out.println("El vampiro esquiva la espada");
            }

            vampiroVivo = vidaVampiro <= 0;

            if(vampiroVivo){
            if (vampiroVivo && Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
                vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA;
                System.out.println("El guerrero recibe una mordida");
            } else {
                System.out.println("El guerrero esquiva la mordida");
                }
            }
            System.out.println("Vida Guerrero [" + vidaGuerrero + "]/Vida Vampiro[" + vidaVampiro + "]");

            guerreroVivo = vidaGuerrero<=0;

            algunMuerto = guerreroVivo || vampiroVivo;

        } while (!algunMuerto);
        String elGanador = vidaGuerrero > 0 ? "Guerrero" : "Vampiro";
        System.out.println("Ganó el "+ elGanador);
    }
}