class Batalla {
    public static void main (String[] args) {

        final int DAÑO_ESPADA = 2;
        int vidaGuerrero = 20;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;
        boolean guerreroMuerto = false;

        final int DAÑO_MORDIDA = 4;
        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;
        boolean vampiroMuerto = false;

        boolean algunMuerto = false;

        do {
            if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                vidaVampiro = vidaVampiro - DAÑO_ESPADA;
                System.out.println("El vampiro ha reicbido daño");
            } else {
                System.out.println("El vampiro ha esquivado el ataque");
            }

            vampiroMuerto = vidaVampiro <= 0;
            
            if (Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
                vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA;
                System.out.println("El guerrero ha recibido daño");
            } else {
                System.out.println("El guerrero ha esquivado el ataque");
            }

            guerreroMuerto = vidaGuerrero <= 0;

            algunMuerto = guerreroMuerto || vampiroMuerto;
            
        } while (!algunMuerto);{
            
        
        String elGanador = vidaGuerrero <=0 ? "El vampiro ha vencido al heroe" : "El heroe ha vencido al vampiro";
        System.out.println("Vida de guerrero: [ "+ vidaGuerrero +"]");
        System.out.println("Vida de vampiro: [ "+ vidaVampiro +"]");
        System.out.println("La batalla ha acabado. " + elGanador);
     }
    
    }
}