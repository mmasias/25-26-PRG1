import java.util.Scanner;

class ClasificacionEdad {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su edad (0-100): ");
        int edad = scanner.nextInt();

        final int EDAD_INFANCIA = 6;
        final int EDAD_ADOLESCENCIA = 12;
        final int EDAD_JUVENTUD = 19;
        final int EDAD_ADULTEZ = 26;
        final int EDAD_PERSONA_MAYOR = 60;
        final int EDAD_LIMITE = 101;


        if (edad < 0){
            System.out.println("ERROR, EDAD NO VÁLIDA");
        } else if (edad < EDAD_INFANCIA){
            System.out.println("Primera infancia");
        } else if (edad < EDAD_ADOLESCENCIA){
            System.out.println("Infancia");
        } else if (edad < EDAD_JUVENTUD){
            System.out.println("Adolescencia");
        } else if (edad < EDAD_ADULTEZ){
            System.out.println("Juventud");
        } else if (edad < EDAD_PERSONA_MAYOR){
            System.out.println("Adultez");
        } else if (edad < EDAD_LIMITE){
            System.out.println("Persona mayor");
        }else{
            System.out.println("ERROR, EDAD NO VÁLIDA");
        }

        scanner.close();

    }

}
