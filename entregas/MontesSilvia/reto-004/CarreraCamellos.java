class CarreraCamellos {
    public static void main (String [] args) {
        final String PISTA_01 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02= "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03= "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PISTA_04= "---+-----------+---------+---------+---------+---------+-----------+";
        final String CABECERA_PISTA= "[J]|";
        final String CAMELLO= ";--;'" ;
        Scanner scanner =new Scanner (System.in);
        final String AVANCE = " "; 
        int posicion =0; 
        final int POSICION_FINAL = 60;
        boolean alcanzoLaMeta= false;
        int fallosSeguidos = 0;  
        int turnosPerdidos=0;
        final int MAX_TURNOS=50;  
 
        int[] avance = {1, 2, 4, 6};
        int[] probabilidad = {60, 40, 30, 10};
       do {
        if (turnosPerdidos > 0) {
            System.out.println(" El camello tropieza y pierde este turno (" + turnosPerdidos + " restantes).");
             turnosPerdidos--;
             turno++;
             if (turno >= MAX_TURNOS) break;
             System.out.println();
             continue; // salta al siguiente turno sin hacer nada más
}
        posicion= posicion +(int) (Math.random () *5);
        System.out.println (PISTA_01);
        System.out.println (PISTA_02);
        System.out.println (PISTA_03);
        System.out.println (PISTA_01);
        System.out.println (CABECERA_PISTA +AVANCE.repeat (i) +CAMELLO);
        System.out.println (PISTA_01);
        scanner= nextLine ();
        alcanzoLaMeta =posicion> =POSICION_FINAL;

       } while (!alcanzoLaMeta); 

       
        }
    
    }
