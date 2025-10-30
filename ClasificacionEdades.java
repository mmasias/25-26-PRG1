import java.util.Scanner;

class ClasificacionEdad {

    public static void main(String[] args) {

        final int EDAD_NIÑO = 0;
        final int EDAD_INFANCIA = 6;
        final int EDAD_ADOLESCENCIA = 12;
        final int EDAD_JOVEN = 19;
        final int EDAD_ADULTO = 26;
        final int EDAD_MAYOR = 60;
        final int EDAD_MINIMA = 0;
        final int EDAD_MAXIMA = 100;
        Scanner lector = new Scanner(System.in);

        System.out.print("Por favor, introduzca su edad: ");
        int edad = lector.nextInt();

        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            System.out.println("edad incorrecta, introduzca una edad entre " + EDAD_MINIMA + " y " + EDAD_MAXIMA);
        } else {
            if (edad < EDAD_INFANCIA) {
                System.out.println("Usted es un niño");
            }
            else if (edad < EDAD_ADOLESCENCIA && edad > EDAD_NIÑO) {
                System.out.println("Usted está en la infancia");
            }
            else if (edad < EDAD_JOVEN && edad > EDAD_INFANCIA) {
                System.out.println("Usted es un adolescente");
            }
            else if (edad < EDAD_ADULTO && edad > EDAD_ADOLESCENCIA) {
                System.out.println("Usted es un joven");
            }
            else if (edad < EDAD_MAYOR && edad > EDAD_JOVEN) {
                System.out.println("Usted es adulto");
            }
            else if (edad > EDAD_ADULTO && edad <= EDAD_MAXIMA) {
                System.out.println("Usted es mayor");
            }

        }
        lector.close();
    }
}

