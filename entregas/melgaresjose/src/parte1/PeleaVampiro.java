class Vampiro {
      public static void main(String[] args) {
            final int DANO_HACHA = 2;
            final int DANO_MORDIDA = 4;
            final double CHANCE_HACHA = 0.5;
            final double CHANCE_MORDIDA = 0.5;
            int guerreroHP = 20;
            int vampiroHP = 10;
            boolean esTurnoGuerrero = true;
            boolean hayMuerto = false;
            boolean dado;
            do {
                  System.out.println("HP Guerrero [" + guerreroHP + "]");
                  System.out.println("HP Vampiro [" + vampiroHP + "]");

                  if (esTurnoGuerrero) {
                        dado = Math.random() < CHANCE_HACHA;
                        vampiroHP = vampiroHP - (dado ? DANO_HACHA:0);
                        System.out.println(dado ? "El vampiro ha sufrido daño!" : "El guerrero fallo su ataque!");
                  }
                  else {
                        dado = Math.random() < CHANCE_MORDIDA;
                        guerreroHP = guerreroHP - (dado ? DANO_MORDIDA : 0);
                        System.out.println(dado ? "El guerrero fue mordido!" : "El guerrero lo ha esquivado!");
                  }
                  System.out.println("--------------------------------------");
                  hayMuerto = vampiroHP * guerreroHP <= 0;
                  esTurnoGuerrero = !esTurnoGuerrero;
            } while(!hayMuerto);
            System.out.println("HP Guerrero [" + guerreroHP + "]");
            System.out.println("HP Vampiro [" + vampiroHP + "]");
            boolean ganoGuerrero = guerreroHP > 0;
            System.out.println(ganoGuerrero ? "El Guerrero es el vencedor" : "Las fuerzas del mal han vencido esta noche");
      }
}