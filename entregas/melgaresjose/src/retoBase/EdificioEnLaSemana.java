class EdificioEnLaSemana {
    public static void main(String[] args) {
        final int DIAS_EN_SEMANA = 7;
        final int HORAS_EN_DIA = 24;
        final double PROBABILIDAD_ABIERTA = 0.70;
        final double PROBABILIDAD_LUZ_ENCENDIDA = 0.60;
        final int PLANTAS_HABITACIONES = 7;
        final int HABITACIONES_POR_PLANTA = 6;
        final String LUZ_APAGADA = "º";
        final String LUZ_ENCENDIDA = "*";
        boolean estaAbierta = false;
        boolean luzEstaEncendida = false;
        int numeroDia;
        int numeroHora;
        for(int i = 1; i < DIAS_EN_SEMANA*HORAS_EN_DIA; i++) {
            for(int j = 1; j <= HABITACIONES_POR_PLANTA; j++) {
                
            }
            
            
            numeroDia = (int) (i / HORAS_EN_DIA) + 1;
            numeroHora = (i % HORAS_EN_DIA);
            System.out.println("Dia: " + numeroDia + " hora: " + numeroHora+ ":00");
        }
    }
}
