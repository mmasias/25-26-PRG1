class Aspiradora {
    public static void main(String[] args) {
        int[] coordAspiradora = {0, 0};
        
        int[][] superficie = crearSuperficie(5,8);
        dibujarSuperficie(superficie, coordAspiradora);    
    }

    private static int[][] crearSuperficie(int dimY, int dimX) {
        int[][] superficie = new int[dimY][dimX];
        for (int i = 0; i < 16;i++) {
            int x = (int) (Math.random() * superficie.length);
            int y = (int)(Math.random() * superficie[0].length);
            superficie[x][y] = (int)(Math.random() * 4) + 1;
        }
        return superficie;
    }

    private static void dibujarSuperficie(int[][] superficie, int[] coordAspiradora) {
        moverAspiradora(coordAspiradora);
        for(int i = 0; i< superficie.length; i++) {
            for(int j = 0;j < superficie[i].length; j++) {
                
                if(i == coordAspiradora[1] && j == coordAspiradora[0]) {
                    System.out.print("(Q)");
                }
                else {
                    System.out.print(mapear(superficie[i][j]));
                }
            }
            System.out.println();
            
        }
    }

    private static void moverAspiradora(int[] coordenadas) {
        coordenadas[0] = 3;
        coordenadas[1] = 2;
    }

    private static String mapear(int tile) {
        String[] estadosSuciedad = {
            " . ",
            "...",
            "ooo",
            "OOO",
            "***"
        };
        return estadosSuciedad[tile];
    }
}