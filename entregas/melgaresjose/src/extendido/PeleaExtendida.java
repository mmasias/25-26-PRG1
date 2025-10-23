import java.util.Scanner;

class PeleaExtendida {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double CHANCE_ARMA1 = 0.50;
        final double CHANCE_ARMA2 = 0.25;
        final double CHANCE_ARMA3 = 0.12;
        final int DANO_ARMA1 = 7;
        final int DANO_ARMA2 = 15;
        final int DANO_ARMA3 = 30;

        final double CHANCE_ATAQUE1 = 0.90;
        final double CHANCE_ATAQUE2 = 0.60;
        final double CHANCE_ATAQUE3 = 0.40;
        final int DANO_ATAQUE1 = 5;
        final int DANO_ATAQUE2 = 10;
        final int DANO_ATAQUE3 = 20;

        int guerreroHP = 150;
        int vampiroHP = 60;
        int opcionGuerrero, opcionVampiro;
        boolean dadoGuerrero = true;
        boolean dadoVampiro = true;
        boolean hayMuerto = false;

        System.out.println("VAMPIRO vs EL GUERRERO !!!!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {
            System.out.println();
            System.out.println("HP Guerrero [" + guerreroHP + "]");
            System.out.println("HP Vampiro [" + vampiroHP + "]");
            System.out.println(">>>>>>> Tu arsenal >>>>>>>");
            System.out.println("1. Daga [Daño: " + DANO_ARMA1 + "] [Chance: " + CHANCE_ARMA1 + "]");
            System.out.println("2. Espada [Daño: " + DANO_ARMA2 + "] [Chance: " + CHANCE_ARMA2 + "]");
            System.out.println("3. Hacha [Daño: " + DANO_ARMA3 + "] [Chance: " + CHANCE_ARMA3 + "]");
            System.out.println("Con que golpeara el Guerrero?");
            opcionGuerrero = scanner.nextInt();
            if (opcionGuerrero == 1) {
                dadoGuerrero = Math.random() < CHANCE_ARMA1;
                vampiroHP = vampiroHP - (dadoGuerrero ? DANO_ARMA1 : 0);
            }
            else if (opcionGuerrero == 2) {
                dadoGuerrero = Math.random() < CHANCE_ARMA2;
                vampiroHP = vampiroHP - (dadoGuerrero ? DANO_ARMA2 : 0);
            }
            else if (opcionGuerrero == 3) {
                dadoGuerrero = Math.random() < CHANCE_ARMA3;
                vampiroHP = vampiroHP - (dadoGuerrero ? DANO_ARMA3 : 0);
            }
            System.out.println(dadoGuerrero ? "El ataque dio al vampiro!" : "Pero el guerrero falló");

            hayMuerto = guerreroHP * vampiroHP <= 0;
            opcionVampiro = hayMuerto ?  16 :(int) (Math.random() * 10);
            if (opcionVampiro >= 0 && opcionVampiro < 3){
                dadoVampiro = Math.random() < CHANCE_ATAQUE1;
                guerreroHP = guerreroHP - (dadoVampiro ? DANO_ATAQUE1 : 0);
                System.out.print("El vampiro hizo arañazo");
                System.out.print(dadoVampiro ? " y ha herido al guerrero": "... pero fallo");
            }
            else if(opcionVampiro >= 3 && opcionVampiro <= 6){
                dadoVampiro = Math.random() < CHANCE_ATAQUE2;
                guerreroHP = guerreroHP - (dadoVampiro ? DANO_ATAQUE2 : 0);
                System.out.print("El vampiro hizo mordida");
                System.out.print(dadoVampiro ? " y ha herido al guerrero": "... pero fallo");
            }
            else if (opcionVampiro > 6 && opcionVampiro <= 10){
                dadoVampiro = Math.random() < CHANCE_ATAQUE3;
                guerreroHP = guerreroHP - (dadoVampiro ? DANO_ATAQUE3 : 0);
                System.out.print("El vampiro hizo tortura mental");
                System.out.print(dadoVampiro ? " y ha hecho al guerrero": "... pero fallo");
            }
            else {
                System.out.println("Ya hay un ganador!");
            }
            System.out.println();
            hayMuerto = guerreroHP * vampiroHP <= 0;
        } while(!hayMuerto);

        boolean ganoGuerrero = guerreroHP > 0;
        System.out.println(ganoGuerrero ? "El Guerrero es el vencedor" : "Las fuerzas del mal han vencido esta noche");
        scanner.close();

    }
}