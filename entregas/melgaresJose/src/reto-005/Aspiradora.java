class Aspiradora {
    public static void main(String[] args) {
        String[] estadosSuciedad = {
            " . ",
            "...",
            "ooo",
            "OOO",
            "***"
        };
        int[] coordAspiradora = {0, 0};
        
        int[][] superficie = crearSuperficie(5,8);
        dibujarSuperficie(superficie, estadosSuciedad);    
    }

    private static int[][] crearSuperficie(int dimVertical, int dimHorizontal) {
        int[][] superficie = new int[dimVertical][dimHorizontal];
        for (int i = 0; i < 16;i++) {
            int x = (int) (Math.random() * superficie.length);
            int y = (int)(Math.random() * superficie[0].length);
            superficie[x][y] = (int)(Math.random() * 4) + 1;
        }
        return superficie;
    }

    private static void dibujarSuperficie(int[][] superficie, String[] suciedades) {
        int posVertical = superficie.length;
        int posHorizontal = superficie[posVertical - 1].length;  
        
        for(int i = 0; i< superficie.length; i++) {
            for(int j = 0;j < superficie[i].length; j++) {
                if(i == posVertical && j == posHorizontal) {
                    System.out.println("(0)");
                }
                 else {
                    System.out.print(suciedades[superficie[i][j]]);
                 }

            }
            System.out.println();
        }
    }
}