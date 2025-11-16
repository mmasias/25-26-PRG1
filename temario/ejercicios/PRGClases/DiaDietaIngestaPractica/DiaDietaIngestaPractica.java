package temario.ejercicios.PRGClases.DiaDietaIngestaPractica;

import java.util.Scanner;

public class DiaDietaIngestaPractica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();
        System.out.println();

        String[] Dia1 = { "Vacio", "Vacio", "Vacio", "Vacio", "Vacio" };
        String[] Dia2 = { "Vacio", "Vacio", "Vacio", "Vacio", "Vacio" };
        String[] Dia3 = { "Vacio", "Vacio", "Vacio", "Vacio", "Vacio" };
        String[] Dia4 = { "Vacio", "Vacio", "Vacio", "Vacio", "Vacio" };
        String[] Dia5 = { "Vacio", "Vacio", "Vacio", "Vacio", "Vacio" };

        String[] Comida = { "Desayuno", "Merienda por la Mañana", "Almuerzo", "Merienda por la tarde", "Cena" };

        final int NUMERO_MENU = -1;
        int diaUsuario = 0;

        while (diaUsuario != NUMERO_MENU) {

            System.out.print("Seleccione el dia (1-5) o -1 para salir: ");
            diaUsuario = scanner.nextInt();
            scanner.nextLine();

            if (diaUsuario == -1) {
                System.out.println("Saliendo del programa...");
                break;
            }

            if (diaUsuario == 1) {
                System.out.println("\n============================================");
                System.out.println("Paciente: " + nombrePaciente);
                System.out.println("===== Dia " + diaUsuario + ":");
                System.out.println("============================================");
                for (int i = 0; i < 5; i++) {
                    System.out.print(Comida[i] + ": " + Dia1[i]);
                    System.out.println();
                }
            } else if (diaUsuario == 2) {
                System.out.println("\n============================================");
                System.out.println("Paciente: " + nombrePaciente);
                System.out.println("===== Dia " + diaUsuario + ":");
                System.out.println("============================================");
                for (int i = 0; i < 5; i++) {
                    System.out.print(Comida[i] + ": " + Dia2[i]);
                    System.out.println();
                }
            } else if (diaUsuario == 3) {
                System.out.println("\n============================================");
                System.out.println("Paciente: " + nombrePaciente);
                System.out.println("===== Dia " + diaUsuario + ":");
                System.out.println("============================================");
                for (int i = 0; i < 5; i++) {
                    System.out.print(Comida[i] + ": " + Dia3[i]);
                    System.out.println();
                }
            } else if (diaUsuario == 4) {
                System.out.println("\n============================================");
                System.out.println("Paciente: " + nombrePaciente);
                System.out.println("===== Dia " + diaUsuario + ":");
                System.out.println("============================================");
                for (int i = 0; i < 5; i++) {
                    System.out.print(Comida[i] + ": " + Dia4[i]);
                    System.out.println();
                }
            } else {
                System.out.println("\n============================================");
                System.out.println("Paciente: " + nombrePaciente);
                System.out.println("===== Dia " + diaUsuario + ":");
                System.out.println("============================================");
                for (int i = 0; i < 5; i++) {
                    System.out.print(Comida[i] + ": " + Dia5[i]);
                    System.out.println();
                }
            }

            System.out.println();

            int comidaUsuario = 0;
            String ingestaUsuario;

            while (comidaUsuario != -1) {

                System.out.println("\n--------------------------------------------");
                System.out.println("Para seleccionar ingesta:");
                System.out.println(
                        "1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");
                System.out.println("--------------------------------------------");

                System.out.print("Seleccione una ingesta: ");
                comidaUsuario = scanner.nextInt();
                scanner.nextLine();

                if (comidaUsuario == -1) {
                    break;
                }

                int indiceIngesta = comidaUsuario - 1;

                System.out.print("Ingrese la ingesta de su " + Comida[indiceIngesta] + ": ");
                ingestaUsuario = scanner.nextLine();

                if (diaUsuario == 1) {
                    Dia1[indiceIngesta] = ingestaUsuario;
                    System.out.println("\n============================================");
                    System.out.println("Paciente: " + nombrePaciente);
                    System.out.println("===== Dia " + diaUsuario + " (Actualizado):");
                    System.out.println("============================================");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(Comida[i] + ": " + Dia1[i]);
                        System.out.println();
                    }
                } else if (diaUsuario == 2) {
                    Dia2[indiceIngesta] = ingestaUsuario;
                    System.out.println("\n============================================");
                    System.out.println("Paciente: " + nombrePaciente);
                    System.out.println("===== Dia " + diaUsuario + " (Actualizado):");
                    System.out.println("============================================");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(Comida[i] + ": " + Dia2[i]);
                        System.out.println();
                    }
                } else if (diaUsuario == 3) {
                    Dia3[indiceIngesta] = ingestaUsuario;
                    System.out.println("\n============================================");
                    System.out.println("Paciente: " + nombrePaciente);
                    System.out.println("===== Dia " + diaUsuario + " (Actualizado):");
                    System.out.println("============================================");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(Comida[i] + ": " + Dia3[i]);
                        System.out.println();
                    }
                } else if (diaUsuario == 4) {
                    Dia4[indiceIngesta] = ingestaUsuario;
                    System.out.println("\n============================================");
                    System.out.println("Paciente: " + nombrePaciente);
                    System.out.println("===== Dia " + diaUsuario + " (Actualizado):");
                    System.out.println("============================================");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(Comida[i] + ": " + Dia4[i]);
                        System.out.println();
                    }
                } else if (diaUsuario == 5) {
                    Dia5[indiceIngesta] = ingestaUsuario;
                    System.out.println("\n============================================");
                    System.out.println("Paciente: " + nombrePaciente);
                    System.out.println("===== Dia " + diaUsuario + " (Actualizado):");
                    System.out.println("============================================");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(Comida[i] + ": " + Dia5[i]);
                        System.out.println();
                    }
                }

            }

            comidaUsuario = 0;

        }

        scanner.close();
    }
}
