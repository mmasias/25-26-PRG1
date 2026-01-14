
import java.util.Scanner;

class ClasificaciondeEdades{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);

        System.out.println("ingrese su edad");
        int edad = sc.nextInt();

        String clasificacion;

        if (edad>=0 && edad<=5){
        clasificacion = "Primera infancia";
        } else if (edad>=6 && edad<=11){
        clasificacion = "Infancia";
         } else if (edad>=12 && edad<=18){
        clasificacion = "adolescencia";
         } else if (edad>=19 && edad<=25){
        clasificacion= "Juventud";
         } else if (edad>=26 && edad<=59){
        clasificacion = "Adultez";
         } else if (edad>=60 && edad<=100){
        clasificacion = "Vejez";
         } else{
            clasificacion = "Edad no valida";
        }
        System.out.print(clasificacion +".");

        sc.close();


    }

}