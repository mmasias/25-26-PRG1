import java.util.Scanner;

public class CalculadoraGeometrica {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int LIMITE_HISTORIAL = 20;
        final double PI = 3.14159;

        String[] nombreFigura = new String[20];
        double[] historialArea = new double[20];
        double[] historialPerimetro = new double[20];
        int contadorHistorial = 0;
        
        System.out.println("Calculadora Geometrica - Areas y Perimetros");

        while(true) {
            System.out.println("[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Seleccione figura: ");
            int x = scanner.nextInt();

            if (x == 5) {
                System.out.println("Historial de Calculos");
                int areaTotal = 0;
                for (int i = 0; i < contadorHistorial; i++) {
                    System.out.println((i+1) + ". " + nombreFigura[i] + " -> Area: " + historialArea[i] + ", Perimetro/Volumen: " + historialPerimetro[i]);
                    areaTotal += historialArea[i];
                }
                System.out.println("Area total acumulada: " + areaTotal);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            double base = 0.0;
            double altura = 0.0;
            boolean calculoValido = false;

            if (x == 1) {
                System.out.print("Radio: ");
                base = scanner.nextDouble();
                if (base > 0) {
                    altura = PI * base * base;
                    double perimetro = 2 * PI * base;
                    System.out.println("Area: " + altura);
                    System.out.println("Perimetro: " + perimetro);
                    calculoValido = true;
                    if(contadorHistorial < 20) {
                        nombreFigura[contadorHistorial] = "Circulo";
                        historialArea[contadorHistorial] = altura;
                        historialPerimetro[contadorHistorial] = perimetro;
                        contadorHistorial++;
                    }
                } else {
                    System.out.println("Radio invalido");
                }
            } else if (x == 2) {
                System.out.print("Base: ");
                base = scanner.nextDouble();
                System.out.print("Altura: ");
                altura = scanner.nextDouble();
                if (base > 0 && altura > 0) {
                    double area = base * altura;
                    double perimetro = 2 * (base + altura);
                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);
                    calculoValido = true;
                    if(contadorHistorial < 20) {
                        nombreFigura[contadorHistorial] = "Rectangulo";
                        historialArea[contadorHistorial] = area;
                        historialPerimetro[contadorHistorial] = perimetro;
                        contadorHistorial++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else if (x == 3) {
                System.out.print("Lado 1: ");
                base = scanner.nextDouble();
                System.out.print("Lado 2: ");
                altura = scanner.nextDouble();
                System.out.print("Lado 3: ");
                double ancho = scanner.nextDouble();
                if (base > 0 && altura > 0 && ancho > 0 && (base + altura > ancho && base + ancho > altura && base + ancho > altura)) {
                    double lado = (base + altura + ancho) / 2;
                    double area = Math.sqrt(lado * (lado - base) * (lado - altura) * (lado - ancho));
                    double perimetro = base + altura + ancho;
                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);
                    calculoValido = true;
                    if(contadorHistorial < 20) {
                        nombreFigura[contadorHistorial] = "Triangulo";
                        historialArea[contadorHistorial] = area;
                        historialPerimetro[contadorHistorial] = perimetro;
                        contadorHistorial++;
                    }
                } else {
                    System.out.println("Lados invalidos o no forman un triangulo");
                }
            } else if (x == 4) {
                System.out.print("Radio: ");
                base = scanner.nextDouble();
                System.out.print("Altura: ");
                altura = scanner.nextDouble();
                if (base > 0 && altura > 0) {
                    double area_base = PI * base * base;
                    double area_lateral = 2 * PI * base * altura;
                    double area_total = 2 * area_base + area_lateral;
                    double volumen = area_base * altura;
                    System.out.println("Area Superficial: " + area_total);
                    System.out.println("Volumen: " + volumen);
                    calculoValido = true;
                    if(contadorHistorial < 20) {
                        nombreFigura[contadorHistorial] = "Cilindro";
                        historialArea[contadorHistorial] = area_total;
                        historialPerimetro[contadorHistorial] = volumen;
                        contadorHistorial++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else {
                System.out.println("Opcion no valida");
            }

            if (calculoValido) {
                System.out.println("Calculo completado.");
            }
            if (calculoValido) {
                int areaActual = 0;
                int perimetroActual = 0;
                String figuraActual = " ";
                System.out.println("Area: " + areaActual);
                System.out.println("Perimetro/Volumen: " + perimetroActual);
                System.out.println("Calculo completado.");

               
                if (contadorHistorial < LIMITE_HISTORIAL) {
                    nombreFigura[contadorHistorial] = figuraActual;
                    historialArea[contadorHistorial] = areaActual;
                    historialPerimetro[contadorHistorial] = perimetroActual;
                    contadorHistorial++;
                } 
        
                else {
                    System.out.println("ERROR: Se ha alcanzado el limite del historial. No se puede guardar mas.");
                }
            }
        }
        scanner.close();
    }
}