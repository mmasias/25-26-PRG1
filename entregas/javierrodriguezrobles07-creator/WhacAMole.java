public class WhacAMole {

    public static void main(String[] args) {
        final String AGUJERO = " (  )";
        final String MONIGOTE = " (ºº)";
        final String MARTILLO = "[[]]";
        final String MONIGOTE_GOLPEADO = "(**)";

        final int DIMENSION = 8;
        final int NUMERO_CASILLAS = DIMENSION * DIMENSION;

        int posicionMonigote = (int) (Math.random() * NUMERO_CASILLAS) + 1;

        for (int posicionImpresion = 1; posicionImpresion <= NUMERO_CASILLAS; posicionImpresion++) {
            if (posicionImpresion == posicionMonigote) {
                System.out.print(MONIGOTE);
            } else {
                System.out.print(AGUJERO);
            }

            if (posicionImpresion % DIMENSION == 0) {
                System.out.println(); 
            } else {
                System.out.print(" ");
            }
        }
    }
}
