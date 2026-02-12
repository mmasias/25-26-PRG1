import java.util.Scanner;

class pruebaarrays{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuantos alumnos quieres introducir?");
        int nAlumnos = scanner.nextInt();

        String [] alumno = new String[nAlumnos];
        int [] notas = new int[nAlumnos];

        for(int i = 0; i <nAlumnos; i++){
            alumno[i]=scanner.nextLine();
            System.out.println("Introduce el nombre del alumno");
            
        }


        for(int j = 0; j <nAlumnos; j++){
            System.out.println("Introduce la nota de cada alumno");
            notas[j]=scanner.nextInt();
        }    

        scanner.close();
    }
}