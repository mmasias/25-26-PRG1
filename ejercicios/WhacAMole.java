package src;
class WhacAMole {
    public static void main (String [] args) {
        final String AGUJERO="( )";
        final String MONIGOTE ="(‘’)";
        final String MARTILLO= "[[]]";
        final String MONIGOTE_GOLPEADO= "[**]";
        final int DIMENSION =8;
        final int NUMERO_CASILLAS= DIMENSION * DIMENSION; 
        int posicionMonigote; 
        posicionMonigote=(int) (Math.random() *NUMERO_CASILLAS +1);
        int posicionGolpe; 
        System.out.println ("Donde golpeas (entre 1 y " + NUMERO_CASILLAS + ")"
        posicionGolpe =scanner.nextInt();
        
        for(int i=1;i<=DIMENSION; i=i+1) {
            for(int j=1;j<=DIMENSION; j=j+1) {
                System.out.print(AGUJERO);

            }
            System.out.println();

        }

    }
}