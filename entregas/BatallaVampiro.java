import java.util.Scanner;

class BatallaVampiro{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean finBatalla = false;

        int hpGuerrero = 150;
        int hpVampiro = 60;

        int dañoArma1 = 7;


        final int ATAQUE_GUERRERO = 2;
        final int ATAQUE_VAMPIRO = 4;

        int probabilidad_ataque = (int)(Math.random()*2);

        System.out.println("EMPIEZA LA BATALLA!");

        while (!finBatalla){
            probabilidad_ataque = (int)(Math.random()*2);

            if (probabilidad_ataque == 1){
                hpGuerrero-=ATAQUE_VAMPIRO;
                System.out.println("El vampiro ha MORDIDO al guerrero!");
                System.out.println("HP VAMPIRO: " + hpVampiro);
                System.out.println("HP GUERRERO: " + hpGuerrero);
            }else{
                System.out.println("El vampiro ha FALLADO");
            }
            if(hpGuerrero <= 0){
                finBatalla = true;
                System.out.println("Ha GANADO el VAMPIRO!");
                break;
            }
            probabilidad_ataque = (int)(Math.random()*2);
            if (probabilidad_ataque == 1){
                hpVampiro-=ATAQUE_GUERRERO;
                System.out.println("El guerrero ha GOLPEADO al vampiro!");
                System.out.println("HP VAMPIRO: " + hpVampiro);
                System.out.println("HP GUERRERO " + hpGuerrero);
            }else{
                System.out.println("El guerrero ha FALLADO");
            }
            if(hpVampiro <= 0){
                finBatalla = true;
                System.out.println("Ha GANADO el GUERRERO!");
                break;
            }
        }
    }
}