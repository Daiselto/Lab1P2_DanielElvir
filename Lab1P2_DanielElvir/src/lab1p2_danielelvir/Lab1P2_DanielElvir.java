/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_danielelvir;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Lab1P2_DanielElvir {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir = true;
        do {
            System.out.println("Bienvenido al Primer lab");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Salir");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el valor a");
                    int a = leer.nextInt();

                    boolean valido = false;
                    do {
                        if (a != 0) {
                            valido = true;
                        } else {
                            valido = false;
                        }
                    } while (!valido);

                    System.out.println("Ingrese el valor b");
                    int b = leer.nextInt();
                    System.out.println("Ingrese el valor c");
                    int c = leer.nextInt();
                    int cont = 0;
                    double num = b * -1;
                    double den = 2 * a;
                    double vertice = num / den;
                    double desp1 = vertice + 200;
                    double desp2 = vertice - 200;
                    System.out.println("La raiz cuadrada de la positiva es: " + newton(a, b, c, desp1, cont));
                    System.out.println("La raiz cuadrada de la negativa es: " + newton(a, b, c, desp2, cont));

                    break;
                }

                case 2: {
                    System.out.println("Ingrese el numero que desea evaluar");
                    int x = leer.nextInt();
                    System.out.println("Ingrese el limite");
                    int n = leer.nextInt();
                    double resultado = 0.0;
                    System.out.println("El resultado de seno es: " + seno(x, n, resultado));
                    System.out.println("El resultado de coseno es: " + coseno(x, n, resultado));
                    if (x<90) {
                        System.out.println("El resultado en tangente es: " + tangente(x, n, resultado));
                    }else{
                        System.out.println("El resultado en tangente es: 0.0");
                    }
                    
                    break;
                }

                case 3: {
                    System.out.println("Gracias por usar el programa");
                    seguir = false;
                    break;
                }
            }
        } while (seguir);
    }

    public static double vertice(int a, int b) {
        double num = b * -1;
        double den = 2 * a;
        double vertice = num / den;

        return vertice;
    }

    public static double newton(int a, int b, int c, double desp, int cont) {
        if (cont == 100) {
            return desp;
        } else {
             desp=desp-(ecuacion(a, b, c, desp)/derivada(a, b, desp));
             return newton(a, b, c, desp, cont+1);
        }
    }

    public static double ecuacion(int a, int b, int c, double desp){
        double ecuacion=a*Math.pow(desp, 2)+b*desp+c;
        return ecuacion;
    }
    
    public static double derivada(int a, int b, double desp){
        double derivada=(2*a*desp)+(b);
        return derivada;
    }

    public static int factorial(int x) {
        if (x <= 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

    public static double seno(int x, int n, double resultado) {
        if (n == 0) {
            return x;
        } else {
            double numerador = (Math.pow((-1), n) * Math.pow(x, 2 * n + 1));
            double denominador = (factorial(2 * n + 1));
            resultado = numerador / denominador;
            // resultado=(Math.pow((-1), n)*Math.pow(x, 2*n+1))/(factorial(2*n+1));
            return resultado + seno(x, n - 1, resultado);
        }
    }

    public static double coseno(int x, int n, double resultado) {
        if (n == 0) {
            return x;
        } else {
            double numerador = (Math.pow(-1, n)) * (Math.pow(x, Math.pow(2, n)));
            double denominador = (factorial(2 * n));
            resultado = numerador / denominador;
            //resultado=(Math.pow(-1, n))*(Math.pow(x, Math.pow(2, n)))/(factorial(2*n));
            return resultado + coseno(x, n - 1, resultado);
        }
    }

    public static double tangente(int x, int n, double resultado) {
        if (n == 0) {
            return x;
        } else {
            double numerador = Math.pow(2, n) * Math.pow(-4, n) * (1 - Math.pow(4, n)) * (Math.pow(x, 2 * n - 1));
            double denominador = factorial(2 * n);
            resultado = numerador / denominador;
            return resultado + tangente(x, n - 1, resultado);
        }
    }
}
