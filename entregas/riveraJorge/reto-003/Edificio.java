class Edificio {

    public static void main(String[] args) {

    }

    final double PERSIANA_ABIERTA = 0.7;
    final double LUZ_ENCENDIDA = 0.6;

    final String VENTANA_CERRADA = " [ ] ";
    final String VENTANA_LUZ_APAGADA = " [º] ";
    final String VENTANA_LUZ_ENCENDIDA = " [*] ";
    final String SEPARADOR = " [    ] ";

    boolean abierta = Math.random() < PERSIANA_ABIERTA;
     {
        boolean encendida = Math.random() < LUZ_ENCENDIDA;

        String estadoVentana;
        if (!abierta)
            System.out.println(VENTANA_CERRADA);
            if (encendida){
                System.out.println(VENTANA_LUZ_ENCENDIDA);
                } else{
                    
                }
                    System.out.println(VENTANA_LUZ_APAGADA);
                
                    
                
            
        
        

    for(int dia=1;dia<=7;dia++){
        for(int hora=0;hora<24;hora++){
            System.out.println("Son las " + hora + " del dia " + dia);
            for(int columna=1;columna<=6;columna++){
                if (columna==3){
                    System.out.print(SEPARADOR);
                }
            }
        }

    }

    
    
    



}


