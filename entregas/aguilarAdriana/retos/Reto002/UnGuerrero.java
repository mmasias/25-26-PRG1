
public class UnGuerrero {
    public static void main (String[] args) {
    int vidaGuerrero = 20;
    int dañoGuerrero = 2;

    int vidaVampiro = 10;
    int dañoVampiro = 4;
    
    System.out.println("¡COMIENZA LA BATALLA!");
    System.out.println("Guerrero: " + vidaGuerrero + " HP");
    System.out.println("Vampiro: " + vidaVampiro + " HP");
    System.out.println();

    while (vidaGuerrero > 0 && vidaVampiro > 0) {
        System.out.println("");
    final double PROBABILIDAD_DE_ATAQUE = 0.5;
        if (Math.random() < PROBABILIDAD_DE_ATAQUE) {
            vidaVampiro = vidaVampiro - dañoGuerrero;
            System.out.println("¡El guerrero golpea!" + dañoGuerrero + " HP");
            } else {
                System.out.println("El guerrero fallo el ataque");
            }
        if (vidaVampiro > 0) {
            if (Math.random() < PROBABILIDAD_DE_ATAQUE) {
                vidaGuerrero = vidaGuerrero - dañoVampiro;
                System.out.println("¡El vampiro muerde! " + dañoVampiro + " HP");
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

